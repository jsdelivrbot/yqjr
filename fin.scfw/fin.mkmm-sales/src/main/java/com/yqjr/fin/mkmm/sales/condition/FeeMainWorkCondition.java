
package com.yqjr.fin.mkmm.sales.condition;

import com.yqjr.fin.mkmm.sales.entity.FeeMainReview;
import com.yqjr.scfw.common.condition.BaseCondition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

public class FeeMainWorkCondition  {

    private String areaName;
    private String areaCode;
    private String businessCode;
    private String businessName;
    private Date activeStartime;
    private Date activeEndtime;
    private String modType;
    private String reviewLevel;
    private String reviewStatus;
    private String reviewType;
    private String company;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Date getActiveStartime() {
        return activeStartime;
    }

    public void setActiveStartime(Date activeStartime) {
        this.activeStartime = activeStartime;
    }

    public Date getActiveEndtime() {
        return activeEndtime;
    }

    public void setActiveEndtime(Date activeEndtime) {
        this.activeEndtime = activeEndtime;
    }

    public String getModType() {
        return modType;
    }

    public void setModType(String modType) {
        this.modType = modType;
    }

    public String getReviewLevel() {
        return reviewLevel;
    }

    public void setReviewLevel(String reviewLevel) {
        this.reviewLevel = reviewLevel;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}