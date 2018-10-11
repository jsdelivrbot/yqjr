package com.yqjr.fin.scfw.isomer.rest;

import com.alibaba.fastjson.JSONObject;
import com.yqjr.fin.scfw.isomer.api.CommonStatusEnum;
import com.yqjr.fin.scfw.isomer.api.request.DynamicBillRequestModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.BillStatusSelectServiceCommand;
import com.yqjr.fin.scfw.isomer.services.IsomerDynamicBillService;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.BillStatusVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.Exception_Exception;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.RequestCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;


/**
 * @description: 状态查询接口
 * @author: lixue
 * @date: 2018/06/08 13:46:56
 **/
@RestController
public class SelectBillStatusRest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IsomerDynamicBillService isomerService;

    @RequestMapping(value = "/dynamicBill/status/query",method = RequestMethod.POST)
    public ResponseModel billStatusSelect(@RequestBody  String requestModelStr) {
        logger.info("billStatusSelect start,requestModelStr = " + requestModelStr );
        ResponseModel responseModel = new ResponseModel();
        try {
            DynamicBillRequestModel requestModel = JSONObject.parseObject(requestModelStr,DynamicBillRequestModel.class);
            RequestCommon requestCommon = isomerService.getBillStatusRequest(requestModel);
            List<BillStatusVO> paramList = isomerService.getBillStatusVoList(requestModel);
            responseModel = BillStatusSelectServiceCommand.commandToOuterCxf(requestCommon,paramList,isomerService.getUrl("03"));
        }catch (MalformedURLException | Exception_Exception e){
            logger.error("调用共享平台账单状态查询接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.REQUEST_GX_FAIL.getCode());
            responseModel.setReqMsg( CommonStatusEnum.REQUEST_GX_FAIL.getMessage());
        }catch (java.lang.Exception e){
            logger.error("状态查询接口异常，message= " + e.getMessage(),e);
            responseModel.setReqCode(CommonStatusEnum.ISOMER_FAIL.getCode());
            responseModel.setReqMsg(CommonStatusEnum.ISOMER_FAIL.getMessage());
        }
        logger.info("billStatusSelect end,responseModel = " + JSONObject.toJSONString(responseModel));
        return responseModel;
    }
}
