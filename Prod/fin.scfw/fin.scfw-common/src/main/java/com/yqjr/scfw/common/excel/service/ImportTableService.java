/*
 * Copyright 2015 www.hyberbin.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Email:hyberbin@qq.com
 */
package com.yqjr.scfw.common.excel.service;

import com.yqjr.scfw.common.excel.adapter.ICellReaderAdapter;
import com.yqjr.scfw.common.excel.bean.BaseExcelVo;
import com.yqjr.scfw.common.excel.bean.CellBean;
import com.yqjr.scfw.common.excel.bean.TableBean;
import com.yqjr.scfw.common.excel.handler.LoadCellHandler;
import com.yqjr.scfw.common.excel.utils.ConverString;
import com.yqjr.scfw.common.excel.utils.FieldUtils;
import com.yqjr.scfw.common.excel.utils.ObjectHelper;
import com.yqjr.scfw.common.excel.utils.Reflections;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对规定格式的Excel进行导入. 适配器由用户自己定义或者直接将常规类型的数据直接批量读取到数据库. Created by hyberbin on
 * 15/7/31.
 */
public class ImportTableService {

    private Sheet sheet;
    private TableBean tableBean;
    private ICellReaderAdapter defaultCellReaderAdapter;
    private Integer startRow = 0;
    private Map<Integer, Integer> forceCellType = new HashMap();
    private String dateFormat = "yyyy/MM/dd";
    private Map<Integer, LoadCellHandler> cellHandlerMap = new HashMap<Integer, LoadCellHandler>();

    public ImportTableService(Sheet sheet) {
        this.sheet = sheet;
    }

    public ImportTableService(Sheet sheet, ICellReaderAdapter defaultCellReaderAdapter) {
        this.sheet = sheet;
        this.defaultCellReaderAdapter = defaultCellReaderAdapter;
    }

    public void setCellType(int columnIndex, int type) {
        forceCellType.put(columnIndex, type);
    }

    /**
     * 从Excel导入到TableBean
     */
    public void doImport() {
        int rowNum = sheet.getLastRowNum() + 1;
        int columnNum = 0;
        for (int i = 0; i < rowNum; i++) {
            if (sheet.getRow(i) != null) {
                int last = sheet.getRow(i).getLastCellNum();
                columnNum = last > columnNum ? last : columnNum;
            }
        }
        tableBean = new TableBean(rowNum, columnNum);
        Collection<CellBean> cellBeans = new ArrayList<CellBean>();
        for (int r = startRow; r < rowNum; r++) {
            Row row = sheet.getRow(r);
            if (row != null) {
                for (int c = 0; c < row.getLastCellNum(); c++) {
                    Cell cell = row.getCell(c);
                    if (cell != null) {
                        String cellValue = null;
                        if (cellHandlerMap.containsKey(c)) {
                             cellValue=cellHandlerMap.get(c).readCell(cell)+"";
                        } else {
                            cell.setCellType(CellType.STRING);
                            Integer type = forceCellType.get(c);
                            if (type != null) {
                                cell.setCellType(type);
                            }
                            if (CellType.BOOLEAN == cell.getCellTypeEnum()) {
                                cellValue = cell.getBooleanCellValue() + "";
                            } else if (CellType.FORMULA == cell.getCellTypeEnum()) {
                                try {
                                    cellValue = String.valueOf(cell.getNumericCellValue());
                                } catch (IllegalStateException e) {
                                    cellValue = String.valueOf(cell.getRichStringCellValue()).trim();
                                }
                            } else if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    Date date2 = cell.getDateCellValue();
                                    SimpleDateFormat dff = new SimpleDateFormat(dateFormat);
                                    cellValue = dff.format(date2);   //日期转化
                                } else {
                                    cellValue = String.valueOf(cell.getNumericCellValue());
                                }
                            } else if (CellType.STRING == cell.getCellTypeEnum()) {
                                cellValue = cell.getStringCellValue();
                            }
                            if (null != cellValue) {
                                cellValue = cellValue.trim();
                            }
                        }
                            CellBean cellBean = new CellBean(cellValue, r, c);
                            cellBean.setCell(cell);
                            cellBeans.add(cellBean);
                    }
                }
            }
        }
        tableBean.setCellBeans(cellBeans);
    }

    /**
     * 整个读取
     *
     * @return
     */
    public Object read() {
        if (tableBean == null) {
            doImport();
        }
        return defaultCellReaderAdapter.read(tableBean);
    }

    /**
     * 读取内容到List,可以是List<Map>也可以是List<Object>
     *
     * @param sortedColumns 从第0列开始,数组中每个元素对应type中的一个字段,元素为空则忽略
     * @param type 读取数据存放的类型
     * @param <T> 泛型
     * @return
     */
    public <T> List<T> read(String[] sortedColumns, Class<? extends T> type) {
        List<T> list = new ArrayList(tableBean.getRowCount());
        for (int i = startRow; i < tableBean.getRowCount(); i++) {
            boolean is = Map.class.isAssignableFrom(type);
            Object bean = is ? new HashMap() : Reflections.instance(type.getName());
            for (int j = 0; j < sortedColumns.length; j++) {
                String column = sortedColumns[j];
                if (ObjectHelper.isNotEmpty(column)) {
                    CellBean cellBean = tableBean.getCellBean(i, j);
                    if (cellBean != null) {
                        Cell cell = cellBean.getCell();
                        if (cell == null) {
                            cell = sheet.getRow(i).createCell(j);
                        }
                        if (bean instanceof Map) {
                            FieldUtils.setFieldValue(bean, "cell" + column, cell);
                            if (ObjectHelper.isNotEmpty(cellBean.getContent())) {
                                FieldUtils.setFieldValue(bean, column, cellBean.getContent());
                            }
                        } else {
                            if (bean instanceof BaseExcelVo) {
                                BaseExcelVo baseExcelVo = ((BaseExcelVo) bean);
                                baseExcelVo.setCell(column, cell);
                                baseExcelVo.setRow(i);
                                baseExcelVo.setCol(j);
                            }
                            Field accessibleField = Reflections.getAccessibleField(bean, column);
                            Class<?> fieldType = accessibleField.getType();
                            Object value = cellBean.getContent();
                            if (!fieldType.equals(String.class)) {
                                value = ConverString.asType(fieldType, cellBean.getContent());
                            }
                            if (ObjectHelper.isNotEmpty(cellBean.getContent())) {
                                FieldUtils.setFieldValue(bean, column, value);
                            }
                        }
                    }
                }
            }
            list.add((T) bean);
        }
        return list;
    }

    public void setCellHandler(Integer column, LoadCellHandler handler) {
        cellHandlerMap.put(column, handler);
    }

    /**
     * 预读取,用于数据校验
     *
     * @param tableBean
     * @return
     */
    public void preRead(TableBean tableBean) {
        defaultCellReaderAdapter.preRead(tableBean);
    }

    public TableBean getTableBean() {
        if (tableBean == null) {
            doImport();
        }
        return tableBean;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

}
