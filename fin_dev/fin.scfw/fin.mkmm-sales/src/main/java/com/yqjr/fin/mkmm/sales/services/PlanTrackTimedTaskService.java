package com.yqjr.fin.mkmm.sales.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yqjr.fin.mkmm.sales.common.DateUtils;
import com.yqjr.fin.mkmm.sales.condition.*;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.mapper.ActiveMatchTaskMapper;
import com.yqjr.fin.mkmm.sales.mapper.PersonSaleMapper;
import com.yqjr.scfw.common.excel.utils.DateUtil;
import com.yqjr.scfw.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 计划跟踪定时任务相关
 * @author: lixue
 * @date: 2018/06/06 10:27:02
 **/
@Service
@Transactional(readOnly = true)
public class PlanTrackTimedTaskService {

    Logger logger = LoggerFactory.getLogger(getClass());
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Autowired
    ActiveMatchTaskService activeMatchTaskService;

    @Autowired
    PersonPlanService personPlanService;

    @Autowired
    BasicBussinessService basicBussinessService;

    @Autowired
    PersonSaleService personSaleService;

    @Autowired
    TeamSaleService teamSaleService;

    @Autowired
    PlanTrackService planTrackService;

    @Autowired
    PlanTrackYearService planTrackYearService;

    @Autowired
    PersonTeamService personTeamService;

    /**
     * 任务表添加数据 任务时间为当前时间前一天 如果当前时间的任务已存在且未执行 不插入
     * 每个公司一个任务 1 汽车金融 2 租赁公司 目前添加任务时无法获知公司 先写死
     */
    public void buildPlanTrackTask() throws Exception{
        logger.info("buildPlanTrackTask start");
        // 活动匹配任务表添加数据 type标识
        for(int i=1;i<=2;i++){
            Date taskDate = DateUtils.getCurrentBeforeDay(1);
            List<ActiveMatchTask> list = getActiveMatchTaskList(taskDate,""+i);
            logger.info("buildPlanTrackTask list size = " + list.size());
            if(null == list || list.size() == 0){
                ActiveMatchTask activeMatchTask = new ActiveMatchTask();
                activeMatchTask.setTaskDate(taskDate);
                activeMatchTask.setType(1L);
                activeMatchTask.setIsExecute("0");//未执行
                activeMatchTask.setFlag("1");
                activeMatchTask.setCompany(""+i);
                activeMatchTaskService.insert(activeMatchTask);
            }
        }
        logger.info("buildPlanTrackTask end");
    }

    /**
     * 查询任务是否已经存在（计划重新导入时 会重新插入任务）
     */
    private List<ActiveMatchTask> getActiveMatchTaskList(Date taskDate,String company){
        logger.info("getActiveMatchTaskList start");
        ActiveMatchTaskCondition activeMatchTaskCondition = new ActiveMatchTaskCondition();
        activeMatchTaskCondition.setTaskDate(taskDate);
        activeMatchTaskCondition.setType(1L);
        activeMatchTaskCondition.setIsExecute("0");
        activeMatchTaskCondition.setFlag("1");
        activeMatchTaskCondition.setCompany(company);
        return activeMatchTaskService.selectList(activeMatchTaskCondition);
    }

    /**
     * @Description: 获取未执行的任务列表
     */
    public List<ActiveMatchTask> getUnexecutedTask(){
        logger.info("getUnexecutedTask start");
        ActiveMatchTaskCondition activeMatchTaskCondition = new ActiveMatchTaskCondition();
        activeMatchTaskCondition.setIsExecute("0");
        activeMatchTaskCondition.setType(1L);
        List<ActiveMatchTask> unexecutedTaskList = activeMatchTaskService.selectList(activeMatchTaskCondition);
        logger.info("getUnexecutedTask end,list size  = " + unexecutedTaskList.size());
        return unexecutedTaskList;
    }

