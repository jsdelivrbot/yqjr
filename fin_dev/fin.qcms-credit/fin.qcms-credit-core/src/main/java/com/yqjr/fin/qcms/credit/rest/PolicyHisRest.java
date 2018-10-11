package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.PolicyHisCondition;
import com.yqjr.fin.qcms.credit.bizz.PolicyHisBizz;
import com.yqjr.fin.qcms.credit.dto.PolicyHisDto;

/**
* 政策轨迹表	 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "policyHiss")
@RestController
@RequestMapping(value = "/policyHiss")
public class PolicyHisRest extends BaseRest<PolicyHisBizz,Long, PolicyHisDto, PolicyHisCondition>  {

}