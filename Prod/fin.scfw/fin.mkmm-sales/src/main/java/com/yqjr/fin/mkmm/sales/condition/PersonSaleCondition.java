
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.PersonSale;

public class PersonSaleCondition extends BaseCondition<PersonSale, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/personSale/list
     *表单维护路径：/personSale/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 人员编号
     */
    @Length(min = 0, max = 16)
    private java.lang.String personCode;

    /**
     * 人员姓名
     */
    @Length(min = 0, max = 32)
    private java.lang.String personName;

    /**
     * 品牌
     */
    @Length(min = 0, max = 16)
    private java.lang.String brands;

    /**
     * 年度
     */
    @Length(min = 0, max = 4)
    private java.lang.String year;

    /**
     * 月
     */
    @Length(min = 0, max = 4)
    private java.lang.String month;

    /**
     * 累计数量
     */
    @Digits(fraction =22,integer=0)
    private Long amount;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 修改人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    /**
     * 预计数量
     */
    @Digits(fraction =32,integer=0)
    private Long expectedNumber;

    /**
     * 导入识别码
     */
    @Digits(fraction =22,integer=0)
    private Long differentCode;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public java.lang.String getBrands() {
        return this.brands;
    }

    public void setBrands(java.lang.String brands) {
        this.brands = brands;
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

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public Long getExpectedNumber() {
        return this.expectedNumber;
    }

    public void setExpectedNumber(Long expectedNumber) {
        this.expectedNumber = expectedNumber;
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