    /**
     * 计划追踪
     */
    @Transactional
    public void planTrack(ActiveMatchTask activeMatchTask) throws Exception{
        logger.info("planTrack start,activeMatchTask = " + JSONObject.toJSONString(activeMatchTask,SerializerFeature.WriteMapNullValue));
        String taskDate = DateUtils.getDateStr(activeMatchTask.getTaskDate());
        String year = taskDate.split("-")[0];
        String month = taskDate.split("-")[1];
        if(Integer.parseInt(month)<10){
            month = month.replace('0',' ').trim();
        }
        // 根据计划表的任务时间 按年、月查询人员销售计划表
        List<PersonPlan> personPlanList = getPersonPlanByYM(year,month,activeMatchTask.getCompany());
        //计划业务数据匹配 根据结果处理对应表
        planBusinessMatch(personPlanList,activeMatchTask);
        //更新任务执行状态
        updateTaskStatus(activeMatchTask);
        logger.info("planTrack end");
    }

    /**
     * 计划业务数据匹配 根据结果处理对应表
     */
    private void planBusinessMatch(List<PersonPlan> personPlanList,ActiveMatchTask activeMatchTask) throws Exception{
        logger.info("planBusinessMatch start,personPlanList size = " + personPlanList.size());
        //  根据人员销售计划查出的数据去业务表中查询是否有销售记录
        if(null != personPlanList && personPlanList.size()>0){
            for(PersonPlan personPlan:personPlanList){
                // personPlan中的所有查询条件都不为空时 根据人员计划表的年、月、品牌、人员编码查询业务表
                if(null != personPlan && StringUtils.isNotBlank(personPlan.getPersonCode()) && StringUtils.isNotBlank(personPlan.getYear()) && StringUtils.isNotBlank(personPlan.getMonth())
                        && StringUtils.isNotBlank(personPlan.getBrands()) && StringUtils.isNotBlank(personPlan.getCompany())){
                    List<BasicBussiness> basicBussinessList = getBasicBusinessByPlan(personPlan);
                    boolean numberIsAdd = false;
                    if(null != basicBussinessList && basicBussinessList.size()>0){//存在销售记录 各表中对应的实际数量累加
                        numberIsAdd = true;
                    }
                    updateTruckInfo(numberIsAdd,personPlan);
                }else {
                    continue;
                }
            }
        }
        logger.info("planBusinessMatch end");
    }

    /**
     * @Description:根据年和月份查询人员销售计划
     * @Param:year
     * @Param:month
     */
    private List<PersonPlan> getPersonPlanByYM(String year, String month,String company){
        logger.info("getPersonPlanByMonth start,year = " + year +",month = " + month);
        PersonPlanCondition personPlanCondition = new PersonPlanCondition();
        personPlanCondition.setYear(year);
        personPlanCondition.setMonth(month);
        personPlanCondition.setCompany(company);
        List<PersonPlan> personPlanList = personPlanService.selectList(personPlanCondition);
        logger.info("getPersonPlanByMonth end,personPlanList size = " + personPlanList.size());
        return personPlanList;
    }


    /**
     * 根据人员计划表的公司、年、月、品牌、人员编码查询业务表
     *
     */
    private List<BasicBussiness> getBasicBusinessByPlan(PersonPlan personPlan){
        logger.info("getBasicBusinessByPlan start,personPlan = " + JSONObject.toJSONString(personPlan,SerializerFeature.WriteMapNullValue));
        String dfactstartDate = personPlan.getYear()+"-"+personPlan.getMonth();
        if(personPlan.getMonth().length() == 1){
            dfactstartDate = personPlan.getYear()+"-"+ "0"+personPlan.getMonth();
        }
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("dfactstartDate",dfactstartDate);
        paramMap.put("personCode",personPlan.getPersonCode());
        paramMap.put("brandsCode",personPlan.getBrands());
        paramMap.put("company",personPlan.getCompany());
        List<BasicBussiness> basicBussinessList = basicBussinessService.selectByPlanInfo(paramMap);
        logger.info("getBasicBusinessByPlan end,basicBussinessList size  = " + basicBussinessList.size());
        return basicBussinessList;
    }

