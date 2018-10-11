package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.CommodityAcceptanceCondition;
import com.yqjr.fin.mkmm.sales.entity.CommodityBase;
import com.yqjr.fin.mkmm.sales.vo.domin.PersonTrackVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;
import com.yqjr.fin.mkmm.sales.mapper.CommodityAcceptanceMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityAcceptanceService extends BaseService<CommodityAcceptanceMapper, CommodityAcceptance, Long> {

    @Autowired
    private CommodityAcceptanceMapper commodityAcceptanceMapper;


    /**
     * 查询物料是否已存在
     * @param commodityBase
     * @return
     */
    public Long selectCommodityDataByName(CommodityBase commodityBase) {

        CommodityAcceptanceCondition commodityAcceptanceCondition = new CommodityAcceptanceCondition();
        commodityAcceptanceCondition.setAreaCode(commodityBase.getAreaCode());
        commodityAcceptanceCondition.setCompany(commodityBase.getCompany());
        commodityAcceptanceCondition.setCommodityName(commodityBase.getCommodityName());
        Long num= this.selectCount(commodityAcceptanceCondition);

        return num;
    }

    /**
     * 物料验收
     * @param commodityAcceptances
     */
    @Transactional
    public void receiveCommodity(List<CommodityAcceptance> commodityAcceptances) {
        UserContext userContext = SessionHolder.getUserContext();
        String company = userContext.getComCode();
        String areaCode = userContext.getAreaCode();
        String areaName = userContext.getAreaName();
        for (CommodityAcceptance commodityAcceptance : commodityAcceptances) {
            commodityAcceptance.setCompany(company);
            commodityAcceptance.setAreaCode(areaCode);
            commodityAcceptance.setAreaName(areaName);
            commodityAcceptance.setAcceptancePerson(userContext.getName());
            commodityAcceptance.setAcceptanceStatus("0");//已验收
            this.insert(commodityAcceptance);
        }
    }

    /**
     * 验收结果导出
     * @param commodityAcceptance
     * @param response
     */
    public void export(CommodityAcceptance commodityAcceptance, HttpServletResponse response) throws IOException {
        UserContext userContext = SessionHolder.getUserContext();
        //查出要导出的数据
        CommodityAcceptanceCondition commodityAcceptanceCondition = new CommodityAcceptanceCondition();
        commodityAcceptanceCondition.setAreaCode(userContext.getAreaCode());
        commodityAcceptanceCondition.setCompany(userContext.getComCode());
        commodityAcceptanceCondition.setProvideOrganization(commodityAcceptance.getProvideOrganization());
        commodityAcceptanceCondition.setCommodityTypeCode(commodityAcceptance.getCommodityTypeCode());
        commodityAcceptanceCondition.setCommodityCode(commodityAcceptance.getCommodityCode());
//        commodityAcceptanceCondition.setAcceptanceStatus("0");//已入库

        List<CommodityAcceptance> commodityAcceptances = this.selectList(commodityAcceptanceCondition);
        //写进excel
        createExcel(commodityAcceptances, response);
    }

    /**
     * 创建excel
     * @param commodityAcceptances
     * @param response
     */
    public void createExcel(List<CommodityAcceptance> commodityAcceptances, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HSSFSheet sheet = workbook.createSheet("物料验收");
        String [] cellValues = {"物料名称","验收数量","供应单位", "验收区域", "验收人", "验收时间"};
        createTitle(sheet,cellValues);
        int i = 1;
        for(CommodityAcceptance commodityAcceptance :commodityAcceptances) {
            HSSFRow row =  sheet.createRow(i);
            row.createCell(0).setCellValue(commodityAcceptance.getCommodityName());
            row.createCell(1).setCellValue(commodityAcceptance.getAcceptanceNumber());
            String org = commodityAcceptance.getProvideOrganization();
            if ("1".equals(org)) {
                row.createCell(2).setCellValue("总部分发");
            } else {
                row.createCell(2).setCellValue("区域采购");
            }
            row.createCell(3).setCellValue(commodityAcceptance.getAreaName());
            row.createCell(4).setCellValue(commodityAcceptance.getAcceptancePerson());
            row.createCell(5).setCellValue(simpleDateFormat.format(commodityAcceptance.getCreateTime()));
            i++;
        }
        String fileName = "commodity.xls";
        //新增数据行，并且设置单元格数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
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
     * 物料验收修改
     */
    public void updateAcceptance(CommodityAcceptance commodityAcceptance){
        CommodityAcceptance ca = new CommodityAcceptance();
        ca.setId(commodityAcceptance.getId());
        ca.setAcceptanceNumber(commodityAcceptance.getAcceptanceNumber());
        if("1".equals(commodityAcceptance.getAcceptanceStatus()) || "2".equals(commodityAcceptance.getAcceptanceStatus())) {
            throw new ValidationException("物料已入库，无法修改！");
        }
        this.patchById(ca);
    }


}