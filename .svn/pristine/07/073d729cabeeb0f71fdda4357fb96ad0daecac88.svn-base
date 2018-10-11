package com.yqjr.fin.mkmm.sales.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.common.DateUtils;
import com.yqjr.fin.mkmm.sales.condition.*;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.model.Active;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 活动匹配定时任务相关
 * @author: lixue
 * @date: 2018/05/30 13:49:32
 **/
@Service
@Transactional(readOnly = true)
public class ActiveTimedTaskService  {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActiveMainService activeMainService;

    @Autowired
    private ActiveMatchTaskService activeMatchTaskService;

    @Autowired
    private ActiveMatchMainService activeMatchMainService;

    @Autowired
    private ActiveDealerMatchService activeDealerMatchService;

    @Autowired
    private BasicBussinessService basicBussinessService;

    @Autowired
    private ActiveMatchDetailService activeMatchDetailService;

    @Autowired
    private ActiveAreaService activeAreaService;

    @Autowired
    private ActiveCarService activeCarService;

    @Autowired
    private ActiveDealerService activeDealerService;


    DecimalFormat decimalFormat = new DecimalFormat("#.##");


    /**
     *构建活动定时任务
     */
    public void buildActiveMatchTask() throws Exception{
        logger.info("ActiveTimedTaskService buildActiveMatchTask start");
        String date = DateUtils.getDateStr(DateUtils.getCurrentBeforeDay(1));
        List<ActiveMain> activeMainList = activeMainService.selectByLoanEndTime(date);
        logger.info("buildActiveMatchTask end,activeMainList = " + JSONObject.toJSONString(activeMainList,SerializerFeature.WRITE_MAP_NULL_FEATURES));
        if (activeMainList != null && activeMainList.size() > 0) {
            addActiveMatchTask(activeMainList);
        }
        logger.info("ActiveTimedTaskService buildActiveMatchTask end");
    }

    /**
     * @Description:构建要添加到匹配任务表的数据
     */
    private void addActiveMatchTask(List<ActiveMain> activeMainList) throws Exception{
        logger.info("addActiveMatchTask start");
        for (ActiveMain activeMain : activeMainList) {
            ActiveMatchTask activeMatchTask = new ActiveMatchTask();
            activeMatchTask.setTaskDate(activeMain.getLoanEndtime());
            activeMatchTask.setActiveCode(activeMain.getActiveCode());
            activeMatchTask.setActiveName(activeMain.getActiveName());
            activeMatchTask.setIsExecute("0");
            activeMatchTask.setFlag("1");
            activeMatchTask.setType(0L);
            activeMatchTask.setCompany(activeMain.getCompany());
            activeMatchTaskService.insert(activeMatchTask);
        }
        logger.info("addActiveMatchTask end");
    }


    /**
     * @Description: 获取未执行的任务列表
     */
    public List<ActiveMatchTask> getUnexecutedTask(){
        logger.info("getUnexecutedTask start");
        ActiveMatchTaskCondition activeMatchTaskCondition = new ActiveMatchTaskCondition();
        activeMatchTaskCondition.setIsExecute("0");
        activeMatchTaskCondition.setFlag("1");
        activeMatchTaskCondition.setType(0L);
        List<ActiveMatchTask> unexecutedTaskList = activeMatchTaskService.selectList(activeMatchTaskCondition);
        logger.info("getUnexecutedTask end,unexecutedTaskList = " + JSONObject.toJSONString(unexecutedTaskList,SerializerFeature.WRITE_MAP_NULL_FEATURES));
        return unexecutedTaskList;
    }

