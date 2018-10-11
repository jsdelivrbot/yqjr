package com.yqjr.fin.risk.stat.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class FctAltCustom extends BaseEntity<FctAltCustom> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/fctAltCustom/list
     *表单维护路径：/fctAltCustom/form
     *
     */

    /**
     * 事件ID
     */
    @Digits(fraction =22,integer=0)
    private Long eventid;

    /**
     * 客户ID
     */
    @Digits(fraction =22,integer=0)
    private Long customid;

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
     * 事件状态
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
    @Length(min = 0, max = 1000)
    private String assvalue1;

    /**
     * 备用字段2
     */
    @Length(min = 0, max = 1000)
    private String assvalue2;

    /**
     * 信号灯
     */
    @Length(min = 0, max = 3)
    private String signallamp;

    /**
     * 信号级别。如1,2,3，其中1的级别最低，3的级别最高，依此类推。
     */
    @Digits(fraction =22,integer=0)
    private Long signallevel;

    /**
     * 客户名称
     */
    @Length(min = 0, max = 256)
    private String customname;

    /**
     * 客户所属城市名称
     */
    @Length(min = 0, max = 32)
    private String cityname;

    /**
     * 区域代码，客户所属的区域。
     */
    @Length(min = 0, max = 64)
    private String areacode;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 128)
    private String areaname;

    /**
     * 品牌代码
     */
    @Length(min = 0, max = 25)
    private String brand;

    /**
     * 品牌名称
     */
    @Length(min = 0, max = 128)
    private String brandname;

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
     * 区域类别
     */
    @Length(min = 0, max = 24)
    private String areatype;

    /**
     * 辅助
     */
    @Length(min = 0, max = 1024)
    private String asstext;

    /**
     * 辅助
     */
    @Length(min = 0, max = 1024)
    private String asscode;

    /**
     * 城市代码
     */
    @Length(min = 0, max = 24)
    private String citycode;

    /**
     * 数据日期
     */
    @Length(min = 0, max = 24)
    private String factdate;

    /**
     * 只对日指标有效，表示该客户该指标同级别预警信号在一个预警周期内首次预警时间，如2010年8月1日为黄色预警，若上一次该客户该指标首次黄色预警为2010年7月20日，若预警时间差超过黄色预警的上限，则该字段伟2010-8-1，否则为2010-7-20，若8月2日继续黄色预警，则该字段为2010-8-1
     */
    @Length(min = 0, max = 24)
    private String firstalertdate;

    /**
     * 只对日指标有效，同FIRSTALERTDATE配合使用，表示该客户该指标同级别预警信号持续天数
     */
    @Digits(fraction =22,integer=0)
    private Long alertcontinuetime;

    /**
     * 只对日指标有效，同FIRSTALERTDATE配合使用，表示该预警事件在预警干预时是否显示
     */
    @Digits(fraction =22,integer=0)
    private Long isdisplay;

    /**
     * 存储大容量字符
     */
    private String asstext1;

    /**
     * 备注
     */
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

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getModifiername() {
        return modifiername;
    }

    public void setModifiername(String modifiername) {
        this.modifiername = modifiername;
    }

    /**
     * 预留字段
     */
    @Length(min = 0, max = 100)
    private java.lang.String attribute1;

    /**
     * 预留字段
     */
    @Length(min = 0, max = 100)
    private java.lang.String attribute2;

    /**
     * 预留字段
     */
    @Length(min = 0, max = 100)
    private java.lang.String attribute3;

    /**
     * 预留字段
     */
    @Length(min = 0, max = 100)
    private java.lang.String attribute4;

    /**
     * 创建人名字
     */
    @Length(min = 0, max = 100)
    private java.lang.String createname;

    /**
     * 更新人名字
     */
    @Length(min = 0, max = 100)
    private java.lang.String modifiername;

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    /**
     * 归属公司代码
     */
    @Length(min = 0, max = 24)
    private java.lang.String comcode;

    public Long getEventid() {
        return this.eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getCustomid() {
        return this.customid;
    }

    public void setCustomid(Long customid) {
        this.customid = customid;
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

    public String getAssvalue1() {
        return this.assvalue1;
    }

    public void setAssvalue1(String assvalue1) {
        this.assvalue1 = assvalue1;
    }

    public String getAssvalue2() {
        return this.assvalue2;
    }

    public void setAssvalue2(String assvalue2) {
        this.assvalue2 = assvalue2;
    }

    public String getSignallamp() {
        return this.signallamp;
    }

    public void setSignallamp(String signallamp) {
        this.signallamp = signallamp;
    }

    public Long getSignallevel() {
        return this.signallevel;
    }

    public void setSignallevel(Long signallevel) {
        this.signallevel = signallevel;
    }

    public String getCustomname() {
        return this.customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }

    public String getCityname() {
        return this.cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
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

    public String getAreatype() {
        return this.areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    public String getAsstext() {
        return this.asstext;
    }

    public void setAsstext(String asstext) {
        this.asstext = asstext;
    }

    public String getAsscode() {
        return this.asscode;
    }

    public void setAsscode(String asscode) {
        this.asscode = asscode;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getFactdate() {
        return this.factdate;
    }

    public void setFactdate(String factdate) {
        this.factdate = factdate;
    }

    public String getFirstalertdate() {
        return this.firstalertdate;
    }

    public void setFirstalertdate(String firstalertdate) {
        this.firstalertdate = firstalertdate;
    }

    public Long getAlertcontinuetime() {
        return this.alertcontinuetime;
    }

    public void setAlertcontinuetime(Long alertcontinuetime) {
        this.alertcontinuetime = alertcontinuetime;
    }

    public Long getIsdisplay() {
        return this.isdisplay;
    }

    public void setIsdisplay(Long isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getAsstext1() {
        return this.asstext1;
    }

    public void setAsstext1(String asstext1) {
        this.asstext1 = asstext1;
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
    private Indicators indicators;

    public Indicators getIndicators() {
        return indicators;
    }

    public void setIndicators(Indicators indicators) {
        this.indicators = indicators;
    }
    //endregion
}
