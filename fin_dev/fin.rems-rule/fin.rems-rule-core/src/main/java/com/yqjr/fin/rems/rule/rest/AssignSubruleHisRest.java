package com.yqjr.fin.rems.rule.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.rems.rule.condition.AssignSubruleHisCondition;
import com.yqjr.fin.rems.rule.bizz.AssignSubruleHisBizz;
import com.yqjr.fin.rems.rule.dto.AssignSubruleHisDto;

/**
* 赋值型子规则轨迹表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "assignSubruleHiss")
@RestController
@RequestMapping(value = "/assignSubruleHiss")
public class AssignSubruleHisRest extends BaseRest<AssignSubruleHisBizz,Long, AssignSubruleHisDto, AssignSubruleHisCondition>  {

}