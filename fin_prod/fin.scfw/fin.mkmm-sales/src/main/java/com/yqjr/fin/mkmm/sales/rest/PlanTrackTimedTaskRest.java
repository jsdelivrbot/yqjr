package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.DateUtils;
import com.yqjr.fin.mkmm.sales.entity.ActiveMatchTask;
import com.yqjr.fin.mkmm.sales.services.PlanTrackTimedTaskService;
import com.yqjr.scfw.common.excel.utils.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @description: 计划跟踪定时任务(人员、团队)
 * @author: lixue
 * @date: 2018/06/06 08:30:05
 **/
@RestController
@RequestMapping(value = "/planTrackTimedTask")
public class PlanTrackTimedTaskRest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlanTrackTimedTaskService planTrackTimedTaskService;

    @ApiOperation(value = "构建计划跟踪任务")
    @RequestMapping(value = "/build")
    public void buildPlanTrackTask(){
        logger.info("buildPlanTrackTask start");
        try {
            planTrackTimedTaskService.buildPlanTrackTask();
        }catch (Exception e){
            logger.error("构建计划跟踪任务，msg = " + e.getMessage(),e);
        }
        logger.info("buildPlanTrackTask end");
    }


    @ApiOperation(value = "人员销售计划追踪")
    @RequestMapping(value = "/track")
    public void planTrack(){
        logger.info("planBusinessMatch start");
        List<ActiveMatchTask> activeMatchTaskList = planTrackTimedTaskService.getUnexecutedTask();
        for (ActiveMatchTask activeMatchTask : activeMatchTaskList) {
            try {
                planTrackTimedTaskService.planTrack(activeMatchTask);
            } catch (Exception e) {
                logger.error("人员销售计划追踪，taskId = "+activeMatchTask.getId()+"，msg = " + e.getMessage(),e);
            }
        }
        logger.info("planBusinessMatch end");
    }







}
