package com.yqjr.fin.mkmm.sales.vo.domin;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.io.Serializable;
import java.util.List;

public class PersonTeamVo implements Serializable {

    private String personCode ;
    private String personName;
    private String personIdcard;
    private String personNature;//人员性质
    private String personLevel;
    private String personJointime;
    private String personStatus;
    private String startTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

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

    public String getPersonIdcard() {
        return personIdcard;
    }

    public void setPersonIdcard(String personIdcard) {
        this.personIdcard = personIdcard;
    }

    public String getPersonNature() {
        return personNature;
    }

    public void setPersonNature(String personNature) {
        this.personNature = personNature;
    }

    public String getPersonLevel() {
        return personLevel;
    }

    public void setPersonLevel(String personLevel) {
        this.personLevel = personLevel;
    }

    public String getPersonJointime() {
        return personJointime;
    }

    public void setPersonJointime(String personJointime) {
        this.personJointime = personJointime;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }
}
