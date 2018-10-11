package com.yqjr.fin.risk.stat.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class Indicators extends BaseEntity<Indicators> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/indicators/list
     *表单维护路径：/indicators/form
     *
     */

    /**
     * PK
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * ·100：财务指标 ·200：监管指标 ·300：风险预警指标
     */
    @Length(min = 0, max = 3)
    private java.lang.String typecode;

    /**
     * 指标代码
     */
    @Length(min = 0, max = 32)
    private java.lang.String indicatorcode;

    /**
     * 指标名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String indicatorname;

    /**
     * 指标对象，如经销商、借款人等。
     */
    @Length(min = 0, max = 64)
    private java.lang.String indicatortarget;

    /**
     * 指标说明
     */
    @Length(min = 0, max = 512)
    private java.lang.String indicatordesc;

    /**
     * 指标主题。用于细分指标。
     */
    @Length(min = 0, max = 32)
    private java.lang.String indicatorcaption;

    /**
     * 指标小类，用于同一主题下再细分指标。
     */
    @Length(min = 0, max = 32)
    private java.lang.String indicatorgroup;

    /**
     * 计算公式
     */
    @Length(min = 0, max = 512)
    private java.lang.String calformula;

    /**
     * 显示顺序
     */
    @Digits(fraction =22,integer=0)
    private Long displayorder;

    /**
     * 是否是预警指标。否则为监管指标。
     */
    @Length(min = 0, max = 1)
    private java.lang.String alertflag;

    /**
     * 预警频度
     */
    @Length(min = 0, max = 2)
    private java.lang.String alertcycle;

    /**
     * 上级指标ID
     */
    @Digits(fraction =22,integer=0)
    private Long parentindicatorid;

    /**
     * 备注
     */
    @Length(min = 0, max = 1024)
    private java.lang.String remark;

    /**
     * 启用标志。0：未启用；1：启用。
     */
    @Digits(fraction =22,integer=0)
    private Long enabledflag;

    /**
     * 上级指标代码
     */
    @Length(min = 0, max = 32)
    private java.lang.String parentindicatorcode;

    /**
     * 指标级别
     */
    @Digits(fraction =22,integer=0)
    private Long indlevel;

    /**
     * Q:季度汇总 H:半年汇总 Y:年度汇总,格式:QHY三个字母任意组合.
     */
    @Length(min = 0, max = 10)
    private java.lang.String cycCounttype;

    /**
     * 是否含有预算指 Y:含有 N/null:不含有
     */
    @Length(min = 0, max = 2)
    private java.lang.String hasbudget;

    /**
     * 数据来源
     */
    @Length(min = 0, max = 128)
    private java.lang.String sourcefrom;

    /**
     * 科目取值类别 1:期初 2:Dr-Cr发生额 2.1:Dr发生额 2.2 : Cr发生额 3:期末 4:Cr-Dr发生额 ,·资产负债，所有者权益类科目指标：3（期末余额）设置规则如下：·收入类：4（贷方-借方）·费用类：2（借方-贷方）。复杂指标 的valuetype 用不上
     */
    @Length(min = 0, max = 2)
    private java.lang.String valuetype;

    /**
     * 运算频率  Y:年   H:半年 Q:季度 M:月 D:日
     */
    @Length(min = 0, max = 12)
    private java.lang.String countcycle;

    /**
     * 值映射指标码:映射数据表中VALUE2、VALUE3和V_VALUE1的对应指标码. --代表为空 格式列举:--,P0011。目前支持3个指标映射，分别是预算、利润、平均规模。各指标之间用英文的逗号分隔。
     */
    @Length(min = 0, max = 100)
    private java.lang.String valuemapping;

    /**
     * 统计纬度码,由一个或者多个纬度运算模板码组成,由逗号分割.
     */
    @Length(min = 0, max = 100)
    private java.lang.String ctcode;

    /**
     * 指标细类
     */
    @Length(min = 0, max = 32)
    private java.lang.String indicatordetail;

    /**
     * 复杂指标运算顺序
     */
    @Length(min = 0, max = 8)
    private java.lang.String coutorder;

    /**
     * 预警处置流程类型
     */
    @Digits(fraction =22,integer=0)
    private Long alerttype;

    /**
     * 归属公司
     */
    @Length(min = 0, max = 64)
    private java.lang.String comcode;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 最后更新人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最后更新时间
     */
    private java.util.Date modifyTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getTypecode() {
        return this.typecode;
    }

    public void setTypecode(java.lang.String typecode) {
        this.typecode = typecode;
    }

    public java.lang.String getIndicatorcode() {
        return this.indicatorcode;
    }

    public void setIndicatorcode(java.lang.String indicatorcode) {
        this.indicatorcode = indicatorcode;
    }

    public java.lang.String getIndicatorname() {
        return this.indicatorname;
    }

    public void setIndicatorname(java.lang.String indicatorname) {
        this.indicatorname = indicatorname;
    }

    public java.lang.String getIndicatortarget() {
        return this.indicatortarget;
    }

    public void setIndicatortarget(java.lang.String indicatortarget) {
        this.indicatortarget = indicatortarget;
    }

    public java.lang.String getIndicatordesc() {
        return this.indicatordesc;
    }

    public void setIndicatordesc(java.lang.String indicatordesc) {
        this.indicatordesc = indicatordesc;
    }

    public java.lang.String getIndicatorcaption() {
        return this.indicatorcaption;
    }

    public void setIndicatorcaption(java.lang.String indicatorcaption) {
        this.indicatorcaption = indicatorcaption;
    }

    public java.lang.String getIndicatorgroup() {
        return this.indicatorgroup;
    }

    public void setIndicatorgroup(java.lang.String indicatorgroup) {
        this.indicatorgroup = indicatorgroup;
    }

    public java.lang.String getCalformula() {
        return this.calformula;
    }

    public void setCalformula(java.lang.String calformula) {
        this.calformula = calformula;
    }

    public Long getDisplayorder() {
        return this.displayorder;
    }

    public void setDisplayorder(Long displayorder) {
        this.displayorder = displayorder;
    }

    public java.lang.String getAlertflag() {
        return this.alertflag;
    }

    public void setAlertflag(java.lang.String alertflag) {
        this.alertflag = alertflag;
    }

    public java.lang.String getAlertcycle() {
        return this.alertcycle;
    }

    public void setAlertcycle(java.lang.String alertcycle) {
        this.alertcycle = alertcycle;
    }

    public Long getParentindicatorid() {
        return this.parentindicatorid;
    }

    public void setParentindicatorid(Long parentindicatorid) {
        this.parentindicatorid = parentindicatorid;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public Long getEnabledflag() {
        return this.enabledflag;
    }

    public void setEnabledflag(Long enabledflag) {
        this.enabledflag = enabledflag;
    }

    public java.lang.String getParentindicatorcode() {
        return this.parentindicatorcode;
    }

    public void setParentindicatorcode(java.lang.String parentindicatorcode) {
        this.parentindicatorcode = parentindicatorcode;
    }

    public Long getIndlevel() {
        return this.indlevel;
    }

    public void setIndlevel(Long indlevel) {
        this.indlevel = indlevel;
    }

    public java.lang.String getCycCounttype() {
        return this.cycCounttype;
    }

    public void setCycCounttype(java.lang.String cycCounttype) {
        this.cycCounttype = cycCounttype;
    }

    public java.lang.String getHasbudget() {
        return this.hasbudget;
    }

    public void setHasbudget(java.lang.String hasbudget) {
        this.hasbudget = hasbudget;
    }

    public java.lang.String getSourcefrom() {
        return this.sourcefrom;
    }

    public void setSourcefrom(java.lang.String sourcefrom) {
        this.sourcefrom = sourcefrom;
    }

    public java.lang.String getValuetype() {
        return this.valuetype;
    }

    public void setValuetype(java.lang.String valuetype) {
        this.valuetype = valuetype;
    }

    public java.lang.String getCountcycle() {
        return this.countcycle;
    }

    public void setCountcycle(java.lang.String countcycle) {
        this.countcycle = countcycle;
    }

    public java.lang.String getValuemapping() {
        return this.valuemapping;
    }

    public void setValuemapping(java.lang.String valuemapping) {
        this.valuemapping = valuemapping;
    }

    public java.lang.String getCtcode() {
        return this.ctcode;
    }

    public void setCtcode(java.lang.String ctcode) {
        this.ctcode = ctcode;
    }

    public java.lang.String getIndicatordetail() {
        return this.indicatordetail;
    }

    public void setIndicatordetail(java.lang.String indicatordetail) {
        this.indicatordetail = indicatordetail;
    }

    public java.lang.String getCoutorder() {
        return this.coutorder;
    }

    public void setCoutorder(java.lang.String coutorder) {
        this.coutorder = coutorder;
    }

    public Long getAlerttype() {
        return this.alerttype;
    }

    public void setAlerttype(Long alerttype) {
        this.alerttype = alerttype;
    }

    public java.lang.String getComcode() {
        return this.comcode;
    }

    public void setComcode(java.lang.String comcode) {
        this.comcode = comcode;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //endregion
    private IndicatorTypes indicatorTypes;
    public IndicatorTypes getIndicatorTypes() {
        return indicatorTypes;
    }

    public void setIndicatorTypes(IndicatorTypes indicatorTypes) {
        this.indicatorTypes = indicatorTypes;
    }




}
