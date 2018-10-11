package com.yqjr.fin.mkmm.sales.rest.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ExportViewVo {
    private String materialName;
    private String materialCode;
    private String materialTheme;
    private String brandsName;
    private String brandsCode;
    private Date effectiveStartTime;
    private Date effectiveEndTime;
    private String dealerName;
    private String dealerCode;
    private String receiveStatus;
    private Date receiveTime;
    private String opinion;
    private Date outTime;

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialTheme() {
        return materialTheme;
    }

    public void setMaterialTheme(String materialTheme) {
        this.materialTheme = materialTheme;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public Date getEffectiveStartTime() {
        return effectiveStartTime;
    }

    public void setEffectiveStartTime(Date effectiveStartTime) {
        this.effectiveStartTime = effectiveStartTime;
    }

    public Date getEffectiveEndTime() {
        return effectiveEndTime;
    }

    public void setEffectiveEndTime(Date effectiveEndTime) {
        this.effectiveEndTime = effectiveEndTime;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
