package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.DecisionTreeRuleCondition;
import com.yqjr.fin.qcms.credit.bizz.DecisionTreeRuleBizz;
import com.yqjr.fin.qcms.credit.dto.DecisionTreeRuleDto;

/**
* 决策树规则表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "decisionTreeRules")
@RestController
@RequestMapping(value = "/decisionTreeRules")
public class DecisionTreeRuleRest extends BaseRest<DecisionTreeRuleBizz,Long, DecisionTreeRuleDto, DecisionTreeRuleCondition>  {

}