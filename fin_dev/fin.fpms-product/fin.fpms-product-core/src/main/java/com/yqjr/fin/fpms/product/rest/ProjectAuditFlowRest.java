package com.yqjr.fin.fpms.product.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.fpms.product.condition.ProjectAuditFlowCondition;
import com.yqjr.fin.fpms.product.bizz.ProjectAuditFlowBizz;
import com.yqjr.fin.fpms.product.dto.ProjectAuditFlowDto;

/**
* 金融专案审核表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:20
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "projectAuditFlows")
@RestController
@RequestMapping(value = "/projectAuditFlows")
public class ProjectAuditFlowRest extends BaseRest<ProjectAuditFlowBizz,Long, ProjectAuditFlowDto, ProjectAuditFlowCondition>  {

}