
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import org.springframework.format.annotation.DateTimeFormat;

public class CommodityInCondition extends BaseCondition<CommodityIn, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/commodityIn/list
     *表单维护路径：/commodityIn/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

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
     * 物料名称
     */
    @Length(min = 0, max = 100)
    private String commodityName;

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
     * 供应单位1：总部分发，2：区域采购
     */
    @Length(min = 0, max = 2)
    private String provideOrganization;

    /**
     * 创建人区域编码
     */
    @Length(min = 0, max = 20)
    private String areaCode;

    /**
     * 创建人区域名称
     */
    @Length(min = 0, max = 100)
    private String areaName;

    /**
     * 入库数量
     */
    @Digits(fraction =22,integer=0)
    private Long inNumber;

    /**
     * 入库单价
     */
    @Digits(fraction =14,integer=2)
    private Long inUnivalent;

    /**
     * 总金额
     */
    @Digits(fraction =14,integer=2)
    private Long amount;

    /**
     * 保管人
     */
    @Length(min = 0, max = 20)
    private String custodian;

    /**
     * 核校人
     */
    @Length(min = 0, max = 20)
    private String checker;

    /**
     * 公司1 ：汽车金融 ，2：租赁公司
     */
    @Length(min = 0, max = 2)
    private String company;

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
     * 物料状态02待入库，03入库中，00已入库
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

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityTypeCode() {
        return this.commodityTypeCode;
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

    public Long getInNumber() {
        return this.inNumber;
    }

    public void setInNumber(Long inNumber) {
        this.inNumber = inNumber;
    }

    public Long getInUnivalent() {
        return this.inUnivalent;
    }

    public void setInUnivalent(Long inUnivalent) {
        this.inUnivalent = inUnivalent;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCustodian() {
        return this.custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getChecker() {
        return this.checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
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