    /**
     * @Description: 一个活动与筛选出的业务明细数据逐个匹配
     */
    @Transactional
    public void taskMatchTransactional(ActiveMatchTask activeMatchTask) throws Exception{
        logger.info("taskMatchTransactional start,activeMatchTask = " + JSONObject.toJSONString(activeMatchTask,SerializerFeature.WRITE_MAP_NULL_FEATURES));
        List<BasicBussiness> basicBussinessList = basicBussinessService.selectByDfactatartDate(DateUtils.getDateStr(activeMatchTask.getTaskDate()));
        logger.info("basicBussinessList size = " + basicBussinessList.size());
        if(null != basicBussinessList && basicBussinessList.size()>0){
            for(BasicBussiness basicBussiness:basicBussinessList){
                Map<String,Object> bussinessMap = beanToMap(basicBussiness);
                ActiveMain activeMain = getActiveMainByTask(activeMatchTask);
                logger.info("taskMatchTransactional activeMain = " + JSONObject.toJSONString(activeMain,SerializerFeature.WriteMapNullValue));
                if(null != activeMain){
                    Map<String,Object> activeMap = getActiveDataMap(activeMain);
                    if(null != activeMap && activeMap.size()>0){
                        activeMap.put("distributor_code",getActiveAllDealer(getDealerByActive(activeMain)));
                    }
                    //单条活动与业务匹配
                    boolean matchResult = mapCompare(bussinessMap,activeMap);
                    //匹配完成后 根据匹配结果 跟新活动明细匹配表 活动匹配主表 经销商匹配表
                    updateMatchInfo(activeMain,basicBussiness,matchResult);
                }
            }
            //一个任务匹配结束后 更新任务表执行结果
            updateActiveTask(activeMatchTask);
        }
        logger.info("taskMatchTransactional end");
    }

    /**
     * 通过活动匹配任务表的活动编码和公司查询活动主表
     */
    private ActiveMain getActiveMainByTask(ActiveMatchTask activeMatchTask){
        logger.info("getActiveMainByTask start,activeMatchTask = " + JSONObject.toJSONString(activeMatchTask));
        ActiveMain  activeMain = null;
        ActiveMainCondition activeMainCondition = new ActiveMainCondition();
        activeMainCondition.setActiveCode(activeMatchTask.getActiveCode());
        activeMainCondition.setCompany(activeMatchTask.getCompany());
        List<ActiveMain> activeMainist = activeMainService.selectList(activeMainCondition);
        if(null != activeMainist && activeMainist.size()>0){
            activeMain = activeMainist.get(0);
        }
        logger.info("getActiveMainByTask end");
        return activeMain;
    }


    /**
     *  通过活动id经销商信息
     */
    private List<ActiveDealer>  getDealerByActive(ActiveMain activeMain){
        logger.info("getDealerByActive start");
        ActiveDealerCondition activeDealerCondition = new ActiveDealerCondition();
        activeDealerCondition.setActiveId(activeMain.getId());
        List<ActiveDealer> activeDealers  =activeDealerService.selectList(activeDealerCondition);
        logger.info("getDealerByActive end, activeDealers = " + JSONObject.toJSONString(activeDealers));
        return activeDealers;
    }

