package com.yqjr.fin.mkmm.sales.vo.domin;

import java.io.Serializable;

public class PersonTrackVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String personCode;
    private String personName;
    private String year;
    private String brands;
    private String month;
    private String planNum;//计划
    private String actualNum;//实际
    private String planRate;//达成率
    private String rate;//序时进度
    private String rateCal;//差

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    public String getActualNum() {
        return actualNum;
    }

    public void setActualNum(String actualNum) {
        this.actualNum = actualNum;
    }

    public String getPlanRate() {
        return planRate;
    }

    public void setPlanRate(String planRate) {
        this.planRate = planRate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateCal() {
        return rateCal;
    }

    public void setRateCal(String rateCal) {
        this.rateCal = rateCal;
    }
}
