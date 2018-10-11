package com.yqjr.fin.mkmm.sales.vo.domin;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.util.List;

public class PersonMainVo extends PersonMain {
    private PersonCity  personCity;//负责城市
    private PersonBrand personBrand;//负责品牌
    private TeamMain teamMain;//团队信息
    private PersonTeam personTeam;
    private WorkFlow workFlow;//工作流

    public PersonCity getPersonCity() {
        return personCity;
    }

    public void setPersonCity(PersonCity personCity) {
        this.personCity = personCity;
    }

    public PersonBrand getPersonBrand() {
        return personBrand;
    }

    public void setPersonBrand(PersonBrand personBrand) {
        this.personBrand = personBrand;
    }

    public TeamMain getTeamMain() {
        return teamMain;
    }

    public void setTeamMain(TeamMain teamMain) {
        this.teamMain = teamMain;
    }

    public PersonTeam getPersonTeam() {
        return personTeam;
    }

    public void setPersonTeam(PersonTeam personTeam) {
        this.personTeam = personTeam;
    }

   public WorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(WorkFlow workFlow) {
        this.workFlow = workFlow;
    }
}
