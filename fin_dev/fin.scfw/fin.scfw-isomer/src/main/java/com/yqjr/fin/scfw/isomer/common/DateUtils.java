package com.yqjr.fin.scfw.isomer.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前天数的后 i 天
     * @param i
     * @return
     */
    public static Date getDateUtil(int i) {
        Date newDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.add(Calendar.DAY_OF_MONTH, i);
        newDate = calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = java.sql.Date.valueOf(sdf.format(newDate));
//        System.out.println(date);
        return date;
    }

    /**
     * 当前日期已过天数
     * @return
     * @throws ParseException
     */
    public static int getDateNum() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
//        System.out.println(sdf.format(date));
        String year = time.substring(0,4);
        String begTime = year+"-01-01";
        long l = date.getTime()-sdf.parse(begTime).getTime();
        long day = l / (24 * 60 * 60 * 1000);
//        System.out.println("过了"+day+"天");
        return Integer.parseInt(day+"");
    }

    /**
     * 获取当前年的天数
     * @return
     */
    public static int getDateYear(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String now = sdf.format(date);
        int year = Integer.parseInt(now);
        int days;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){//闰年的判断规则
             days = 366;
        }else{
             days = 365;
        }
        return days;
    }

    /**
     * 计算年序时进度
     * @return
     * @throws ParseException
     */
    public static Double queryRate() throws ParseException {
        //当前日期已过天数
        int days= DateUtils.getDateNum();
        //获取当前年的天数
        int all = DateUtils.getDateYear();
        Double rate =  (days*1.00)/all;
        return rate;
    }

}
