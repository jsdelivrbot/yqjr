package com.yqjr.fin.mkmm.sales.common;

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

    /**
     * @Description: date类型时间转成字符串
     * @Param: [date]
     * @return: java.lang.String
     */
    public static String getDateStr(Date date){
        if(null == date){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);
        return  currentDate;
    }

    /**
     * @Description:获取当前日期前i天
     * @Param: []
     * @return: java.lang.String
     */
    public static Date getCurrentBeforeDay(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,-i);
        return calendar.getTime();
    }



    /**
     * 根据年 月 获取对应的月份 天数
     * */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取一年一共多少天
     * */
    public static int getYearDays(int year) {
        int sumDays = 0;
        for(int i=1;i<=12;i++){
           sumDays = sumDays+getDaysByYearMonth(year,i);
       }
       return sumDays;
    }

    /**
     * 获取当前天是一年的第几天
     * */
    public static int getDayOfYear() {
        return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
    }


    public static String getYmdDateStr(Date date){
        if(null == date){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sdf.format(date);
        return  currentDate;
    }
}
