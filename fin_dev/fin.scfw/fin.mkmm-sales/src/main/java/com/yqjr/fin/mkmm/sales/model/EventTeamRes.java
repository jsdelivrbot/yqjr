package com.yqjr.fin.mkmm.sales.model;

import java.io.Serializable;

public class EventTeamRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /*序号*/
    private Long id;
    /*团队代码*/
    private String teamCode;
    /*团队名称*/
    private String teamName;
    /*事件年度*/
    private String eventYear;
    /*事件分类*/
    private String eventType;
    /*处理单位*/
    private String eventApart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEventYear() {
        return eventYear;
    }

    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventApart() {
        return eventApart;
    }

    public void setEventApart(String eventApart) {
        this.eventApart = eventApart;
    }
}
