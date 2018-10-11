package com.yqjr.fin.mkmm.sales.services;


import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.*;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.model.ActiveReview;
import com.yqjr.fin.mkmm.sales.rest.vo.ActiveReviewVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.services.gateway.MetaGateway;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by zhouchong on 2018/6/1.
 */
@Service
@Transactional(readOnly = true)
public class ActiveReviewService {

    /**
     * 工作流
     */
    @Autowired
    private WorkFlowService workFlowService;

    /**
     * 字典表
     */
    @Autowired
    private SelectCodeService selectCodeService;

    /**
     * 活动主表
     */
    @Autowired
    private ActiveMainReviewService ativeMainReviewService;

    /**
     * 活动地区
     */
    @Autowired
    private ActiveAreaReviewService activeAreaReviewService;
    /**
     * 经销商
     */
    @Autowired
    private ActiveDealerReviewService ativeDealeReviewService;

    /**
     * 活动车辆
     */
    @Autowired
    private ActiveCarReviewService activeCarReviewService;

    /**
     * 活动产品
     */
    @Autowired
    private ActiveProdReviewService activeProdReviewService;

    /**
     * 业务模式
     */
    @Autowired
    private ActiveBusinessReviewService activeBusinessReviewService;

    /**
     * 附加贷
     */
    @Autowired
    private ActiveAdditionReviewService activeAdditionalReviewService;


    /**
     * 营销活动
     */
    @Autowired
    private ActiveMarketingReviewService activeMarketingReviewService;

    /**
     * 活动主表
     */
    @Autowired
    private ActiveMainService activeMainService;
    /**
     * 活动地区
     */
    @Autowired
    private ActiveAreaService activeAreaService;
    /**
     * 经销商
     */
    @Autowired
    private ActiveDealerService activeDealerService;

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
     * 业务模式
     */
    @Autowired
    private ActiveBusinessService activeBusinessService;

    /**
     * 附加贷
     */
    @Autowired
    private ActiveAdditionService activeAdditionService;

    /**
     * 营销活动
     */
    @Autowired
    private ActiveMarketingService activeMarketingService;


    /**
     * 活动主表
     */
    @Autowired
    private ActiveMainHisService activeMainHisService;

    /**
     * 活动地区
     */
    @Autowired
    private ActiveAreaHisService activeAreaHisService;
    /**
     * 经销商
     */
    @Autowired
    private ActiveDealerHisService activeDealeHisService;

    /**
     * 活动车辆
     */
    @Autowired
    private ActiveCarHisService activeCarHisService;

    /**
     * 活动产品
     */
    @Autowired
    private ActiveProdHisService activeProdHisService;

    /**
     * 业务模式
     */
    @Autowired
    private ActiveBusinessHisService activeBusinessHisService;

    /**
     * 附加贷
     */
    @Autowired
    private ActiveAdditionHisService activeAdditionalHisService;


    /**
     * 营销活动
     */
    @Autowired
    private ActiveMarketingHisService activeMarketingHisService;

