package com.yqjr.fin.mkmm.sales.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class CommodityStock extends BaseEntity<CommodityStock> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/commodityStock/list
     *表单维护路径：/commodityStock/form
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
     * 区域编码
     */
    @Length(min = 0, max = 20)
    private String areaCode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 100)
    private String areaName;

    /**
     * 入库数量
     */
    @Digits(fraction =22,integer=0)
    private Long inNumber;

    /**
     * 入库金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal inAmount;

    /**
     * 出库数量
     */
    @Digits(fraction =22,integer=0)
    private Long putNumber;

    /**
     * 出库金额
     */
    @Digits(fraction =14,integer=2)
    private BigDecimal putAmount;

    /**
     * 当前库存
     */
    @Digits(fraction =22,integer=0)
    private Long nowStock;

    /**
     * 公司1 ：汽车金融 ，2：租赁公司
     */
    @Length(min = 0, max = 2)
    private String company;

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

    public void setCommodityTypeCode(String commodityTypeCode) {
        this.commodityTypeCode = commodityTypeCode;
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

    public BigDecimal getInAmount() {
        return inAmount;
    }

    public void setInAmount(BigDecimal inAmount) {
        this.inAmount = inAmount;
    }

    public BigDecimal getPutAmount() {
        return putAmount;
    }

    public void setPutAmount(BigDecimal putAmount) {
        this.putAmount = putAmount;
    }

    public Long getPutNumber() {
        return this.putNumber;
    }

    public void setPutNumber(Long putNumber) {
        this.putNumber = putNumber;
    }


    public Long getNowStock() {
        return this.nowStock;
    }

    public void setNowStock(Long nowStock) {
        this.nowStock = nowStock;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
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
