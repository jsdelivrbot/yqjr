package com.yqjr.fin.common.base.starter.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class ExcelReadKit {

    /**
     *
     * @param file
     *            文件
     * @param sheetIndex
     *            第x个sheet
     * @return
     */
    public static ExcelReadResultBean readExcel(MultipartFile file, int sheetIndex) {
        ExcelReadResultBean resultBean = new ExcelReadResultBean();
        String filePath = file.getOriginalFilename();
        try {
            Sheet sheet = null;
            Workbook wb = null;
            InputStream fis = file.getInputStream(); // 根据excel文件路径创建文件流

            if (filePath.endsWith(ExcelConfig.FT_XLS)) {
                wb = new HSSFWorkbook(fis); // 读取excel工作簿
                sheet = wb.getSheetAt(sheetIndex); // 读取excel的sheet，0表示读取第一个
            } else {
                wb = new XSSFWorkbook(fis);// 读取excel工作簿
                sheet = wb.getSheetAt(sheetIndex); // 读取excel的sheet，0表示读取第一个
            }
            resultBean = realSheetValue(sheet);
        } catch (Exception e) {
            log.error("[读取Excel<{}>出错]：", filePath, e);
            resultBean.setResult(false);
            resultBean.setErrMsg("读取Excel文件出错");
        }
        return resultBean;
    }

    /***
     * 读取单元格的值
     *
     * @Title: getCellValue
     * @Date : 2016-7-27 上午10:52:07
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    // 判断是否日期类型
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date dateValue = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                        result =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateValue);
                    } else {
                        result = cell.getNumericCellValue();
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    // 读取公式的值
                    try {
                        result = String.valueOf(cell.getNumericCellValue());
                    } catch (IllegalStateException e) {
                        result = String.valueOf(cell.getRichStringCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

    /**
     * 读取sheet页的数据转化为ExcelReadResultBean对象中
     * @param sheet
     * @return
     */
    private static ExcelReadResultBean realSheetValue(Sheet sheet) {
        ExcelReadResultBean resultBean = new ExcelReadResultBean();
        boolean result = true;
        String errMsg = "";
        List<List<String>> list = new ArrayList<List<String>>();

        int i = 0, j = 0;
        for (i = 0; i <= sheet.getLastRowNum(); i++) {
            try {
                Row row = sheet.getRow(i); // 取出sheet中的某一行数据
                if (row != null) {
                    List<String> rowList = new ArrayList<String>(row.getPhysicalNumberOfCells());
                    // 获取该行中总共有多少列数据row.getLastCellNum()
                    for (j = 0; j < row.getLastCellNum(); j++) {
                        try {
                            // 获取该行中的一个单元格对象
                            Cell cell = row.getCell(j);

                            if (cell != null) {// 判断cell是否为空
                                //判断是否具有合并单元格
                                boolean isMerge = isMergedRegion(sheet, i, cell.getColumnIndex());
                                if(isMerge) {
                                    //该单元格存在合并
                                    String rs = getMergedRegionValue(sheet, row.getRowNum(), cell.getColumnIndex());
                                    rowList.add(rs);
                                }else {
                                    rowList.add(getCellValue(cell));
                                }

                            } else {// 如果cell为空，用空格字段代替
                                rowList.add("");
                            }

                        } catch (Exception e) {
                            log.error("读取{}行{}列时出错", i + 1, j + 1);
                            result = false;
                            errMsg = errMsg + "读取" + (i + 1) + "行" + (j + 1) + "列时出错;";
                            rowList.add("");
                        }
                    }
                    list.add(rowList);
                }
            } catch (Exception e) {
                log.error("读取{}行时出错", i + 1);
                result = false;
                errMsg = errMsg + "读取" + (i + 1) + "行时出错";
            }
        }

        resultBean.setResult(result);
        resultBean.setErrMsg(errMsg);
        resultBean.setContentList(list);
        return resultBean;
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }
    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private static boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }
}