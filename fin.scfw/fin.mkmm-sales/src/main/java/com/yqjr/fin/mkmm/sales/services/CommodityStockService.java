package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.CommodityStockCondition;
import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.entity.CommodityOut;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityStock;
import com.yqjr.fin.mkmm.sales.mapper.CommodityStockMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityStockService extends BaseService<CommodityStockMapper, CommodityStock, Long> {

    @Autowired
    private CommodityStockMapper commodityStockMapper;
    /**
     * 物料入库
     */
    @Transactional
    public void inStock(CommodityIn commodityIn) {
        //获取入库信息
        String areaName = commodityIn.getAreaName();
        String commodityName = commodityIn.getCommodityName();
        String commodityTypeName = commodityIn.getCommodityTypeName();

        CommodityStock commodityStock = new CommodityStock();
        commodityStock.setAreaCode(commodityIn.getAreaCode());
        commodityStock.setCommodityTypeCode(commodityIn.getCommodityTypeCode());
        commodityStock.setCommodityCode(commodityIn.getCommodityCode());
        commodityStock.setCompany(commodityIn.getCompany());
        //获取当前库存
        CommodityStock stock = getStockNumber(commodityStock);
        Long stockNumber;
        if(StringUtils.isEmpty(stock)) {
            stockNumber = (long)0;
        } else {
            stockNumber = stock.getNowStock();
        }
        //计算当前库存
        stockNumber += commodityIn.getInNumber();

        if(!StringUtils.isEmpty(stock)) {
            //数据更新
            commodityStock.setId(stock.getId());
            commodityStock.setNowStock(stockNumber);
            this.patchById(commodityStock);
        } else {
            //数据新增
            commodityStock.setNowStock(stockNumber);
            commodityStock.setCommodityName(commodityName);
            commodityStock.setAreaName(areaName);
            commodityStock.setCommodityTypeName(commodityTypeName);
            this.insert(commodityStock);
        }

    }

    /**
     * 物料出库
     */
    @Transactional
    public void outStock(CommodityOut commodityOut) {
        //获取出库信息
        CommodityStock commodityStock = new CommodityStock();
        commodityStock.setAreaCode(commodityOut.getAreaCode());
        commodityStock.setCommodityTypeCode(commodityOut.getCommodityTypeCode());
        commodityStock.setCommodityCode(commodityOut.getCommodityCode());
        commodityStock.setCompany(commodityOut.getCompany());
        //获取当前库存
        CommodityStock stock = getStockNumber(commodityStock);
        Long stockNumber;
        if(StringUtils.isEmpty(stock)) {
            stockNumber = (long)0;
        } else {
            stockNumber = stock.getNowStock();
        }
        //计算当前库存
        stockNumber -= commodityOut.getPutNumber();
        if(stockNumber<0) {
            throw new ValidationException("库存不足，出库失败！");
        }
        //数据更新
        commodityStock.setId(stock.getId());
        commodityStock.setNowStock(stockNumber);
        this.patchById(commodityStock);

    }

    /**
     * 获取当前库存
     */
    public CommodityStock getStockNumber(CommodityStock commodityStock) {
        CommodityStock stock = commodityStockMapper.selectCommodityStock(commodityStock);

        return stock;
    }

    /**
     * 查询库存表信息
     * @param commodityStockCondition
     * @param response
     * @throws IOException
     */
    public void export(CommodityStockCondition commodityStockCondition, HttpServletResponse response) throws IOException {
        List<CommodityStock> commodityStocks = this.selectList(commodityStockCondition);
        createExcel(commodityStocks,response);
    }

    /**
     * 生成excel
     * @param commodityStocks
     * @param response
     * @throws IOException
     */
    public void createExcel(List<CommodityStock> commodityStocks, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("物料出库记录");
        String [] cellValues = {"区域","物料分类","物料名称", "当前库存"};
        //创建表头
        createTitle(sheet,cellValues);
        //写数据
        writeDataMsg(commodityStocks, sheet);

        String fileName = "commodityStock.xls";
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
     * 写数据
     * @param commodityStocks
     * @param sheet
     */
    public void writeDataMsg (List<CommodityStock> commodityStocks, HSSFSheet sheet) {
        CommodityStock commodityStock = null;
        for (int i=0;i<commodityStocks.size();i++) {
            commodityStock = commodityStocks.get(i);
            HSSFRow row =  sheet.createRow(i+1);
            row.createCell(0).setCellValue(commodityStock.getAreaName());
            row.createCell(1).setCellValue(commodityStock.getCommodityTypeName());
            row.createCell(2).setCellValue(commodityStock.getCommodityName());
            row.createCell(3).setCellValue(commodityStock.getNowStock()+"");
        }
    }


    /**
     * 展示物料库存数量
     * @param commodityTypeCode
     * @param commodityCode
     */
    public String calculateStock(String commodityTypeCode, String commodityCode) {

        if("".equals(commodityCode) || commodityCode == null) {
            return "";
        }
        UserContext userContext = SessionHolder.getUserContext();
        String company = userContext.getComCode();
        String areaCode = userContext.getAreaCode();
        CommodityStockCondition commodityStockCondition = new CommodityStockCondition();
        commodityStockCondition.setCompany(company);
        commodityStockCondition.setCommodityCode(commodityCode);
        commodityStockCondition.setCommodityTypeCode(commodityTypeCode);
        commodityStockCondition.setAreaCode(areaCode);
        List<CommodityStock> commodityStocks = this.selectList(commodityStockCondition);
        String nowStock;
        if(commodityStocks.size()>0) {
             nowStock = commodityStocks.get(0).getNowStock() + "";
        } else {
            nowStock = "0";
        }
        return nowStock;

    }

    /**
     * 库存管理，库存求和
     * @return
     */
    public String sumStock(String commodityTypeCode, String commodityCode, String areaCode) {
        UserContext userContext = SessionHolder.getUserContext();
        if ("".equals(commodityCode) || commodityCode == null) {
            return "";
        }
        if ("".equals(areaCode)) {
            if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
                areaCode = userContext.getAreaCode();
            } else {
                areaCode = "";
            }
        }
        CommodityStockCondition commodityStockCondition = new CommodityStockCondition();
        commodityStockCondition.setCompany(userContext.getComCode());
        commodityStockCondition.setCommodityCode(commodityCode);
        commodityStockCondition.setCommodityTypeCode(commodityTypeCode);
        commodityStockCondition.setAreaCode(areaCode);
        List<CommodityStock> commodityStocks = this.selectList(commodityStockCondition);
        int sumStock = 0;
        if(commodityStocks.size() == 0) {
            sumStock = 0;
        } else {
            for (int i=0; i<commodityStocks.size(); i++) {
                Long nowStock = commodityStocks.get(i).getNowStock();
                sumStock += nowStock;
            }
        }

        return sumStock+"";
    }
}