    /**
     * 添加活动审核数据
     * @param activeReview
     */
    @Transactional
    public synchronized void insertActiveReviews(ActiveReview activeReview){
        String areaHeadLetter = "";
        if (activeReview.getAtiveMain().getAreaCode() == null){
            throw new ValidationException("获取区域代码失败，请联系管理员");
        }
        List<SelectCodeVo> selectCodeVos = selectCodeService.translateCode("Zone",activeReview.getAtiveMain().getAreaCode());
        if (selectCodeVos != null && selectCodeVos.size()>0){
            areaHeadLetter = selectCodeVos.get(0).getHeadLetter();
        }
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        String likeID = areaHeadLetter+year; //查询条件
        ActiveMainReviewCondition activeMainReviewWhere=new ActiveMainReviewCondition();
        activeMainReviewWhere.setActiveCode(likeID);
        int ativeCodeCount=ativeMainReviewService.queryActiveMainReviewCount(activeMainReviewWhere);
        String ativeCode="001";
        if(ativeCodeCount>0){
            String maxID=ativeMainReviewService.queryMaxID(likeID);
            ativeCode=likeID+String.format("%03d",Integer.parseInt(maxID)+1);
        }else{
            ativeCode=likeID+ativeCode;
        }
        //节点类型 01-添加、活动id、 审核类型03-活动
        long  workFlowID=workFlowService.saveWorkFlowInfo("01",ativeCode,"03");



        //保存活动AtiveMain表数据
        activeReview.getAtiveMain().setActiveCode(ativeCode);
        activeReview.getAtiveMain().setFolowId(workFlowID);
        activeReview.getAtiveMain().setReviewType("01");//审核类型（01新增)
        activeReview.getAtiveMain().setReviewStatus("02");//审核状态 (02待审核)
        activeReview.getAtiveMain().setFlag("1");//有效标识 1有效
        if (UserRoleHelp.isAdmin() || UserRoleHelp.isMarketingManager() || UserRoleHelp.isMarketingWorkers()){
            activeReview.getAtiveMain().setFounderLevel("03");
        }else if (UserRoleHelp.isRegionalLeaders()){
            activeReview.getAtiveMain().setFounderLevel("02");
        }else if (UserRoleHelp.isSalesManager()){
            activeReview.getAtiveMain().setFounderLevel("01");
        }
        UserContext context = SessionHolder.getUserContext();
        activeReview.getAtiveMain().setCreatorName(context.getName());
        ativeMainReviewService.insert(activeReview.getAtiveMain());
        Long  ativeReviewID=activeReview.getAtiveMain().getId();
        //保存活动AtiveRrea（区域）表数据
        if("0".equals(activeReview.getAtiveMain().getInputDeale())) {
            activeReview.getActiveArea().setActiveCode(ativeCode);
            activeReview.getActiveArea().setActiveReviewId(ativeReviewID);
            activeReview.getActiveArea().setCompany(context.getComCode());
            activeAreaReviewService.insert(activeReview.getActiveArea());
        }
        //存入经销商信息
        if("1".equals(activeReview.getAtiveMain().getInputDeale())) {
            //保存活动ativeDeale（经销商）表数据
            int ativeDealeSize = activeReview.getAtiveDealeList().size();
            for (int i = 0; i < ativeDealeSize; i++) {
                ActiveDealerReview activeDealerReview = activeReview.getAtiveDealeList().get(i);
                activeDealerReview.setActiveCode(ativeCode);
                activeDealerReview.setActiveReviewId(ativeReviewID);
                activeDealerReview.setCompany(context.getComCode());
                ativeDealeReviewService.insert(activeDealerReview);
            }
        }

        //保存活动activeCar（车）表数据
        activeReview.getActiveCar().setActiveCode(ativeCode);
        activeReview.getActiveCar().setActiveReviewId(ativeReviewID);
        activeReview.getActiveCar().setCompany(context.getComCode());
        activeCarReviewService.insert(activeReview.getActiveCar());

        //保存活动activeProd（产品）表数据
        int activeProdSize= activeReview.getActiveProdList().size();
        for(int i=0;i<activeProdSize;i++){
            ActiveProdReview activeProdReview =activeReview.getActiveProdList().get(i);
            activeProdReview.setActiveCode(ativeCode);
            activeProdReview.setActiveReviewId(ativeReviewID);
            activeProdReview.setCompany(context.getComCode());
            activeProdReviewService.insert(activeProdReview);
        }

        //保存activeAdditional（附加贷）表数据
        activeReview.getActiveAdditional().setActiveCode(ativeCode);
        activeReview.getActiveAdditional().setActiveReviewId(ativeReviewID);
        activeReview.getActiveAdditional().setCompany(context.getComCode());
        activeAdditionalReviewService.insert(activeReview.getActiveAdditional());

        //保存activeMarketing（营销活动）表数据
        activeReview.getActiveMarketing().setActiveCode(ativeCode);
        activeReview.getActiveMarketing().setActiveReviewId(ativeReviewID);
        activeReview.getActiveMarketing().setCompany(context.getComCode());
        activeMarketingReviewService.insert(activeReview.getActiveMarketing());
        //保存activeBusiness（业务模式）表数据
        activeReview.getActiveBusiness().setActiveCode(ativeCode);
        activeReview.getActiveBusiness().setActiveReviewId(ativeReviewID);
        activeReview.getActiveBusiness().setCompany(context.getComCode());
        activeBusinessReviewService.insert(activeReview.getActiveBusiness());
    }

