package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.condition.CommodityInCondition;
import com.yqjr.fin.mkmm.sales.condition.ProjectBaseCondition;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityAcceptanceVo;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityInVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.mapper.CommodityInMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import com.yqjr.scfw.common.utils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityInService extends BaseService<CommodityInMapper, CommodityIn, Long> {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CommodityInMapper commodityInMapper;
    @Autowired
    private ProjectBaseService projectBaseService;
    @Autowired
    private CommodityReviewService commodityReviewService;
    @Autowired
    private CommodityAcceptanceService commodityAcceptanceService;


    public List<CommodityIn> selectByProjectCode(String projectCode){
        return commodityInMapper.selectByProjectCode(projectCode);
    }

    public List<CommodityIn> queryCommodityInList(String commodityName){
        CommodityIn commodityIn = new CommodityIn();
        commodityIn.setCommodityName(commodityName);
        UserContext userContext = SessionHolder.getUserContext();
        commodityIn.setCompany(userContext.getComCode());
        commodityIn.setAreaCode(userContext.getAreaCode());
        commodityIn.setAreaName(userContext.getAreaName());
        return commodityInMapper.queryCommodityInList(commodityIn);
    }


    /**
     * 物料入库登记
     * @param commodityInVo
     */
    @Transactional
    public void submit(CommodityInVo commodityInVo) {
        UserContext userContext = SessionHolder.getUserContext();
        //待入库物料集合
        List<CommodityAcceptanceVo> commodityAcceptanceVos = commodityInVo.getCommodityAcceptanceVos();
        //入库项目
        String projectCode = commodityInVo.getProjectCode();
        //入库项目名称
        String projectName = getProjectName(projectCode).getProjectName();

        CommodityAcceptance commodityAcceptance = new CommodityAcceptance();
        commodityAcceptance.setAcceptanceStatus("1");//入库中

        CommodityReview commodityReview = new CommodityReview();
        commodityReview.setProjectCode(projectCode);
        commodityReview.setProjectName(projectName);
        commodityReview.setAreaCode(userContext.getAreaCode());
        commodityReview.setAreaName(userContext.getAreaName());
        commodityReview.setCompany(userContext.getComCode());
        commodityReview.setType("1");//入库审核
        commodityReview.setFlag("1");//有效
        commodityReview.setCommodityStatus("02");//待审核
        commodityReview.setCustodian(userContext.getName());
        CommodityAcceptanceVo commodityAcceptanceVo = new CommodityAcceptanceVo();
        for (int i=0; i<commodityAcceptanceVos.size(); i++) {
            commodityAcceptanceVo = commodityAcceptanceVos.get(i);
            commodityReview.setCommodityTypeCode(commodityAcceptanceVo.getCommodityTypeCode());
            commodityReview.setCommodityTypeName(commodityAcceptanceVo.getCommodityTypeName());
            commodityReview.setCommodityCode(commodityAcceptanceVo.getCommodityCode());
            commodityReview.setCommodityName(commodityAcceptanceVo.getCommodityName());
            commodityReview.setAcceptanceId(commodityAcceptanceVo.getId());
            commodityReview.setAmount(commodityAcceptanceVo.getAmount());
            commodityReview.setInNumber(commodityAcceptanceVo.getAcceptanceNumber());
            commodityReview.setInUnivalent(commodityAcceptanceVo.getInUnivalent());
            commodityReview.setProvideOrganization(commodityAcceptanceVo.getProvideOrganization());
            commodityReview.setAcceptancePerson(commodityAcceptanceVo.getAcceptancePerson());
            commodityReviewService.insert(commodityReview);
            //更改验收物料状态为入库中
            commodityAcceptance.setId(commodityAcceptanceVo.getId());
            commodityAcceptanceService.patchById(commodityAcceptance);
        }

    }


    /**
     * 根据项目编码查询项目名称
     * @param projectCode
     * @return
     */
    public ProjectBase getProjectName(String projectCode){
        UserContext userContext = SessionHolder.getUserContext();
        ProjectBaseCondition projectBaseCondition = new ProjectBaseCondition();
        projectBaseCondition.setCompany(userContext.getComCode());
        projectBaseCondition.setProjectCode(projectCode);
        List<ProjectBase> projectBases = projectBaseService.selectList(projectBaseCondition);
        if (projectBases.size()<=0) {
            throw new ValidationException("入库项目不存在！");
        }
        return projectBases.get(0);
    }


    public void exportList(CommodityIn commodityIn, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("物料入库信息");
        String [] cellValues = {"区域名称","物料分类","物料名称", "项目名称",  "入库数量", "单价", "总金额", "供应单位", "入库人", "校核人", "入库时间"};
        //创建表头
        createTitle(sheet,cellValues);
        //写数据
        writeData(commodityIn, sheet);

        String fileName = "commodityIn.xls";
        //新增数据行，并且设置单元格数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
        logger.info("入库记录导出完成！");
    }
    /***
     * 创建表头
     * @param sheet
     */
    private void createTitle(HSSFSheet sheet, String [] cellValues) {
        HSSFRow row = sheet.createRow(0);
        //设置列宽
        for(int i = 0; i<cellValues.length ;i++) {
            sheet.setColumnWidth(i, 15*256);
        }
        HSSFCell cell;
        for(int i = 0; i<cellValues.length ;i++) {
            cell = row.createCell(i);
            cell.setCellValue(cellValues[i]);
        }
    }

    public void writeData(CommodityIn commodityIn,HSSFSheet sheet){
        CommodityInCondition commodityInCondition = new CommodityInCondition();
        UserContext userContext = SessionHolder.getUserContext();
        commodityInCondition.setAreaCode(userContext.getAreaCode());
        commodityInCondition.setCompany(userContext.getComCode());
        commodityInCondition.setCommodityCode(commodityIn.getCommodityCode());
        commodityInCondition.setCommodityTypeCode(commodityIn.getCommodityTypeCode());
        commodityInCondition.setProvideOrganization(commodityIn.getProvideOrganization());
        commodityInCondition.setProjectCode(commodityIn.getProjectCode());
        //查询数据
        List<CommodityIn> commodityIns = this.selectList(commodityInCondition);
        //插入数据
        insertData(commodityIns,sheet);
    }

    /**
     *插入数据
     */
    public void insertData(List<CommodityIn> commodityIns,HSSFSheet sheet){
        CommodityIn commodityIn = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for(int i=0;i<commodityIns.size();i++){
            commodityIn = commodityIns.get(i);
            HSSFRow row =  sheet.createRow(i+1);
            row.createCell(0).setCellValue(commodityIn.getAreaName());
            row.createCell(1).setCellValue(commodityIn.getCommodityTypeName());
            row.createCell(2).setCellValue(commodityIn.getCommodityName());
            row.createCell(3).setCellValue(commodityIn.getProjectName());
            row.createCell(4).setCellValue(commodityIn.getInNumber()+"");
            if (!"".equals(commodityIn.getInUnivalent()) && commodityIn.getInUnivalent() != null) {
                row.createCell(5).setCellValue(decimalFormat.format(commodityIn.getInUnivalent()));
            }
            if (!"".equals(commodityIn.getAmount()) && commodityIn.getAmount() != null) {
                row.createCell(6).setCellValue(decimalFormat.format(commodityIn.getAmount()));
            }
            if ("1".equals(commodityIn.getProvideOrganization())) {
                row.createCell(7).setCellValue("总部分发");
            } else if ("2".equals(commodityIn.getProvideOrganization())){
                row.createCell(7).setCellValue("自行采购");
            }
            row.createCell(8).setCellValue(commodityIn.getCustodian());
            row.createCell(9).setCellValue(commodityIn.getChecker());
            row.createCell(10).setCellValue(simpleDateFormat.format(commodityIn.getCreateTime()));
        }
    }

}