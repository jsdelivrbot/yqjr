package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.entity.PersonPlan;
import com.yqjr.fin.mkmm.sales.entity.PersonTeam;
import com.yqjr.fin.mkmm.sales.entity.PlanTrack;
import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;

public interface PersonPlanMapper extends Mapper<PersonPlan, Long> {

	//region generated by CodeRobot
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~此线上方代码自动生成，在此下方编写自定义代码。
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion

    //判断是否已存在记录
    List<PersonPlan> selectPersonPlanByYear(String year,String company);
    //将当前月到12月的数据查出
    List<PersonPlan> queryPersonPlanByYear(String year ,String company,int nowMonth);
    //删除将当前月到12月的数据
    void deletePersonPlanByYear(String year ,String company,int nowMonth);
    //查人的集合
    List<PersonPlan> selectPlans(PersonPlan personPlan);

    //查一共有多少人人
    List<PersonPlan> selectPersonPlan(String year,String brands,String company);

    //查每个人的12个月计划
    List<PersonPlan> selectPersonMonthPlan(String year,String brands,String personNo,String company,String month);

    //查人的月计划合计
    Long selectPlanByMonth(PersonPlan personPlan);
    //查询每个人的计划
    Long queryOldPersonPlan(PersonPlan personPlan);

    //查询月跟踪表中当月数据
    List<PlanTrack> selectMonthPlanTrack(String year ,int nowMonth,String company);

    //删除当月数据
    void deletePlanTrack(String year ,int nowMonth,String company);

    //先获取有多少人
    List<String> selectPersonByYear(String year,String company);

    //每个人/每个品牌的年实际达成合计数
    Long sumPersonSales(String year,String personCode,String brands,String company);

    //每个人/每个品牌的年计划合计数
    Long sumPersonPlan(String year,String personCode,String brands,String company);
    //查这个人的性质和区域
    List<PersonTeam> selectPersonTeam(String personCode,String company);

}
