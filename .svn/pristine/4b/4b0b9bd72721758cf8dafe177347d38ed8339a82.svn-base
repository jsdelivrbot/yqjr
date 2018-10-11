package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class Role extends BaseEntity<Role> {


    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/role/list
     *表单维护路径：/role/form
     *
     */

    /**
     * 主键
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 所属系统ID
     */
    @Digits(fraction =22,integer=0)
    private Long systemId;

    /**
     * 角色名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String name;

    /**
     * 角色类型
     */
    @Length(min = 0, max = 16)
    private java.lang.String roleType;

    /**
     * 是否系统数据
     */
    @Length(min = 0, max = 1)
    private java.lang.String isSys;

    /**
     * 是否可用
     */
    @Length(min = 0, max = 1)
    private java.lang.String useAble;

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
     * 有效无效标识
     */
    private java.lang.String status;

    /**
     * 角色英文名
     */
    @Length(min = 0, max = 32)
    private java.lang.String enName;
    
    @Length(min = 0, max = 32)
    private java.lang.String roleCode;
    

    public java.lang.String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSystemId() {
        return this.systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(java.lang.String roleType) {
        this.roleType = roleType;
    }

    public java.lang.String getIsSys() {
        return this.isSys;
    }

    public void setIsSys(java.lang.String isSys) {
        this.isSys = isSys;
    }

    public java.lang.String getUseAble() {
        return this.useAble;
    }

    public void setUseAble(java.lang.String useAble) {
        this.useAble = useAble;
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

    public java.lang.String getEnName() {
        return this.enName;
    }

    public void setEnName(java.lang.String enName) {
        this.enName = enName;
    }

}
