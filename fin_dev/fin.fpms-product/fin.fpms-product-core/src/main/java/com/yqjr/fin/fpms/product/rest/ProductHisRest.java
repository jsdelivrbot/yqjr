package com.yqjr.fin.fpms.product.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.fpms.product.condition.ProductHisCondition;
import com.yqjr.fin.fpms.product.bizz.ProductHisBizz;
import com.yqjr.fin.fpms.product.dto.ProductHisDto;

/**
* 金融产品轨迹表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "productHiss")
@RestController
@RequestMapping(value = "/productHiss")
public class ProductHisRest extends BaseRest<ProductHisBizz,Long, ProductHisDto, ProductHisCondition>  {

}