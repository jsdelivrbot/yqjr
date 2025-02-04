
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.FeeMain;

import java.math.BigDecimal;

public class FeeMainCondition extends BaseCondition<FeeMain, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/feeMain/list
     *表单维护路径：/feeMain/form
     *
     */

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 结算单号
     */
    @Length(min = 0, max = 20)
    private java.lang.String billno;

    /**
     * 费用类型 (01-活动费用)
     */
    @Length(min = 0, max = 20)
    private java.lang.String feeType;

    /**
     * 费用来源（01-正常渠道计算，02-费用追加）
     */
    @Length(min = 0, max = 20)
    private java.lang.String feeSource;

    /**
     * 业务代码
     */
    @Length(min = 0, max = 20)
    private java.lang.String businessCode;

    /**
     * 业务名称
     */
    @Length(min = 0, max = 64)
    private java.lang.String businessName;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    /**
     * 结算状态（00-初始，01-未动支，02-动支中，03-已动支）
     */
    @Length(min = 0, max = 20)
    private java.lang.String billStatus;

    /**
     * 是否送共享(01-未送共享，02-已送共享，99-未知状态)
     */
    @Length(min = 0, max = 20)
    private java.lang.String isSendGx;

    /**
     * 有效状态
     */
    @Length(min = 0, max = 10)
    private java.lang.String validStatus;

    /**
     * 结算单上限金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal maxBillFee;

    /**
     * 结算单金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal billFee;

    /**
     * 结算次数
     */
    @Digits(fraction =22,integer=0)
    private Long settleTimes;

    /**
     * 实际活动成交数量
     */
    @Digits(fraction =22,integer=0)
    private Long actualTurnoverCount;

    /**
     * 预计活动成交数量
     */
    @Digits(fraction =22,integer=0)
    private Long estimateTurnoverCount;

    /**
     * 达成率
     */
    @Length(min = 0, max = 20)
    private java.lang.String reachRate;

    /**
     * 区域代码
     */
    @Length(min = 0, max = 500)
    private java.lang.String areaCode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 1000)
    private java.lang.String areaName;

    /**
     * 品牌编码
     */
    @Length(min = 0, max = 50)
    private java.lang.String brandsCode;

    /**
     * 品牌名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String brandsName;

    /**
     * 活动开始日期
     */
    private java.util.Date activeStartime;

    /**
     * 活动截止日期
     */
    private java.util.Date activeEndtime;

    /**
     * 审核表ID
     */
    @Digits(fraction =22,integer=0)
    private Long feeMainReviewId;

    /**
     * 费用申请归属部门
     */
    @Length(min = 0, max = 20)
    private java.lang.String feeowner;

    /**
     * 备注
     */
    @Length(min = 0, max = 500)
    private java.lang.String remark;

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
     * 有效标识（如表记录不删除，以此区分,0无效，1有效）
     */
    @Length(min = 0, max = 10)
    private java.lang.String flag;

    /**
     * 审核ID
     * @return
     */
    @Digits(fraction =22,integer=0)
    private Long reviewId;

    /**
     * 请求共享平台流水号
     */
    @Length(min = 0, max = 50)
    private java.lang.String serialNumber;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getBillno() {
        return this.billno;
    }

    public void setBillno(java.lang.String billno) {
        this.billno = billno;
    }

    public java.lang.String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(java.lang.String feeType) {
        this.feeType = feeType;
    }

    public java.lang.String getFeeSource() {
        return this.feeSource;
    }

    public void setFeeSource(java.lang.String feeSource) {
        this.feeSource = feeSource;
    }

    public java.lang.String getBusinessCode() {
        return this.businessCode;
    }

    public void setBusinessCode(java.lang.String businessCode) {
        this.businessCode = businessCode;
    }

    public java.lang.String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(java.lang.String businessName) {
        this.businessName = businessName;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getBillStatus() {
        return this.billStatus;
    }

    public void setBillStatus(java.lang.String billStatus) {
        this.billStatus = billStatus;
    }

    public java.lang.String getIsSendGx() {
        return this.isSendGx;
    }

    public void setIsSendGx(java.lang.String isSendGx) {
        this.isSendGx = isSendGx;
    }

    public java.lang.String getValidStatus() {
        return this.validStatus;
    }

    public void setValidStatus(java.lang.String validStatus) {
        this.validStatus = validStatus;
    }

    public BigDecimal getMaxBillFee() {
        return this.maxBillFee;
    }

    public void setMaxBillFee(BigDecimal maxBillFee) {
        this.maxBillFee = maxBillFee;
    }

    public BigDecimal getBillFee() {
        return this.billFee;
    }

    public void setBillFee(BigDecimal billFee) {
        this.billFee = billFee;
    }

    public Long getSettleTimes() {
        return this.settleTimes;
    }

    public void setSettleTimes(Long settleTimes) {
        this.settleTimes = settleTimes;
    }

    public Long getActualTurnoverCount() {
        return this.actualTurnoverCount;
    }

    public void setActualTurnoverCount(Long actualTurnoverCount) {
        this.actualTurnoverCount = actualTurnoverCount;
    }

    public Long getEstimateTurnoverCount() {
        return this.estimateTurnoverCount;
    }

    public void setEstimateTurnoverCount(Long estimateTurnoverCount) {
        this.estimateTurnoverCount = estimateTurnoverCount;
    }

    public java.lang.String getReachRate() {
        return this.reachRate;
    }

    public void setReachRate(java.lang.String reachRate) {
        this.reachRate = reachRate;
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

    public java.lang.String getBrandsCode() {
        return this.brandsCode;
    }

    public void setBrandsCode(java.lang.String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public java.lang.String getBrandsName() {
        return this.brandsName;
    }

    public void setBrandsName(java.lang.String brandsName) {
        this.brandsName = brandsName;
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

    public Long getFeeMainReviewId() {
        return this.feeMainReviewId;
    }

    public void setFeeMainReviewId(Long feeMainReviewId) {
        this.feeMainReviewId = feeMainReviewId;
    }

    public java.lang.String getFeeowner() {
        return this.feeowner;
    }

    public void setFeeowner(java.lang.String feeowner) {
        this.feeowner = feeowner;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
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

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}