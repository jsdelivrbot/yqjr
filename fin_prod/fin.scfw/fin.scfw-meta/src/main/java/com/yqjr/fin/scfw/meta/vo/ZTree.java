package com.yqjr.fin.scfw.meta.vo;

import java.util.List;

public class ZTree {
    private String id;
    private String name;
    private String pId;
    private String open;
    private String isParent;
    private List<ZTree> children;

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public List<ZTree> getChildren() {
        return children;
    }

    public void setChildren(List<ZTree> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
