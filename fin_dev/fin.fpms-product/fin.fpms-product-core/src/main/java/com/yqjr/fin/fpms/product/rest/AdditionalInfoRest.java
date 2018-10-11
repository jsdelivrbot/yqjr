package com.yqjr.fin.fpms.product.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.fpms.product.condition.AdditionalInfoCondition;
import com.yqjr.fin.fpms.product.bizz.AdditionalInfoBizz;
import com.yqjr.fin.fpms.product.dto.AdditionalInfoDto;

/**
* 金融专案附加信息表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:18
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "additionalInfos")
@RestController
@RequestMapping(value = "/additionalInfos")
public class AdditionalInfoRest extends BaseRest<AdditionalInfoBizz,Long, AdditionalInfoDto, AdditionalInfoCondition>  {

}