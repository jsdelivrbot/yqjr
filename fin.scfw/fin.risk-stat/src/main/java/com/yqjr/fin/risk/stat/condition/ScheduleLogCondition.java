
package com.yqjr.fin.risk.stat.condition;

import com.yqjr.fin.risk.stat.entity.ScheduleLog;
import com.yqjr.scfw.common.condition.BaseCondition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

public class ScheduleLogCondition extends BaseCondition<ScheduleLog, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/scheduleLog/list
     *表单维护路径：/scheduleLog/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 任务id
     */
    @Digits(fraction =22,integer=0)
    private Long jobId;

    /**
     * 类名称
     */
    @Length(min = 0, max = 100)
    private String beanName;

    /**
     * 方法名称
     */
    @Length(min = 0, max = 100)
    private String methodName;

    /**
     * 参数
     */
    @Length(min = 0, max = 500)
    private String params;

    /**
     * 任务状态
     */
    @Digits(fraction =22,integer=0)
    private Long status;

    /**
     *  失败信息
     */
    @Length(min = 0, max = 2000)
    private String error;

    /**
     * 耗时(单位：毫秒)
     */
    @Digits(fraction =22,integer=0)
    private Long times;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后更新人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最后更新时间
     */
    private String modifyTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getBeanName() {
        return this.beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getTimes() {
        return this.times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}