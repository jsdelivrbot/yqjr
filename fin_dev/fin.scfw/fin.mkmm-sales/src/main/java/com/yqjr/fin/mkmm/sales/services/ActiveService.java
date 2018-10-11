package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.mapper.ActiveAdditionHisMapper;
import com.yqjr.fin.mkmm.sales.model.Active;
import com.yqjr.scfw.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ActiveService  {

    /**
     * 活动主表
     */
    @Autowired
    private ActiveMainService ativeMainService;

    /**
     * 活动地区
     */
    @Autowired
    private ActiveAreaService activeAreaService;
    /**
     * 经销商
     */
    @Autowired
    private ActiveDealerService ativeDealeService;

    /**
     * 活动车辆
     */
    @Autowired
    private ActiveCarService activeCarService;

    /**
     * 活动产品
     */
    @Autowired
    private ActiveProdService activeProdService;

    /**
     * 附加贷
     */
    @Autowired
    private ActiveAdditionService activeAdditionalService;

    /**
     * 营销活动
     */
    @Autowired
    private ActiveMarketingService activeMarketingService;

    /**
     * 营销活动
     */
    @Autowired
    private ActiveBusinessService activeBusinessService;

    /**
     *
     */
    @Autowired
    private ActiveMatchMainService activeMatchMainService;

    /**
     *
     */
    @Autowired
    private FeeMainReviewService feeMainReviewService;

    public Active selectActiveByCode(String activeCode,String company) {
        Active active = new Active();
        //根据code查活动主表
        List<ActiveMain> activeMains = ativeMainService.selectActiveMainByCode(activeCode,company);
        //根据code查活动区域
        List<ActiveArea> activeAreas = activeAreaService.selectActiveAreaByCode(activeCode,company);
        //根据code查活动经销商
        List<ActiveDealer> activeDealers = ativeDealeService.selectActiveDealeByCode(activeCode,company);
        //根据code查活动车辆
        List<ActiveCar> activeCars = activeCarService.selectActiveCarByCode(activeCode,company);
        //根据code查活动产品
        List<ActiveProd> activeProds = activeProdService.selectActiveProdByCode(activeCode,company);
        //根据code查活动附加贷
        List<ActiveAddition> activeAdditions = activeAdditionalService.selectActiveAdditionalByCode(activeCode,company);
        //根据code查活动营销活动
        List<ActiveMarketing> activeMarketings = activeMarketingService.selectActiveMarketingByCode(activeCode,company);
        //业务模式
        List<ActiveBusiness> activeBusinesss = activeBusinessService.selectActiveBusinessByCode(activeCode,company);
        //
        List<ActiveMatchMain> activeMatchMains = activeMatchMainService.selectActiveMatchByCode(activeCode,company);
        //
        List<FeeMainReview> feeMainReviews = feeMainReviewService.selectFeeMainReviewByCode(activeCode,company);

        if(activeAdditions.size()>0){
            active.setActiveAdditional(activeAdditions.get(0));
        }
        if(activeAreas.size()>0) {
            active.setActiveArea(activeAreas.get(0));
        }
        if(activeCars.size()>0) {
            active.setActiveCar(activeCars.get(0));
        }
        if(activeMarketings.size()>0) {
            active.setActiveMarketing(activeMarketings.get(0));
        }
        active.setActiveProdList(activeProds);
        if(activeMains.size()>0) {
            active.setActiveMain(activeMains.get(0));
        }
        active.setActiveDealeList(activeDealers);
        if(activeBusinesss.size()>0) {
            active.setActiveBusiness(activeBusinesss.get(0));
        }
        if(activeMatchMains.size()>0 && !"".equals(activeMatchMains.get(0) ) && null != activeMatchMains.get(0)) {
            active.setReachRate(activeMatchMains.get(0).getReachRate());
            active.setActualTurnoverCount(activeMatchMains.get(0).getActualTurnoverCount());
            active.setMaxBillFee(activeMatchMains.get(0).getMaxBillFee());
            active.setActiveAreaCode(activeMatchMains.get(0).getAreaCode());
        }
        if(feeMainReviews.size()>0) {
            active.setRemark2(feeMainReviews.get(0).getRemark());
        }

        return active;
    }


}