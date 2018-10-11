package com.yqjr.fin.fpms.product.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.BusinessException;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.fpms.product.bizz.ProductShowBizz;
import com.yqjr.fin.fpms.product.dto.ProductShowDto;
import com.yqjr.fin.fpms.product.dto.ProductTreeDto;
import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.io.pem.PemObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.*;
import com.yqjr.fin.fpms.product.condition.ProductCondition;
import com.yqjr.fin.fpms.product.bizz.ProductBizz;
import com.yqjr.fin.fpms.product.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
* 金融产品主表 rest层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:49:56
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "products")
@RestController
@Slf4j
@RequestMapping(value = "/products")
public class ProductRest extends BaseRest<ProductBizz,Long, ProductDto, ProductCondition>  {

    @ApiOperation(value = "金融产品名称唯一性验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName",
                    value = "金融产品名称", required = true,
                    dataType = "String")
    })
    @RequestMapping(value = "/validate/name", method = RequestMethod.GET)
    public ServiceResponse<ProductDto> validateName(@RequestParam(value = "vname") String productName){
        try {
            bizz.validateName(productName);
            return ServiceResponse.ok();
        }catch (CommonBizzException e) {
            log.error("金融产品名称已存在： msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品基本信息新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productDto",
                    value = "金融产品实体", required = true,
                    dataType = "ProductDto")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ServiceResponse<ProductDto> add(@RequestBody ProductDto productDto){
        try {
            bizz.addProduct(productDto);
            return ServiceResponse.ok();
        }catch (Exception e) {
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage(),null);
        }
    }

    @Autowired
    ProductShowBizz productShowBizz;
    @ApiOperation(value = "金融产品配置信息显示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId",
                    value = "金融产品Id", required = true,
                    dataType = "Long")
    })
    @RequestMapping(value = "/showInfo", method = RequestMethod.GET)
    public ServiceResponse<ProductShowDto> showProjectInfo(
            @RequestParam(value = "productId") Long productId){
        try {
            ProductShowDto productShowDto = productShowBizz.showBasicInfo(productId);
            return ServiceResponse.ok(productShowDto);
        }catch (Exception e){
            log.error("系统异常 : " + e,e.getMessage());
            return ServiceResponse.of(e.getMessage());
        }
    }

    @ApiOperation(value = "金融产品基本信息删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId",
                    value = "金融产品id", required = true,
                    dataType = "Long")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ServiceResponse<ProductDto> delete(@RequestParam(value = "id") Long id){
        try {
            bizz.deleteProduct(id);
            return ServiceResponse.ok();
        }catch (CommonBizzException e) {
            log.error("金融产品无法删除： msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品基本信息修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productDto",
                    value = "金融产品实体", required = true,
                    dataType = "ProductDto")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResponse<ProductDto> update(@RequestBody ProductDto productDto){
        try {
            bizz.updateProduct(productDto);
            return ServiceResponse.ok();
        }catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品审核状态分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productCondition",
                    value = "金融产品条件实体", required = true,
                    dataType = "ProductCondition")
    })
    @RequestMapping(value = "/find/Examine", method = RequestMethod.POST)
    public ServiceResponse<PageList<ProductDto>> findExamineStatus(
            @RequestBody ProductCondition productCondition){
        try {
            PageList<ProductDto> productDtoPageList = bizz.findExamineStatus(productCondition);
            return ServiceResponse.ok(productDtoPageList);
        }catch (Exception e){
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }


    @ApiOperation(value = "金融产品提交审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId",
                    value = "金融产品id", required = true,
                    dataType = "Long")
    })
    @RequestMapping(value = "/commitAudit", method = RequestMethod.GET)
    public ServiceResponse<ProductDto> commitAudit(@RequestParam(value = "productId") Long productId){
        try {
            bizz.commitAudit(productId);
            return ServiceResponse.ok();
        }catch (Exception e){
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品附件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile",
                    value = "上传文件", required = true,
                    dataType = "MultipartFile")
    })
    @RequestMapping(value = "/upload/one", method = RequestMethod.POST)
    public ServiceResponse<ProductDto> uploadOne(
            @RequestBody MultipartFile multipartFile){
        try {
            bizz.uploadOne(multipartFile);
            return ServiceResponse.ok();
        }catch (CommonBizzException e) {
            log.error("金融产品附件上传异常： msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品附件批量上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFiles",
                    value = "文件数组", required = true,
                    dataType = "multipartFiles")
    })
    @RequestMapping(value = "/upload/more", method = RequestMethod.POST)
    public ServiceResponse<ProductDto> uploadMore(
            @RequestBody MultipartFile[] multipartFiles){
        try {
            bizz.uploadMore(multipartFiles);
            return ServiceResponse.ok();
        }catch (CommonBizzException e) {
            log.error("金融产品附件上传异常： msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }

    @ApiOperation(value = "金融产品关联树节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId",
                    value = "金融产品id", required = true,
                    dataType = "Long"),
            @ApiImplicitParam(name = "treeId",
                    value = "产品树节点id",required = true,
                    dataType = "Long")
    })
    @RequestMapping(value = "/connectNode", method = RequestMethod.GET)
    public ServiceResponse<ProductDto> connectNode(
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "treeId") Long treeId){
        try {
            bizz.connectNode(productId,treeId);
            return ServiceResponse.ok();
        }catch (CommonBizzException e) {
            log.error("金融产品关联树节点异常： msg="+e.getMessage(),e);
            throw new CommonBizzException(e.getMessage(),e.getCause());
        } catch (Exception e) {
            log.error("系统异常" + e.getMessage(),e);
            return ServiceResponse.of(ServiceResponseEnum.SYSTEM_EXCEPTION.getCode(),
                    ServiceResponseEnum.SYSTEM_EXCEPTION.getMessage(),null);
        }
    }
}