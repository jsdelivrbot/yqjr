package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 计划跟踪对象
 * Created by fanna on 2018/6/9.
 */
public class PlanTrackVo extends PlanTrack{

    private Long yearActualNum;
    private Long yearPlanNum;
    private String yearPlanRate;
    private String yearRate;
    private String yearRateCal;

    @Override
    public Long getYearActualNum() {
        return yearActualNum;
    }

    @Override
    public void setYearActualNum(Long yearActualNum) {
        this.yearActualNum = yearActualNum;
    }

    @Override
    public Long getYearPlanNum() {
        return yearPlanNum;
    }

    @Override
    public void setYearPlanNum(Long yearPlanNum) {
        this.yearPlanNum = yearPlanNum;
    }

    @Override
    public String getYearPlanRate() {
        return yearPlanRate;
    }

    @Override
    public void setYearPlanRate(String yearPlanRate) {
        this.yearPlanRate = yearPlanRate;
    }

    @Override
    public String getYearRate() {
        return yearRate;
    }

    @Override
    public void setYearRate(String yearRate) {
        this.yearRate = yearRate;
    }

    @Override
    public String getYearRateCal() {
        return yearRateCal;
    }

    @Override
    public void setYearRateCal(String yearRateCal) {
        this.yearRateCal = yearRateCal;
    }
}
