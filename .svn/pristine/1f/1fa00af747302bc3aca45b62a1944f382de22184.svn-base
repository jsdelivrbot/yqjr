package com.yqjr.fin.fpms.product.rest;

import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.fpms.product.bizz.gateway.RuleImportBizz;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 规则导入rest
 * @author: lixue
 * @date: 2018/08/29 15:55:21
 **/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "ruleImport")
@RestController
@Slf4j
@RequestMapping(value = "/ruleImport")
public class RuleImportRest {

    @Autowired
    RuleImportBizz ruleImportBizz;

    @ApiOperation(value = "获取规则因子列表（1 金融  2 租赁）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "公司",  dataType = "Long")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<List<RuleFactorDto>> ruleFactorList(@RequestParam Long company) {
        try{
            return ruleImportBizz.ruleFactorDtoList(company);
        }catch (Exception e){
            log.error("调用规则引擎获取规则因子列表异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

}
