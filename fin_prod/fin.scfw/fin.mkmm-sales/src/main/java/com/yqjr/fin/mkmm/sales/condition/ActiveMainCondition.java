
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.ActiveMain;

import java.math.BigDecimal;

public class ActiveMainCondition extends BaseCondition<ActiveMain, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/activeMain/list
     *表单维护路径：/activeMain/form
     *
     */

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 活动编码
     */
    @Length(min = 0, max = 20)
    private java.lang.String activeCode;

    /**
     * 活动名称
     */
    @Length(min = 0, max = 64)
    private java.lang.String activeName;

    /**
     * 活动开始日期
     */
    private java.util.Date activeStartime;

    /**
     * 活动截止日期
     */
    private java.util.Date activeEndtime;

    /**
     * 放款开始日期
     */
    private java.util.Date loanStartime;

    /**
     * 放款截止日期
     */
    private java.util.Date loanEndtime;

    /**
     * 首付起始比例
     */
    @Length(min = 0, max = 20)
    private java.lang.String patmentBegin;

    /**
     * 首付终止比例
     */
    @Length(min = 0, max = 20)
    private java.lang.String patmentEnd;

    /**
     * 车籍
     */
    @Length(min = 0, max = 20)
    private java.lang.String carReg;

    /**
     * 贷款期限
     */
    private Long loanTermBegin;

    /**
     * 贷款期限
     */
    private Long loanTermEnd;

    /**
     * 贷款金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal loanAmtBegin;

    /**
     * 贷款金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal loanAmtEnd;

    /**
     * 促销活动激励标准
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal avtiveCriterion;

    /**
     * 附加贷(0没有，1有)
     */
    @Length(min = 0, max = 20)
    private java.lang.String additionFlag;

    /**
     * 附加贷起始金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal additionAmtBegin;

    /**
     * 附加贷终止金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal additionAmtEnd;

    /**
     * 活动状态
     */
    @Length(min = 0, max = 20)
    private java.lang.String activeStatus;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

    /**
     * 附件
     */
    @Length(min = 0, max = 20)
    private java.lang.String annex;

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
     * 动支状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String paymentStatus;

    /**
     * 备注
     */
    @Length(min = 0, max = 265)
    private java.lang.String remark;

    /**
     * 活动预计笔数
     */
    @Digits(fraction =22,integer=0)
    private Long expectedCount;

    /**
     * 审核表ID
     */
    @Digits(fraction =22,integer=0)
    private Long activeMainReviewId;

    /**
     * 有效状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String validStatus;

    /**
     * 附件上传文件ID
     */
    @Length(min = 0, max = 30)
    private java.lang.String additionalId;

    /**
     * 经销商录入标识（1是 0否）
     */
    @Length(min = 0, max = 20)
    private java.lang.String inputDeale;

    /**
     * 区域编码
     */
    @Length(min = 0, max = 50)
    private java.lang.String areaCode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String areaName;

    /**
     * 区域标识,1为区域，0为省市
     */
    @Length(min = 0, max = 10)
    private java.lang.String inputArea;

    public String getInputArea() {
        return inputArea;
    }

    public void setInputArea(String inputArea) {
        this.inputArea = inputArea;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getActiveCode() {
        return this.activeCode;
    }

    public void setActiveCode(java.lang.String activeCode) {
        this.activeCode = activeCode;
    }

    public java.lang.String getActiveName() {
        return this.activeName;
    }

    public void setActiveName(java.lang.String activeName) {
        this.activeName = activeName;
    }

    public java.util.Date getActiveStartime() {
        return this.activeStartime;
    }

    public void setActiveStartime(java.util.Date activeStartime) {
        this.activeStartime = activeStartime;
    }

    public java.util.Date getActiveEndtime() {
        return this.activeEndtime;
    }

    public void setActiveEndtime(java.util.Date activeEndtime) {
        this.activeEndtime = activeEndtime;
    }

    public java.util.Date getLoanStartime() {
        return this.loanStartime;
    }

    public void setLoanStartime(java.util.Date loanStartime) {
        this.loanStartime = loanStartime;
    }

    public java.util.Date getLoanEndtime() {
        return this.loanEndtime;
    }

    public void setLoanEndtime(java.util.Date loanEndtime) {
        this.loanEndtime = loanEndtime;
    }

    public java.lang.String getPatmentBegin() {
        return this.patmentBegin;
    }

    public void setPatmentBegin(java.lang.String patmentBegin) {
        this.patmentBegin = patmentBegin;
    }

    public java.lang.String getPatmentEnd() {
        return this.patmentEnd;
    }

    public void setPatmentEnd(java.lang.String patmentEnd) {
        this.patmentEnd = patmentEnd;
    }

    public java.lang.String getCarReg() {
        return this.carReg;
    }

    public void setCarReg(java.lang.String carReg) {
        this.carReg = carReg;
    }

    public Long getLoanTermBegin() {
        return loanTermBegin;
    }

    public void setLoanTermBegin(Long loanTermBegin) {
        this.loanTermBegin = loanTermBegin;
    }

    public Long getLoanTermEnd() {
        return loanTermEnd;
    }

    public void setLoanTermEnd(Long loanTermEnd) {
        this.loanTermEnd = loanTermEnd;
    }

    public BigDecimal getLoanAmtBegin() {
        return this.loanAmtBegin;
    }

    public void setLoanAmtBegin(BigDecimal loanAmtBegin) {
        this.loanAmtBegin = loanAmtBegin;
    }

    public BigDecimal getLoanAmtEnd() {
        return this.loanAmtEnd;
    }

    public void setLoanAmtEnd(BigDecimal loanAmtEnd) {
        this.loanAmtEnd = loanAmtEnd;
    }

    public BigDecimal getAvtiveCriterion() {
        return avtiveCriterion;
    }

    public void setAvtiveCriterion(BigDecimal avtiveCriterion) {
        this.avtiveCriterion = avtiveCriterion;
    }

    public java.lang.String getAdditionFlag() {
        return this.additionFlag;
    }

    public void setAdditionFlag(java.lang.String additionFlag) {
        this.additionFlag = additionFlag;
    }

    public BigDecimal getAdditionAmtBegin() {
        return this.additionAmtBegin;
    }

    public void setAdditionAmtBegin(BigDecimal additionAmtBegin) {
        this.additionAmtBegin = additionAmtBegin;
    }

    public BigDecimal getAdditionAmtEnd() {
        return this.additionAmtEnd;
    }

    public void setAdditionAmtEnd(BigDecimal additionAmtEnd) {
        this.additionAmtEnd = additionAmtEnd;
    }

    public java.lang.String getActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(java.lang.String activeStatus) {
        this.activeStatus = activeStatus;
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

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.lang.String getAnnex() {
        return this.annex;
    }

    public void setAnnex(java.lang.String annex) {
        this.annex = annex;
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

    public java.lang.String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(java.lang.String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public Long getExpectedCount() {
        return this.expectedCount;
    }

    public void setExpectedCount(Long expectedCount) {
        this.expectedCount = expectedCount;
    }

    public Long getActiveMainReviewId() {
        return this.activeMainReviewId;
    }

    public void setActiveMainReviewId(Long activeMainReviewId) {
        this.activeMainReviewId = activeMainReviewId;
    }

    public java.lang.String getValidStatus() {
        return this.validStatus;
    }

    public void setValidStatus(java.lang.String validStatus) {
        this.validStatus = validStatus;
    }

    public java.lang.String getAdditionalId() {
        return this.additionalId;
    }

    public void setAdditionalId(java.lang.String additionalId) {
        this.additionalId = additionalId;
    }

    public java.lang.String getInputDeale() {
        return this.inputDeale;
    }

    public void setInputDeale(java.lang.String inputDeale) {
        this.inputDeale = inputDeale;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}