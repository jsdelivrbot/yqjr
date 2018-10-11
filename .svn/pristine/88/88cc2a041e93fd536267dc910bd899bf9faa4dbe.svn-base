package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.DecisionTreeAuditFlowCondition;
import com.yqjr.fin.qcms.credit.bizz.DecisionTreeAuditFlowBizz;
import com.yqjr.fin.qcms.credit.dto.DecisionTreeAuditFlowDto;

/**
* 决策树模型审核表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:28
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "decisionTreeAuditFlows")
@RestController
@RequestMapping(value = "/decisionTreeAuditFlows")
public class DecisionTreeAuditFlowRest extends BaseRest<DecisionTreeAuditFlowBizz,Long, DecisionTreeAuditFlowDto, DecisionTreeAuditFlowCondition>  {

}