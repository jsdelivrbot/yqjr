package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

/**
 * Created by yaoxin on 2018/6/11.
 */
public class ActiveReviewListCondition {

    /**
     * 所属公司
     */
    @Length(min = 0, max = 100)
    private java.lang.String company;

    /**
     * 活动编码
     */
    @Length(min = 0, max = 20)
    private java.lang.String activeCode;

    /**
     * 活动名称
     */
    @Length(min = 0, max = 64)
    private java.lang.String activeName;

    /**
     * 审核类型（01新增，02修改）
     */
    @Length(min = 0, max = 4)
    private java.lang.String reviewType;

    /**
     * 审核状态（00驳回,01提交审核,02待审核,03审核中,04审核通过）
     */
    @Length(min = 0, max = 4)
    private java.lang.String reviewStatus;

    /**
     * 审核级别
     */
    @Length(min = 0, max = 4)
    private java.lang.String reviewLevel;

    /**
     * 区域编码
     */
    @Length(min = 0, max = 50)
    private java.lang.String areaCode;

    /**
     * 发起人级别
     */
    @Length(min = 0, max = 10)
    private java.lang.String founderLevel;

    public String getFounderLevel() {
        return founderLevel;
    }

    public void setFounderLevel(String founderLevel) {
        this.founderLevel = founderLevel;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewLevel() {
        return reviewLevel;
    }

    public void setReviewLevel(String reviewLevel) {
        this.reviewLevel = reviewLevel;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
