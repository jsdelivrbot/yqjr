package com.yqjr.fin.mkmm.sales.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class BasicBussiness extends BaseEntity<BasicBussiness> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/basicBussiness/list
     *表单维护路径：/basicBussiness/form
     *
     */

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 业务明细表主键ID
     */
    @Digits(fraction =22,integer=0)
    private Long businessid;

    /**
     * 申请ID（业务数据唯一标识）
     */
    @Length(min = 0, max = 50)
    private java.lang.String applyid;

    /**
     * 结算单号
     */
    @Length(min = 0, max = 20)
    private java.lang.String billNo;

    /**
     * 业务明细单号（合同号）
     */
    @Length(min = 0, max = 50)
    private java.lang.String contractNo;

    /**
     * 借据号
     */
    @Length(min = 0, max = 50)
    private java.lang.String loanNo;

    /**
     * 客户ID
     */
    @Length(min = 0, max = 50)
    private java.lang.String customCode;

    /**
     * 客户名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String customName;

    /**
     * 证件类型
     */
    @Length(min = 0, max = 20)
    private java.lang.String customIdType;

    /**
     * 证件号
     */
    @Length(min = 0, max = 100)
    private java.lang.String customIdCard;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

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
     * 车系代码
     */
    @Length(min = 0, max = 50)
    private java.lang.String seriesCode;

    /**
     * 车系名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String seriesName;

    /**
     * 车型
     */
    @Length(min = 0, max = 100)
    private java.lang.String carBrandType;

    /**
     * 车型名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String carBrandTypeName;

    /**
     * 净车价
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal carPrice;

    /**
     * 车籍
     */
    @Length(min = 0, max = 100)
    private java.lang.String carMortgagerName;

    /**
     * 营销活动（车贷金融产品id）
     */
    @Length(min = 0, max = 100)
    private java.lang.String nactivitiesId;

    /**
     * 营销活动名称（车贷金融产品id）
     */
    @Length(min = 0, max = 100)
    private java.lang.String nactivitiesName;

    /**
     * 附加费金融产品id
     */
    @Length(min = 0, max = 100)
    private java.lang.String necactivitiesId;

    /**
     * 附加费金融产品名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String necactivitiesName;

    /**
     * 业务类型Code
     */
    @Length(min = 0, max = 100)
    private java.lang.String nbizType;

    /**
     * 业务类型名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String nbizTypeName;

    /**
     * 信贷产品Code
     */
    @Length(min = 0, max = 100)
    private java.lang.String ngetinterestType;

    /**
     * 信贷产品名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String ngetinterestTypeName;

    /**
     * 金融产品(服务产品Code)
     */
    @Length(min = 0, max = 100)
    private java.lang.String ndlrbizType;

    /**
     * 金融产品(服务产品名称)
     */
    @Length(min = 0, max = 100)
    private java.lang.String ndlrbizTypeName;

    /**
     * 贷款金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal nloanMoney;

    /**
     * 贷款期限
     */
    @Length(min = 0, max = 100)
    private java.lang.String timeLimit;

    /**
     * 申请日期
     */
    @JSONField(format="yyyy-MM-dd")
    private java.util.Date dapplyDate;

    /**
     * 放款日期
     */
    @JSONField(format="yyyy-MM-dd")
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
    private java.lang.String largeAreaCode;

    /**
     * 大区名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String largeAreaName;

    /**
     * 二区代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String zoneTwoCode;

    /**
     * 二区名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String zoneTwoName;

    /**
     * 经销商代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String distributorCode;

    /**
     * 经销商名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String distributorName;

    /**
     * 销售顾问代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String salesPersonCode;

    /**
     * 销售顾问名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String salesPersonName;

    /**
     * 省份代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String provinceCode;

    /**
     * 省份名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String provinceName;

    /**
     * 城市代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String cityCode;

    /**
     * 城市名称
     */
    @Length(min = 0, max = 100)
    private java.lang.String cityName;

    /**
     * 备注
     */
    @Length(min = 0, max = 100)
    private java.lang.String remark;

    /**
     * 创建时间(数据提取时间)
     */
    @JSONField(format="yyyy-MM-dd HH-mm-ss")
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    @JSONField(format="yyyy-MM-dd HH-mm-ss")
    private java.util.Date modifyTime;

    /**
     * 生效时间
     */
    @JSONField(format="yyyy-MM-dd HH-mm-ss")
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
     * 活动统计标识（01-未统计 02-已统计）
     */
    @Length(min = 0, max = 20)
    private java.lang.String activematchflag;

    /**
     * 计划跟踪标识（01-未统计 02-已统计）
     */
    @Length(min = 0, max = 20)
    private java.lang.String planmatchflag;

    /**
     * 有效标识（如表记录不删除，以此区分,0无效，1有效）
     */
    @Length(min = 0, max = 10)
    private java.lang.String flag;

    /**
     * 人员编号
     */
    @Length(min = 0, max = 50)
    private java.lang.String personCode;

    /**
     * 人员姓名
     */
    @Length(min = 0, max = 50)
    private java.lang.String personName;

    /**
     * 团队名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String teamName;

    /**
     * 团队编号
     */
    @Length(min = 0, max = 50)
    private java.lang.String teamCode;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessid() {
        return this.businessid;
    }

    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }

    public java.lang.String getApplyid() {
        return this.applyid;
    }

    public void setApplyid(java.lang.String applyid) {
        this.applyid = applyid;
    }

    public java.lang.String getBillNo() {
        return this.billNo;
    }

    public void setBillNo(java.lang.String billNo) {
        this.billNo = billNo;
    }

    public java.lang.String getContractNo() {
        return this.contractNo;
    }

    public void setContractNo(java.lang.String contractNo) {
        this.contractNo = contractNo;
    }

    public java.lang.String getLoanNo() {
        return this.loanNo;
    }

    public void setLoanNo(java.lang.String loanNo) {
        this.loanNo = loanNo;
    }

    public java.lang.String getCustomCode() {
        return this.customCode;
    }

    public void setCustomCode(java.lang.String customCode) {
        this.customCode = customCode;
    }

    public java.lang.String getCustomName() {
        return this.customName;
    }

    public void setCustomName(java.lang.String customName) {
        this.customName = customName;
    }

    public java.lang.String getCustomIdType() {
        return this.customIdType;
    }

    public void setCustomIdType(java.lang.String customIdType) {
        this.customIdType = customIdType;
    }

    public java.lang.String getCustomIdCard() {
        return this.customIdCard;
    }

    public void setCustomIdCard(java.lang.String customIdCard) {
        this.customIdCard = customIdCard;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
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

    public java.lang.String getSeriesCode() {
        return this.seriesCode;
    }

    public void setSeriesCode(java.lang.String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public java.lang.String getSeriesName() {
        return this.seriesName;
    }

    public void setSeriesName(java.lang.String seriesName) {
        this.seriesName = seriesName;
    }

    public java.lang.String getCarBrandType() {
        return this.carBrandType;
    }

    public void setCarBrandType(java.lang.String carBrandType) {
        this.carBrandType = carBrandType;
    }

    public java.lang.String getCarBrandTypeName() {
        return this.carBrandTypeName;
    }

    public void setCarBrandTypeName(java.lang.String carBrandTypeName) {
        this.carBrandTypeName = carBrandTypeName;
    }

    public BigDecimal getCarPrice() {
        return this.carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public java.lang.String getCarMortgagerName() {
        return this.carMortgagerName;
    }

    public void setCarMortgagerName(java.lang.String carMortgagerName) {
        this.carMortgagerName = carMortgagerName;
    }

    public java.lang.String getNactivitiesId() {
        return this.nactivitiesId;
    }

    public void setNactivitiesId(java.lang.String nactivitiesId) {
        this.nactivitiesId = nactivitiesId;
    }

    public java.lang.String getNactivitiesName() {
        return this.nactivitiesName;
    }

    public void setNactivitiesName(java.lang.String nactivitiesName) {
        this.nactivitiesName = nactivitiesName;
    }

    public java.lang.String getNecactivitiesId() {
        return this.necactivitiesId;
    }

    public void setNecactivitiesId(java.lang.String necactivitiesId) {
        this.necactivitiesId = necactivitiesId;
    }

    public java.lang.String getNecactivitiesName() {
        return this.necactivitiesName;
    }

    public void setNecactivitiesName(java.lang.String necactivitiesName) {
        this.necactivitiesName = necactivitiesName;
    }

    public java.lang.String getNbizType() {
        return this.nbizType;
    }

    public void setNbizType(java.lang.String nbizType) {
        this.nbizType = nbizType;
    }

    public java.lang.String getNbizTypeName() {
        return this.nbizTypeName;
    }

    public void setNbizTypeName(java.lang.String nbizTypeName) {
        this.nbizTypeName = nbizTypeName;
    }

    public java.lang.String getNgetinterestType() {
        return this.ngetinterestType;
    }

    public void setNgetinterestType(java.lang.String ngetinterestType) {
        this.ngetinterestType = ngetinterestType;
    }

    public java.lang.String getNgetinterestTypeName() {
        return this.ngetinterestTypeName;
    }

    public void setNgetinterestTypeName(java.lang.String ngetinterestTypeName) {
        this.ngetinterestTypeName = ngetinterestTypeName;
    }

    public java.lang.String getNdlrbizType() {
        return this.ndlrbizType;
    }

    public void setNdlrbizType(java.lang.String ndlrbizType) {
        this.ndlrbizType = ndlrbizType;
    }

    public java.lang.String getNdlrbizTypeName() {
        return this.ndlrbizTypeName;
    }

    public void setNdlrbizTypeName(java.lang.String ndlrbizTypeName) {
        this.ndlrbizTypeName = ndlrbizTypeName;
    }

    public BigDecimal getNloanMoney() {
        return this.nloanMoney;
    }

    public void setNloanMoney(BigDecimal nloanMoney) {
        this.nloanMoney = nloanMoney;
    }

    public java.lang.String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(java.lang.String timeLimit) {
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

    public BigDecimal getNecloanMoney() {
        return this.necloanMoney;
    }

    public void setNecloanMoney(BigDecimal necloanMoney) {
        this.necloanMoney = necloanMoney;
    }

    public BigDecimal getFirstRatio() {
        return this.firstRatio;
    }

    public void setFirstRatio(BigDecimal firstRatio) {
        this.firstRatio = firstRatio;
    }

    public java.lang.String getLargeAreaCode() {
        return this.largeAreaCode;
    }

    public void setLargeAreaCode(java.lang.String largeAreaCode) {
        this.largeAreaCode = largeAreaCode;
    }

    public java.lang.String getLargeAreaName() {
        return this.largeAreaName;
    }

    public void setLargeAreaName(java.lang.String largeAreaName) {
        this.largeAreaName = largeAreaName;
    }

    public java.lang.String getZoneTwoCode() {
        return this.zoneTwoCode;
    }

    public void setZoneTwoCode(java.lang.String zoneTwoCode) {
        this.zoneTwoCode = zoneTwoCode;
    }

    public java.lang.String getZoneTwoName() {
        return this.zoneTwoName;
    }

    public void setZoneTwoName(java.lang.String zoneTwoName) {
        this.zoneTwoName = zoneTwoName;
    }

    public java.lang.String getDistributorCode() {
        return this.distributorCode;
    }

    public void setDistributorCode(java.lang.String distributorCode) {
        this.distributorCode = distributorCode;
    }

    public java.lang.String getDistributorName() {
        return this.distributorName;
    }

    public void setDistributorName(java.lang.String distributorName) {
        this.distributorName = distributorName;
    }

    public java.lang.String getSalesPersonCode() {
        return this.salesPersonCode;
    }

    public void setSalesPersonCode(java.lang.String salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public java.lang.String getSalesPersonName() {
        return this.salesPersonName;
    }

    public void setSalesPersonName(java.lang.String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public java.lang.String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(java.lang.String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public java.lang.String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
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

    public java.lang.String getActivematchflag() {
        return this.activematchflag;
    }

    public void setActivematchflag(java.lang.String activematchflag) {
        this.activematchflag = activematchflag;
    }

    public java.lang.String getPlanmatchflag() {
        return this.planmatchflag;
    }

    public void setPlanmatchflag(java.lang.String planmatchflag) {
        this.planmatchflag = planmatchflag;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
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

    public java.lang.String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(java.lang.String teamName) {
        this.teamName = teamName;
    }

    public java.lang.String getTeamCode() {
        return this.teamCode;
    }

    public void setTeamCode(java.lang.String teamCode) {
        this.teamCode = teamCode;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
