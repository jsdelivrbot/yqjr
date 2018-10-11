package com.yqjr.fin.risk.stat.services;

import com.yqjr.fin.risk.stat.utils.Constant;
import com.yqjr.fin.risk.stat.utils.ScheduleUtils;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.risk.stat.entity.ScheduleJob;
import com.yqjr.fin.risk.stat.mapper.ScheduleJobMapper;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class ScheduleJobService extends BaseService<ScheduleJobMapper, ScheduleJob, Long> {

    @Autowired
    private Scheduler scheduler;

    /** 项目启动时，初始化定时器 */
    @PostConstruct
    public void init(){
        List<ScheduleJob> scheduleJobList = this.selectList(null);
        for(ScheduleJob scheduleJob : scheduleJobList){
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            }else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }
    /**
     * 批量更新定时任务状态
     */
    public int updateBatch(String ids, int status){
        ids="'"+ids.replace(",","','")+"'";
        return mapper.updateBatch(ids,status);
    }
    /**
     * 立即执行
     */
    @Transactional(rollbackFor = Exception.class)
    public void run(String ids) {
        String[] jobIds = ids.split(",");
        for(String jobId : jobIds){
            ScheduleUtils.run(scheduler, this.selectById(Long.parseLong(jobId)));
        }
    }
    /**
     * 暂停运行
     */
    @Transactional(rollbackFor = Exception.class)
    public void pause(String ids) {
        String[] jobIds = ids.split(",");
        for(String jobId : jobIds){
            ScheduleUtils.pauseJob(scheduler, Long.parseLong(jobId));
        }
        updateBatch(ids, Constant.ScheduleStatus.PAUSE.getValue());
    }
    /**
     * 恢复运行
     */
    @Transactional(rollbackFor = Exception.class)
    public void resume(String ids) {
        String[] jobIds = ids.split(",");
        for(String jobId : jobIds){
            ScheduleUtils.resumeJob(scheduler, Long.parseLong(jobId));
        }
        updateBatch(ids, Constant.ScheduleStatus.NORMAL.getValue());
    }

}