package com.yqjr.fin.mkmm.sales.rest.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 销管二期开发
 * 物料入库树状菜单
 * Created by fannaian on 2018/9/6.
 */

public class SelectMenuVo implements Serializable {

    private String title;
    private String value;
    private String id;
    private List<SelectMenuVo> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SelectMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<SelectMenuVo> children) {
        this.children = children;
    }
}
