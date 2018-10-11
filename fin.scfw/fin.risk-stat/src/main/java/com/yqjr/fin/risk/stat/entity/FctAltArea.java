package com.yqjr.fin.risk.stat.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class FctAltArea extends BaseEntity<FctAltArea> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/fctAltArea/list
     *表单维护路径：/fctAltArea/form
     *
     */

    /**
     * 事件ID
     */
    @Digits(fraction =22,integer=0)
    private Long eventid;

    /**
     * 指标ID
     */
    @Digits(fraction =22,integer=0)
    private Long indId;

    /**
     * 日期
     */
    @Length(min = 0, max = 24)
    private String bizdate;

    /**
     * 指标实际值
     */
    @Digits(fraction =16,integer=8)
    private Long factvalue;

    /**
     * 当期值1
     */
    @Digits(fraction =16,integer=8)
    private Long factvalue1;

    /**
     * 当期值2
     */
    @Digits(fraction =16,integer=8)
    private Long factvalue2;

    /**
     * 当期值3
     */
    @Digits(fraction =16,integer=8)
    private Long factvalue3;

    /**
     * 合计值
     */
    @Digits(fraction =16,integer=8)
    private Long facttotalvalue;

    /**
     * 合计值1
     */
    @Digits(fraction =16,integer=8)
    private Long facttotalvalue1;

    /**
     * 上期
     */
    @Digits(fraction =16,integer=8)
    private Long lastfactvalue;

    /**
     * 上期1
     */
    @Digits(fraction =16,integer=8)
    private Long lastfactvalue1;

    /**
     * 去年同期
     */
    @Digits(fraction =16,integer=8)
    private Long lastyearvalue;

    /**
     * 去年同期1
     */
    @Digits(fraction =16,integer=8)
    private Long lastyearvalue1;

    /**
     * 事件状态。0：无效；1：有效；-1：失效；9：干预中。
     */
    @Length(min = 0, max = 3)
    private String eventstate;

    /**
     * 干预状态。
     */
    @Length(min = 0, max = 3)
    private String handlestate;

    /**
     * 预警时间
     */
    private String alerttime;

    /**
     * 备用字段1
     */
    @Digits(fraction =16,integer=8)
    private Long assvalue1;

    /**
     * 备用字段2
     */
    @Digits(fraction =16,integer=8)
    private Long assvalue2;

    /**
     * 信号灯
     */
    @Length(min = 0, max = 3)
    private String signallamp;

    /**
     * 信号级别。如1,2,3，其中1的级别最低，3的级别最高，依此类推。
     */
    @Length(min = 0, max = 3)
    private String signallevel;

    /**
     * 区域代码
     */
    @Length(min = 0, max = 64)
    private String areacode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 128)
    private String areaname;

    /**
     * 区划代码
     */
    @Length(min = 0, max = 32)
    private String provcode;

    /**
     * 区划名称
     */
    @Length(min = 0, max = 128)
    private String provname;

    /**
     * 品牌代码
     */
    @Length(min = 0, max = 30)
    private String brand;

    /**
     * 品牌名称
     */
    @Length(min = 0, max = 120)
    private String brandname;

    /**
     * 辅助标志
     */
    @Length(min = 0, max = 4)
    private String assflag;

    /**
     * 区域类别
     */
    @Length(min = 0, max = 24)
    private String areatype;

    /**
     * 备用code
     */
    @Length(min = 0, max = 1024)
    private String asscode;

    /**
     * 备用文本
     */
    @Length(min = 0, max = 1024)
    private String asstext;

    /**
     * 备注
     */
    @Length(min = 0, max = 1024)
    private String remark;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后更新人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最后更新时间
     */
    private String modifyTime;

    public Long getEventid() {
        return this.eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getIndId() {
        return this.indId;
    }

    public void setIndId(Long indId) {
        this.indId = indId;
    }

    public String getBizdate() {
        return this.bizdate;
    }

    public void setBizdate(String bizdate) {
        this.bizdate = bizdate;
    }

    public Long getFactvalue() {
        return this.factvalue;
    }

    public void setFactvalue(Long factvalue) {
        this.factvalue = factvalue;
    }

    public Long getFactvalue1() {
        return this.factvalue1;
    }

    public void setFactvalue1(Long factvalue1) {
        this.factvalue1 = factvalue1;
    }

    public Long getFactvalue2() {
        return this.factvalue2;
    }

    public void setFactvalue2(Long factvalue2) {
        this.factvalue2 = factvalue2;
    }

    public Long getFactvalue3() {
        return this.factvalue3;
    }

    public void setFactvalue3(Long factvalue3) {
        this.factvalue3 = factvalue3;
    }

    public Long getFacttotalvalue() {
        return this.facttotalvalue;
    }

    public void setFacttotalvalue(Long facttotalvalue) {
        this.facttotalvalue = facttotalvalue;
    }

    public Long getFacttotalvalue1() {
        return this.facttotalvalue1;
    }

    public void setFacttotalvalue1(Long facttotalvalue1) {
        this.facttotalvalue1 = facttotalvalue1;
    }

    public Long getLastfactvalue() {
        return this.lastfactvalue;
    }

    public void setLastfactvalue(Long lastfactvalue) {
        this.lastfactvalue = lastfactvalue;
    }

    public Long getLastfactvalue1() {
        return this.lastfactvalue1;
    }

    public void setLastfactvalue1(Long lastfactvalue1) {
        this.lastfactvalue1 = lastfactvalue1;
    }

    public Long getLastyearvalue() {
        return this.lastyearvalue;
    }

    public void setLastyearvalue(Long lastyearvalue) {
        this.lastyearvalue = lastyearvalue;
    }

    public Long getLastyearvalue1() {
        return this.lastyearvalue1;
    }

    public void setLastyearvalue1(Long lastyearvalue1) {
        this.lastyearvalue1 = lastyearvalue1;
    }

    public String getEventstate() {
        return this.eventstate;
    }

    public void setEventstate(String eventstate) {
        this.eventstate = eventstate;
    }

    public String getHandlestate() {
        return this.handlestate;
    }

    public void setHandlestate(String handlestate) {
        this.handlestate = handlestate;
    }

    public String getAlerttime() {
        return this.alerttime;
    }

    public void setAlerttime(String alerttime) {
        this.alerttime = alerttime;
    }

    public Long getAssvalue1() {
        return this.assvalue1;
    }

    public void setAssvalue1(Long assvalue1) {
        this.assvalue1 = assvalue1;
    }

    public Long getAssvalue2() {
        return this.assvalue2;
    }

    public void setAssvalue2(Long assvalue2) {
        this.assvalue2 = assvalue2;
    }

    public String getSignallamp() {
        return this.signallamp;
    }

    public void setSignallamp(String signallamp) {
        this.signallamp = signallamp;
    }

    public String getSignallevel() {
        return this.signallevel;
    }

    public void setSignallevel(String signallevel) {
        this.signallevel = signallevel;
    }

    public String getAreacode() {
        return this.areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return this.areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getProvcode() {
        return this.provcode;
    }

    public void setProvcode(String provcode) {
        this.provcode = provcode;
    }

    public String getProvname() {
        return this.provname;
    }

    public void setProvname(String provname) {
        this.provname = provname;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandname() {
        return this.brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getAssflag() {
        return this.assflag;
    }

    public void setAssflag(String assflag) {
        this.assflag = assflag;
    }

    public String getAreatype() {
        return this.areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    public String getAsscode() {
        return this.asscode;
    }

    public void setAsscode(String asscode) {
        this.asscode = asscode;
    }

    public String getAsstext() {
        return this.asstext;
    }

    public void setAsstext(String asstext) {
        this.asstext = asstext;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
