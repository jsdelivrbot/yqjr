package com.yqjr.fin.mkmm.sales.rest.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MaterialInVo {
    private String materialCode;
    private String brandsCode;
    private String materialTheme;
    private String uploader;
    private String materialSource;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeEnd;
    private String company;
    private String areaCode;
    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public String getMaterialTheme() {
        return materialTheme;
    }

    public void setMaterialTheme(String materialTheme) {
        this.materialTheme = materialTheme;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getMaterialSource() {
        return materialSource;
    }

    public void setMaterialSource(String materialSource) {
        this.materialSource = materialSource;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

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
}
