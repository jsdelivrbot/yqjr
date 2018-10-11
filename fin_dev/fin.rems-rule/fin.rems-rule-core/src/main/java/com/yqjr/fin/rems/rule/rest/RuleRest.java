package com.yqjr.fin.rems.rule.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.rems.rule.condition.RuleCondition;
import com.yqjr.fin.rems.rule.bizz.RuleBizz;
import com.yqjr.fin.rems.rule.dto.RuleDto;

/**
* 规则表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "rules")
@RestController
@RequestMapping(value = "/rules")
public class RuleRest extends BaseRest<RuleBizz,Long, RuleDto, RuleCondition>  {

}