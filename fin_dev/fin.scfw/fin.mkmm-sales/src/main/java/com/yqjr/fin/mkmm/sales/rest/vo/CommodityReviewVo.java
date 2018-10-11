package com.yqjr.fin.mkmm.sales.rest.vo;

public class CommodityReviewVo extends CommodityOutVo {
    private String batchCode;
    private String putName;
    private String commodityStatus;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(String commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public String getPutName() {
        return putName;
    }

    public void setPutName(String putName) {
        this.putName = putName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }
}
