package com.yqjr.fin.common.base.starter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 正则表达式工具类
 * @author: lixue
 * @date: 2018/09/13 08:45:26
 **/
public class RegularPatternUtil {

    //数字
    public static final String NUMBER_PATTERN = "-?[0-9]+.*[0-9]*";
    //整数
    public static final String INT_PATTERN = "^-?[1-9]\\d*$";
    //正整数
    public static final String POSITIVE_INT_PATTERN = "^[1-9]\\d*|0$";
    //日期 yyyy-MM-dd 支持闰年
    public static final String DATE_PATTERNT = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    //时间 yyyy-MM-dd HH:mm:ss
    public static final String TIME_PATTERN = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)\\\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";



    /**
     * 正则格式匹配
     * @param cellContent 匹配值
     * @param patternStr 匹配格式
     * @return true 匹配 false 不匹配
     */
    public static Boolean regularMatch(String cellContent,String patternStr){
        Pattern pattern = Pattern.compile(patternStr);//^>=
        Matcher matcher = pattern.matcher(cellContent);
        if (matcher.find()) {
            return true;
        }else{
            return false;
        }
    }



}
