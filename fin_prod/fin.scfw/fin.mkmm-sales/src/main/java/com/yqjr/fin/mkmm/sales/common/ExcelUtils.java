package com.yqjr.fin.mkmm.sales.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 下载excel表格
     * @param filePath
     * @param fileName
     * @param response
     */
    public static void excelDownLoad(String filePath, String fileName, HttpServletResponse response) {
        File file = new File(filePath);
        InputStream ins= null;
        BufferedInputStream bins = null;
        BufferedOutputStream bouts = null;
        OutputStream outs= null;
        //清空response
        response.reset();
        try {
            ins = new FileInputStream(file);
            response.setContentType("application/x-download");
            response.setHeader("Content-Type","application/force-download");
            response.setHeader("Content-Type","application/vnd.ms-excel");
            //设置文件大小
            response.setContentLength((int) file.length());
            //设置头部信息
            response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            outs = response.getOutputStream();
            bouts=new BufferedOutputStream(outs);
            bins=new BufferedInputStream(ins);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            //开始向网络传输文件流
            while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                bouts.write(buffer, 0, bytesRead);
            }
            bouts.flush();
        }catch (IOException e) {
            logger.error("IO异常", e);
        } finally {
            try {
                //关闭流
                ins.close();
                bins.close();
                outs.close();
                bouts.close();
            } catch (IOException e) {
                logger.error("IO异常", e);
            }

        }
    }

    /**
     *  上传excel
     * @param file
     * @param filePath
     * @return
     * @throws IOException
     */
    public static File upLoadExcel(MultipartFile file, String filePath) throws IOException {
        File newFile = new File(filePath);
        //判断是否存在，存在则删除
        if (newFile.exists()) {
            newFile.delete();
        }
        //新建
        newFile.createNewFile();
        //上传表格
        file.transferTo(new File(filePath));
        return newFile;
    }
}
