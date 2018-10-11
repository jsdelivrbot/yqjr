package com.yqjr.fin.fpms.product.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.fpms.product.condition.ProjectAdditionalInfoCondition;
import com.yqjr.fin.fpms.product.bizz.ProjectAdditionalInfoBizz;
import com.yqjr.fin.fpms.product.dto.ProjectAdditionalInfoDto;

/**
* 金融专案附加信息主表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "projectAdditionalInfos")
@RestController
@RequestMapping(value = "/projectAdditionalInfos")
public class ProjectAdditionalInfoRest extends BaseRest<ProjectAdditionalInfoBizz,Long, ProjectAdditionalInfoDto, ProjectAdditionalInfoCondition>  {

}