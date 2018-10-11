
package com.yqjr.fin.mkmm.sales.condition;

import com.yqjr.fin.mkmm.sales.entity.WorkFlow;
import com.yqjr.scfw.common.condition.BaseCondition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

public class WorkFlowCondition extends BaseCondition<WorkFlow, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/workFlow/list
     *表单维护路径：/workFlow/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 创建类型（01添加，02修改）
     */
    @Length(min = 0, max = 4)
    private String type;

    /**
     * 审核事件id（记录人员code和团队code）
     */
    @Length(min = 0, max = 16)
    private String reviewId;

    /**
     * 业务类型（01人员，02团队）
     */
    @Length(min = 0, max = 4)
    private String modType;

    /**
     * 审核状态（00驳回,01提交审核,02待审核,03审核中，04审核通过）
     */
    @Length(min = 0, max = 4)
    private String reviewStatus;

    /**
     * 审核级别(1一级审核，2二级审核)
     */
    @Length(min = 0, max = 4)
    private String reviewLevel;

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
     * 修改人（审核人）
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 备用1
     */
    @Length(min = 0, max = 16)
    private String transcode1;

    /**
     * 备用2
     */
    @Length(min = 0, max = 16)
    private String transcode2;

    /**
     * 备用3
     */
    @Length(min = 0, max = 16)
    private String transcode3;

    /**
     * 备用4
     */
    @Length(min = 0, max = 16)
    private String transcode4;

    /**
     * 审批意见
     */
    @Length(min = 0, max = 256)
    private String opinion;

    /**
     * 流入(上一级)id
     */
    @Digits(fraction =22,integer=0)
    private Long flowId;
    /**
     * 修改人姓名
     */
    @Length(min = 0, max = 50)
    private java.lang.String modifierName;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getModType() {
        return this.modType;
    }

    public void setModType(String modType) {
        this.modType = modType;
    }

    public String getReviewStatus() {
        return this.reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewLevel() {
        return this.reviewLevel;
    }

    public void setReviewLevel(String reviewLevel) {
        this.reviewLevel = reviewLevel;
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

    public String getTranscode1() {
        return this.transcode1;
    }

    public void setTranscode1(String transcode1) {
        this.transcode1 = transcode1;
    }

    public String getTranscode2() {
        return this.transcode2;
    }

    public void setTranscode2(String transcode2) {
        this.transcode2 = transcode2;
    }

    public String getTranscode3() {
        return this.transcode3;
    }

    public void setTranscode3(String transcode3) {
        this.transcode3 = transcode3;
    }

    public String getTranscode4() {
        return this.transcode4;
    }

    public void setTranscode4(String transcode4) {
        this.transcode4 = transcode4;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public java.lang.String getModifierName() {
        return this.modifierName;
    }

    public void setModifierName(java.lang.String modifierName) {
        this.modifierName = modifierName;
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