package com.yqjr.fin.risk.stat.rest;


import java.util.*;
import com.yqjr.fin.risk.stat.common.ResultMsg;
import com.yqjr.fin.risk.stat.utils.ScheduleUtils;
import com.yqjr.fin.risk.stat.utils.TimeSetting;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.rest.BaseRest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.risk.stat.common.JQGridJsonResult;
import com.yqjr.fin.risk.stat.entity.ScheduleJob;
import com.yqjr.fin.risk.stat.condition.ScheduleJobCondition;
import com.yqjr.fin.risk.stat.services.ScheduleJobService;
import org.quartz.Scheduler;

@Api(consumes = "application/json", produces = "application/json",protocols = "http",basePath = "scheduleJobs")
@RestController
@RequestMapping(value = "/scheduleJobs")
public class ScheduleJobRest extends BaseRest<ScheduleJobService, ScheduleJob> {
    @Autowired
    private Scheduler scheduler;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询自动任务表（参数：实体对象属性、pageNum、pageSize）", tags = "自动任务表信息：ScheduleJobRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ScheduleJob> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            ScheduleJobCondition condition) {
        List<ScheduleJob> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<ScheduleJob> pageList = new PageInfo<>(list);
        JQGridJsonResult<ScheduleJob> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }
    @ApiOperation(value = "删除自动任务", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultMsg<String> delete(String ids) {
        String[] str = ids.split(",");
        List<Long> id=new ArrayList<>();
        for (String str1:str) {
            ScheduleUtils.deleteScheduleJob(scheduler, Long.parseLong(str1));
            id.add(Long.parseLong(str1));
        }
        try {
            logger.info("开始删除id为:"+id);
            baseService.deleteByIds(id);
            logger.info("删除id为:"+id+"成功");
            return new ResultMsg<String>(Const.CODE_SUCCESS, "删除成功", Const.SUCCESS, "");
        } catch (Exception e) {
            logger.error("根据id删除指标类型错误",e);
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
    }

    @ApiOperation(value = "新增自动任务", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultMsg<String> add(ScheduleJob it) {
        try {
            logger.info("新增自动任务");
            it.setStatus(1);
            it.setExecutionTime( TimeSetting.translation(it.getCronExpression()));
            baseService.insert(it);
            System.out.println("-----------");
          // ValidatorUtils.validateEntity(it);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "添加成功", Const.SUCCESS, "");
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
    }

    @ApiOperation(value = "多个自动任务修改", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ResultMsg<String> update(ScheduleJob it) {
        try {
            logger.info("修改自动任务");
            it.setExecutionTime( TimeSetting.translation(it.getCronExpression()));
            baseService.patchById(it);
           // ValidatorUtils.validateEntity(it);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "修改成功", Const.SUCCESS, "");
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "修改出现错误", Const.FAILURE, "");
        }
    }

    @ApiOperation(value = "查寻单个自动任务", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody ObjectResultResponse<ScheduleJob> findById(Long id) {
        logger.info("查询单个自动任务");
        ScheduleJob scheduleJob = baseService.selectById(id);
        scheduleJob.setCreateTime(null);
        scheduleJob.setModifyTime(null);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_CHECK_SUCCESS, scheduleJob);
    }



    @ApiOperation(value = "根据id暂停自动任务", tags = "")
    @RequestMapping(value = "/pause", method = RequestMethod.GET)
    public ResultMsg<String> pause(String ids) {
        try {
            logger.info("暂停自动任务");
            baseService.pause(ids);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "暂停成功", Const.SUCCESS, "");
        } catch (Exception e) {
            logger.error("暂停自动任务错误",e);
            return new ResultMsg<String>(Const.CODE_FAILURE, "暂停错误", Const.FAILURE, "");
        }
    }

    @ApiOperation(value = "根据idj恢复自动任务", tags = "用户信息：UserController")
    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public ResultMsg<String> resume(String ids) {
        try {
            logger.info("恢复自动任务");
            baseService.resume(ids);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "恢复成功", Const.SUCCESS, "");
        } catch (Exception e) {
            logger.error("根据id恢复自动任务错误",e);
            return new ResultMsg<String>(Const.CODE_FAILURE, "恢复错误", Const.FAILURE, "");
        }
    }
    @ApiOperation(value = "根据idj立即执行自动任务", tags = "用户信息：UserController")
    @RequestMapping(value = "/runOnce", method = RequestMethod.GET)
    public ResultMsg<String> runOnce(String ids) {
        try {
            logger.info("立即执行自动自动任务");
            baseService.run(ids);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "立即执行成功", Const.SUCCESS, "");
        } catch (Exception e) {
            logger.error("立即执行自动任务错误",e);
            return new ResultMsg<String>(Const.CODE_FAILURE, "立即执行错误", Const.FAILURE, "");
        }
    }
}