    /**
     *  将活动对应的多个经销商拼接在一起 逗号分隔
     */
    private String getActiveAllDealer(List<ActiveDealer> activeDealers){
        logger.info("getActiveAllDealer start,activeDealers = " + activeDealers.size());
        StringBuilder dealerCode = new StringBuilder();
        if(null != activeDealers && activeDealers.size()>0){
            for(ActiveDealer activeDealer:activeDealers){
                dealerCode =dealerCode.append(activeDealer.getDealerCode()).append(",");
            }
        }
        logger.info("getDealerByActiveCode end ,dealerCode = " + dealerCode.toString());
        return dealerCode.toString();
    }
    /**
     * @Description:将需要与业务比较的活动信息放进map
     */
    private Map<String,Object> getActiveDataMap(ActiveMain activeMain) throws  Exception{
        logger.info("getActiveDataMap start,activeMain = " + JSONObject.toJSONString(activeMain));
        List<Map<String, Object>> list = activeMainService.getActiveMatchData(activeMain.getId());
        logger.info("getActiveDataMap list = " + JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue));
        if(null != list && list.size()>0){
            return list.get(0);
        }
        return null;
    }


    /**
     * 业务map与活动map比较
     */
    private Boolean mapCompare(Map<String,Object> bussinessMap,Map<String,Object> activeMap) throws Exception{
        logger.info("mapCompare start,bussinessMap = " + bussinessMap +",activeMap = " + activeMap);
        boolean matchResult = true;
        if(null != bussinessMap && bussinessMap.size()>0 && null != activeMap && activeMap.size()>0){
            for(Map.Entry<String,Object> map:activeMap.entrySet()){
                String activeKey = map.getKey();
                Object activeValue = map.getValue();
                Object bussinessValue = bussinessMap.get(activeKey);
                matchResult = bussinessActiveCompare(activeKey,activeValue, bussinessValue);
                if(!matchResult){
                    break;
                }
            }
        }else {
            matchResult = false;
        }
        logger.info("mapCompare end,matchResult = " + matchResult) ;
        return matchResult;
    }

    /**
     * @Description:活动明细
     */
    private Boolean bussinessActiveCompare(String key,Object activeValue,Object bussinessValue) throws Exception{
        logger.info("bussinessActiveCompare start,key = "+key+",activeValueStr = " + activeValue +",bussinessValueStr = " + bussinessValue);
        Boolean valueMatchResult = false;
        //当业务数据为空,活动数据不为空的时候，如果活动数据为全部时 true 否则 false
        if(org.springframework.util.StringUtils.isEmpty(bussinessValue) && !org.springframework.util.StringUtils.isEmpty(activeValue)){
            if("00".equals(activeValue)) {//活动数据选择全部时 匹配
                valueMatchResult = true;
            }
        }else if(null != bussinessValue && null != activeValue){//业务数据、活动数据都不为空 比较
            if(bussinessValue instanceof Date){ //日期类型先转成字符串
                bussinessValue = DateUtils.getYmdDateStr((Date)bussinessValue);
            }
            valueMatchResult = valueCompare(key,activeValue.toString(),bussinessValue.toString());
        }else{
            //当 业务null && 活动null 或者 业务不null && 活动null 均为true
            valueMatchResult = true;
        }
        logger.info("bussinessActiveCompare end,valueMatchResult = " + valueMatchResult);
        return valueMatchResult;
    }
    
    /**
     * @Description: 活动和业务数据map的value值比较
     */
    private Boolean valueCompare(String key,String activeValueStr,String bussinessValueStr) throws Exception{
        logger.info("valueCompare start,key = " + key +",activeValueStr = " + activeValueStr +",bussinessValueStr = " + bussinessValueStr);
        if (activeValueStr.contains("-")) {//区间比较
           return sectionCompare(activeValueStr,bussinessValueStr);
        } else if (activeValueStr.equals("00")) {// 如果活动数据是全部 true
            return true;
        } else if (activeValueStr.contains(",")) {// 一个活动对应多条记录 用逗号分隔存储时 活动数据包含业务数据通过
            if (activeValueStr.contains(bussinessValueStr)) {
                return true;
            }
        } else {
            if (activeValueStr.equals(bussinessValueStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 活动匹配信息处理
     * 更新活动匹配主表 更新活动匹配明细表 更新经销商匹配明细表
     */
    private void updateMatchInfo(ActiveMain activeMain,BasicBussiness basicBussiness,boolean matchResult) throws Exception{
        logger.info("updateMatchInfo start,activeMain = " + activeMain.getId() +",bussinessId = "+basicBussiness.getId()+",matchResult = " + matchResult);
        ActiveArea activeArea = getActiveAreaByActive(activeMain);
        ActiveCar activeCar = getActiveCarByActive(activeMain);
        ActiveMatchMain activeMatchMain = getActiveMatchMainByActive(activeMain);
        //更新活动匹配主表
        processActiveMatchMain(activeMain,matchResult,activeArea,activeCar,activeMatchMain);
        if(matchResult){
            ActiveDealerMatch activeDealerMatch = getDealerMatchByCode(basicBussiness);
            //更新经销商匹配主表
            processDealerMatchInfo(activeDealerMatch,basicBussiness);
            //更新活动匹配详细表
            activeMatchMain = getActiveMatchMainByActive(activeMain);
            processActiveMatchDetail(activeMain,basicBussiness,activeDealerMatch,activeMatchMain);
        }
        logger.info("updateMatchInfo end");
    }



    /**
     * @Description:更新任务执行状态为已执行
     */
    private void updateActiveTask(ActiveMatchTask activeMatchTask) throws  Exception{
        logger.info("updateActiveTask start,id = " + activeMatchTask.getId());
        activeMatchTask.setIsExecute("1");
        activeMatchTaskService.updateById(activeMatchTask);
        logger.info("updateActiveTask end");
    }

    /**
     * 处理活动匹配主表
     * 查询活动匹配主表 是否存在 不存在添加 否则更新
     */
    private void processActiveMatchMain(ActiveMain activeMain,boolean matchResult,ActiveArea activeArea,ActiveCar activeCar,ActiveMatchMain activeMatchMain) throws Exception{
        logger.info("processActiveMatchMain start,matchResult = " + matchResult);
        ActiveDealer activeDealer = getActiveDealerByActiveId(activeMain);
        // 活动匹配主表存在  并且匹配 更新活动实际成交数量、活动达成率
        if(null != activeMatchMain && matchResult){
            Long actualCount = activeMatchMain.getActualTurnoverCount();
            if(org.springframework.util.StringUtils.isEmpty(actualCount)){
                actualCount = 0L;
            }
            actualCount = actualCount + 1;
            activeMatchMain.setActualTurnoverCount(actualCount);//活动实际成交数量
            String reachRate = calReachRate(actualCount,activeMatchMain.getEstimateTurnoverCount()); //达成率
            activeMatchMain.setReachRate(reachRate);
            activeMatchMain.setMaxBillFee(calMaxBillFee(actualCount,activeDealer,activeMain.getAvtiveCriterion()));
            activeMatchMainService.patchById(activeMatchMain);
        }else if(activeMatchMain == null ){// 活动匹配主表不存在 新增活动匹配主表
            addActiveMatchMain(activeMain,matchResult,activeCar,activeDealer);
        }
        logger.info("processActiveMatchMain end");
    }

    /**
     * @Description: 活动匹配主表添加
     */
    private void addActiveMatchMain(ActiveMain activeMain,boolean matchResult,ActiveCar activeCar,ActiveDealer activeDealer) throws Exception{
        logger.info("addActiveMatchMain start,matchResult = " + matchResult);
        ActiveMatchMain activeMatchMain = new ActiveMatchMain();
        activeMatchMain.setCountType("1");
        activeMatchMain.setBusinessCode(activeMain.getActiveCode());
        activeMatchMain.setBusinessName(activeMain.getActiveName());
        activeMatchMain.setCompany(activeMain.getCompany());
        Date currentDate = new Date();
        //当前时间早于活动开始时间 活动未开始 当前时间晚于活动结束时间  活动已结束
        if(currentDate.before(activeMain.getActiveStartime())){//活动未开始
            activeMatchMain.setValidStatus("01");
        }else if(currentDate.after(activeMain.getActiveEndtime())){//活动已结束
            activeMatchMain.setValidStatus("03");
        }else{//正在进行中
            activeMatchMain.setValidStatus("02");
        }
        Long expectedCount = activeMain.getExpectedCount();//活动预期数量
        Long actualCount = 0L; //实际活动成交数量
        activeMatchMain.setEstimateTurnoverCount(expectedCount);
        String reachRate = "0%";
        if(matchResult){//匹配 实际活动成交数量为1 更新达成率
            actualCount = 1L;
            reachRate = calReachRate(actualCount,expectedCount);
        }
        activeMatchMain.setActualTurnoverCount(actualCount);
        activeMatchMain.setReachRate(reachRate);
        activeMatchMain.setAreaCode(activeMain.getAreaCode());
        activeMatchMain.setAreaName(activeMain.getAreaName());
        if(null != activeCar){
            activeMatchMain.setBrandsCode(activeCar.getBrandsCode());
            activeMatchMain.setBrandsName(activeCar.getBrandsName());
        }
        activeMatchMain.setAvtiveCriterion(activeMain.getAvtiveCriterion());//促销活动激励标准
        activeMatchMain.setMaxBillFee(calMaxBillFee(actualCount,activeDealer,activeMain.getAvtiveCriterion()));//结算单上限金额
        activeMatchMain.setActiveStartime(activeMain.getActiveStartime());
        activeMatchMain.setActiveEndtime(activeMain.getActiveEndtime());
        activeMatchMain.setIsSettlement("01");
        activeMatchMain.setFlag("1");
        activeMatchMainService.insert(activeMatchMain);
        logger.info("addActiveMatchMain end");
    }

    /**
     * 处理经销商匹配信息 匹配 && 存在 更新 匹配 && 不存在 新增
     * 经销商可选 可不选 活动可能对应多个经销商 所以当匹配时 以业务表的经销商代码为准
     */
    private void processDealerMatchInfo(ActiveDealerMatch activeDealerMatch,BasicBussiness basicBussiness) throws  Exception{
        logger.info("processDealerMatchInfo start,activeDealerId = "+basicBussiness.getId());
        if (null != activeDealerMatch) {// 经销商匹配信息表存在  更新实际数量
            Long actualCount = activeDealerMatch.getRealDistributorCount();
            if (null != actualCount) {
                actualCount = actualCount + 1;
            } else {
                actualCount = 0L;
            }
            activeDealerMatch.setRealDistributorCount(actualCount);
            activeDealerMatchService.updateById(activeDealerMatch);
        } else {// 经销商匹配信息表不存在  新增
            addActiveDealerMatch(basicBussiness);
        }
        logger.info("processDealerMatchInfo end");
    }


    /**
     * @Description: 处理活动匹配明细信息
     */
    private void processActiveMatchDetail(ActiveMain activeMain,BasicBussiness basicBussiness,ActiveDealerMatch activeDealerMatch,ActiveMatchMain activeMatchMain) throws Exception{
        logger.info("processActiveMatchDetail start");
        ActiveMatchDetail activeMatchDetail = new ActiveMatchDetail();
        activeMatchDetail.setBusinessCode(activeMain.getActiveCode());
        activeMatchDetail.setBusinessName(activeMain.getActiveName());
        Long realCount = 0L;
        Long totalCount = 0L;
        if(null != activeDealerMatch ){
            activeMatchDetail.setDistributorid(activeDealerMatch.getId());
            realCount = (null == activeDealerMatch.getRealDistributorCount())?0L:activeDealerMatch.getRealDistributorCount();
            totalCount = (null ==activeDealerMatch.getDistributorCount())?0L:activeDealerMatch.getDistributorCount();
        }
        // 实际数量为0 最大数量不为0 &&  超出上限 不计算费用
        if(realCount == 0 || (realCount == 0 && totalCount == 0) ||  (totalCount>0 && realCount>totalCount)){
            activeMatchDetail.setIsCountMaxIn("02");// 不计算费用
        }else {
            activeMatchDetail.setIsCountMaxIn("01");// 计算费用
        }
        activeMatchDetail.setTaskId(activeMatchMain.getId());
        activeMatchDetail.setCountDate(basicBussiness.getDfactstartDate());
        // 属性拷贝 并将id等字段置为空 重新生成
        BeanUtil.copyProperties(activeMatchDetail,basicBussiness);
        activeMatchDetail.setId(null);
        activeMatchDetail.setCreateTime(null);
        activeMatchDetail.setModifyTime(null);
        activeMatchDetail.setStartTime(null);
        activeMatchDetail.setCreator(null);
        activeMatchDetail.setModifyTime(null);
        activeMatchDetail.setFlag("1");
        activeMatchDetailService.insert(activeMatchDetail);
        logger.info("processActiveMatchDetail end");
    }


    /**
     * 根据活动id，查询活动区域表
     */
    private  ActiveArea getActiveAreaByActive(ActiveMain activeMain){
        logger.info("getActiveAreaByActive start");
        ActiveArea activeArea = null;
        ActiveAreaCondition activeAreaCondition = new ActiveAreaCondition();
        activeAreaCondition.setActiveId(activeMain.getId());
        List<ActiveArea> activeAreaList = activeAreaService.selectList(activeAreaCondition);
        if(null != activeAreaList && activeAreaList.size()>0){
            activeArea = activeAreaList.get(0);
        }
        logger.info("getActiveAreaByActive end,activeArea = " + JSONObject.toJSONString(activeArea));
        return activeArea;
    }

    /**
     * 根据活动id，查询活动车辆信息表
     */
    private ActiveCar getActiveCarByActive(ActiveMain activeMain){
        logger.info("getActiveAreaByActive start");
        ActiveCar activeCar = null;
        ActiveCarCondition activeCarCondition = new ActiveCarCondition();
        activeCarCondition.setActiveId(activeMain.getId());
        List<ActiveCar> activeCarList = activeCarService.selectList(activeCarCondition);
        if(null != activeCarList && activeCarList.size()>0){
            activeCar = activeCarList.get(0);
        }
        logger.info("getActiveAreaByActive end,activeCar = " + JSONObject.toJSONString(activeCar));
        return activeCar;
    }


    /**
     * 通过经销商编码和公司查询经销商匹配信息
     */
    private ActiveDealerMatch getDealerMatchByCode(BasicBussiness basicBussiness){
        logger.info("getDealerMatchByCode start,activeDealer = " + basicBussiness.getId());
        ActiveDealerMatch activeDealerMatch= null;
        ActiveDealerMatchCondition activeDealerMatchCondition = new ActiveDealerMatchCondition();
        activeDealerMatchCondition.setDistributorCode(basicBussiness.getDistributorCode());
        activeDealerMatchCondition.setCompany(basicBussiness.getCompany());
        activeDealerMatchCondition.setFlag("1");
        List<ActiveDealerMatch> activeDealerMatchs = activeDealerMatchService.selectList(activeDealerMatchCondition);
        if(null != activeDealerMatchs && activeDealerMatchs.size()>0){
            activeDealerMatch = activeDealerMatchs.get(0);
        }
        logger.info("getDealerMatchByCode end ,activeDealerMatch = " + activeDealerMatch);
        return activeDealerMatch;
    }

    /**
     *  通过活动编码和公司查询活动匹配主表
     */
    private ActiveMatchMain getActiveMatchMainByActive(ActiveMain activeMain){
        logger.info("getActiveMatchMainByActive start");
        ActiveMatchMain activeMatchMain = null;
        ActiveMatchMainCondition activeMatchMainCondition = new ActiveMatchMainCondition();
        activeMatchMainCondition.setBusinessCode(activeMain.getActiveCode());
        activeMatchMainCondition.setCompany(activeMain.getCompany());
        activeMatchMainCondition.setFlag("1");
        List<ActiveMatchMain> matchMainList = activeMatchMainService.selectList(activeMatchMainCondition);
        if(null != matchMainList && matchMainList.size()>0){
            activeMatchMain = matchMainList.get(0);
        }
        logger.info("getActiveMatchMainByActive end,activeMatchMain = " + JSONObject.toJSONString(activeMatchMain));
        return activeMatchMain;
    }


    /**
     *  达成率计算
     */
    private String calReachRate(Long actualCount,Long expectedCount){
        logger.info("calReachRate start,actualCount = " + actualCount +", expectedCount = " + expectedCount);
        String reachRate = null;
        if(null != expectedCount && expectedCount>0 && null != actualCount){
            BigDecimal result = new BigDecimal(actualCount).divide(new BigDecimal(expectedCount),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            reachRate = decimalFormat.format(result)+"%";
        }
        if(StringUtils.isBlank(reachRate)){
            reachRate = "0%";
        }
        logger.info("calReachRate end,reachRate = " + reachRate);
        return reachRate;
    }

    /**
     *  经销商匹配表新增
     */
    private void addActiveDealerMatch(BasicBussiness basicBussiness){
        logger.info("addActiveDealerMatch start");
        ActiveDealerMatch activeDealerMatch = new ActiveDealerMatch();
        activeDealerMatch.setDistributorCode(basicBussiness.getDistributorCode());
        activeDealerMatch.setDistributorName(basicBussiness.getDistributorName());
        activeDealerMatch.setFlag("1");
        activeDealerMatch.setRealDistributorCount(1L);
        activeDealerMatch.setCompany(basicBussiness.getCompany());
        activeDealerMatchService.insert(activeDealerMatch);
        logger.info("addActiveDealerMatch end");
    }

    /**
     *  经销商是否导入 导入 通过活动id查询经销商信息
     */
    private ActiveDealer getActiveDealerByActiveId(ActiveMain activeMain){
        logger.info("getActiveDealerByActiveId start");
        ActiveDealer activeDealer = null;
        // 经销商未导入
        if("0".equals(activeMain.getInputDeale())){
            return null;
        }
        ActiveDealerCondition activeDealerCondition = new ActiveDealerCondition();
        activeDealerCondition.setActiveId(activeMain.getId());
        List<ActiveDealer> activeDealers = activeDealerService.selectList(activeDealerCondition);
        if(null != activeDealers && activeDealers.size()>0){
            activeDealer = activeDealers.get(0);
        }
        logger.info("getActiveDealerByActiveId end,activeDealer = " + JSONObject.toJSONString(activeDealer));
        return  activeDealer;
    }


    /**
     *  计算结算单上限金额
     */
    private BigDecimal calMaxBillFee(Long activeActualCount,ActiveDealer activeDealer,BigDecimal activeCriteron) throws Exception{
        logger.info("calMaxBillFee start,activeActualCount = " + activeActualCount + ",activeCriteron = " + activeCriteron +",activeDealer = " + JSONObject.toJSONString(activeDealer));
        Long actualCount = 0L;
        //经销商未导入 或者 活动上线数量不存在 以活动实际成交数量为准
        if(null == activeDealer || null == activeDealer.getActiveNumber()){
            actualCount = activeActualCount;
        }else if(activeActualCount >= activeDealer.getActiveNumber()){//活动实际成交数量超出上限 取上限
            actualCount = activeDealer.getActiveNumber();
        }else{
            actualCount = activeActualCount; //活动实际成交数量小于上限 取实际
        }
        BigDecimal actualCountDec = new BigDecimal(actualCount);
        BigDecimal maxBillFee = actualCountDec.multiply(activeCriteron).setScale(2,BigDecimal.ROUND_HALF_UP);
        logger.info("calMaxBillFee end,maxBillFee = " + maxBillFee.toString());
        return  maxBillFee;
    }

    /**
     * 活动和业务数据区间比较时
     */
    private Boolean sectionCompare(String activeValueStr,String bussinessValueStr){
        logger.info("sectionCompare start");
        String[] activeValueArray = activeValueStr.split("-");
        if(activeValueArray.length == 0){
            return true;
        }
        String start = activeValueArray[0];
        String end = activeValueArray[1];
        if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
            BigDecimal startBigDecimal = new BigDecimal(start);
            BigDecimal endBigDecimal = new BigDecimal(end);
            BigDecimal businessBigDecimal = new BigDecimal(bussinessValueStr);
            if (businessBigDecimal.compareTo(startBigDecimal) >= 0 && businessBigDecimal.compareTo(endBigDecimal) <= 0) {
                return true;
            }
        }else{
            return true;
        }
        logger.info("sectionCompare end");
        return false;

    }

    /**
     * @Description:将bean转成map
     * @Param: [bean]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

}