    /**
     * 活动指定-修改-查询指定ID数据
     * @param mainReviewCondition
     * @return
     */
    @Transactional(readOnly = true)
    public ActiveReview getActiveReviews(ActiveMainReviewCondition mainReviewCondition) {
        if (mainReviewCondition == null){
            return null;
        }
        Long id = 0L;
        ActiveReview activeReview = new ActiveReview();
        //ActiveMainReview表
        mainReviewCondition.setFlag("1");
        List<ActiveMainReview> activeMainReviews = ativeMainReviewService.selectList(mainReviewCondition);
        if (activeMainReviews != null && activeMainReviews.size()>0){
            id = activeMainReviews.get(0).getId();
            activeReview.setAtiveMain(activeMainReviews.get(0));
        }else {
            throw new ValidationException("查询失败，请联系管理员");
        }
        //ActiveAdditionReview表
        ActiveAdditionReviewCondition additionReviewCondition = new ActiveAdditionReviewCondition();
        additionReviewCondition.setActiveReviewId(id);
        activeReview.setActiveAdditional(activeAdditionalReviewService.selectOne(additionReviewCondition));
        //ActiveAreaReview表
        ActiveAreaReviewCondition areaReviewCondition = new ActiveAreaReviewCondition();
        areaReviewCondition.setActiveReviewId(id);
        activeReview.setActiveArea(activeAreaReviewService.selectOne(areaReviewCondition));
        //ActiveBusinessReview表
        ActiveBusinessReviewCondition businessReviewCondition = new ActiveBusinessReviewCondition();
        businessReviewCondition.setActiveReviewId(id);
        activeReview.setActiveBusiness(activeBusinessReviewService.selectOne(businessReviewCondition));
        //ActiveCarReview表
        ActiveCarReviewCondition carReviewCondition = new ActiveCarReviewCondition();
        carReviewCondition.setActiveReviewId(id);
        activeReview.setActiveCar(activeCarReviewService.selectOne(carReviewCondition));
        //ActiveMarketingReview表
        ActiveMarketingReviewCondition marketingReviewCondition = new ActiveMarketingReviewCondition();
        marketingReviewCondition.setActiveReviewId(id);
        activeReview.setActiveMarketing(activeMarketingReviewService.selectOne(marketingReviewCondition));
        //ActiveProdReview表
        ActiveProdReviewCondition prodReviewCondition = new ActiveProdReviewCondition();
        prodReviewCondition.setActiveReviewId(id);
        activeReview.setActiveProdList(activeProdReviewService.selectList(prodReviewCondition));
        //ActiveDealerReview表
        ActiveDealerReviewCondition dealerReviewCondition = new ActiveDealerReviewCondition();
        dealerReviewCondition.setActiveReviewId(id);
        activeReview.setAtiveDealeList(ativeDealeReviewService.selectList(dealerReviewCondition));
        return activeReview;
    }

