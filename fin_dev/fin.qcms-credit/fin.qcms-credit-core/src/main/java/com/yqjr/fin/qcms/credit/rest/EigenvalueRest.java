package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.EigenvalueCondition;
import com.yqjr.fin.qcms.credit.bizz.EigenvalueBizz;
import com.yqjr.fin.qcms.credit.dto.EigenvalueDto;

/**
* 特征值表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:29
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "eigenvalues")
@RestController
@RequestMapping(value = "/eigenvalues")
public class EigenvalueRest extends BaseRest<EigenvalueBizz,Long, EigenvalueDto, EigenvalueCondition>  {

}