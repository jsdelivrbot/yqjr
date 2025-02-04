package com.yqjr.fin.mkmm.sales.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class EventHisPerson extends BaseEntity<EventHisPerson> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/eventHisPerson/list
     *表单维护路径：/eventHisPerson/form
     *
     */

    /**
     * 事件序号
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 事件编号
     */
    @Length(min = 0, max = 50)
    private java.lang.String eventCode;

    /**
     * 事件年度
     */
    @Length(min = 0, max = 50)
    private java.lang.String eventYear;

    /**
     * 受理单位
     */
    @Length(min = 0, max = 50)
    private java.lang.String eventApart;

    /**
     * 内容
     */
    @Length(min = 0, max = 50)
    private java.lang.String eventText;

    /**
     * 事件归属编号
     */
    @Length(min = 0, max = 12)
    private java.lang.String code;

    /**
     * 事件状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String eventStatus;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

    /**
     * 操作员
     */
    @Length(min = 0, max = 50)
    private java.lang.String operatePerson;

    /**
     * 操作状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String operateStatus;

    /**
     * 最新标识
     */
    @Length(min = 0, max = 10)
    private java.lang.String flag;

    /**
     * 备注
     */
    @Length(min = 0, max = 256)
    private java.lang.String remark;

    /**
     * 备注1
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode1;

    /**
     * 备注2
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode2;

    /**
     * 备注3
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode3;

    /**
     * 备注4
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode4;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 修改人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getEventCode() {
        return this.eventCode;
    }

    public void setEventCode(java.lang.String eventCode) {
        this.eventCode = eventCode;
    }

    public java.lang.String getEventYear() {
        return this.eventYear;
    }

    public void setEventYear(java.lang.String eventYear) {
        this.eventYear = eventYear;
    }

    public java.lang.String getEventApart() {
        return this.eventApart;
    }

    public void setEventApart(java.lang.String eventApart) {
        this.eventApart = eventApart;
    }

    public java.lang.String getEventText() {
        return this.eventText;
    }

    public void setEventText(java.lang.String eventText) {
        this.eventText = eventText;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }

    public java.lang.String getEventStatus() {
        return this.eventStatus;
    }

    public void setEventStatus(java.lang.String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.lang.String getOperatePerson() {
        return this.operatePerson;
    }

    public void setOperatePerson(java.lang.String operatePerson) {
        this.operatePerson = operatePerson;
    }

    public java.lang.String getOperateStatus() {
        return this.operateStatus;
    }

    public void setOperateStatus(java.lang.String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getTranscode1() {
        return this.transcode1;
    }

    public void setTranscode1(java.lang.String transcode1) {
        this.transcode1 = transcode1;
    }

    public java.lang.String getTranscode2() {
        return this.transcode2;
    }

    public void setTranscode2(java.lang.String transcode2) {
        this.transcode2 = transcode2;
    }

    public java.lang.String getTranscode3() {
        return this.transcode3;
    }

    public void setTranscode3(java.lang.String transcode3) {
        this.transcode3 = transcode3;
    }

    public java.lang.String getTranscode4() {
        return this.transcode4;
    }

    public void setTranscode4(java.lang.String transcode4) {
        this.transcode4 = transcode4;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
