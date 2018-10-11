package com.yqjr.fin.rems.rule.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.rems.rule.condition.VerifySubruleHisCondition;
import com.yqjr.fin.rems.rule.bizz.VerifySubruleHisBizz;
import com.yqjr.fin.rems.rule.dto.VerifySubruleHisDto;

/**
*  验证型子规则轨迹表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "verifySubruleHiss")
@RestController
@RequestMapping(value = "/verifySubruleHiss")
public class VerifySubruleHisRest extends BaseRest<VerifySubruleHisBizz,Long, VerifySubruleHisDto, VerifySubruleHisCondition>  {

}