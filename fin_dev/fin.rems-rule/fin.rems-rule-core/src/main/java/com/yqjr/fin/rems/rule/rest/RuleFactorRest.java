package com.yqjr.fin.rems.rule.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.yqjr.fin.rems.rule.condition.RuleFactorCondition;
import com.yqjr.fin.rems.rule.bizz.RuleFactorBizz;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;

import java.util.List;

/**
* 规则因子主表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "ruleFactors")
@Slf4j
@RestController
@RequestMapping(value = "/ruleFactors")
public class RuleFactorRest extends BaseRest<RuleFactorBizz,Long, RuleFactorDto, RuleFactorCondition> {


    @ApiOperation(value = "规则因子名称唯一性校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorName", value = "规则因子名称", required = true, dataType = "String")
    })
    @RequestMapping(value = "/name/valid", method = RequestMethod.GET)
    public ServiceResponse<RuleFactorDto> nameValid(
            @RequestParam(value = "ruleFactorName") String ruleFactorName) {

        try{
           bizz.nameValid(ruleFactorName);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.NAME_ALREADY_EXIST.getCode(),e.getMessage(),e);
        }catch (Exception e){
            log.error("规则因子名称唯一性校验异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();
    }

    @ApiOperation(value = "规则因子代码唯一性校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorCode", value = "规则因子代码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/code/valid", method = RequestMethod.GET)
    public ServiceResponse<RuleFactorDto> codeValid(
            @RequestParam(value = "ruleFactorCode") String ruleFactorCode) {
        try{
             bizz.codeValid(ruleFactorCode);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.CODE_ALREADY_EXIST.getCode(),e);
        }catch (Exception e){
            log.error("规则因子代码唯一性校验异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();
    }

    @ApiOperation(value = "规则因子添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorDto", value = "规则因子dto", required = true, dataType = "RuleFactorDto")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ServiceResponse<RuleFactorDto> add(@RequestBody RuleFactorDto ruleFactorDto) {
        try{
            bizz.add(ruleFactorDto);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.ADD_FAIL.getCode(),e);
        }catch (Exception e){
            log.error("规则因子添加异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();

    }

    @ApiOperation(value = "规则因子列表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorCondition", value = "规则因子查询条件",  dataType = "RuleFactorCondition")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ServiceResponse<PageList<RuleFactorDto>> page(RuleFactorCondition ruleFactorCondition) {

        try{
            bizz.page(ruleFactorCondition);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.NO_QUERY_RESULT.getCode(),e);
        }catch (Exception e){
            log.error("规则因子分页查询异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();
    }

    @ApiOperation(value = "规则因子修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorDto", value = "规则因子前后端交互类",  dataType = "RuleFactorDto")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResponse<RuleFactorDto> update(RuleFactorDto ruleFactorDto) {
        try{
            bizz.ruleFactorUpdate(ruleFactorDto);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.UPDATE_FAIL.getCode(),e);
        }catch (Exception e){
            log.error("规则因子修改异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();
    }


    @ApiOperation(value = "规则因子删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleFactorId", value = "规则因子id",  dataType = "Long")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ServiceResponse<RuleFactorDto> delete( @RequestParam(value = "ruleFactorId") Long ruleFactorId) {
        try{
            return bizz.ruleFactorDelete(ruleFactorId);
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.DELETE_FAIL.getCode(),e);
        }catch (Exception e){
            log.error("规则因子删除异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "根据公司获取规则因子列表（1 金融  2 租赁）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "公司",  dataType = "Long")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<List<RuleFactorDto>> ruleFactorList(@RequestParam Long company) {
        try{
            return ServiceResponse.ok(bizz.ruleFactorList(company));
        }catch (CommonBizzException e){
            throw new RestException(ServiceResponseEnum.NO_COMPANY.getCode(),e);
        }catch (Exception e){
            log.error("获取规则因子列表异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }






}