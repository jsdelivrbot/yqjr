package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.CommodityOutCondition;
import com.yqjr.fin.mkmm.sales.condition.CommodityReviewCondition;
import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;
import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.entity.CommodityOut;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityReviewVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityReview;
import com.yqjr.fin.mkmm.sales.mapper.CommodityReviewMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityReviewService extends BaseService<CommodityReviewMapper, CommodityReview, Long> {

    @Autowired
    private CommodityInService commodityInService;
    @Autowired
    private CommodityAcceptanceService commodityAcceptanceService;
    @Autowired
    CommodityReviewMapper commodityReviewMapper;
    @Autowired
    private CommodityStockService commodityStockService;
    @Autowired
    CommodityOutService commodityOutService;


    @Transactional
    public void review(CommodityReview review) {
        Long id = review.getId();
        String CommodityStatus = review.getCommodityStatus();
        String remark = review.getRemark();
        if("04".equals(CommodityStatus)) {//审核通过
            CommodityReview commodityReview = new CommodityReview();
            commodityReview.setId(id);
            commodityReview.setCommodityStatus("04");
            commodityReview.setFlag("0");
            commodityReview.setRemark(remark);
            this.patchById(commodityReview);
            //数据进入入库表
            commodityReview = this.selectById(id);
            CommodityIn commodityIn = insertIntoCommodityIn(commodityReview);
            //更新验收表物料状态
            Long acceptId = commodityReview.getAcceptanceId();
            updateCommodityAcceptance(acceptId);
            //记录库存
            commodityStockService.inStock(commodityIn);
        } else if ("00".equals(CommodityStatus)) {//审核驳回
            CommodityReview commodityReview = new CommodityReview();
            commodityReview.setId(id);
            commodityReview.setRemark(remark);
            commodityReview.setCommodityStatus("00");
            this.patchById(commodityReview);
        }

    }


    /**
     * 将数据插入入库表
     * @param commodityReview
     */
    public CommodityIn insertIntoCommodityIn(CommodityReview commodityReview){
        UserContext userContext = SessionHolder.getUserContext();
        CommodityIn commodityIn = new CommodityIn();
        commodityIn.setCommodityTypeCode(commodityReview.getCommodityTypeCode());
        commodityIn.setCommodityTypeName(commodityReview.getCommodityTypeName());
        commodityIn.setCommodityCode(commodityReview.getCommodityCode());
        commodityIn.setCommodityName(commodityReview.getCommodityName());
        commodityIn.setAreaCode(commodityReview.getAreaCode());
        commodityIn.setAreaName(commodityReview.getAreaName());
        commodityIn.setProjectCode(commodityReview.getProjectCode());
        commodityIn.setProjectName(commodityReview.getProjectName());
        commodityIn.setCompany(commodityReview.getCompany());
        commodityIn.setCustodian(commodityReview.getCustodian());
        commodityIn.setChecker(userContext.getName());
        commodityIn.setAcceptanceId(commodityReview.getAcceptanceId());
        commodityIn.setProvideOrganization(commodityReview.getProvideOrganization());
        commodityIn.setInNumber(commodityReview.getInNumber());
        commodityIn.setInUnivalent(commodityReview.getInUnivalent());
        commodityIn.setAmount(commodityReview.getAmount());
        commodityIn.setInTime(new Date());
        commodityIn.setCommodityStatus("00");//已入库
        commodityInService.insert(commodityIn);
        return commodityIn;
    }

    /**
     * 更新验收表物料状态
     * @param id
     */
    public void updateCommodityAcceptance(Long id) {
        CommodityAcceptance commodityAcceptance = new CommodityAcceptance();
        commodityAcceptance.setId(id);
        commodityAcceptance.setAcceptanceStatus("2");
        commodityAcceptanceService.patchById(commodityAcceptance);
    }

    /**
     * 物料入库审核进度处理
     * @param commodityReview
     */
    @Transactional
    public void inProcess(CommodityReview commodityReview) {
        CommodityReview cr = new CommodityReview();
        Long id = commodityReview.getId();
        Long number = commodityReview.getInNumber();
        BigDecimal amount = commodityReview.getAmount();
        BigDecimal inUnivalent = commodityReview.getInUnivalent();
        //更新待审核状态
        cr.setCommodityStatus("02");
        cr.setId(id);
        cr.setAmount(amount);
        cr.setInNumber(number);
        cr.setInUnivalent(inUnivalent);
        this.patchById(cr);
    }

    /**
     * 物料出库审核
     * @param review
     */
    @Transactional(rollbackFor = {Exception.class})
    public void outReview(CommodityReview review){
        String batchCode = review.getBatchCode();
        String commodityStatus = review.getCommodityStatus();
        String remark = review.getRemark();
        List<CommodityReview> commoReviews = this.selectByBatchCode(batchCode);
        if("04".equals(commodityStatus)){//审核通过
            UserContext userContext = SessionHolder.getUserContext();
            CommodityReview commodityReview = new CommodityReview();
            commodityReview.setFlag("0");
            commodityReview.setCommodityStatus("04");
            commodityReview.setRemark(remark);
            commodityReview.setBatchCode(batchCode);
            //修改审核表数据
            this.updateByBatchCode(commodityReview);
            CommodityReview commodityReview1 = null;
            CommodityOut commodityOut = new CommodityOut();
            for(int i=0;i<commoReviews.size();i++){
                commodityReview1 = commoReviews.get(i);
                BeanUtil.copyProperties(commodityOut,commodityReview1);
                commodityOut.setOutTime(new Date());
                commodityOut.setChecker(userContext.getName());
                commodityOut.setReceiveStatus("0");
                commodityOutService.insert(commodityOut);
            }
        }else if("00".equals(commodityStatus)){
            CommodityReview commodityReview = new CommodityReview();
            commodityReview.setBatchCode(batchCode);
            commodityReview.setCommodityStatus("00");
            commodityReview.setRemark(remark);
            this.updateByBatchCode(commodityReview);
            // 查询审核数据id
            List<Long> ids = getIds(commoReviews);
            //库存补回来
            inStock(ids);
        }
    }

    /**
     * 获取审核数据的id
     * @param commoReviews
     * @return
     */
    List<Long> getIds(List<CommodityReview> commoReviews){
        List<Long> ids = new ArrayList<Long>();
        Long id = 0L;
        for(int i=0;i<commoReviews.size();i++) {
            id = commoReviews.get(i).getId();
            ids.add(id);
        }
        return ids;
    }
    /**
     * 通过批次号查询同一批审核数据
     * @param batchCode
     * @return
     */
    public List<CommodityReview> selectByBatchCode(String batchCode){
        return commodityReviewMapper.selectByBatchCode(batchCode);
    }
    /**
     * 通过批次号修改同一批次的审核信息
     * @param commodityReview
     */
    public void updateByBatchCode(CommodityReview commodityReview){
        commodityReviewMapper.updateByBatchCode(commodityReview);
    }

    /**
     * 审核数据页面查询
     * @param batchCode
     * @return
     */
    @Transactional
    public CommodityReviewVo selectMsg(String batchCode){
        CommodityReviewVo commodityReviewVo = new CommodityReviewVo();
        //查出同一批出库数据
        List<CommodityReview> commodityReviews = commodityReviewMapper.selectReviewMsg(batchCode);

        if (commodityReviews.size()>0) {
            commodityReviewVo.setProvideOrganization(commodityReviews.get(0).getProvideOrganization());
            commodityReviewVo.setCommodityName(commodityReviews.get(0).getCommodityName());
            commodityReviewVo.setCommodityTypeName(commodityReviews.get(0).getCommodityTypeName());
            commodityReviewVo.setProjectName(commodityReviews.get(0).getProjectName());
            commodityReviewVo.setBatchCode(commodityReviews.get(0).getBatchCode());
            commodityReviewVo.setPutName(commodityReviews.get(0).getPutName());

            CommodityReview commodityReview = null;
            List<CommodityOutCondition> list = new ArrayList<CommodityOutCondition>();

            for(int i=0;i<commodityReviews.size();i++){
                commodityReview = commodityReviews.get(i);
                CommodityOutCondition commodityOutCondition = new CommodityOutCondition();
                commodityOutCondition.setDealerName(commodityReview.getDealerName());
                commodityOutCondition.setDealerCode(commodityReview.getDealerCode());
                commodityOutCondition.setPutNumber(commodityReview.getPutNumber());
                commodityOutCondition.setPutUnivalent(commodityReview.getPutUnivalent());
                commodityOutCondition.setAmount(commodityReview.getAmount());
                list.add(commodityOutCondition);
            }
            commodityReviewVo.setCommodityOutConditions(list);
            return commodityReviewVo;
        } else {
            return null;
        }


    }

    /**
     * 审核进度修改
     * @param commodityReview
     */
    @Transactional
    public void reviewChange(CommodityReview commodityReview){
        CommodityReview commodityRe = new CommodityReview();
        commodityRe.setId(commodityReview.getId());
        commodityRe.setPutUnivalent(commodityReview.getPutUnivalent());
        commodityRe.setPutNumber(commodityReview.getPutNumber());
        commodityRe.setCommodityStatus("02");
        commodityRe.setAmount(commodityReview.getAmount());
        this.patchById(commodityRe);
        //单笔减库存
        outStock(commodityReview);
    }

    /**
     * 补库存
     */
    public void inStock(List<Long> ids) {
        //通过批次号获取经销商数据
        List<CommodityReview> commodityReviews =selectRejectMsg(ids);
        Long sum = (long)0;
        //计算出了多少数量
        for(CommodityReview commodityReview : commodityReviews) {
            Long num = commodityReview.getPutNumber();
            sum += num;
        }
        if(commodityReviews.size()>0) {
            String commodityCode = commodityReviews.get(0).getCommodityCode();
            String commodityTypeCode = commodityReviews.get(0).getCommodityTypeCode();
            String company = commodityReviews.get(0).getCompany();
            String areaCode = commodityReviews.get(0).getAreaCode();
            CommodityIn commodityIn = new CommodityIn();
            commodityIn.setInNumber(sum);
            commodityIn.setAreaCode(areaCode);
            commodityIn.setCompany(company);
            commodityIn.setCommodityTypeCode(commodityTypeCode);
            commodityIn.setCommodityCode(commodityCode);
            commodityStockService.inStock(commodityIn);
        }

    }

    /**
     * 单笔减库存
     */
    public void outStock(CommodityReview commodityReview) {
        String commodityCode = commodityReview.getCommodityCode();
        String commodityTypeCode = commodityReview.getCommodityTypeCode();
        String company = commodityReview.getCompany();
        String areaCode = commodityReview.getAreaCode();
        Long num = commodityReview.getPutNumber();

        CommodityOut commodityOut = new CommodityOut();
        commodityOut.setPutNumber(num);
        commodityOut.setCompany(company);
        commodityOut.setCommodityTypeCode(commodityTypeCode);
        commodityOut.setCommodityCode(commodityCode);
        commodityOut.setAreaCode(areaCode);
        commodityStockService.outStock(commodityOut);
    }

    /**
     *  物料审核根据批次号查经销商
     */
    @Transactional
    public List<SelectMenuVo> selectReviewDealer(String batchCode) {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityReviewCondition commodityReviewCondition = new CommodityReviewCondition();
        commodityReviewCondition.setCompany(userContext.getComCode());
        commodityReviewCondition.setAreaCode(userContext.getAreaCode());
        commodityReviewCondition.setBatchCode(batchCode);
        //查询经销商
        List<CommodityReview> reviews = this.selectList(commodityReviewCondition);
        //组装数据
        List<SelectMenuVo> selectMenuVos = getDealerData(reviews);
        return selectMenuVos;
    }

    /**
     * 组装数据
     * @param commodityReviews
     * @return
     */
    public List<SelectMenuVo> getDealerData (List<CommodityReview> commodityReviews){

        List<SelectMenuVo> selectMenuVos = new ArrayList<>();
        for(CommodityReview commodityReview : commodityReviews) {
            SelectMenuVo selectMenuVo = new SelectMenuVo();
            selectMenuVo.setTitle(commodityReview.getDealerName());
            selectMenuVo.setValue(commodityReview.getDealerCode());
            selectMenuVos.add(selectMenuVo);
        }
        return selectMenuVos;
    }

    /**
     * 出库审核列表页
     * @param condition
     * @return
     */
    public List<CommodityReview> queryOutReviewList(CommodityReviewCondition condition, PageBounds... pageBounds) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCommodityStatus("02");
        condition.setFlag("1");
        condition.setType("2");
        if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
            condition.setAreaCode(userContext.getAreaCode());
        }
        condition.setCompany(userContext.getComCode());
        condition.setCreator(Long.parseLong(userContext.getId()));
        List<CommodityReview> commodityReviews = commodityReviewMapper.queryOutReviewList(condition, pageBounds);

        return commodityReviews;
    }

    /**
     * 入库审核列表页
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<CommodityReview> queryInReviewList(CommodityReviewCondition condition, PageBounds... pageBounds) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCommodityStatus("02");
        condition.setCompany(userContext.getComCode());
        condition.setFlag("1");
        condition.setType("1");
        condition.setCreator(Long.parseLong(userContext.getId()));
        if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
            condition.setAreaCode(userContext.getAreaCode());
        }
        List<CommodityReview> commodityReviews = commodityReviewMapper.queryInReviewList(condition, pageBounds);

        return commodityReviews;

    }

    /**
     * 查询驳回数据
     * @param ids
     * create by lf
     * 20180914
     * @return
     */
    public List<CommodityReview> selectRejectMsg (List<Long> ids) {
        List<CommodityReview> commodityReviews = new ArrayList<>();
        CommodityReview commodityReview = null;
        return commodityReviewMapper.selectByIds(ids);
    }

    /**
     * 查询物料审核进度处理信息
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<CommodityReview> queryOutProcessList(CommodityReviewCondition condition, PageBounds... pageBounds) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setAreaCode(userContext.getAreaCode());
        condition.setCompany(userContext.getComCode());
        condition.setCreator(Long.parseLong(userContext.getId()));
        List<CommodityReview> commodityReviews = commodityReviewMapper.queryOutProcessList(condition, pageBounds);
        return commodityReviews;
     }

     /**
     * 查询物料审核进度处理信息
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<CommodityReview> queryProcessList(CommodityReviewCondition condition, PageBounds... pageBounds) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setAreaCode(userContext.getAreaCode());
        condition.setCompany(userContext.getComCode());
        condition.setCreator(Long.parseLong(userContext.getId()));
        List<CommodityReview> commodityReviews = commodityReviewMapper.queryInProcessList(condition, pageBounds);
        return commodityReviews;
     }
}