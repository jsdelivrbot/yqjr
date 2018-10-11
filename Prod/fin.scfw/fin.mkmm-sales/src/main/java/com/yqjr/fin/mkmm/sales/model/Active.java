package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 活动明细对象
 * Created by fanna on 2018/6/4.
 */
public class Active  {

    private Long actualTurnoverCount;//实际达成
    private String reachRate;//达成率
    private BigDecimal maxBillFee;//结算单金额上限
    private BigDecimal billFee;//结算金额
    private String activeAreaCode;//登录人员区域
    private String remark2;//结算费用时的备注

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getActiveAreaCode() {
        return activeAreaCode;
    }

    public void setActiveAreaCode(String activeAreaCode) {
        this.activeAreaCode = activeAreaCode;
    }

    public BigDecimal getMaxBillFee() {
        return maxBillFee;
    }

    public void setMaxBillFee(BigDecimal maxBillFee) {
        this.maxBillFee = maxBillFee;
    }

    public BigDecimal getBillFee() {
        return billFee;
    }

    public void setBillFee(BigDecimal billFee) {
        this.billFee = billFee;
    }

    public Long getActualTurnoverCount() {
        return actualTurnoverCount;
    }

    public void setActualTurnoverCount(Long actualTurnoverCount) {
        this.actualTurnoverCount = actualTurnoverCount;
    }

    public String getReachRate() {
        return reachRate;
    }

    public void setReachRate(String reachRate) {
        this.reachRate = reachRate;
    }

    /**
     * 活动主表
     */
    private ActiveMain activeMain;
    /**
     * 活动地区
     */
    private ActiveArea activeArea;
    /**
     * 经销商
     */
    private List<ActiveDealer> activeDealeList;

    /**
     * 活动车辆
     */
    private ActiveCar activeCar;

    /**
     * 活动产品
     */
    private List<ActiveProd> activeProdList;

    /**
     * 附加贷
     */
    private ActiveAddition activeAdditional;

    /**
     * 业务模式
     */
    private ActiveBusiness activeBusiness;


    /**
     * 营销活动
     */
    private ActiveMarketing activeMarketing;


    public ActiveArea getActiveArea() {
        return activeArea;
    }

    public void setActiveArea(ActiveArea activeArea) {
        this.activeArea = activeArea;
    }


    public ActiveCar getActiveCar() {
        return activeCar;
    }

    public void setActiveCar(ActiveCar activeCar) {
        this.activeCar = activeCar;
    }

    public List<ActiveProd> getActiveProdList() {
        return activeProdList;
    }

    public void setActiveProdList(List<ActiveProd> activeProdList) {
        this.activeProdList = activeProdList;
    }

    public ActiveAddition getActiveAdditional() {
        return activeAdditional;
    }

    public void setActiveAdditional(ActiveAddition activeAdditional) {
        this.activeAdditional = activeAdditional;
    }

    public ActiveBusiness getActiveBusiness() {
        return activeBusiness;
    }

    public void setActiveBusiness(ActiveBusiness activeBusiness) {
        this.activeBusiness = activeBusiness;
    }

    public ActiveMarketing getActiveMarketing() {
        return activeMarketing;
    }

    public void setActiveMarketing(ActiveMarketing activeMarketing) {
        this.activeMarketing = activeMarketing;
    }

    public ActiveMain getActiveMain() {
        return activeMain;
    }

    public void setActiveMain(ActiveMain activeMain) {
        this.activeMain = activeMain;
    }

    public List<ActiveDealer> getActiveDealeList() {
        return activeDealeList;
    }

    public void setActiveDealeList(List<ActiveDealer> activeDealeList) {
        this.activeDealeList = activeDealeList;
    }
}
