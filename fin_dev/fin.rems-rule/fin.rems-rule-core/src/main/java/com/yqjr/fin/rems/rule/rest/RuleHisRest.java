package com.yqjr.fin.rems.rule.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.rems.rule.condition.RuleHisCondition;
import com.yqjr.fin.rems.rule.bizz.RuleHisBizz;
import com.yqjr.fin.rems.rule.dto.RuleHisDto;

/**
*  规则轨迹表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "ruleHiss")
@RestController
@RequestMapping(value = "/ruleHiss")
public class RuleHisRest extends BaseRest<RuleHisBizz,Long, RuleHisDto, RuleHisCondition>  {

}