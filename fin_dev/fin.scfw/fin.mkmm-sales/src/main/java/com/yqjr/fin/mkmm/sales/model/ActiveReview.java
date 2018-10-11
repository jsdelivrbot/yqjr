package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.util.List;

/**
 * Created by zhouchong on 2018/5/30.
 */
public class ActiveReview {
    /**
     * 活动主表
     */
    private ActiveMainReview ativeMain;
    /**
     * 活动地区
     */
    private ActiveAreaReview activeArea;
    /**
     * 经销商
     */
    private List<ActiveDealerReview> ativeDealeList;

    /**
     * 活动车辆
     */
    private ActiveCarReview activeCar;

    /**
     * 活动产品
     */
    private List<ActiveProdReview> activeProdList;



    /**
     * 附加贷
     */
    private ActiveAdditionReview activeAdditional;

    /**
     * 业务模式
     */
    private ActiveBusinessReview activeBusiness;

    public ActiveBusinessReview getActiveBusiness() {
        return activeBusiness;
    }

    public void setActiveBusiness(ActiveBusinessReview activeBusiness) {
        this.activeBusiness = activeBusiness;
    }

    /**
     * 营销活动
     */
    private ActiveMarketingReview activeMarketing;


    public ActiveMainReview getAtiveMain() {
        return ativeMain;
    }

    public void setAtiveMain(ActiveMainReview ativeMain) {
        this.ativeMain = ativeMain;
    }

    public ActiveAreaReview getActiveArea() {
        return activeArea;
    }

    public void setActiveArea(ActiveAreaReview activeArea) {
        this.activeArea = activeArea;
    }

    public List<ActiveDealerReview> getAtiveDealeList() {
        return ativeDealeList;
    }

    public void setAtiveDealeList(List<ActiveDealerReview> ativeDealeList) {
        this.ativeDealeList = ativeDealeList;
    }

    public ActiveCarReview getActiveCar() {
        return activeCar;
    }

    public void setActiveCar(ActiveCarReview activeCar) {
        this.activeCar = activeCar;
    }

    public List<ActiveProdReview> getActiveProdList() {
        return activeProdList;
    }

    public void setActiveProdList(List<ActiveProdReview> activeProdList) {
        this.activeProdList = activeProdList;
    }

    public ActiveAdditionReview getActiveAdditional() {
        return activeAdditional;
    }

    public void setActiveAdditional(ActiveAdditionReview activeAdditional) {
        this.activeAdditional = activeAdditional;
    }

    public ActiveMarketingReview getActiveMarketing() {
        return activeMarketing;
    }

    public void setActiveMarketing(ActiveMarketingReview activeMarketing) {
        this.activeMarketing = activeMarketing;
    }


}