    /**
     * 修改并添加活动审核数据
     * @param activeReview
     */
    @Transactional(readOnly = false)
    public synchronized void updateAndInsertActiveReviews(ActiveReview activeReview){
        String ativeCode = activeReview.getAtiveMain().getActiveCode();
        String company = activeReview.getAtiveMain().getCompany();
        //节点类型 01-添加、活动id、审核类型03-活动
        long  workFlowID=workFlowService.saveWorkFlowInfo("01",ativeCode,"03");
        if (activeReview.getAtiveMain().getId() != null){
            ativeMainReviewService.updateFlagById(activeReview.getAtiveMain().getId());
        }
        //保存活动AtiveMain表数据
        activeReview.getAtiveMain().setActiveCode(ativeCode);
        activeReview.getAtiveMain().setFolowId(workFlowID);
        activeReview.getAtiveMain().setReviewType("01");//审核新增（01新增)
        activeReview.getAtiveMain().setReviewStatus("02");//审核状态 (02待审核)
        activeReview.getAtiveMain().setFlag("1");//有效标识 1有效
        ativeMainReviewService.insert(activeReview.getAtiveMain());
        Long  ativeReviewID=activeReview.getAtiveMain().getId();

        //保存activeBusiness（业务模式）表数据
        activeReview.getActiveBusiness().setActiveCode(ativeCode);
        activeReview.getActiveBusiness().setActiveReviewId(ativeReviewID);
        activeReview.getActiveBusiness().setCompany(company);
        activeBusinessReviewService.insert(activeReview.getActiveBusiness());

        //保存活动AtiveRrea（区域）表数据
        if("0".equals(activeReview.getAtiveMain().getInputDeale())) {
            activeReview.getActiveArea().setActiveCode(ativeCode);
            activeReview.getActiveArea().setActiveReviewId(ativeReviewID);
            activeReview.getActiveArea().setCompany(company);
            activeAreaReviewService.insert(activeReview.getActiveArea());
        }
        //存入经销商信息
        if("1".equals(activeReview.getAtiveMain().getInputDeale())) {
            //保存活动ativeDeale（经销商）表数据
            int ativeDealeSize = activeReview.getAtiveDealeList().size();
            for (int i = 0; i < ativeDealeSize; i++) {
                ActiveDealerReview activeDealerReview = activeReview.getAtiveDealeList().get(i);
                activeDealerReview.setActiveCode(ativeCode);
                activeDealerReview.setActiveReviewId(ativeReviewID);
                activeDealerReview.setCompany(company);
                ativeDealeReviewService.insert(activeDealerReview);
            }
        }

        //保存活动activeCar（车）表数据
        activeReview.getActiveCar().setActiveCode(ativeCode);
        activeReview.getActiveCar().setActiveReviewId(ativeReviewID);
        activeReview.getActiveCar().setCompany(company);
        activeCarReviewService.insert(activeReview.getActiveCar());

        //保存活动activeProd（产品）表数据
        int activeProdSize= activeReview.getActiveProdList().size();
        for(int i=0;i<activeProdSize;i++){
            ActiveProdReview activeProdReview =activeReview.getActiveProdList().get(i);
            activeProdReview.setActiveCode(ativeCode);
            activeProdReview.setActiveReviewId(ativeReviewID);
            activeProdReview.setCompany(company);
            activeProdReviewService.insert(activeProdReview);
        }

        //保存activeAdditional（附加贷）表数据
        activeReview.getActiveAdditional().setActiveCode(ativeCode);
        activeReview.getActiveAdditional().setActiveReviewId(ativeReviewID);
        activeReview.getActiveAdditional().setCompany(company);
        activeAdditionalReviewService.insert(activeReview.getActiveAdditional());

        //保存activeMarketing（营销活动）表数据
        activeReview.getActiveMarketing().setActiveCode(ativeCode);
        activeReview.getActiveMarketing().setActiveReviewId(ativeReviewID);
        activeReview.getActiveMarketing().setCompany(company);
        activeMarketingReviewService.insert(activeReview.getActiveMarketing());

    }

