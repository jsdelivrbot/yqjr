package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class RoleMenu extends BaseEntity<RoleMenu> {


    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/roleMenu/list
     *表单维护路径：/roleMenu/form
     *
     */

    /**
     * 角色ID
     */
    @Digits(fraction =22,integer=0)
    private Long roleId;

    /**
     * 菜单ID
     */
    @Digits(fraction =22,integer=0)
    private Long menuId;

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

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
