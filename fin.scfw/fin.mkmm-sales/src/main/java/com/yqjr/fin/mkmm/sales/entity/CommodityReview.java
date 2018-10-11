package com.yqjr.fin.mkmm.sales.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class CommodityReview extends BaseEntity<CommodityReview> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/commodityReview/list
     *表单维护路径：/commodityReview/form
     *
     */

    /**
     * 序号
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 物料名称
     */
    @Length(min = 0, max = 100)
    private String commodityName;

    /**
     * 物料编码
     */
    @Length(min = 0, max = 20)
    private String commodityCode;

    /**
     * 物料分类名称
     */
    @Length(min = 0, max = 100)
    private String commodityTypeName;

    /**
     * 物料分类编码
     */
    @Length(min = 0, max = 20)
    private String commodityTypeCode;

    /**
     * 项目名称
     */
    @Length(min = 0, max = 100)
    private String projectName;

    /**
     * 项目编码
     */
    @Length(min = 0, max = 20)
    private String projectCode;

    /**
     * 供应单位
     */
    @Length(min = 0, max = 2)
    private String provideOrganization;

    /**
     * 区域编码
     */
    @Length(min = 0, max = 20)
    private String areaCode;
    /**
     * 出库批次标识
     */
    @Length(min = 0, max = 100)
    private String batchCode;
    /**
     * 区域名称
     */
    @Length(min = 0, max = 100)
    private String areaName;

    /**
     * 验收数量
     */
    @Digits(fraction =22,integer=0)
    private Long acceptanceNumber;

    /**
     * 验收单位
     */
    @Length(min = 0, max = 100)
    private String acceptanceOrganization;

    /**
     * 验收人
     */
    @Length(min = 0, max = 20)
    private String acceptancePerson;

    /**
     * 入库数量
     */
    @Digits(fraction =22,integer=0)
    private Long inNumber;

    /**
     * 入库单价
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal inUnivalent;

    /**
     * 总金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal amount;

    /**
     * 保管人
     */
    @Length(min = 0, max = 20)
    private String custodian;

    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String inTime;

    /**
     * 验收表id
     */
    @Digits(fraction =22,integer=0)
    private Long acceptanceId;

    /**
     * 投放经销商编码
     */
    @Length(min = 0, max = 20)
    private String dealerCode;

    /**
     * 投放经销商名称
     */
    @Length(min = 0, max = 100)
    private String dealerName;

    /**
     * 投放数量
     */
    @Digits(fraction =22,integer=0)
    private Long putNumber;

    /**
     * 投放单价
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal putUnivalent;

    /**
     * 投放状态0：未投放，1：投放中，2：投放成功
     */
    @Length(min = 0, max = 2)
    private String putStatus;

    /**
     * 出库人
     */
    @Length(min = 0, max = 20)
    private String putName;

    /**
     * 入库出库审核标识1：入库审核，2出库审核
     */
    @Length(min = 0, max = 2)
    private String type;

    /**
     * 公司1：汽车金融 ，2：租赁公司
     */
    @Length(min = 0, max = 2)
    private String company;

    /**
     * 审核意见
     */
    @Length(min = 0, max = 560)
    private String remark;

    /**
     * 数据有效标识0：无效，1：有效
     */
    @Length(min = 0, max = 2)
    private String flag;

    /**
     * 物料状态02待审核，04审核通过，00审核驳回
     */
    @Length(min = 0, max = 2)
    private String commodityStatus;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityCode() {
        return this.commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityTypeName() {
        return this.commodityTypeName;
    }

    public void setCommodityTypeName(String commodityTypeName) {
        this.commodityTypeName = commodityTypeName;
    }

    public String getCommodityTypeCode() {
        return this.commodityTypeCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public void setCommodityTypeCode(String commodityTypeCode) {
        this.commodityTypeCode = commodityTypeCode;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProvideOrganization() {
        return this.provideOrganization;
    }

    public void setProvideOrganization(String provideOrganization) {
        this.provideOrganization = provideOrganization;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAcceptanceNumber() {
        return this.acceptanceNumber;
    }

    public void setAcceptanceNumber(Long acceptanceNumber) {
        this.acceptanceNumber = acceptanceNumber;
    }

    public String getAcceptanceOrganization() {
        return this.acceptanceOrganization;
    }

    public void setAcceptanceOrganization(String acceptanceOrganization) {
        this.acceptanceOrganization = acceptanceOrganization;
    }

    public String getAcceptancePerson() {
        return this.acceptancePerson;
    }

    public void setAcceptancePerson(String acceptancePerson) {
        this.acceptancePerson = acceptancePerson;
    }

    public Long getInNumber() {
        return this.inNumber;
    }

    public void setInNumber(Long inNumber) {
        this.inNumber = inNumber;
    }

    public BigDecimal getInUnivalent() {
        return inUnivalent;
    }

    public void setInUnivalent(BigDecimal inUnivalent) {
        this.inUnivalent = inUnivalent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustodian() {
        return this.custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getInTime() {
        return this.inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public Long getAcceptanceId() {
        return this.acceptanceId;
    }

    public void setAcceptanceId(Long acceptanceId) {
        this.acceptanceId = acceptanceId;
    }

    public String getDealerCode() {
        return this.dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Long getPutNumber() {
        return this.putNumber;
    }

    public void setPutNumber(Long putNumber) {
        this.putNumber = putNumber;
    }

    public BigDecimal getPutUnivalent() {
        return this.putUnivalent;
    }

    public void setPutUnivalent(BigDecimal putUnivalent) {
        this.putUnivalent = putUnivalent;
    }

    public String getPutStatus() {
        return this.putStatus;
    }

    public void setPutStatus(String putStatus) {
        this.putStatus = putStatus;
    }

    public String getPutName() {
        return this.putName;
    }

    public void setPutName(String putName) {
        this.putName = putName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCommodityStatus() {
        return this.commodityStatus;
    }

    public void setCommodityStatus(String commodityStatus) {
        this.commodityStatus = commodityStatus;
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
