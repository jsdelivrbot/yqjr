
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.ActiveProd;

public class ActiveProdCondition extends BaseCondition<ActiveProd, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/activeProd/list
     *表单维护路径：/activeProd/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 活动ID
     */
    @Digits(fraction =22,integer=0)
    private Long activeId;

    /**
     * 活动编号
     */
    @Length(min = 0, max = 32)
    private java.lang.String activeCode;

    /**
     * 信贷产品编码
     */
    @Length(min = 0, max = 50)
    private java.lang.String prodCode;

    /**
     * 信贷产品名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String prodName;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

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
     * 产品类型-01金融产品-02信贷产品
     */
    @Length(min = 0, max = 32)
    private java.lang.String prodType;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActiveId() {
        return this.activeId;
    }

    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }

    public java.lang.String getActiveCode() {
        return this.activeCode;
    }

    public void setActiveCode(java.lang.String activeCode) {
        this.activeCode = activeCode;
    }

    public java.lang.String getProdCode() {
        return this.prodCode;
    }

    public void setProdCode(java.lang.String prodCode) {
        this.prodCode = prodCode;
    }

    public java.lang.String getProdName() {
        return this.prodName;
    }

    public void setProdName(java.lang.String prodName) {
        this.prodName = prodName;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
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

    public java.lang.String getProdType() {
        return this.prodType;
    }

    public void setProdType(java.lang.String prodType) {
        this.prodType = prodType;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}