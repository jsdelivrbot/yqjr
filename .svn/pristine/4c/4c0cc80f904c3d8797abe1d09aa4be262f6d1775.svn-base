package com.yqjr.fin.common.base.starter.util.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;

@Slf4j
public class WebExcelWriteKit extends ExcelWriteKit {

    /**
     * 输出成文档
     *
     * @param wb
     *            工作表
     * @param fileName
     *            文件名
     * @param response
     */
    public static void output(Workbook wb, String fileName, HttpServletRequest request, HttpServletResponse response) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            wb.write(os);

            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);

            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+fileName);

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[2048];
            int bytesRead;

            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            log.error("输出Excel出错:", e);
        } catch (Exception e) {
            log.error("输出Excel出错:", e);
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
                if (os != null)
                    os.close();
            } catch (Exception e) {
                log.error("输出Excel出错:{}", e);
            }
        }
    }

    /**
     * 从页面上输出Excel
     *
     * @param bean
     *            WriteExcelBean
     * @param response
     */
    public static void outputExcel(ExcelWriteBean bean, HttpServletRequest request, HttpServletResponse response) {
        ExcelWriteKit excelWriteKit = new ExcelWriteKit();
        Workbook wb = excelWriteKit.writeExcel(bean);
        String fileName = bean.getFileName() + "." + bean.getFileType();
        output(wb, fileName, request, response);
    }

    /**
     * 将jsonobject 集合转化为 ExcelWriteBean对象
     * 该方法只应用于表头为一行的表格生成
     * @param jsonObjectList
     * @return
     */
    public static ExcelWriteBean JSONObjToExcelWriteBean(List<JSONObject> jsonObjectList){

        ExcelWriteBean excelWriteBean = new ExcelWriteBean();
        //初始化Key值
        Set<String> set = null;
        // 内容列表
        List<List<Object>> contentList = new ArrayList<List<Object>>();
        /**
         * 放入头数据和内容数据
         */
        for (JSONObject jsonObject : jsonObjectList){
            List<Object> rowList = new ArrayList<Object>();
            if(set == null) {
                set = jsonObject.keySet();
                excelWriteBean.setHeaderList(new ArrayList<>(set));
            }
            for (String s : set){
                rowList.add(jsonObject.get(s));
            }
            contentList.add(rowList);
        }
        excelWriteBean.setContentList(contentList);
        return excelWriteBean;
    }
}
