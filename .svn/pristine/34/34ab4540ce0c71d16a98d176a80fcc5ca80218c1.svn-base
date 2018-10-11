package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.entity.PersonMain;
import com.yqjr.fin.mkmm.sales.entity.TeamMain;
import com.yqjr.fin.mkmm.sales.services.PersonMainService;
import com.yqjr.fin.mkmm.sales.services.TeamMainService;
import com.yqjr.scfw.common.rest.BaseRest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "/EffectiveChanges")
@RestController
@RequestMapping(value = "/EffectiveChanges")
public class EffectiveChangeRest{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonMainService personMainService;

    @Autowired
    private TeamMainService teamMainService;

    /**
     * 根据当前时间修改有效性
     * create by lf   2018/7/18
     */
    @ApiOperation(value = "校验生效时间与当前时间赋值有效性", tags = "校验生效时间与当前时间赋值有效性：EffectiveChangeRest")
    @ApiImplicitParams({

    })
    @RequestMapping(value = "/changePersonStatus", method = RequestMethod.GET)
    public void changePersonStatus(){
        List<PersonMain> personMains = personMainService.selectAllNoStatus();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        String startTime;
        PersonMain personMain = new PersonMain();
        for(int i = 0;i<personMains.size();i++){
            if(personMains.get(i).getStartTime()==null){
                continue;
            }
            personMain.setId(personMains.get(i).getId());
            personMain.setStartTime(personMains.get(i).getStartTime());
                startTime = sdf.format(personMain.getStartTime());
            if(time.equals(startTime)){
                personMain.setPersonStatus("1");
                personMainService.updateById(personMain);
            }

        }
    }


    /**
     * 根据当前时间修改有效性
     * create by lf   2018/7/18
     */
    @ApiOperation(value = "校验生效时间与当前时间赋值有效性", tags = "校验生效时间与当前时间赋值有效性：EffectiveChangeRest")
    @ApiImplicitParams({

    })
    @RequestMapping(value = "/changeTeamStatus", method = RequestMethod.GET)
    public void changeTeamStatus(){
        List<TeamMain> teamMains = teamMainService.selectAllTeamStatus();
        TeamMain teamMain = new TeamMain();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        String startTime;
        for (int i=0;i<teamMains.size();i++){
            if(teamMains.get(i).getStartTime()==null){
                continue;
            }
            teamMain.setId(teamMains.get(i).getId());
            teamMain.setStartTime(teamMains.get(i).getStartTime());
            startTime = sdf.format(teamMain.getStartTime());
            if(time.equals(startTime)){
                teamMain.setTeamStatus("1");
                teamMainService.updateById(teamMain);
            }

        }
    }
}