    /**
     * 更新追踪信息：实际销售累计表 团队销售累计表 计划与实际跟踪表 计划跟踪年度表
     */
    public void  updateTruckInfo(Boolean numberIsAdd,PersonPlan personPlan) throws Exception{
        logger.info("updateTruckInfo start,numberIsAdd = " + numberIsAdd + ",personPlan = " + JSONObject.toJSONString(personPlan));
        updatePersonSale(numberIsAdd,personPlan);
        PersonTeam personTeam = getPersonTeam(personPlan);
        if(numberIsAdd){
            updateTeamSale(numberIsAdd,personPlan,personTeam);
        }
        updatePlanTrack(numberIsAdd,personPlan,personTeam);
        updatePlanTrackYear(numberIsAdd,personPlan,personTeam);
        logger.info("updateTruckInfo end");
    }

    /**
     * 更新人员实际累计销售表 存在 有销售记录 更新累计数量 不存在插入
     */
    private void updatePersonSale(boolean numberIsAdd,PersonPlan personPlan){
        logger.info("updatePersonSale start");
        PersonSale personSale = getPersonSale(personPlan);
        //存在 并且有销售记录 更新累计数量
        if(null != personSale && numberIsAdd){
            personSale.setAmount(personSale.getAmount()+1);
            personSaleService.updateById(personSale);
        }else if(null == personSale){// 不存在 新增
            addPersonSale(numberIsAdd,personPlan);
        }
        logger.info("updatePersonSale end");
    }

    /**
     * 更新团队实际累计销售表 记录存在并且有销售记录 更新累计数量 不存在插入
     */
    private void updateTeamSale(boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam){
        logger.info("updateTeamSale start,numberIsAdd = " + numberIsAdd );
        //当人员存在销售记录时判断所在团队的记录是否存在 存在更新 累计数量 不存在 新增
        if(numberIsAdd && null != personTeam && StringUtils.isNotBlank(personTeam.getTeamCode())){
            TeamSale teamSale = getTeamSale(personPlan,personTeam.getTeamCode());
            if(null != teamSale && numberIsAdd){
                if(null != teamSale.getAmount()){
                    teamSale.setAmount(teamSale.getAmount()+1);
                }else {
                    teamSale.setAmount(1L);
                }
                teamSaleService.updateById(teamSale);
            }else if(null == teamSale){// 不存在 新增
                addTeamSale(numberIsAdd,personPlan,personTeam);
            }
        }
        logger.info("updatePersonSale end");
    }

    /**
     * 更新计划跟踪表 记录存在 更新数据 不存在插入
     */
    private void updatePlanTrack(boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam) throws Exception{
        logger.info("updatePlanTrack start");
        PlanTrack planTrack = getPlanTrack(personPlan);
        //存在 并且有销售记录 更新月实际台数达成量、月台数预算达成率、月序时进度、月达成率与序时进度差值；
        // 没有销售记录 更新月序时进度、月达成率与序时进度差值
        if(null != planTrack){
            updatePlanTrackData(numberIsAdd,planTrack);
        }else if(null == planTrack){// 不存在 新增
            addPlanTrack(numberIsAdd,personPlan,personTeam);
        }
        logger.info("updatePersonSale end");
    }

    /**
     * 更新计划跟踪表年度表 存在 有销售记录 更新累计数量 不存在插入
     */
    private void updatePlanTrackYear(Boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam) throws  Exception{
        logger.info("updatePlanTrack start");
        PlanTrackYear planTrackYear = getPlanTrackYear(personPlan);
        //存在 并且有销售记录 更新年实际台数达成量、年台数预算达成率、年序时进度、年达成率与序时进度差值；
        // 没有销售记录 更新年序时进度、年达成率与序时进度差值
        if(null != planTrackYear){
            updatePlanTrackYearData(numberIsAdd,planTrackYear);
        }else if(null == planTrackYear){// 不存在 新增
            addPlanTrackYear(numberIsAdd,personPlan,personTeam);
        }
        logger.info("updatePersonSale end");
    }



