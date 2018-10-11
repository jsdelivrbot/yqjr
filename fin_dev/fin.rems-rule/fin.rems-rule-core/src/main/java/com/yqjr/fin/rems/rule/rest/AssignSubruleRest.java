package com.yqjr.fin.rems.rule.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.rems.rule.condition.AssignSubruleCondition;
import com.yqjr.fin.rems.rule.bizz.AssignSubruleBizz;
import com.yqjr.fin.rems.rule.dto.AssignSubruleDto;

/**
* 赋值型子规则表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:32
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "assignSubrules")
@RestController
@RequestMapping(value = "/assignSubrules")
public class AssignSubruleRest extends BaseRest<AssignSubruleBizz,Long, AssignSubruleDto, AssignSubruleCondition>  {

}