    public ActiveReviewVo getActiveReviewCheck(Long id) {
        if (id == null){
            return null;
        }
        ActiveReviewVo activeReview = new ActiveReviewVo();
        //ActiveMainReview表
        ActiveMainReviewCondition mainReviewCondition = new ActiveMainReviewCondition();
        mainReviewCondition.setId(id);
        activeReview.setAtiveMain(ativeMainReviewService.selectOne(mainReviewCondition));
        //ActiveAdditionReview表
        ActiveAdditionReviewCondition additionReviewCondition = new ActiveAdditionReviewCondition();
        additionReviewCondition.setActiveReviewId(id);
        activeReview.setActiveAdditional(activeAdditionalReviewService.selectOne(additionReviewCondition));
        //ActiveAreaReview表
        ActiveAreaReviewCondition areaReviewCondition = new ActiveAreaReviewCondition();
        areaReviewCondition.setActiveReviewId(id);
        activeReview.setActiveArea(activeAreaReviewService.selectOne(areaReviewCondition));
        //ActiveBusinessReview表
        ActiveBusinessReviewCondition businessReviewCondition = new ActiveBusinessReviewCondition();
        businessReviewCondition.setActiveReviewId(id);
        activeReview.setActiveBusiness(activeBusinessReviewService.selectOne(businessReviewCondition));
        //ActiveCarReview表
        ActiveCarReviewCondition carReviewCondition = new ActiveCarReviewCondition();
        carReviewCondition.setActiveReviewId(id);
        activeReview.setActiveCar(activeCarReviewService.selectOne(carReviewCondition));
        //ActiveMarketingReview表
        ActiveMarketingReviewCondition marketingReviewCondition = new ActiveMarketingReviewCondition();
        marketingReviewCondition.setActiveReviewId(id);
        activeReview.setActiveMarketing(activeMarketingReviewService.selectOne(marketingReviewCondition));
        //ActiveProdReview表
        ActiveProdReviewCondition prodReviewCondition = new ActiveProdReviewCondition();
        prodReviewCondition.setActiveReviewId(id);
        activeReview.setActiveProdList(activeProdReviewService.selectList(prodReviewCondition));
        //ActiveDealerReview表
        ActiveDealerReviewCondition dealerReviewCondition = new ActiveDealerReviewCondition();
        dealerReviewCondition.setActiveReviewId(id);
        activeReview.setAtiveDealeList(ativeDealeReviewService.selectList(dealerReviewCondition));
        //WorkFlow表
        activeReview.setWorkFlow(workFlowService.selectByActiveMainId(id));
        return activeReview;
    }

