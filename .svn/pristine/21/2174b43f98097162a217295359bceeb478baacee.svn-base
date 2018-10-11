package com.yqjr.fin.scfw.isomer.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yqjr.fin.scfw.isomer.api.CommonStatusEnum;
import com.yqjr.fin.scfw.isomer.api.request.DynamicBillRequestModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.FyafDynamicBillServiceCommand;
import com.yqjr.fin.scfw.isomer.services.FyzlDynamicBillServiceCommand;
import com.yqjr.fin.scfw.isomer.services.IsomerDynamicBillService;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillDetailVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillMainVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.Exception_Exception;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.FyzlDynamicBillDetailVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.FyzlDynamicBillMainVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lixue
 * @date: 2018/06/08 13:47:42
 **/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "dynamicBill")
@RestController
public class DynamicBillRest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IsomerDynamicBillService service;

    @ApiOperation(value = "租赁公司事先动支单据接口")
    @RequestMapping(value = "/dynamicBill/fyzl",method = RequestMethod.POST)
    public ResponseModel fYZLDynamicBill(@RequestBody  String requestModelStr) {
        logger.info("fYZLDynamicBill start,dynamicBillMainData = " + requestModelStr);
        ResponseModel responseModel = new ResponseModel();
        try {
            DynamicBillRequestModel requestModel = JSONObject.parseObject(requestModelStr,DynamicBillRequestModel.class);
            FyzlDynamicBillMainVO fyzlDynamicBillMainVO = service.getFyzlMainVo(requestModel);
            List<FyzlDynamicBillDetailVO> paramList = service.getFyzlDetailVoList(requestModel);
            responseModel = FyzlDynamicBillServiceCommand.commandToOuterCxf(fyzlDynamicBillMainVO,paramList,service.getUrl("02"));
        }catch (MalformedURLException | Exception_Exception e){
            logger.error("调用共享平台租赁公司事先动支单据接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.REQUEST_GX_FAIL.getCode());
            responseModel.setReqMsg( CommonStatusEnum.REQUEST_GX_FAIL.getMessage());
        }catch (java.lang.Exception e){
            logger.error("租赁公司事先动支单据接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.ISOMER_FAIL.getCode());
            responseModel.setReqMsg( CommonStatusEnum.ISOMER_FAIL.getMessage());
        }

        logger.info("fYZLDynamicBill end,responseModel = " + JSONObject.toJSONString(responseModel));
        return responseModel;
    }

    @ApiOperation(value = "汽车金融事先动支单据接口")
    @RequestMapping(value = "/dynamicBill/fyaf",method = RequestMethod.POST)
    public ResponseModel fYAFDynamicBill(@RequestBody String requestModelStr) {
        logger.info("fYAFDynamicBill start,requestModelStr = " + requestModelStr);
        ResponseModel responseModel = new ResponseModel();
        try {
            DynamicBillRequestModel requestModel = JSONObject.parseObject(requestModelStr,DynamicBillRequestModel.class);
            FyafDynamicBillMainVO fyafDynamicBillMainVO = service.getFyafMainVo(requestModel);
            List<FyafDynamicBillDetailVO> paramList = service.getFyafDetailVoList(requestModel);
            responseModel = FyafDynamicBillServiceCommand.commandToOuterCxf(fyafDynamicBillMainVO,paramList,service.getUrl("01"));
        }catch (com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.Exception_Exception | MalformedURLException e){
            logger.error("调用共享平台汽车金融事先动支单据接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.REQUEST_GX_FAIL.getCode());
            responseModel.setReqMsg( CommonStatusEnum.REQUEST_GX_FAIL.getMessage());
        }catch (java.lang.Exception e){
            logger.error("汽车金融事先动支单据接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.ISOMER_FAIL.getCode());
            responseModel.setReqMsg( CommonStatusEnum.ISOMER_FAIL.getMessage());
        }
        logger.info("fYAFDynamicBill end");
        return responseModel;
    }



}
