
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.PlanTrack;

public class PlanTrackCondition extends BaseCondition<PlanTrack, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/planTrack/list
     *表单维护路径：/planTrack/form
     *
     */

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 年份
     */
    @Length(min = 0, max = 4)
    private java.lang.String year;

    /**
     * 月份
     */
    @Length(min = 0, max = 2)
    private java.lang.String month;

    /**
     * 区域代码
     */
    @Length(min = 0, max = 16)
    private java.lang.String areaCode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String areaName;

    /**
     * 团队代码
     */
    @Length(min = 0, max = 16)
    private java.lang.String teamCode;

    /**
     * 团队名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String teamName;

    /**
     * 下辖区域代码
     */
    @Length(min = 0, max = 16)
    private java.lang.String cityCode;

    /**
     * 下辖区域名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String cityName;

    /**
     * 人员代码
     */
    @Length(min = 0, max = 16)
    private java.lang.String personCode;

    /**
     * 人员名称
     */
    @Length(min = 0, max = 16)
    private java.lang.String personName;

    /**
     * 人员类别
     */
    @Length(min = 0, max = 16)
    private java.lang.String personType;

    /**
     * 品牌
     */
    @Length(min = 0, max = 16)
    private java.lang.String brands;

    /**
     * 品牌类别
     */
    @Length(min = 0, max = 16)
    private java.lang.String brandType;

    /**
     * 月实际台数达成量
     */
    @Digits(fraction =22,integer=0)
    private Long monthActualNum;

    /**
     * 月台数预算
     */
    @Digits(fraction =22,integer=0)
    private Long monthPlanNum;

    /**
     * 月台数预算达成率
     */
    @Length(min = 0, max = 16)
    private java.lang.String monthPlanRate;

    /**
     * 月序时进度
     */
    @Length(min = 0, max = 16)
    private java.lang.String monthRate;

    /**
     * 月达成率与序时进度差值
     */
    @Length(min = 0, max = 16)
    private java.lang.String monthRateCal;

    /**
     * 年台数实际达成量
     */
    @Digits(fraction =22,integer=0)
    private Long yearActualNum;

    /**
     * 年台数预算数
     */
    @Digits(fraction =22,integer=0)
    private Long yearPlanNum;

    /**
     * 年台数预算数达成率
     */
    @Length(min = 0, max = 16)
    private java.lang.String yearPlanRate;

    /**
     * 年序时进度
     */
    @Length(min = 0, max = 16)
    private java.lang.String yearRate;

    /**
     * 年达成率与序时进度差值
     */
    @Length(min = 0, max = 16)
    private java.lang.String yearRateCal;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 备用1
     */
    @Length(min = 0, max = 16)
    private java.lang.String transcode1;

    /**
     * 备用2
     */
    @Length(min = 0, max = 16)
    private java.lang.String transcode2;

    /**
     * 备用3
     */
    @Length(min = 0, max = 16)
    private java.lang.String transcode3;

    /**
     * 备用4
     */
    @Length(min = 0, max = 16)
    private java.lang.String transcode4;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

    /**
     * 修改人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最新标识
     */
    @Length(min = 0, max = 2)
    private java.lang.String flag;

    /**
     * 导入识别码
     */
    @Digits(fraction =22,integer=0)
    private Long differentCode;

    /**
     * 公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getYear() {
        return this.year;
    }

    public void setYear(java.lang.String year) {
        this.year = year;
    }

    public java.lang.String getMonth() {
        return this.month;
    }

    public void setMonth(java.lang.String month) {
        this.month = month;
    }

    public java.lang.String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(java.lang.String areaCode) {
        this.areaCode = areaCode;
    }

    public java.lang.String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(java.lang.String areaName) {
        this.areaName = areaName;
    }

    public java.lang.String getTeamCode() {
        return this.teamCode;
    }

    public void setTeamCode(java.lang.String teamCode) {
        this.teamCode = teamCode;
    }

    public java.lang.String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(java.lang.String teamName) {
        this.teamName = teamName;
    }

    public java.lang.String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }

    public java.lang.String getCityName() {
        return this.cityName;
    }

    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }

    public java.lang.String getPersonCode() {
        return this.personCode;
    }

    public void setPersonCode(java.lang.String personCode) {
        this.personCode = personCode;
    }

    public java.lang.String getPersonName() {
        return this.personName;
    }

    public void setPersonName(java.lang.String personName) {
        this.personName = personName;
    }

    public java.lang.String getPersonType() {
        return this.personType;
    }

    public void setPersonType(java.lang.String personType) {
        this.personType = personType;
    }

    public java.lang.String getBrands() {
        return this.brands;
    }

    public void setBrands(java.lang.String brands) {
        this.brands = brands;
    }

    public java.lang.String getBrandType() {
        return this.brandType;
    }

    public void setBrandType(java.lang.String brandType) {
        this.brandType = brandType;
    }

    public Long getMonthActualNum() {
        return this.monthActualNum;
    }

    public void setMonthActualNum(Long monthActualNum) {
        this.monthActualNum = monthActualNum;
    }

    public Long getMonthPlanNum() {
        return this.monthPlanNum;
    }

    public void setMonthPlanNum(Long monthPlanNum) {
        this.monthPlanNum = monthPlanNum;
    }

    public java.lang.String getMonthPlanRate() {
        return this.monthPlanRate;
    }

    public void setMonthPlanRate(java.lang.String monthPlanRate) {
        this.monthPlanRate = monthPlanRate;
    }

    public java.lang.String getMonthRate() {
        return this.monthRate;
    }

    public void setMonthRate(java.lang.String monthRate) {
        this.monthRate = monthRate;
    }

    public java.lang.String getMonthRateCal() {
        return this.monthRateCal;
    }

    public void setMonthRateCal(java.lang.String monthRateCal) {
        this.monthRateCal = monthRateCal;
    }

    public Long getYearActualNum() {
        return this.yearActualNum;
    }

    public void setYearActualNum(Long yearActualNum) {
        this.yearActualNum = yearActualNum;
    }

    public Long getYearPlanNum() {
        return this.yearPlanNum;
    }

    public void setYearPlanNum(Long yearPlanNum) {
        this.yearPlanNum = yearPlanNum;
    }

    public java.lang.String getYearPlanRate() {
        return this.yearPlanRate;
    }

    public void setYearPlanRate(java.lang.String yearPlanRate) {
        this.yearPlanRate = yearPlanRate;
    }

    public java.lang.String getYearRate() {
        return this.yearRate;
    }

    public void setYearRate(java.lang.String yearRate) {
        this.yearRate = yearRate;
    }

    public java.lang.String getYearRateCal() {
        return this.yearRateCal;
    }

    public void setYearRateCal(java.lang.String yearRateCal) {
        this.yearRateCal = yearRateCal;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public java.lang.String getTranscode1() {
        return this.transcode1;
    }

    public void setTranscode1(java.lang.String transcode1) {
        this.transcode1 = transcode1;
    }

    public java.lang.String getTranscode2() {
        return this.transcode2;
    }

    public void setTranscode2(java.lang.String transcode2) {
        this.transcode2 = transcode2;
    }

    public java.lang.String getTranscode3() {
        return this.transcode3;
    }

    public void setTranscode3(java.lang.String transcode3) {
        this.transcode3 = transcode3;
    }

    public java.lang.String getTranscode4() {
        return this.transcode4;
    }

    public void setTranscode4(java.lang.String transcode4) {
        this.transcode4 = transcode4;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public Long getDifferentCode() {
        return this.differentCode;
    }

    public void setDifferentCode(Long differentCode) {
        this.differentCode = differentCode;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}