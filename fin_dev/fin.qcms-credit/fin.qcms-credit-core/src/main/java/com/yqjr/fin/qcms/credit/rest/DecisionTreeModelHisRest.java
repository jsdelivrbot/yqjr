package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.DecisionTreeModelHisCondition;
import com.yqjr.fin.qcms.credit.bizz.DecisionTreeModelHisBizz;
import com.yqjr.fin.qcms.credit.dto.DecisionTreeModelHisDto;

/**
* 决策树模型轨迹表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "decisionTreeModelHiss")
@RestController
@RequestMapping(value = "/decisionTreeModelHiss")
public class DecisionTreeModelHisRest extends BaseRest<DecisionTreeModelHisBizz,Long, DecisionTreeModelHisDto, DecisionTreeModelHisCondition>  {

}