    /**
     *  根据年、月、人员编号、品牌查询人员实际累计销售表
     */
    private PersonSale getPersonSale(PersonPlan personPlan){
        logger.info(" getPersonSale start");
        PersonSale personSale= null;
        PersonSaleCondition personSaleCondition = new PersonSaleCondition();
        personSaleCondition.setCompany(personPlan.getCompany());
        personSaleCondition.setPersonCode(personPlan.getPersonCode());
        personSaleCondition.setBrands(personPlan.getBrands());
        personSaleCondition.setYear(personPlan.getYear());
        personSaleCondition.setMonth(personPlan.getMonth());
        List<PersonSale> personSaleList = personSaleService.selectList(personSaleCondition);
        if(null != personSaleList && personSaleList.size()>0){
            personSale = personSaleList.get(0);
        }
        logger.info("getBasicBusinessByPlan end ,personSale = " + JSONObject.toJSONString(personSale),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        return  personSale;
    }

    /**
     * 添加人员实际累计销售表记录
     */
    private void addPersonSale(boolean numberIsAdd,PersonPlan personPlan){
        logger.info("addPersonSale start");
        PersonSale personSale = new PersonSale();
        personSale.setPersonCode(personPlan.getPersonCode());
        personSale.setPersonName(personPlan.getPersonName());
        personSale.setBrands(personPlan.getBrands());
        personSale.setYear(personPlan.getYear());
        personSale.setMonth(personPlan.getMonth());
        personSale.setCompany(personPlan.getCompany());
        personSale.setExpectedNumber(personPlan.getAmount());
        personPlan.setCompany(personPlan.getCompany());
        if(numberIsAdd){
            personSale.setAmount(1L);
        }else {
            personSale.setAmount(0L);
        }
        personSale.setDifferentCode(personPlan.getDifferentCode());
        personSaleService.insert(personSale);
        logger.info("addPersonSale end");
    }

    /**
     *  根据年、月、团队编号、品牌查询团队实际累计销售表
     */
    private TeamSale getTeamSale(PersonPlan personPlan,String teamCode){
        logger.info("getTeamSale start,personPlanId = " + personPlan.getId());
        TeamSale teamSale = null;
        TeamSaleCondition teamSaleCondition = new TeamSaleCondition();
        teamSaleCondition.setCompany(personPlan.getCompany());
        teamSaleCondition.setYear(personPlan.getYear());
        teamSaleCondition.setMonth(personPlan.getMonth());
        teamSaleCondition.setTeamCode(teamCode);
        teamSaleCondition.setBrands(personPlan.getBrands());
        List<TeamSale> teamSaleList = teamSaleService.selectList(teamSaleCondition);
        if(null != teamSaleList && teamSaleList.size()>0){
            teamSale = teamSaleList.get(0);
        }
        logger.info("getTeamSale start ,teamSale = " + JSONObject.toJSONString(teamSale),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        return  teamSale;
    }

    /**
     * 添加团队实际累计销售表记录
     */
    private void addTeamSale(boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam){
        logger.info("addTeamSale start,numberIsAdd = " + numberIsAdd );
        TeamSale teamSale = new TeamSale();
        teamSale.setTeamCode(personTeam.getTeamCode());
        teamSale.setTeamName(personTeam.getTeamName());
        teamSale.setBrands(personPlan.getBrands());
        teamSale.setYear(personPlan.getYear());
        teamSale.setMonth(personPlan.getMonth());
        teamSale.setAmount(1L);
        teamSale.setCompany(personPlan.getCompany());
        teamSale.setDifferentCode(personPlan.getDifferentCode());
        teamSaleService.insert(teamSale);
        logger.info("addTeamSale end");
    }



    /**
     *  根据年、月、团队编号、品牌查询计划与实际跟踪表
     */
    private PlanTrack getPlanTrack(PersonPlan personPlan){
        logger.info("getPlanTrack start");
        PlanTrack planTrack = null;
        PlanTrackCondition planTrackCondition = new PlanTrackCondition();
        planTrackCondition.setCompany(personPlan.getCompany());
        planTrackCondition.setYear(personPlan.getYear());
        planTrackCondition.setMonth(personPlan.getMonth());
        planTrackCondition.setPersonCode(personPlan.getPersonCode());
        planTrackCondition.setBrands(personPlan.getBrands());
        List<PlanTrack> planTrackList = planTrackService.selectList(planTrackCondition);
        if(null != planTrackList && planTrackList.size()>0){
            planTrack = planTrackList.get(0);
        }
        logger.info("getPlanTrack start ,planTrack = " + JSONObject.toJSONString(planTrack),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        return  planTrack;
    }

    /**
     *  计划与实际跟踪表添加
     */
    private void addPlanTrack(Boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam) throws Exception{
        logger.info("addPlanTrack start");
        PlanTrack planTrack = new PlanTrack();
        planTrack.setYear(personPlan.getYear());
        planTrack.setMonth(personPlan.getMonth());
        if(null != personTeam){
            planTrack.setAreaCode(personTeam.getAreaCode());
            planTrack.setAreaName(personTeam.getAreaName());
            planTrack.setTeamCode(personTeam.getTeamCode());
            planTrack.setTeamName(personTeam.getTeamName());
            planTrack.setPersonType(personTeam.getPersonNature());
        }
        planTrack.setPersonCode(personPlan.getPersonCode());
        planTrack.setPersonName(personPlan.getPersonName());
        planTrack.setBrands(personPlan.getBrands());
        planTrack.setMonthPlanNum(personPlan.getAmount());
        Long monthActualNum = 0L;
        if(numberIsAdd){
            monthActualNum = monthActualNum+1;
        }
        BigDecimal monthPlanRateDec = rateCalDec(personPlan.getAmount(),monthActualNum);
        String monthPlanRate = decimalFormat.format(monthPlanRateDec)+"%";//达成率;
        BigDecimal monthRateDec = getMonthRate();//序时进度数值
        String monthRate = decimalFormat.format(monthRateDec)+"%";//序时进度
        String monthRateCal = decimalFormat.format(monthPlanRateDec.subtract(monthRateDec))+"%";//达成率与序时进度差
        planTrack.setMonthRate(monthRate);
        planTrack.setMonthActualNum(monthActualNum);
        planTrack.setMonthPlanRate(org.apache.commons.lang3.StringUtils.isBlank(monthPlanRate)?"0%":monthPlanRate);
        planTrack.setMonthRateCal(monthRateCal);
        planTrack.setFlag("1");
        planTrack.setCompany(personPlan.getCompany());
        planTrack.setDifferentCode(personPlan.getDifferentCode());
        planTrackService.insert(planTrack);
        logger.info("addPlanTrack end");
    }

    /**
     *  计划与实际跟踪年度表添加
     */
    private void addPlanTrackYear(Boolean numberIsAdd,PersonPlan personPlan,PersonTeam personTeam) throws Exception{
        logger.info("addPlanTrackYear start");
        PlanTrackYear planTrackYear = new PlanTrackYear();
        planTrackYear.setYear(personPlan.getYear());
        //planTrackYear.setMonth(personPlan.getMonth());
        if(null != personTeam){
            planTrackYear.setAreaCode(personTeam.getAreaCode());
            planTrackYear.setAreaName(personTeam.getAreaName());
            planTrackYear.setTeamCode(personTeam.getTeamCode());
            planTrackYear.setTeamName(personTeam.getTeamName());
            planTrackYear.setPersonType(personTeam.getPersonNature());
        }
        planTrackYear.setPersonCode(personPlan.getPersonCode());
        planTrackYear.setPersonName(personPlan.getPersonName());
        planTrackYear.setBrands(personPlan.getBrands());
        Long yearPlanNumber = null == getYearPlanNumber(personPlan)?0L: getYearPlanNumber(personPlan);
        planTrackYear.setYearPlanNum(yearPlanNumber);
        Long yearActualNum = 0L;
        if(numberIsAdd){
            yearActualNum = yearActualNum+1;
        }
        BigDecimal yearPlanRateDec = rateCalDec(yearPlanNumber,yearActualNum);
        String yearPlanRate = decimalFormat.format(yearPlanRateDec)+"%";//达成率
        BigDecimal yearRateDec = getYearRate(Integer.parseInt(personPlan.getYear()));//序时进度数值
        String yearRate = decimalFormat.format(yearRateDec)+"%";//序时进度
        String yearRateCal = decimalFormat.format(yearPlanRateDec.subtract(yearRateDec))+"%";//达成率与序时进度差
        planTrackYear.setYearRate(yearRate);
        planTrackYear.setYearActualNum(yearActualNum);
        planTrackYear.setYearPlanRate(yearPlanRate);
        planTrackYear.setYearRateCal(yearRateCal);
        planTrackYear.setFlag("1");
        planTrackYear.setCompany(personPlan.getCompany());
        planTrackYearService.insert(planTrackYear);
        logger.info("addPlanTrackYear end");
    }


    /**
     *  根据年、月、人员编码、品牌查询计划与实际跟踪年度表
     */
    private PlanTrackYear getPlanTrackYear(PersonPlan personPlan){
        logger.info("getPlanTrackYear start");
        PlanTrackYear planTrackYear = null;
        PlanTrackYearCondition planTrackYearCondition = new PlanTrackYearCondition();
        planTrackYearCondition.setYear(personPlan.getYear());
        planTrackYearCondition.setCompany(personPlan.getCompany());
        planTrackYearCondition.setPersonCode(personPlan.getPersonCode());
        planTrackYearCondition.setBrands(personPlan.getBrands());
        List<PlanTrackYear> planTrackYearList = planTrackYearService.selectList(planTrackYearCondition);
        if(null != planTrackYearList && planTrackYearList.size()>0){
            planTrackYear = planTrackYearList.get(0);
        }
        logger.info("getPlanTrackYear end,planTrackYear = " + JSONObject.toJSONString(planTrackYear),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        return  planTrackYear;
    }

    /**
     *   更新计划与跟踪表(月实际台数达成量、月台数预算达成率、月序时进度、月达成率与序时进度差值)
     */
    private void updatePlanTrackData(Boolean numberIsAdd,PlanTrack planTrack) throws Exception{
        logger.info("updatePlanTrackData start");
        // 达成率 有销售记录 重新计算 没有销售记录 取表里的
        BigDecimal monthPlanRateDec = new BigDecimal(planTrack.getMonthPlanRate().replace('%',' ').trim());
        if(numberIsAdd){
            monthPlanRateDec = rateCalDec(planTrack.getMonthPlanNum(),planTrack.getMonthActualNum()+1);
            //monthPlanRateDec = new BigDecimal(planTrack.getMonthActualNum()+1).divide(new BigDecimal(planTrack.getMonthPlanNum()),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String monthPlanRate = decimalFormat.format(monthPlanRateDec)+"%";//达成率
            planTrack.setMonthActualNum(planTrack.getMonthActualNum()+1);
            planTrack.setMonthPlanRate(monthPlanRate);
        }
        BigDecimal monthRateDec = getMonthRate();//序时进度数值
        String monthRate = decimalFormat.format(monthRateDec)+"%";//序时进度
        String monthRateCal = decimalFormat.format(monthPlanRateDec.subtract(monthRateDec))+"%";//达成率与序时进度差
        planTrack.setMonthRate(monthRate);
        planTrack.setMonthRateCal(monthRateCal);
        planTrackService.updateById(planTrack);
        logger.info("updatePlanTrackData end");
    }


    /**
     *   更新计划与跟踪年度表(年实际台数达成量、年台数预算达成率、年序时进度、年达成率与序时进度差值)
     */
    private void updatePlanTrackYearData(Boolean numberIsAdd,PlanTrackYear planTrackYear) throws Exception{
        logger.info("updatePlanTrackYearData start");
        // 达成率 有销售记录 重新计算 没有销售记录 取表里的
        BigDecimal yearPlanRateDec = new BigDecimal(planTrackYear.getYearPlanRate().replace('%',' ').trim());
        if(numberIsAdd){
            yearPlanRateDec = rateCalDec(planTrackYear.getYearPlanNum(),planTrackYear.getYearActualNum()+1);
            //yearPlanRateDec = new BigDecimal(planTrackYear.getYearActualNum()+1).divide(new BigDecimal(planTrackYear.getYearPlanNum()),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String yearPlanRate = decimalFormat.format(yearPlanRateDec)+"%";//达成率
            planTrackYear.setYearActualNum(planTrackYear.getYearActualNum()+1);
            planTrackYear.setYearPlanRate(yearPlanRate);
        }
        BigDecimal yearRateDec = getYearRate(Integer.parseInt(planTrackYear.getYear()));//序时进度数值
        String yearRate = decimalFormat.format(yearRateDec)+"%";//序时进度
        String yearRateCal = decimalFormat.format(yearPlanRateDec.subtract(yearRateDec))+"%";//达成率与序时进度差
        planTrackYear.setYearRate(yearRate);
        planTrackYear.setYearRateCal(yearRateCal);
        planTrackYearService.updateById(planTrackYear);
        logger.info("updatePlanTrackYearData end");
    }

    /**
     * 计算月序时进度
     */
    private BigDecimal getMonthRate(){
        logger.info("getMonthRate start");
        Calendar cal = Calendar.getInstance();
        //当前是这个月的第几天
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        //当前月的天数
        int monthDayNumbers = cal.get(Calendar.DATE);
        logger.info("getMonthRate dom = " + dom+",monthDayNumbers = " + monthDayNumbers);
        BigDecimal result = new BigDecimal(dom).divide(new BigDecimal(monthDayNumbers),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        logger.info("getMonthRate end ,monthPlanRate = " + result);
        return  result;
    }


    /**
     * 计算年序时进度
     */
    private BigDecimal getYearRate(int year){
        logger.info("getYearRate start");
        int dayOfYear = DateUtils.getDayOfYear();
        int yearNumbers = DateUtils.getYearDays(year);
        logger.info("getYearRate dayOfYear = " + dayOfYear+",yearNumbers = " + yearNumbers);
        BigDecimal result = new BigDecimal(dayOfYear).divide(new BigDecimal(yearNumbers),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        logger.info("getMonthRate end ,monthPlanRate = " + result);
        return  result;
    }

    /**
     * 通过人员编码查询人员团队关系表
     */
    private PersonTeam getPersonTeam(PersonPlan personPlan){
        logger.info("getPersonTeam start");
        PersonTeam personTeam = null;
        PersonTeamCondition personTeamCondition = new PersonTeamCondition();
        personTeamCondition.setCompany(personPlan.getCompany());
        personTeamCondition.setPersonCode(personPlan.getPersonCode());
        List<PersonTeam>  personTeamList = personTeamService.selectList(personTeamCondition);
        if(null != personTeamList && personTeamList.size()>0){
            personTeam = personTeamList.get(0);
        }
        logger.info("getPersonTeam end,personTeam = " + JSONObject.toJSONString(personTeam),SerializerFeature.WRITE_MAP_NULL_FEATURES);
        return personTeam;
    }

    /**
     * 查询人员的年度计划数量
     */
    private Long getYearPlanNumber(PersonPlan personPlan) throws Exception{
        logger.info("getYearPlanNumber start,personCode = " + personPlan.getPersonCode());
        PersonPlan queryPersonPlan = new PersonPlan();
        queryPersonPlan.setYear(personPlan.getYear());
        queryPersonPlan.setBrands(personPlan.getBrands());
        queryPersonPlan.setPersonCode(personPlan.getPersonCode());
        Long yearPlanNumber = personPlanService.selectPlanByMonth(personPlan);
        logger.info("getYearPlanNumber end,yearPlanNumber = " + yearPlanNumber);
        return yearPlanNumber;
    }

    /**
     * 更新任务执行状态为已执行
     */
    private void updateTaskStatus(ActiveMatchTask activeMatchTask) throws  Exception{
        logger.info("updateActiveTask start,id = " + activeMatchTask.getId());
        activeMatchTask.setIsExecute("1");
        activeMatchTaskService.updateById(activeMatchTask);
        logger.info("updateActiveTask end");
    }


    /**
     * 月度、年度达成率数值计算
     */
    private BigDecimal rateCalDec(Long planNum,Long actualNum) throws Exception{
        logger.info("rateCalDec start,planNum = " + planNum +",actualNum = " + actualNum);
        BigDecimal monthPlanRateDec = new BigDecimal(0);
        if(null != planNum && planNum>0 && null != actualNum){
            monthPlanRateDec = new BigDecimal(actualNum).divide(new BigDecimal(planNum),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        }
        logger.info("rateCalDec end,monthPlanRateDec = " + monthPlanRateDec);
        return monthPlanRateDec;
    }

    public static void main(String[] args) {
        PlanTrackTimedTaskService planTrackTimedTaskService = new PlanTrackTimedTaskService();
        planTrackTimedTaskService.getYearRate(2018);
    }
}
