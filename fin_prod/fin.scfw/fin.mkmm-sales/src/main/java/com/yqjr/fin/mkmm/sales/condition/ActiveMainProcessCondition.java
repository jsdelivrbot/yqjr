package com.yqjr.fin.mkmm.sales.condition;

/**
 * 活动审核进度筛选调教
 * Created by yaoxin on 2018/6/4.
 */
public class ActiveMainProcessCondition {

    /**
     * 公司
     */
    private String company;

    /**
     * 活动代码
     */
    private String activeCode;

    /**
     * 活动名称
     */
    private String activeName;

    /**
     * 活动区域代码
     */
    private String areaCode;

    /**
     * 区域代码
     */
    private String areaMainCode;

    /**
     * 品牌代码
     */
    private String brandsCode;

    /**
     * 创建人
     */
    private Long creator;

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaMainCode() {
        return areaMainCode;
    }

    public void setAreaMainCode(String areaMainCode) {
        this.areaMainCode = areaMainCode;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }
}
