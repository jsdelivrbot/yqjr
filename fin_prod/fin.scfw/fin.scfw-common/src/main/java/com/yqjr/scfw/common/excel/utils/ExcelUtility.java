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
package com.yqjr.scfw.common.excel.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Created by Hyberbin on 14-1-21.
 */
public class ExcelUtility {
    public static void copyCell(Cell srcCell, Cell distCell){
        distCell.setCellStyle(srcCell.getCellStyle());
        if(srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }

        distCell.setCellType(srcCell.getCellTypeEnum());

        if (srcCell.getCellTypeEnum() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(srcCell)) {
                distCell.setCellValue(srcCell.getDateCellValue());
            } else {
                distCell.setCellValue(srcCell.getNumericCellValue());
            }
        } else if (srcCell.getCellTypeEnum() == CellType.STRING) {
            distCell.setCellValue(srcCell.getRichStringCellValue());
        } else if (srcCell.getCellTypeEnum() == CellType.BLANK) {
            //nothing
        } else if (srcCell.getCellTypeEnum() == CellType.BOOLEAN) {
            distCell.setCellValue(srcCell.getBooleanCellValue());
        } else if (srcCell.getCellTypeEnum() == CellType.ERROR) {
            distCell.setCellErrorValue(srcCell.getErrorCellValue());
        } else if (srcCell.getCellTypeEnum() == CellType.FORMULA) {
            distCell.setCellFormula(srcCell.getCellFormula());
        } else {
            //nothing
        }
    }

    //to same sheet
    public static void copyRows(Sheet st,int startRow,int endRow,int pPosition) {
        int pStartRow = startRow;
        int pEndRow = endRow;
        int targetRowFrom;
        int targetRowTo;
        int columnCount;
        CellRangeAddress region = null;
        int i;
        int j;
        for (i = 0; i < st.getNumMergedRegions(); i++) {
            region = st.getMergedRegion(i);
            if ((region.getFirstRow() >= pStartRow)&& (region.getLastRow() <= pEndRow)) {
                targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
                targetRowTo = region.getLastRow() - pStartRow + pPosition;

                CellRangeAddress newRegion = region.copy();

                newRegion.setFirstRow(targetRowFrom);
                newRegion.setFirstColumn(region.getFirstColumn());
                newRegion.setLastRow(targetRowTo);
                newRegion.setLastColumn(region.getLastColumn());
                st.addMergedRegion(newRegion);
            }
        }
        //set the column height and value
        for (i = pStartRow; i <= pEndRow; i++) {
            Row sourceRow = st.getRow(i);
            if(sourceRow != null) {
                columnCount = sourceRow.getLastCellNum();
                Row newRow = st.createRow(pPosition+i);
                newRow.setHeight(sourceRow.getHeight());
                for(j=0;j<columnCount;j++) {
                    Cell templateCell = sourceRow.getCell(j);
                    if(templateCell != null) {
                        Cell newCell = newRow.createCell(j);
                        copyCell(templateCell,newCell);
                    }
                }
            }
        }
    }
}