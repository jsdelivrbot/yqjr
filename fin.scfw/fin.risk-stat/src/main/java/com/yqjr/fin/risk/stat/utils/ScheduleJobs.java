package com.yqjr.fin.risk.stat.utils;

import com.alibaba.fastjson.JSON;
import com.yqjr.fin.risk.stat.utils.SpringContextUtils;
import com.yqjr.fin.risk.stat.entity.ScheduleJob;
import com.yqjr.fin.risk.stat.entity.ScheduleLog;
import com.yqjr.fin.risk.stat.services.ScheduleLogService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务
 *
 * @author cuiyan
 * @since 2018/9/6
 */
public class ScheduleJobs extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService service = Executors.newSingleThreadExecutor(); 
	
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//		ScheduleJob schedule = (ScheduleJob) context.getMergedJobDataMap()
//        		.get(ScheduleJob.JOB_PARAM_KEY);

		Object temp = context.getMergedJobDataMap().get(ScheduleJob.JOB_PARAM_KEY);
		ScheduleJob schedule=new ScheduleJob();
		System.out.println(temp);
		if (temp instanceof ScheduleJob){
			schedule= (ScheduleJob) temp;
		}else {
			String string = JSON.toJSON(temp).toString();
			System.out.println(string);
			schedule = JSON.parseObject(string, ScheduleJob.class);
		}

        //获取spring bean
		ScheduleLogService scheduleLogService = (ScheduleLogService) SpringContextUtils.getBean("scheduleLogService");

        //数据库保存执行记录
		ScheduleLog log = new ScheduleLog();
        log.setJobId(schedule.getId());
        log.setBeanName(schedule.getBeanName());
        log.setMethodName(schedule.getMethodName());
        log.setParams(schedule.getParams());
        log.setCreateTime(new Date());
        
        //任务开始时间
        long startTime = System.currentTimeMillis();
        
        try {
            //执行任务
        	logger.info("任务准备执行，任务ID：" + schedule.getId());
            ScheduleRunnable task = new ScheduleRunnable(schedule.getBeanName(),
					schedule.getMethodName(), schedule.getParams());
            Future<?> future = service.submit(task);
            
			future.get();
			
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			//任务状态    0：成功    1：失败
			log.setStatus(0);
			
			logger.info("任务执行完毕，任务ID：" + schedule.getId() + "  总共耗时：" + times + "毫秒");
		} catch (Exception e) {
			logger.error("任务执行失败，任务ID：" + schedule.getId(), e);
			
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			
			//任务状态    0：成功    1：失败
			log.setStatus(1);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
		}finally {
			//scheduleLogService.insert(log);
		}
    }
}
