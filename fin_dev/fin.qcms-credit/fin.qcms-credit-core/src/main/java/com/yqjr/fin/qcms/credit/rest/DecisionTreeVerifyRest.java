package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.DecisionTreeVerifyCondition;
import com.yqjr.fin.qcms.credit.bizz.DecisionTreeVerifyBizz;
import com.yqjr.fin.qcms.credit.dto.DecisionTreeVerifyDto;

/**
* 决策树模型验证表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "decisionTreeVerifys")
@RestController
@RequestMapping(value = "/decisionTreeVerifys")
public class DecisionTreeVerifyRest extends BaseRest<DecisionTreeVerifyBizz,Long, DecisionTreeVerifyDto, DecisionTreeVerifyCondition>  {

}