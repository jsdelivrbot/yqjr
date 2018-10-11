package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class Zone extends BaseEntity<Zone> {


    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/zone/list
     *表单维护路径：/zone/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 父id
     */
    @Digits(fraction =22,integer=0)
    private Long parentId;

    /**
     * 名称
     */
    @Length(min = 0, max = 200)
    private java.lang.String name;

    /**
     * 地区编码
     */
    @Length(min = 0, max = 100)
    private java.lang.String code;

    /**
     * 状态(1有效,-1无效)
     */
    private java.lang.String status;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
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
