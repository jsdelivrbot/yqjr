
package com.yqjr.fin.scfw.meta.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.scfw.meta.entity.Menu;

import java.util.List;

public class MenuCondition extends BaseCondition<Menu, Long> {

    private static final long serialVersionUID = 1L;

    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 父ID
     */
    @Digits(fraction =22,integer=0)
    private Long parentId;



    /**
     * 菜单名称
     */
    @Length(min = 0, max = 200)
    private java.lang.String name;

    @Length(min = 0, max = 200)
    private java.lang.String title;


    @Length(min = 0, max = 16)
    private java.lang.String icon;

    @Length(min = 0, max = 16)
    private java.lang.String path;

    private List<MenuCondition> children;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MenuCondition> getChildren() {
        return children;
    }

    public void setChildren(List<MenuCondition> children) {
        this.children = children;
    }
}