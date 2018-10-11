package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.PolicyRuleCondition;
import com.yqjr.fin.qcms.credit.bizz.PolicyRuleBizz;
import com.yqjr.fin.qcms.credit.dto.PolicyRuleDto;

/**
* 政策规则关系表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "policyRules")
@RestController
@RequestMapping(value = "/policyRules")
public class PolicyRuleRest extends BaseRest<PolicyRuleBizz,Long, PolicyRuleDto, PolicyRuleCondition>  {

}