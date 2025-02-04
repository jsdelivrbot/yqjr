package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainCondition;
import com.yqjr.fin.mkmm.sales.condition.PersonMainCondition;
import com.yqjr.fin.mkmm.sales.condition.PersonMainReviewCondition;
import com.yqjr.fin.mkmm.sales.condition.TeamMainCondition;
import com.yqjr.fin.mkmm.sales.entity.ActiveMain;
import com.yqjr.fin.mkmm.sales.entity.PersonMain;
import com.yqjr.fin.mkmm.sales.entity.PersonMainReview;
import com.yqjr.fin.mkmm.sales.entity.TeamMain;
import com.yqjr.fin.mkmm.sales.rest.vo.AutoCompleteVo;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhouchong on 2018/5/25.
 */
@Service
@Transactional(readOnly = true)
public class AutoCompleteService {
    @Autowired
    private TeamMainService teamMainService;

    @Autowired
    private PersonMainService personMainService;

    @Autowired
    private ActiveMainService activeMainService;

    @Autowired
    private PersonMainReviewService personMainReviewService;

    public List<AutoCompleteVo> autoComplete(String codeType,String name){
        List<AutoCompleteVo> autoCompleteVos=new ArrayList<AutoCompleteVo>();
        UserContext userContext=SessionHolder.getUserContext();
        String areaCode = "";
        if (UserRoleHelp.isAdmin()||UserRoleHelp.isMarketingWorkers()||UserRoleHelp.isMarketingManager()) {
            areaCode = "";    //所有区域
        }else {
            areaCode = userContext.getAreaCode();    //添加区域作为筛选条件
        }
        String company = userContext.getComCode();
        if("Team".equals(codeType)){
            TeamMainCondition teamMainCondition=new TeamMainCondition();
            teamMainCondition.setTeamName(name);
            teamMainCondition.setCompany(company);
            teamMainCondition.setAreaCode(areaCode);
            List<TeamMain> teamMains=teamMainService.queryTeamMainList(teamMainCondition);
            return teamMains.stream().map(this::teamMainToAutoCompleteVo).collect(Collectors.toList());
        }

        if("Person".equals(codeType)){
            PersonMainCondition personMainCondition=new PersonMainCondition();
            personMainCondition.setPersonName(name);
            personMainCondition.setCompany(company);
            List<PersonMain> personMains=personMainService.queryPersonMainList(personMainCondition);
            return personMains.stream().map(this::personMainToAutoCompleteVo).collect(Collectors.toList());
        }

        if ("ActiveCode".equals(codeType)){
            ActiveMainCondition activeMainCondition = new ActiveMainCondition();
            activeMainCondition.setActiveCode(name);
            activeMainCondition.setCompany(company);
            activeMainCondition.setAreaCode(areaCode);
            List<ActiveMain> activeMains = activeMainService.queryActiveMains(activeMainCondition);
            return activeMains.stream().map(this::activeMainToAutoCompleteVo).collect(Collectors.toList());
        }

        return autoCompleteVos;
    }
    private AutoCompleteVo teamMainToAutoCompleteVo(TeamMain teamMain){
        AutoCompleteVo autoCompleteVo=new AutoCompleteVo();
        autoCompleteVo.setValue(teamMain.getTeamCode());
        autoCompleteVo.setLabel(teamMain.getTeamName());
        return autoCompleteVo;
    }


    private AutoCompleteVo personMainToAutoCompleteVo(PersonMain personMain){
        AutoCompleteVo autoCompleteVo=new AutoCompleteVo();
        autoCompleteVo.setValue(personMain.getPersonCode());
        autoCompleteVo.setLabel(personMain.getPersonName());
        return autoCompleteVo;
    }


    private AutoCompleteVo activeMainToAutoCompleteVo(ActiveMain activeMain){
        AutoCompleteVo autoCompleteVo=new AutoCompleteVo();
        autoCompleteVo.setValue(activeMain.getActiveCode());
        autoCompleteVo.setLabel(activeMain.getActiveName());
        return autoCompleteVo;
    }


}