    /**
     * 活动审核
     * @param oldWorkFlow
     */
    @Transactional
    public void activeReviewSubmit(WorkFlow oldWorkFlow) {
        UserContext uc = SessionHolder.getUserContext();
        if (oldWorkFlow == null){
            return;
        }
        oldWorkFlow.setCompany(uc.getComCode());
        String activeCode = oldWorkFlow.getReviewId();
        ActiveMainReviewCondition mainReviewCondition = new ActiveMainReviewCondition();
        mainReviewCondition.setActiveCode(activeCode);
        ActiveReview activeReview = this.getActiveReviews(mainReviewCondition);
        ActiveMainReview activeMainReview = activeReview.getAtiveMain();
        WorkFlow workFlow=workFlowService.selectById(oldWorkFlow.getId());
        workFlow.setModifierName(oldWorkFlow.getModifierName());
        workFlow.setCompany(uc.getComCode());
        String reviewLevel=oldWorkFlow.getReviewLevel();

        if (oldWorkFlow.getReviewStatus().equals("04")){
            workFlow.setOpinion(oldWorkFlow.getOpinion());
            workFlow.setReviewStatus("04");
            workFlowService.patchById(workFlow);//更新当前节点
            if ("1".equals(reviewLevel)){//1级审核通过
                workFlow.setReviewLevel("2");//设置流转到2级
                workFlow.setReviewStatus("02");//设置下个节点为待审核
                workFlow.setModifyTime(null);//操作时间为空
                workFlow.setOpinion(null);
                workFlow.setModifier(null);
                workFlow.setModifierName(null);
                workFlow.setFlowId(workFlow.getId());
                workFlowService.insert(workFlow);//插入2级节点
                activeMainReview.setFolowId(workFlow.getId());//更新审核表最新工作流ID
                activeMainReview.setReviewStatus("02");//待审核
                ativeMainReviewService.patchById(activeMainReview);//更新审核表
            }else if("2".equals(reviewLevel)){//2级审核通过数据正式生效
                synchronized (this) {
                    String workflowType = workFlow.getType();
//                TeamMain teamMainNew=teamReviewToTeamMain(teamReview);
                    activeMainReview.setReviewStatus("04");
                    activeMainReview.setFlag("0");//设置当前数据为无效
                    ativeMainReviewService.patchById(activeMainReview);//更新审核表
                    //判断此条审核数据是操作类型是添加 还是修改
                    if ("01".equals(workflowType)) {//添加操作
                        //添加ActiveMain表有效数据
                        ActiveMain activeMain = activeMainService.reviewToActiveMain(activeMainReview);
                        activeMain.setActiveStatus("01");
                        Long insertId = activeMainService.insertAndReturnId(activeMain);
                        //添加ActiveMarketing表有效数据
                        if (activeReview.getActiveMarketing() != null) {
                            ActiveMarketing activeMarketing = activeMainService.reviewToActiveMarketing(activeReview.getActiveMarketing());
                            activeMarketing.setActiveId(insertId);
                            activeMarketing.setCompany(uc.getComCode());
                            activeMarketingService.insert(activeMarketing);
                        }
                        if ("1".equals(activeMainReview.getInputDeale())) {
                            //添加ActiveDealer表有效数据
                            if (activeReview.getAtiveDealeList() != null) {
                                for (ActiveDealerReview activeDealerReview : activeReview.getAtiveDealeList()) {
                                    ActiveDealer activeDealer = activeMainService.reviewToActiveDealer(activeDealerReview);
                                    activeDealer.setActiveId(insertId);
                                    activeDealer.setCompany(uc.getComCode());
                                    activeDealerService.insert(activeDealer);
                                }
                            }
                        } else {
                            //添加ActiveArea表有效数据
                            if (activeReview.getActiveArea() != null) {
                                ActiveArea activeArea = activeMainService.reviewToActiveArea(activeReview.getActiveArea());
                                activeArea.setActiveId(insertId);
                                activeArea.setCompany(uc.getComCode());
                                activeAreaService.insert(activeArea);
                            }
                        }
                        //添加ActiveProd表有效数据
                        if (activeReview.getActiveProdList() != null) {
                            for (ActiveProdReview activeProdReview : activeReview.getActiveProdList()) {
                                ActiveProd activeProd = activeMainService.reviewToActiveProd(activeProdReview);
                                activeProd.setActiveId(insertId);
                                activeProd.setCompany(uc.getComCode());
                                activeProdService.insert(activeProd);
                            }
                        }
                        //添加ActiveCar表有效数据
                        if (activeReview.getActiveCar() != null) {
                            ActiveCar activeCar = activeMainService.reviewToActiveCar(activeReview.getActiveCar());
                            activeCar.setActiveId(insertId);
                            activeCar.setCompany(uc.getComCode());
                            activeCarService.insert(activeCar);
                        }
                        //添加ActiveBusiness表有效数据
                        if (activeReview.getActiveBusiness() != null) {
                            ActiveBusiness activeBusiness = activeMainService.reviewToActiveBusiness(activeReview.getActiveBusiness());
                            activeBusiness.setActiveId(insertId);
                            activeBusiness.setCompany(uc.getComCode());
                            activeBusinessService.insert(activeBusiness);
                        }
                        if ("1".equals(activeMainReview.getAdditionFlag())) {
                            //添加ActiveAddition表有效数据
                            if (activeReview.getActiveAdditional() != null) {
                                ActiveAddition activeAddition = activeMainService.reviewToActiveAddition(activeReview.getActiveAdditional());
                                activeAddition.setActiveId(insertId);
                                activeAddition.setCompany(uc.getComCode());
                                activeAdditionService.insert(activeAddition);
                            }
                        }
                    } else if ("02".equals(workflowType)) {//修改操作
                        //修改ActiveMain表有效数据
                        ActiveMain activeMain = new ActiveMain();
                        ActiveMainCondition activeMainCondition = new ActiveMainCondition();
                        activeMainCondition.setActiveCode(activeCode);
                        List<ActiveMain> activeMainList = activeMainService.selectList(activeMainCondition);
                        activeMain = activeMainList.get(0);
                        ActiveMainHis activeMainHis = activeMainService.formalToActiveMainHis(activeMain);
                        activeMainHis.setCompany(uc.getComCode());
                        activeMainHisService.insert(activeMainHis);
                        ActiveMain newActiveMain = activeMainService.reviewToActiveMain(activeMainReview);
                        activeMainService.patchByActiveCode(newActiveMain);
                        //修改ActiveMarketing表有效数据
                        ActiveMarketing activeMarketing = new ActiveMarketing();
                        ActiveMarketingCondition activeMarketingCondition = new ActiveMarketingCondition();
                        activeMarketingCondition.setActiveCode(activeCode);
                        List<ActiveMarketing> activeMarketingList = activeMarketingService.selectList(activeMarketingCondition);
                        activeMarketing = activeMarketingList.get(0);
                        ActiveMarketingHis activeMarketingHis = activeMainService.formalToActiveMarketingHis(activeMarketing);
                        activeMarketingHis.setCompany(uc.getComCode());
                        activeMarketingHisService.insert(activeMarketingHis);
                        ActiveMarketing newActiveMarketing = activeMainService.reviewToActiveMarketing(activeReview.getActiveMarketing());
                        activeMarketingService.patchByActiveCode(newActiveMarketing);
                        if ("1".equals(activeMainReview.getInputDeale())) {
                            //修改ActiveDealer表有效数据
                            ActiveDealerCondition activeDealerCondition = new ActiveDealerCondition();
                            activeDealerCondition.setActiveCode(activeCode);
                            List<ActiveDealer> activeDealerList = activeDealerService.selectList(activeDealerCondition);
                            for (ActiveDealer activeDealers : activeDealerList) {
                                ActiveDealerHis activeDealerHis = activeMainService.formalToActiveDealerHis(activeDealers);
                                activeDealerHis.setCompany(uc.getComCode());
                                activeDealeHisService.insert(activeDealerHis);
                            }
                            activeDealerService.deleteByActiveCode(activeCode);
                            for (ActiveDealerReview activeDealerReview : activeReview.getAtiveDealeList()) {
                                ActiveDealer activeDealer = activeMainService.reviewToActiveDealer(activeDealerReview);
                                activeDealer.setCompany(uc.getComCode());
                                activeDealerService.insert(activeDealer);
                            }
                        } else {
                            //修改ActiveArea表有效数据
                            ActiveArea activeArea = new ActiveArea();
                            ActiveAreaCondition activeAreaCondition = new ActiveAreaCondition();
                            activeAreaCondition.setActiveCode(activeCode);
                            List<ActiveArea> activeAreaList = activeAreaService.selectList(activeAreaCondition);
                            activeArea = activeAreaList.get(0);
                            ActiveAreaHis activeAreaHis = activeMainService.formalToActiveAreaHis(activeArea);
                            activeAreaHis.setCompany(uc.getComCode());
                            activeAreaHisService.insert(activeAreaHis);
                            ActiveArea newActiveArea = activeMainService.reviewToActiveArea(activeReview.getActiveArea());
                            activeAreaService.patchByActiveCode(newActiveArea);
                        }
                        //修改ActiveProd表有效数据
                        ActiveProdCondition activeProdCondition = new ActiveProdCondition();
                        activeProdCondition.setActiveCode(activeCode);
                        List<ActiveProd> activeProdList = activeProdService.selectList(activeProdCondition);
                        for (ActiveProd activeProd : activeProdList) {
                            ActiveProdHis activeProdHis = activeMainService.formalToActiveProdHis(activeProd);
                            activeProdHis.setCompany(uc.getComCode());
                            activeProdHisService.insert(activeProdHis);
                        }
                        activeProdService.deleteByActiveCode(activeCode);
                        for (ActiveProdReview activeProdReview : activeReview.getActiveProdList()) {
                            ActiveProd activeProd = activeMainService.reviewToActiveProd(activeProdReview);
                            activeProd.setCompany(uc.getComCode());
                            activeProdService.insert(activeProd);
                        }
                        //修改ActiveCar表有效数据
                        ActiveCar activeCar = new ActiveCar();
                        ActiveCarCondition activeCarCondition = new ActiveCarCondition();
                        activeCarCondition.setActiveCode(activeCode);
                        List<ActiveCar> activeCarList = activeCarService.selectList(activeCarCondition);
                        activeCar = activeCarList.get(0);
                        ActiveCarHis activeCarHis = activeMainService.formalToActiveCarHis(activeCar);
                        activeCarHis.setCompany(uc.getComCode());
                        activeCarHisService.insert(activeCarHis);
                        ActiveCar newActiveCar = activeMainService.reviewToActiveCar(activeReview.getActiveCar());
                        activeCarService.patchByActiveCode(newActiveCar);
                        //修改ActiveBusiness表有效数据
                        ActiveBusiness activeBusiness = new ActiveBusiness();
                        ActiveBusinessCondition activeBusinessCondition = new ActiveBusinessCondition();
                        activeBusinessCondition.setActiveCode(activeCode);
                        List<ActiveBusiness> activeBusinessList = activeBusinessService.selectList(activeBusinessCondition);
                        activeBusiness = activeBusinessList.get(0);
                        ActiveBusinessHis activeBusinessHis = activeMainService.formalToActiveBusinessHis(activeBusiness);
                        activeBusinessHis.setCompany(uc.getComCode());
                        activeBusinessHisService.insert(activeBusinessHis);
                        ActiveBusiness newActiveBusiness = activeMainService.reviewToActiveBusiness(activeReview.getActiveBusiness());
                        activeBusinessService.patchByActiveCode(newActiveBusiness);
                        if ("1".equals(activeMainReview.getAdditionFlag())) {
                            //修改ActiveAddition表有效数据
                            ActiveAddition activeAddition = new ActiveAddition();
                            ActiveAdditionCondition activeAdditionCondition = new ActiveAdditionCondition();
                            activeAdditionCondition.setActiveCode(activeCode);
                            List<ActiveAddition> activeAdditionList = activeAdditionService.selectList(activeAdditionCondition);
                            activeAddition = activeAdditionList.get(0);
                            ActiveAdditionHis activeAdditionHis = activeMainService.formalToActiveAdditionHis(activeAddition);
                            activeAdditionHis.setCompany(uc.getComCode());
                            activeAdditionalHisService.insert(activeAdditionHis);
                            ActiveAddition newActiveAddition = activeMainService.reviewToActiveAddition(activeReview.getActiveAdditional());
                            activeAdditionService.patchByActiveCode(newActiveAddition);
                        }
                    }
                }
            }
        }else if("00".equals(oldWorkFlow.getReviewStatus())){//打回操作
            workFlow.setOpinion(oldWorkFlow.getOpinion());
            workFlow.setReviewStatus("00");
            workFlowService.patchById(workFlow);//更新当前节点
            //更新TeamReview表审核状态
            activeReview.getAtiveMain().setReviewStatus("00");
            ativeMainReviewService.patchById(activeReview.getAtiveMain());
        }
    }

    /**
     * 修改审核状态为审核中
     * @param status
     * @param id
     * @param flowId
     */
    @Transactional
    public synchronized void updateCheckStatus(String status, Long id, Long flowId) {
        UserContext userContext = SessionHolder.getUserContext();
        Long modifier = Long.parseLong(userContext.getId());
        ActiveMainReview activeMainReview = ativeMainReviewService.selectById(id);
        if ("03".equals(activeMainReview.getReviewStatus())){
            throw new ValidationException("该条数据已经被占用");
        }else {
            ativeMainReviewService.updateStatusById(status,id,modifier);
            workFlowService.updateStatusById(status,flowId,modifier);
        }
    }
}
