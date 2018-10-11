package com.yqjr.fin.mkmm.sales.vo.domin;

import java.io.Serializable;

/**
 * create by fannna on 20180628
 * 用于人员计划跟踪时 查询人员姓名
 */
public class PersonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String personCode;
    private String personName;
    private String areaCode;
    private String company;

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
