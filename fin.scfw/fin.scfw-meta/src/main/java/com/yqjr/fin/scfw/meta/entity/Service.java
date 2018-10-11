package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class Service extends BaseEntity<Service> {


    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/service/list
     *表单维护路径：/service/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 服务名称
     */
    @Length(min = 0, max = 20)
    private java.lang.String serviceName;

    /**
     * 服务ID
     */
    @Length(min = 0, max = 20)
    private java.lang.String serviceId;

    /**
     * 所属系统 (sys_system表的ID)
     */
    @Length(min = 0, max = 20)
    private java.lang.String systemId;

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

    public java.lang.String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    public java.lang.String getSystemId() {
        return this.systemId;
    }

    public void setSystemId(java.lang.String systemId) {
        this.systemId = systemId;
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
