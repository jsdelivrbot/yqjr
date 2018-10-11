package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class Zonesets extends BaseEntity<Zonesets> {
    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/zonesets/list
     *表单维护路径：/zonesets/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 集合名称
     */
    @Length(min = 0, max = 200)
    private java.lang.String setsName;

    /**
     * 备注
     */
    @Length(min = 0, max = 1000)
    private java.lang.String remark;

    /**
     * 状态
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

    public java.lang.String getSetsName() {
        return this.setsName;
    }

    public void setSetsName(java.lang.String setsName) {
        this.setsName = setsName;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
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
