
package com.yqjr.fin.mkmm.sales.condition;

import com.yqjr.fin.mkmm.sales.entity.ActiveMatchDetail;
import com.yqjr.scfw.common.condition.BaseCondition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class ActiveMatchDetailVoCondition  {

    /**
     * 活动编码
     */
    @Length(min = 0, max = 20)
    private String  activeCode;

    /**
     * 活动名称
     */
    @Length(min = 0, max = 64)
    private String activeName;

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 业务代码
     */
    @Length(min = 0, max = 20)
    private String businessCode;

    /**
     * 业务名称
     */
    @Length(min = 0, max = 64)
    private String businessName;

    /**
     * 关联业务明细表主键ID
     */
    @Digits(fraction =22,integer=0)
    private Long businessid;

    /**
     * 关联经销商匹配表ID
     */
    @Digits(fraction =22,integer=0)
    private Long distributorid;

    /**
     * 是否在统计最大值范围内
     */
    @Length(min = 0, max = 20)
    private String isCountMaxIn;

    /**
     * 关联任务表ID
     */
    @Digits(fraction =22,integer=0)
    private Long taskId;

    /**
     * 统计归属日期（按照放款日期筛选）
     */
    private java.util.Date countDate;

    /**
     * 申请ID（业务数据唯一标识）
     */
    @Length(min = 0, max = 50)
    private String applyid;

    /**
     * 结算单号
     */
    @Length(min = 0, max = 20)
    private String billNo;

    /**
     * 合同号
     */
    @Length(min = 0, max = 50)
    private String contractNo;

    /**
     * 借据号
     */
    @Length(min = 0, max = 50)
    private String loanNo;

    /**
     * 客户ID
     */
    @Length(min = 0, max = 50)
    private String customCode;

    /**
     * 客户名称
     */
    @Length(min = 0, max = 100)
    private String customName;

    /**
     * 证件类型
     */
    @Length(min = 0, max = 20)
    private String customIdType;

    /**
     * 证件号
     */
    @Length(min = 0, max = 100)
    private String customIdCard;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 100)
    private String company;

    /**
     * 品牌编码
     */
    @Length(min = 0, max = 50)
    private String brandsCode;

    /**
     * 品牌名称
     */
    @Length(min = 0, max = 50)
    private String brandsName;

    /**
     * 车系代码
     */
    @Length(min = 0, max = 50)
    private String seriesCode;

    /**
     * 车型
     */
    @Length(min = 0, max = 100)
    private String carBrandType;

    /**
     * 车型名称
     */
    @Length(min = 0, max = 100)
    private String carBrandTypeName;

    /**
     * 车系名称
     */
    @Length(min = 0, max = 50)
    private String seriesName;

    /**
     * 净车价
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal carPrice;

    /**
     * 车贷金融产品id
     */
    @Length(min = 0, max = 100)
    private String nactivitiesId;

    /**
     * 车籍
     */
    @Length(min = 0, max = 100)
    private String carMortgagerName;

    /**
     * 车贷金融产品名称
     */
    @Length(min = 0, max = 100)
    private String nactivitiesName;

    /**
     * 附加费金融产品id
     */
    @Length(min = 0, max = 100)
    private String necactivitiesId;

    /**
     * 附加费金融产品名称
     */
    @Length(min = 0, max = 100)
    private String necactivitiesName;

    /**
     * 业务类型Code
     */
    @Length(min = 0, max = 100)
    private String nbizType;

    /**
     * 业务类型名称
     */
    @Length(min = 0, max = 100)
    private String nbizTypeName;

    /**
     * 信贷产品Code
     */
    @Length(min = 0, max = 100)
    private String ngetinterestType;

    /**
     * 信贷产品名称
     */
    @Length(min = 0, max = 100)
    private String ngetinterestTypeName;

    /**
     * 服务产品Code
     */
    @Length(min = 0, max = 100)
    private String ndlrbizType;

    /**
     * 服务产品名称
     */
    @Length(min = 0, max = 100)
    private String ndlrbizTypeName;

    /**
     * 贷款金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal nloanMoney;

    /**
     * 贷款期限
     */
    @Length(min = 0, max = 100)
    private String timeLimit;

    /**
     * 申请日期
     */
    private java.util.Date dapplyDate;

    /**
     * 放款日期
     */
    private java.util.Date dfactstartDate;

    /**
     * 附加贷金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal necloanMoney;

    /**
     * 首付比例
     */
    @Digits(fraction =4,integer=4)
    private BigDecimal firstRatio;

    /**
     * 大区代码
     */
    @Length(min = 0, max = 100)
    private String largeAreaCode;

    /**
     * 大区名称
     */
    @Length(min = 0, max = 100)
    private String largeAreaName;

    /**
     * 二区代码
     */
    @Length(min = 0, max = 100)
    private String zoneTwoCode;

    /**
     * 二区名称
     */
    @Length(min = 0, max = 100)
    private String zoneTwoName;

    /**
     * 经销商代码
     */
    @Length(min = 0, max = 100)
    private String distributorCode;

    /**
     * 经销商名称
     */
    @Length(min = 0, max = 100)
    private String distributorName;

    /**
     * 销售顾问代码
     */
    @Length(min = 0, max = 100)
    private String salesPersonCode;

    /**
     * 销售顾问名称
     */
    @Length(min = 0, max = 100)
    private String salesPersonName;

    /**
     * 省份代码
     */
    @Length(min = 0, max = 100)
    private String provinceCode;

    /**
     * 省份名称
     */
    @Length(min = 0, max = 100)
    private String provinceName;

    /**
     * 城市代码
     */
    @Length(min = 0, max = 100)
    private String cityCode;

    /**
     * 城市名称
     */
    @Length(min = 0, max = 100)
    private String cityName;

    /**
     * 备注
     */
    @Length(min = 0, max = 500)
    private String remark;

    /**
     * 创建时间(数据提取时间)
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
    private String flag;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getBusinessid() {
        return this.businessid;
    }

    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }

    public Long getDistributorid() {
        return this.distributorid;
    }

    public void setDistributorid(Long distributorid) {
        this.distributorid = distributorid;
    }

    public String getIsCountMaxIn() {
        return this.isCountMaxIn;
    }

    public void setIsCountMaxIn(String isCountMaxIn) {
        this.isCountMaxIn = isCountMaxIn;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public java.util.Date getCountDate() {
        return this.countDate;
    }

    public void setCountDate(java.util.Date countDate) {
        this.countDate = countDate;
    }

    public String getApplyid() {
        return this.applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getBillNo() {
        return this.billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getContractNo() {
        return this.contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getLoanNo() {
        return this.loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getCustomCode() {
        return this.customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomIdType() {
        return this.customIdType;
    }

    public void setCustomIdType(String customIdType) {
        this.customIdType = customIdType;
    }

    public String getCustomIdCard() {
        return this.customIdCard;
    }

    public void setCustomIdCard(String customIdCard) {
        this.customIdCard = customIdCard;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBrandsCode() {
        return this.brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public String getBrandsName() {
        return this.brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getSeriesCode() {
        return this.seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getCarBrandType() {
        return this.carBrandType;
    }

    public void setCarBrandType(String carBrandType) {
        this.carBrandType = carBrandType;
    }

    public String getCarBrandTypeName() {
        return this.carBrandTypeName;
    }

    public void setCarBrandTypeName(String carBrandTypeName) {
        this.carBrandTypeName = carBrandTypeName;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getNactivitiesId() {
        return this.nactivitiesId;
    }

    public void setNactivitiesId(String nactivitiesId) {
        this.nactivitiesId = nactivitiesId;
    }

    public String getCarMortgagerName() {
        return this.carMortgagerName;
    }

    public void setCarMortgagerName(String carMortgagerName) {
        this.carMortgagerName = carMortgagerName;
    }

    public String getNactivitiesName() {
        return this.nactivitiesName;
    }

    public void setNactivitiesName(String nactivitiesName) {
        this.nactivitiesName = nactivitiesName;
    }

    public String getNecactivitiesId() {
        return this.necactivitiesId;
    }

    public void setNecactivitiesId(String necactivitiesId) {
        this.necactivitiesId = necactivitiesId;
    }

    public String getNecactivitiesName() {
        return this.necactivitiesName;
    }

    public void setNecactivitiesName(String necactivitiesName) {
        this.necactivitiesName = necactivitiesName;
    }

    public String getNbizType() {
        return this.nbizType;
    }

    public void setNbizType(String nbizType) {
        this.nbizType = nbizType;
    }

    public String getNbizTypeName() {
        return this.nbizTypeName;
    }

    public void setNbizTypeName(String nbizTypeName) {
        this.nbizTypeName = nbizTypeName;
    }

    public String getNgetinterestType() {
        return this.ngetinterestType;
    }

    public void setNgetinterestType(String ngetinterestType) {
        this.ngetinterestType = ngetinterestType;
    }

    public String getNgetinterestTypeName() {
        return this.ngetinterestTypeName;
    }

    public void setNgetinterestTypeName(String ngetinterestTypeName) { this.ngetinterestTypeName = ngetinterestTypeName; }

    public String getNdlrbizType() {
        return this.ndlrbizType;
    }

    public void setNdlrbizType(String ndlrbizType) {
        this.ndlrbizType = ndlrbizType;
    }

    public String getNdlrbizTypeName() {
        return this.ndlrbizTypeName;
    }

    public void setNdlrbizTypeName(String ndlrbizTypeName) {
        this.ndlrbizTypeName = ndlrbizTypeName;
    }

    public BigDecimal getCarPrice() { return carPrice; }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public BigDecimal getNloanMoney() {
        return nloanMoney;
    }

    public void setNloanMoney(BigDecimal nloanMoney) {
        this.nloanMoney = nloanMoney;
    }

    public BigDecimal getNecloanMoney() {
        return necloanMoney;
    }

    public void setNecloanMoney(BigDecimal necloanMoney) {
        this.necloanMoney = necloanMoney;
    }

    public BigDecimal getFirstRatio() {
        return firstRatio;
    }

    public void setFirstRatio(BigDecimal firstRatio) {
        this.firstRatio = firstRatio;
    }

    public String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public java.util.Date getDapplyDate() {
        return this.dapplyDate;
    }

    public void setDapplyDate(java.util.Date dapplyDate) {
        this.dapplyDate = dapplyDate;
    }

    public java.util.Date getDfactstartDate() {
        return this.dfactstartDate;
    }

    public void setDfactstartDate(java.util.Date dfactstartDate) {
        this.dfactstartDate = dfactstartDate;
    }



    public String getLargeAreaCode() {
        return this.largeAreaCode;
    }

    public void setLargeAreaCode(String largeAreaCode) {
        this.largeAreaCode = largeAreaCode;
    }

    public String getLargeAreaName() {
        return this.largeAreaName;
    }

    public void setLargeAreaName(String largeAreaName) {
        this.largeAreaName = largeAreaName;
    }

    public String getZoneTwoCode() {
        return this.zoneTwoCode;
    }

    public void setZoneTwoCode(String zoneTwoCode) {
        this.zoneTwoCode = zoneTwoCode;
    }

    public String getZoneTwoName() {
        return this.zoneTwoName;
    }

    public void setZoneTwoName(String zoneTwoName) {
        this.zoneTwoName = zoneTwoName;
    }

    public String getDistributorCode() {
        return this.distributorCode;
    }

    public void setDistributorCode(String distributorCode) {
        this.distributorCode = distributorCode;
    }

    public String getDistributorName() {
        return this.distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getSalesPersonCode() {
        return this.salesPersonCode;
    }

    public void setSalesPersonCode(String salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getSalesPersonName() {
        return this.salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
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

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}