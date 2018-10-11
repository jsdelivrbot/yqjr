package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class System extends BaseEntity<System> {


    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/system/list
     *表单维护路径：/system/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 系统名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String systemName;

    /**
     * 系统地址
     */
    @Length(min = 0, max = 64)
    private java.lang.String systemUrl;

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

    /**
     * 备注
     */
    @Length(min = 0, max = 255)
    private java.lang.String remarks;

    /**
     * 标识
     */
    private java.lang.String status;

    /**
     * 系统英文简称
     */
    @Length(min = 0, max = 16)
    private java.lang.String systemEnname;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(java.lang.String systemName) {
        this.systemName = systemName;
    }

    public java.lang.String getSystemUrl() {
        return this.systemUrl;
    }

    public void setSystemUrl(java.lang.String systemUrl) {
        this.systemUrl = systemUrl;
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

    public java.lang.String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getSystemEnname() {
        return this.systemEnname;
    }

    public void setSystemEnname(java.lang.String systemEnname) {
        this.systemEnname = systemEnname;
    }

}
