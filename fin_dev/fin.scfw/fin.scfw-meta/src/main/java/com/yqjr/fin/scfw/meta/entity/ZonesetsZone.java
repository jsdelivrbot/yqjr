package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class ZonesetsZone extends BaseEntity<ZonesetsZone> {
    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/zonesetsZone/list
     *表单维护路径：/zonesetsZone/form
     *
     */

    /**
     * 区域集合ID
     */
    @Digits(fraction =22,integer=0)
    private Long zonesetsId;

    /**
     * 区域ID
     */
    @Digits(fraction =22,integer=0)
    private Long zoneId;

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 创建时间
     */
    private java.lang.String createTime;

    /**
     * 最后更新人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最后更新时间
     */
    private java.lang.String modifyTime;

    public Long getZonesetsId() {
        return this.zonesetsId;
    }

    public void setZonesetsId(Long zonesetsId) {
        this.zonesetsId = zonesetsId;
    }

    public Long getZoneId() {
        return this.zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public java.lang.String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.lang.String createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public java.lang.String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(java.lang.String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
