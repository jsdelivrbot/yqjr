package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.CommodityOutCondition;
import com.yqjr.fin.mkmm.sales.entity.CommodityBase;
import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.entity.CommodityReview;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityOutVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityOut;
import com.yqjr.fin.mkmm.sales.mapper.CommodityOutMapper;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityOutService extends BaseService<CommodityOutMapper, CommodityOut, Long> {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CommodityReviewService commodityReviewService;
    @Autowired
    CommodityStockService commodityStockService;
    @Autowired
    private CommodityBaseService commodityBaseService;
    @Autowired
    private ProjectBaseService projectBaseService;
    @Autowired
    private CommodityOutMapper commodityOutMapper;

    /**
     * 销管二期
     * 物料出库提交审核
     * @param commodityOutVo
     * create by lf
     * 2018/9/3
     */
    @Transactional(rollbackFor = { Exception.class })
    public synchronized void outReview(CommodityOutVo commodityOutVo){
        UserContext userContext = SessionHolder.getUserContext();
        String batchCode = new Date().getTime()+""+(int)(Math.random()*10000);
        String provideOrganization = commodityOutVo.getProvideOrganization();
        //将出库的数据赋值给出库对象
        List<CommodityOutCondition> commodityOutConditions = this.setForCommodityOutConditions(commodityOutVo);
        //将出库对象的数据赋值给审核表对象
        List<CommodityReview> commodityReviews = this.setForCommodityReview(commodityOutConditions,provideOrganization);
        CommodityReview commodityReview = null;
        for(int i=0;i<commodityReviews.size();i++){
            commodityReview = commodityReviews.get(i);
            commodityReview.setBatchCode(batchCode);
            commodityReview.setPutName(userContext.getName()); // 出库人
            commodityReviewService.insert(commodityReview);
        }
        //减去库存
        outStock(commodityOutConditions);
    }

    /**
     * 销管二期
     * 将出库的数据赋值给出库对象
     * @param commodityOutVo
     * create by lf
     * 2018/9/3
     */
    public List<CommodityOutCondition> setForCommodityOutConditions(CommodityOutVo commodityOutVo){

        CommodityOutCondition commodityOutCondition1 = null;
        List<CommodityOutCondition> lists = new ArrayList<CommodityOutCondition>();
        UserContext userContext = SessionHolder.getUserContext();
        String commodityCode = commodityOutVo.getCommodityCode();
        String commodityName = commodityBaseService.getCommodityName(commodityCode);//物料名称
        String projectCode = commodityOutVo.getProjectCode();
        String projectName = projectBaseService.getProjectName(projectCode);
        List<CommodityOutCondition> commodityOutConditions = commodityOutVo.getCommodityOutConditions();
        for(int i=0;i<commodityOutConditions.size();i++){
            CommodityOutCondition commodityOutCondition = new CommodityOutCondition();
            commodityOutCondition1 = commodityOutConditions.get(i);
            commodityOutCondition.setAreaCode(userContext.getAreaCode());
            commodityOutCondition.setAreaName(userContext.getAreaName());
            commodityOutCondition.setCompany(userContext.getComCode());
            commodityOutCondition.setCommodityName(commodityName);
            commodityOutCondition.setCommodityCode(commodityCode);
            commodityOutCondition.setCommodityTypeCode(commodityOutVo.getCommodityTypeCode());
            if ("00".equals(commodityOutVo.getCommodityTypeCode())) {
                commodityOutCondition.setCommodityTypeName("促销物料");
            } else if ("01".equals(commodityOutVo.getCommodityTypeCode())) {
                commodityOutCondition.setCommodityTypeName("广宣物料");
            } else {
                commodityOutCondition.setCommodityTypeName("品牌物料");
            }
            commodityOutCondition.setProjectName(projectName);
            commodityOutCondition.setProjectCode(projectCode);
            commodityOutCondition.setDealerName(commodityOutCondition1.getDealerName());
            commodityOutCondition.setDealerCode(commodityOutCondition1.getDealerCode());
            commodityOutCondition.setPutNumber(commodityOutCondition1.getPutNumber());
            commodityOutCondition.setPutUnivalent(commodityOutCondition1.getPutUnivalent());
            commodityOutCondition.setAmount(commodityOutCondition1.getAmount());
            commodityOutCondition.setReceiveStatus("1"); // 未领用
            lists.add(commodityOutCondition);
        }
        return lists;
    }

    /**
     * 销管二期
     * 将出库信息提交到审核表中
     * create by lf
     * 2018/9/3
     * @param commodityOutConditions
     * @return
     */
    public List<CommodityReview> setForCommodityReview(List<CommodityOutCondition> commodityOutConditions,String provideOrganization){
        List<CommodityReview> lists = new ArrayList<CommodityReview>();

        CommodityOutCondition commodityOutCondition = null;
        for (int i=0;i<commodityOutConditions.size();i++) {
            CommodityReview commodityReview = new CommodityReview();
            commodityOutCondition = commodityOutConditions.get(i);
            BeanUtils.copyProperties(commodityReview,commodityOutCondition);
            commodityReview.setProvideOrganization(provideOrganization);
            commodityReview.setType("2"); //出库审核
            commodityReview.setFlag("1"); //数据有效
            commodityReview.setCommodityStatus("02"); //待审核
            lists.add(commodityReview);
        }
        return lists;
    }


    /**
     * 出库记录导出
     * @param commodityOut
     * @param response
     */
    public void export(CommodityOut commodityOut, HttpServletResponse response) throws IOException {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityOutCondition commodityOutCondition = new CommodityOutCondition();
        commodityOutCondition.setCommodityCode(commodityOut.getCommodityCode());
        commodityOutCondition.setCommodityTypeCode(commodityOut.getCommodityTypeCode());
        commodityOutCondition.setDealerCode(commodityOut.getDealerCode());
        commodityOutCondition.setProjectCode(commodityOut.getProjectCode());
        commodityOutCondition.setAreaName(userContext.getAreaName());
        commodityOutCondition.setCompany(userContext.getComCode());
        commodityOutCondition.setAreaCode(userContext.getAreaCode());
        //查出要导出的数据
        List<CommodityOut> commodityOuts = this.selectList(commodityOutCondition);
        //生成excel
        createExcel(commodityOuts, response);

    }

    /**
     * 创建excel
     * @param commodityOuts
     * @param response
     */
    public void createExcel(List<CommodityOut> commodityOuts, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("物料出库记录");
        String [] cellValues = {"区域名称","物料分类","物料名称", "项目名称", "投放经销商", "出库数量", "出库单价", "总金额", "出库人", "出库时间", "领用状态", "领用人", "领用时间", "反馈意见"};
        //创建表头
        createTitle(sheet,cellValues);
        //写数据
        putCommodityOutData(commodityOuts, sheet);

        String fileName = "commodityOut.xls";
        //新增数据行，并且设置单元格数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
        logger.info("出库记录导出完成！");
    }

    private void putCommodityOutData(List<CommodityOut> commodityOuts, HSSFSheet sheet) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int i = 1;
        for (CommodityOut commodityOut:commodityOuts) {
            HSSFRow row =  sheet.createRow(i);
            row.createCell(0).setCellValue(commodityOut.getAreaName());
            row.createCell(1).setCellValue(commodityOut.getCommodityTypeName());
            row.createCell(2).setCellValue(commodityOut.getCommodityName());
            row.createCell(3).setCellValue(commodityOut.getProjectName());
            row.createCell(4).setCellValue(commodityOut.getDealerName());
            row.createCell(5).setCellValue(commodityOut.getPutNumber());
            row.createCell(6).setCellValue(decimalFormat.format(commodityOut.getPutUnivalent()));
            row.createCell(7).setCellValue(decimalFormat.format(commodityOut.getAmount()));
            row.createCell(8).setCellValue(commodityOut.getPutName());
            row.createCell(9).setCellValue(simpleDateFormat.format(commodityOut.getOutTime()));
            if("1".equals(commodityOut.getReceiveStatus())) {
                row.createCell(10).setCellValue("未领用");
            } else if ("0".equals(commodityOut.getReceiveStatus())) {
                row.createCell(10).setCellValue("已领用");
            }
            row.createCell(11).setCellValue(commodityOut.getReceiver());
            if (commodityOut.getReceiveTime() == null || "".equals(commodityOut.getReceiveTime())) {
                row.createCell(12).setCellValue("");
            } else {
                row.createCell(12).setCellValue(simpleDateFormat.format(commodityOut.getReceiveTime()));
            }
            row.createCell(13).setCellValue(commodityOut.getOpinion());
            i++;
        }
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


    /**
     * DSP投放物料查询
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<CommodityOut> selectCommodityList(CommodityOutCondition condition, PageBounds... pageBounds) {
        List<CommodityOut> commodityOuts = new ArrayList<>();
        if("".equals(condition.getDealerCode()) || null == condition.getDealerCode()) {
            return null;
        }
        if("".equals(condition.getCompany()) || null == condition.getCompany()) {
            return null;
        }
        commodityOuts = this.selectList(condition, pageBounds);
        return commodityOuts;
    }


    /**
     * DSP物料接收
     * @param commodityOut
     */
    @Transactional
    public void receiveCommodity(CommodityOut commodityOut) {
        //校验字段必输
        validationData(commodityOut);

        Long id = commodityOut.getId();
        String receiver = commodityOut.getReceiver();
        Date receiveTime = commodityOut.getReceiveTime();
        //不为空时，更新状态
        CommodityOut co = new CommodityOut();
        co.setId(id);
        co.setReceiveTime(receiveTime);
        co.setReceiver(receiver);
        co.setReceiveStatus("0");//已领用
        this.patchById(co);

    }

    /**
     * 校验字段必输
     * @param commodityOut
     */
    public void validationData(CommodityOut commodityOut) {
        if("".equals(commodityOut.getId()) || null == commodityOut.getId()) {
            throw new ValidationException("id不能为空");
        }
        if("".equals(commodityOut.getDealerCode()) || null == commodityOut.getDealerCode()) {
            throw new ValidationException("经销商不能为空");
        }
        if("".equals(commodityOut.getReceiver()) || null == commodityOut.getReceiver()) {
            throw new ValidationException("领用人不能为空");
        }
        if("".equals(commodityOut.getReceiveTime()) || null == commodityOut.getReceiveTime()) {
            throw new ValidationException("领用时间不能为空");
        }
        if("".equals(commodityOut.getOpinion()) || null == commodityOut.getOpinion()) {
            throw new ValidationException("意见反馈不能为空");
        }
    }

    /**
     * 去库存
     */
    public void outStock(List<CommodityOutCondition> commodityOutConditions) {
        Long sum = (long)0;
        //出库数量
        for(CommodityOutCondition commodityOutCondition : commodityOutConditions) {
            Long num = commodityOutCondition.getPutNumber();
            sum += num;
        }
        if(commodityOutConditions.size()>0) {
            String commodityCode = commodityOutConditions.get(0).getCommodityCode();
            String commodityTypeCode = commodityOutConditions.get(0).getCommodityTypeCode();
            String company = commodityOutConditions.get(0).getCompany();
            String areaCode = commodityOutConditions.get(0).getAreaCode();
            CommodityOut commodityOut = new CommodityOut();
            commodityOut.setAreaCode(areaCode);
            commodityOut.setCommodityCode(commodityCode);
            commodityOut.setCommodityTypeCode(commodityTypeCode);
            commodityOut.setCompany(company);
            commodityOut.setPutNumber(sum);
            commodityStockService.outStock(commodityOut);
        }

    }

    /**
     * 根据条件模糊查询首页
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<CommodityOut> selectCommodityOutList(CommodityOutCondition condition, PageBounds... pageBounds) {

        List<CommodityOut> commodityOuts = commodityOutMapper.selectCommodityOutList(condition, pageBounds);
        return commodityOuts;
    }



}