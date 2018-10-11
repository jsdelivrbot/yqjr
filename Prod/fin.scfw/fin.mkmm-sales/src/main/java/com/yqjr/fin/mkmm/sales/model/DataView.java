package com.yqjr.fin.mkmm.sales.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DataView implements Serializable {

    private static final long serialVersionUID = 1L;

    //大区
    @Length(min = 0, max = 30)
    private  String largeAreaCode;
    //下辖区域
    @Length(min = 0, max = 20)
    private  String zoneTwoCode;
    //经销商代码
    @Length(min = 0, max = 20)
    private  String distributorCode;
    //销售顾问代码
    @Length(min = 0, max = 100)
    private String salesPersonCode;
    //省份
    @Length(min = 0, max = 100)
    private String provinceCode;
    //城市
    @Length(min = 0, max = 100)
    private String cityCode;
    //合同号
    @Length(min = 0, max = 50)
    private String contractNo;
    //借据号
    @Length(min = 0, max = 50)
    private String loanNo;
    //客户名称
    @Length(min = 0, max = 200)
    private String customName;
    //证件号
    @Length(min = 0, max = 50)
    private String customIdCard;
    //大品牌
    @Length(min = 0, max = 50)
    private String brandsCode;
    //子品牌
    @Length(min = 0, max = 50)
    private String seriesCode;
    //车型
    @Length(min = 0, max = 100)
    private String carBrandType;
    //净车价
    @Digits(fraction =2,integer=14)
    private BigDecimal carPrice;
    //车籍
    @Length(min = 0, max = 200)
    private String carMortgagerName;
    //车贷金融产品id
    @Length(min = 0, max = 100)
    private String nactivitiesId;
    //附加费金融产品id
    @Length(min = 0, max = 100)
    private String necactivitiesId;
    //业务类型Code
    @Length(min = 0, max = 100)
    private String nbizType;
    //信贷产品Code
    @Length(min = 0, max = 100)
    private String ngetinterestType;
    //服务产品Code
    @Length(min = 0, max = 100)
    private String ndlrbizType;
    //所属公司
    @Length(min = 0, max = 100)
    private String company;
    //贷款金额
    @Digits(fraction =2,integer=14)
    private BigDecimal nloanMoney;
    //贷款期限
    @Length(min = 0, max = 100)
    private String timeLimit;
    //申请日期
    @JSONField(format="yyyy-MM-dd" )
    private java.util.Date dapplyDate;
    //放款日期
    @JSONField(format="yyyy-MM-dd")
    private java.util.Date dfactstartDate;
    //附加贷金额
    @Digits(fraction =2,integer=14)
    private BigDecimal necloanMoney;
    //首付比例
    @Digits(fraction =4,integer=4)
    private BigDecimal firstRatio;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLargeAreaCode() {
        return largeAreaCode;
    }

    public void setLargeAreaCode(String largeAreaCode) {
        this.largeAreaCode = largeAreaCode;
    }

    public String getZoneTwoCode() {
        return zoneTwoCode;
    }

    public void setZoneTwoCode(String zoneTwoCode) {
        this.zoneTwoCode = zoneTwoCode;
    }

    public String getDistributorCode() {
        return distributorCode;
    }

    public void setDistributorCode(String distributorCode) {
        this.distributorCode = distributorCode;
    }

    public String getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(String salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomIdCard() {
        return customIdCard;
    }

    public void setCustomIdCard(String customIdCard) {
        this.customIdCard = customIdCard;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getCarBrandType() {
        return carBrandType;
    }

    public void setCarBrandType(String carBrandType) {
        this.carBrandType = carBrandType;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarMortgagerName() {
        return carMortgagerName;
    }

    public void setCarMortgagerName(String carMortgagerName) {
        this.carMortgagerName = carMortgagerName;
    }

    public String getNactivitiesId() {
        return nactivitiesId;
    }

    public void setNactivitiesId(String nactivitiesId) {
        this.nactivitiesId = nactivitiesId;
    }

    public String getNecactivitiesId() {
        return necactivitiesId;
    }

    public void setNecactivitiesId(String necactivitiesId) {
        this.necactivitiesId = necactivitiesId;
    }

    public String getNbizType() {
        return nbizType;
    }

    public void setNbizType(String nbizType) {
        this.nbizType = nbizType;
    }

    public String getNgetinterestType() {
        return ngetinterestType;
    }

    public void setNgetinterestType(String ngetinterestType) {
        this.ngetinterestType = ngetinterestType;
    }

    public String getNdlrbizType() {
        return ndlrbizType;
    }

    public void setNdlrbizType(String ndlrbizType) {
        this.ndlrbizType = ndlrbizType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getNloanMoney() {
        return nloanMoney;
    }

    public void setNloanMoney(BigDecimal nloanMoney) {
        this.nloanMoney = nloanMoney;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Date getDapplyDate() {
        return dapplyDate;
    }

    public void setDapplyDate(Date dapplyDate) {
        this.dapplyDate = dapplyDate;
    }

    public Date getDfactstartDate() {
        return dfactstartDate;
    }

    public void setDfactstartDate(Date dfactstartDate) {
        this.dfactstartDate = dfactstartDate;
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
}
