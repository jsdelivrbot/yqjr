
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.ActiveAdditionReview;

public class ActiveAdditionReviewCondition extends BaseCondition<ActiveAdditionReview, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/activeAdditionReview/list
     *表单维护路径：/activeAdditionReview/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 活动_ID
     */
    @Digits(fraction =22,integer=0)
    private Long activeReviewId;

    /**
     * 活动编号
     */
    @Length(min = 0, max = 32)
    private java.lang.String activeCode;

    /**
     * 附加贷编码
     */
    @Length(min = 0, max = 50)
    private java.lang.String additionalCode;

    /**
     * 附加贷名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String additionalName;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

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

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActiveReviewId() {
        return this.activeReviewId;
    }

    public void setActiveReviewId(Long activeReviewId) {
        this.activeReviewId = activeReviewId;
    }

    public java.lang.String getActiveCode() {
        return this.activeCode;
    }

    public void setActiveCode(java.lang.String activeCode) {
        this.activeCode = activeCode;
    }

    public java.lang.String getAdditionalCode() {
        return this.additionalCode;
    }

    public void setAdditionalCode(java.lang.String additionalCode) {
        this.additionalCode = additionalCode;
    }

    public java.lang.String getAdditionalName() {
        return this.additionalName;
    }

    public void setAdditionalName(java.lang.String additionalName) {
        this.additionalName = additionalName;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
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

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}