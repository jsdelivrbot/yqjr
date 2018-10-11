package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;

import java.util.List;

/**
 * Created by fannaian on 2018/09/04
 */
public class CommodityInVo {

    //项目编码
    private String projectCode;
    //待入库物料集合
    private List<CommodityAcceptanceVo> commodityAcceptanceVos;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public List<CommodityAcceptanceVo> getCommodityAcceptanceVos() {
        return commodityAcceptanceVos;
    }

    public void setCommodityAcceptanceVos(List<CommodityAcceptanceVo> commodityAcceptanceVos) {
        this.commodityAcceptanceVos = commodityAcceptanceVos;
    }
}
