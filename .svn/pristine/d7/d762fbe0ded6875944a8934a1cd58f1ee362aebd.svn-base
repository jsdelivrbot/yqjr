package com.yqjr.fin.risk.stat.task;

import com.yqjr.fin.risk.stat.task.Mapper.AutomaticTaskMapper;
import com.yqjr.scfw.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component("AutomaticTask")
public class AutomaticTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AutomaticTaskMapper automaticTaskMapper;

    public void autoRunDay(String params){
        logger.info("正在执行的自动任务为:"+params);
        String[] str=params.split(",");
        Date date =new Date();
        if(str.length>1){
            try {
                date=DateUtils.getDate(str[1],"yyyy-MM-dd");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Calendar calendar = Calendar.getInstance();
		    calendar.add(Calendar.DAY_OF_MONTH, -1);
            date = calendar.getTime();
        }
        Map<String,Object> map= new HashMap<>();
        map.put("bizdate",date);
        map.put("methodName",params);
        try {
            automaticTaskMapper.autoRunDay(map);
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            logger.error("执行自动任务:"+params+"出现错误");
            e.printStackTrace();
        }
    }

    public void autoRunMonth(String params){
        logger.info("正在执行的自动任务为:"+params);
        String[] str=params.split(",");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        String date =DateUtils.getDate(calendar.getTime(),"yyyy-MM-dd");
        if(str.length>1){ date=str[1];}
        Map<String,Object> map= new HashMap<>();
        map.put("p_theyear",date.substring(0,4));
        map.put("p_themonth",date.substring(5,7));
        map.put("methodName",params);
        try {
            automaticTaskMapper.autoRunMonth(map);
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            logger.error("执行自动任务:"+params+"出现错误");
            e.printStackTrace();
        }
    }

    public void autoRunYear(String params){
        logger.info("正在执行的自动任务为:"+params);
        String[] str=params.split(",");
        Date date =new Date();
        if(str.length>1){
            try {
                date=DateUtils.getDate(str[1],"yyyy-MM-dd");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -1);
            date = calendar.getTime();
        }
        Map<String,Object> map= new HashMap<>();
        map.put("bizdate",date);
        map.put("methodName",params);
        try {
            automaticTaskMapper.autoRunDay(map);
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            logger.error("执行自动任务:"+params+"出现错误");
            e.printStackTrace();
        }
    }
}
