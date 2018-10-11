package com.yqjr.fin.fpms.product.rest;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.fpms.product.bizz.ProductTreeBizz;
import com.yqjr.fin.fpms.product.condition.ProductTreeCondition;
import com.yqjr.fin.fpms.product.dto.ProductTreeDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/productTree")
@RestController
public class ProductTreeRest extends BaseRest<ProductTreeBizz, Long, ProductTreeDto, ProductTreeCondition> {

    @ApiOperation(value = "产品树列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "公司", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "businessLine", value = "业务条线", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Long company,Long businessLine){
        JSONArray jsonArray = bizz.productTreeList(company,businessLine,0L);
        log.info("jsonArray = " + new Gson().toJson(jsonArray));
    }

    @ApiOperation(value = "产品树新增节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productTreeDto", value = "产品树dto", required = true, dataType = "ProductTreeDto")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ServiceResponse<ProductTreeDto> nodeAdd(ProductTreeDto productTreeDto) {
        try{
            bizz.nodeAdd(productTreeDto);
        }catch(CommonBizzException e){
            throw new RestException(ServiceResponseEnum.ADD_FAIL.getCode(),e);
        }catch(Exception e){
            log.error("产品树新增节点异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();
    }


    @ApiOperation(value = "产品树删除节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productTreeDto", value = "产品树dto(id、层级编号、是否最终节点、父节点id必传)", required = true, dataType = "ProductTreeDto")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ServiceResponse<ProductTreeDto> nodeDelete(ProductTreeDto productTreeDto) {
        try{
            bizz.nodeDel(productTreeDto);
        }catch(CommonBizzException e){
            throw new RestException(ServiceResponseEnum.DELETE_FAIL.getCode(),e);
        }catch(Exception e){
            log.error("产品树删除节点异常，msg = " + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
        return ServiceResponse.ok();

    }





}
