package com.yqjr.fin.mkmm.sales.rest;


import com.alibaba.fastjson.JSONObject;
import com.yqjr.fin.mkmm.sales.common.DateUtils;
import com.yqjr.fin.mkmm.sales.entity.ActiveMain;
import com.yqjr.fin.mkmm.sales.entity.ActiveMatchTask;
import com.yqjr.fin.mkmm.sales.services.ActiveMainService;
import com.yqjr.fin.mkmm.sales.services.ActiveMatchTaskService;
import com.yqjr.fin.mkmm.sales.services.ActiveTimedTaskService;
import com.yqjr.scfw.common.excel.utils.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description: 活动匹配明细定时任务
 * @author: lixue
 * @date: 2018/05/30 08:37:02
 **/
@RestController
@RequestMapping(value = "/activeTimedTask")
public class ActiveTimedTaskRest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActiveTimedTaskService activeTimedTaskService;

    @ApiOperation(value = "构建活动匹配任务", tags = "活动主表：ActiveTimedTaskRest")
    @RequestMapping(value = "/build")
    public void buildActiveMatchTask(){
        logger.info("buildActiveMatchTask start");
        try {
            activeTimedTaskService.buildActiveMatchTask();
        }catch (Exception e){
            logger.error("构建活动匹配任务异常，msg = " + e.getMessage(),e);
        }
        logger.info("buildActiveMatchTask end");
    }

    @ApiOperation(value = "活动业务明细匹配")
    @RequestMapping(value = "/match")
    public void activeBusinessMatch(){
        logger.info("activeBusinessMatch start");
        List<ActiveMatchTask> activeMatchTaskList = activeTimedTaskService.getUnexecutedTask();
        for (ActiveMatchTask activeMatchTask : activeMatchTaskList) {
            logger.info("任务执行，id = " + activeMatchTask.getId());
            try {
                activeTimedTaskService.taskMatchTransactional(activeMatchTask);
            } catch (Exception e) {
                logger.error("活动业务明细匹配异常，taskId = "+activeMatchTask.getId()+"，msg = " + e.getMessage(),e);
            }
        }
        logger.info("activeBusinessMatch end");
    }




}
