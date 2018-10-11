package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.DecisionTreeCondition;
import com.yqjr.fin.qcms.credit.bizz.DecisionTreeBizz;
import com.yqjr.fin.qcms.credit.dto.DecisionTreeDto;

/**
* 决策树表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:28
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "decisionTrees")
@RestController
@RequestMapping(value = "/decisionTrees")
public class DecisionTreeRest extends BaseRest<DecisionTreeBizz,Long, DecisionTreeDto, DecisionTreeCondition>  {

}