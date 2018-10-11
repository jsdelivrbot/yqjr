package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

/**
 * 活动制定
 * Created by yaoxin on 2018/6/6.
 */
public class ActiveMainAllListCondition {
        /**
         * 所属公司
         */
        @Length(min = 0, max = 100)
        private String company;
        /**
         * 活动编码
         */
        @Length(min = 0, max = 20)
        private String activeCode;

        /**
         * 活动名称
         */
        @Length(min = 0, max = 64)
        private String activeName;

        /**
         * 区域代码
         */
        @Length(min = 0, max = 100)
        private String areaCode;

        /**
         * 区域名称
         */
        @Length(min = 0, max = 1000)
        private String areaName;

        /**
         * 受理开始时间
         */
        @Length(min = 0, max = 50)
        private String activeStartTime;

        /**
         * 受理结束时间
         */
        @Length(min = 0, max = 50)
        private String activeEndTime;

        /**
         * 品牌名称
         */
        @Length(min = 0, max = 50)
        private String brandsName;

    /**
     * 品牌编码
     */
    @Length(min = 0, max = 50)
    private String brandsCode;



    /**
     * 活动状态
     */
    @Length(min = 0, max = 20)
    private java.lang.String activeStatus;

    /**
     * 结算状态（00-初始，01-未动支，02-动支中，03-已动支）
     */
    @Length(min = 0, max = 20)
    private java.lang.String billStatus;

    /**
     * 动支状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String paymentStatus;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
