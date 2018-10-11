package com.yqjr.fin.mkmm.sales.vo.domin;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.util.List;

public class ActiveMatchVo extends ActiveMatchDetail {

    private String activeCode;//活动编码
    private String activeName;//活动名称

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }
}
