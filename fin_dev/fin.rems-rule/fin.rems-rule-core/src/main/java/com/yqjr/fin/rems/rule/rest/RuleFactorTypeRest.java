package com.yqjr.fin.rems.rule.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.BusinessException;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.rems.rule.condition.RuleFactorCondition;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.yqjr.fin.rems.rule.condition.RuleFactorTypeCondition;
import com.yqjr.fin.rems.rule.bizz.RuleFactorTypeBizz;
import com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto;

/**
*  规则因子类型表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "ruleFactorTypes")
@RestController
@Slf4j
@RequestMapping(value = "/ruleFactorTypes")
public class RuleFactorTypeRest extends BaseRest<RuleFactorTypeBizz,Long,
        RuleFactorTypeDto, RuleFactorTypeCondition> {

    @ApiOperation(value = "规则因子类型名称唯一性验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeName",
                    value = "规则因子类型名称", required = true,
                    dataType = "String")
    })
    @RequestMapping(value = "/validate/name", method = RequestMethod.GET)
    public ServiceResponse<RuleFactorTypeDto> validateName(@RequestParam(value = "typeName") String typeName) {
        try {
            bizz.validateTypeName(typeName);
            return ServiceResponse.ok();
        } catch (CommonBizzException e) {
            log.error("规则因子类型名称唯一性验证错误：msg"+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }


    @ApiOperation(value = "规则因子类型新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorTypeDto",
                    value = "规则因子类型实体", required = true, dataType = "RuleFactorTypeDto")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ServiceResponse<RuleFactorTypeDto> addType(@RequestBody RuleFactorTypeDto ruleFactorTypeDto) {
        try {
            bizz.addFactorType(ruleFactorTypeDto);
            return ServiceResponse.ok();
        } catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }

    @ApiOperation(value = "规则因子类型修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorTypeDto",
                    value = "规则因子类型实体", required = true, dataType = "RuleFactorTypeDto")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResponse<RuleFactorTypeDto> updateType(@RequestBody RuleFactorTypeDto ruleFactorTypeDto) {
        try {
            bizz.updateFactorType(ruleFactorTypeDto);
            return ServiceResponse.ok();
        }catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }


    @ApiOperation(value = "规则因子类型删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId",
                    value = "规则因子类型Id", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ServiceResponse<RuleFactorTypeDto> deleteType(@RequestParam(value = "id") Long typeId) {
        try {
            bizz.deleteFactorType(typeId);
            return ServiceResponse.ok();
        } catch (CommonBizzException e) {
            log.error("规则因子类型删除异常：msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }


    @ApiOperation(value = "规则因子类型分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorCondition",
                    value = "规则因子类型条件实体", required = true,
                    dataType = "RuleFactorCondition")
    })
    @RequestMapping(value = "/findPage", method = RequestMethod.POST)
    public ServiceResponse<PageList<RuleFactorTypeDto>> page(
            @RequestBody RuleFactorTypeCondition ruleFactorTypeCondition) {
        try {
            PageList<RuleFactorTypeDto> list = bizz.findByPage(ruleFactorTypeCondition);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }

}