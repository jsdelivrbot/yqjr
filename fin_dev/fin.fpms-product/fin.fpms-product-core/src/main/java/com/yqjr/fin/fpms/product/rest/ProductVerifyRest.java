package com.yqjr.fin.fpms.product.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.fpms.product.condition.ProductVerifyCondition;
import com.yqjr.fin.fpms.product.bizz.ProductVerifyBizz;
import com.yqjr.fin.fpms.product.dto.ProductVerifyDto;

/**
* 金融产品验证表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "productVerifys")
@RestController
@RequestMapping(value = "/productVerifys")
public class ProductVerifyRest extends BaseRest<ProductVerifyBizz,Long, ProductVerifyDto, ProductVerifyCondition>  {

}