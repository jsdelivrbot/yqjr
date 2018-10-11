package com.yqjr.fin.common.base.starter.util.excel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

@Slf4j
public class ExcelWriteKit {

    private short fontSize = 11;

    private CellStyle cellStyleCommon = null;
    private CellStyle cellStyleHeader = null;
    private CellStyle cellStyleNumeric = null;
    private CellStyle cellStyleDate = null;

    private Font fontStyleCommon = null;
    private Font fontStyleBolder = null;

    private boolean isNeedStyle = false;

    public Workbook createWorkbook(String fileType) {
        Workbook wb = null;
        if (ExcelConfig.FT_XLSX.equals(fileType)) {
            wb = new SXSSFWorkbook(-1);

        } else {
            wb = new HSSFWorkbook();
        }
        return wb;
    }

    /**
     * 创建一个内容格，字符串格式
     *
     * @param wb
     *            工作表
     * @param row
     *            行
     * @param cellIndex
     *            列
     * @param cellValue
     *            内容值
     * @return
     */
    public Cell createCell(Workbook wb, Row row, int cellIndex, String cellValue) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellType(ExcelConfig.CT_STRING);
        cell.setCellValue(cellValue);
        cell.setCellStyle(getCommonCellStyle(wb));
        return cell;
    }

    private CellStyle getCommonCellStyle(Workbook wb) {
        if (isNeedStyle) {
            if (cellStyleCommon == null) {
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle = addCellBorder(cellStyle);
                cellStyle.setFont(getCellFont(wb));
                cellStyleCommon = cellStyle;
            }
        }
        return cellStyleCommon;
    }

    /**
     * 创建一个表头内容格
     *
     * @param wb
     *            工作表
     * @param row
     *            列
     * @param cellIndex
     *            行
     * @param cellValue
     *            内容值
     * @return
     */
    public Cell createHeaderCell(Workbook wb, Row row, int cellIndex, String cellValue) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(cellValue);
        cell.setCellStyle(getHeaderCellStyle(wb));
        return cell;
    }

    private CellStyle getHeaderCellStyle(Workbook wb) {
        if (isNeedStyle) {
            if (cellStyleHeader == null) {
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle = addCellBorder(cellStyle);
                cellStyle.setFont(getCellBoldFont(wb));
                cellStyleHeader = cellStyle;
            }
        }
        return cellStyleHeader;
    }

    /**
     * 创建一个数字内容格
     *
     * @param wb
     *            内容表
     * @param row
     *            列
     * @param cellIndex
     *            行
     * @param cellValue
     *            内容值
     * @param formatStr
     *            格式
     * @return
     */
    public Cell createNumericCell(Workbook wb, Row row, int cellIndex, double cellValue, String formatStr) {
        Cell cell = row.createCell(cellIndex, ExcelConfig.CT_NUMERIC);
        cell.setCellValue(cellValue);
        cell.setCellStyle(getNumericCellStyle(wb, formatStr));
        return cell;
    }

    private CellStyle getNumericCellStyle(Workbook wb, String formatStr) {
        if (isNeedStyle) {
            if (cellStyleNumeric == null) {
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle = addCellBorder(cellStyle);
                cellStyle.setFont(getCellFont(wb));

                DataFormat format = wb.createDataFormat();
                cellStyle.setDataFormat(format.getFormat(formatStr));
                cellStyle.setAlignment(HorizontalAlignment.CENTER);

                cellStyleNumeric = cellStyle;
            }
        }
        return cellStyleNumeric;
    }

    /**
     * 创建一个日期内容格
     *
     * @param wb
     *            内容表
     * @param row
     *            列
     * @param cellIndex
     *            行
     * @param cellValue
     *            内容值
     * @param formatStr
     *            格式
     * @return
     */
    public Cell createDateCell(Workbook wb, Row row, int cellIndex, Date cellValue, String formatStr) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(cellValue);
        cell.setCellStyle(getDateCellStyle(wb, formatStr));
        return cell;
    }

    private CellStyle getDateCellStyle(Workbook wb, String formatStr) {
        if (isNeedStyle) {
            if (cellStyleDate == null) {
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle = addCellBorder(cellStyle);
                cellStyle.setFont(getCellFont(wb));
                cellStyleDate = cellStyle;
            }
        }
        return cellStyleDate;
    }

    /**
     * 增加内容格边线
     *
     * @param cellStyle
     * @return
     */
    public CellStyle addCellBorder(CellStyle cellStyle) {
        cellStyle.setBorderBottom(BorderStyle.DOUBLE);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.DASH_DOT);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        return cellStyle;
    }

    /**
     * 获取普通字体
     *
     * @param wb
     *            工作表
     * @return
     */
    public Font getCellFont(Workbook wb) {
        if (fontStyleCommon == null) {
            Font font = wb.createFont();
            font.setFontHeightInPoints(getFontSize());
            fontStyleCommon = font;
        }
        return fontStyleCommon;
    }

    /**
     * 获取加粗字体
     *
     * @param wb
     *            工作表
     * @return
     */
    public Font getCellBoldFont(Workbook wb) {
        if (fontStyleBolder == null) {
            Font font = wb.createFont();
            font.setFontHeightInPoints(getFontSize());
            font.setBold(true);
            fontStyleBolder = font;
        }
        return fontStyleBolder;
    }

    /**
     * 写Excel工作簿
     *
     * @param bean
     *            WriteExcelBean
     * @return Workbook工作簿对象
     */
    public Workbook writeExcel(ExcelWriteBean bean) {
        Workbook wb = createWorkbook(bean.getFileType());
        String sheetName = bean.getSheetName();
        if (sheetName == null || "".equals(sheetName)) {
            sheetName = "sheet1";
        }
        Sheet sheet = wb.createSheet(sheetName);

        // 处理表头内容
        if (bean.getHeaderList().size() > 0) {
            Row row = sheet.createRow(0);
            for (int i = 0; i < bean.getHeaderList().size(); i++) {
                String headerValue = bean.getHeaderList().get(i);
                createHeaderCell(wb, row, i, headerValue);
            }
        }

        // 处理表中内容
        if (bean.getContentList().size() > 0) {
            int rowCount = 1;// 行计数器
            // 没有表头的情况
            if (bean.getHeaderList().size() == 0) {
                rowCount = 0;
            }

            for (List<Object> contentList : bean.getContentList()) {
                Row row = sheet.createRow(rowCount);
                for (int i = 0; i < contentList.size(); i++) {
                    Object cellValue = contentList.get(i);
                    if (getCellType(i, bean.getCellTypeMap()) == ExcelConfig.CT_NUMERIC) {
                        if (cellValue == null) {// 如果值为空，默认填0
                            cellValue = new Integer(0);
                        }
                        createNumericCell(wb, row, i, Double.valueOf(cellValue.toString()),
                                getCellFormat(i, bean.getCellFormatMap()));
                    } else {
                        if (cellValue == null) {// 如果值为空，默认空字符串
                            cellValue = new String("");
                        }
                        createCell(wb, row, i, cellValue.toString());
                    }
                }
                rowCount++;

                if (rowCount % 100 == 0) {
                    try {
                        ((SXSSFSheet) sheet).flushRows(100);
                    } catch (Exception e) {
                        log.error("表格生成时刷新异常", e);
                        throw new CommonBizzException(ServiceResponseEnum.SYSTEM_EXCEPTION);
                    }
                }
            }

        }
        return wb;
    }

    /**
     * 获取cell的类型
     *
     * @param cellIndex
     * @param cellTypeMap
     * @return
     */
    private int getCellType(int cellIndex, HashMap<Integer, Integer> cellTypeMap) {
        int cellType = ExcelConfig.CT_STRING;
        try {
            if (!cellTypeMap.isEmpty()) {
                cellType = cellTypeMap.get(cellIndex);
            }
        } catch (Exception e) {
            cellType = ExcelConfig.CT_STRING;
        }
        return cellType;
    }

    /**
     * 获取cell的格式
     *
     * @param cellIndex
     * @param cellFormatMap
     * @return
     */
    private String getCellFormat(int cellIndex, HashMap<Integer, String> cellFormatMap) {
        String cellFormat = "";
        try {
            if (!cellFormatMap.isEmpty()) {
                cellFormat = cellFormatMap.get(cellIndex);
            }
        } catch (Exception e) {
            cellFormat = "";
        }
        return cellFormat;
    }


    public short getFontSize() {
        return fontSize;
    }

    public void setFontSize(short fontSize) {
        this.fontSize = fontSize;
    }

    public CellStyle getCellStyleCommon() {
        return cellStyleCommon;
    }

    public void setCellStyleCommon(CellStyle cellStyleCommon) {
        this.cellStyleCommon = cellStyleCommon;
    }

    public CellStyle getCellStyleHeader() {
        return cellStyleHeader;
    }

    public void setCellStyleHeader(CellStyle cellStyleHeader) {
        this.cellStyleHeader = cellStyleHeader;
    }

    public CellStyle getCellStyleNumeric() {
        return cellStyleNumeric;
    }

    public void setCellStyleNumeric(CellStyle cellStyleNumeric) {
        this.cellStyleNumeric = cellStyleNumeric;
    }

    public CellStyle getCellStyleDate() {
        return cellStyleDate;
    }

    public void setCellStyleDate(CellStyle cellStyleDate) {
        this.cellStyleDate = cellStyleDate;
    }

    public Font getFontStyleCommon() {
        return fontStyleCommon;
    }

    public void setFontStyleCommon(Font fontStyleCommon) {
        this.fontStyleCommon = fontStyleCommon;
    }

    public Font getFontStyleBolder() {
        return fontStyleBolder;
    }

    public void setFontStyleBolder(Font fontStyleBolder) {
        this.fontStyleBolder = fontStyleBolder;
    }

    public boolean getIsNeedStyle() {
        return isNeedStyle;
    }

    public void setIsNeedStyle(boolean isNeedStyle) {
        this.isNeedStyle = isNeedStyle;
    }
}
