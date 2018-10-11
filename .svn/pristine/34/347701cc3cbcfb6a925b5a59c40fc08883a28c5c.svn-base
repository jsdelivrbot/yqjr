package com.yqjr.fin.scfw.isomer.services;

import com.yqjr.fin.scfw.isomer.api.CommonStatusEnum;
import com.yqjr.fin.scfw.isomer.api.response.BillStatusResDetailModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseDetailModel;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.Message;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.BillStatusVO;
import com.yqjr.scfw.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description: 将共享返回值转换成我方返回值
 * @author: lixue
 * @date: 2018/06/09 14:32:41
 **/
public class CommonTools {

    private static Logger logger = LoggerFactory.getLogger(CommonTools.class.getName());

    /**
     * 金融公司事先动支单据接口返回值转换成我方返回值
     */
    public static ResponseModel fayfTransToOurRes(Message fyafMessage){
        logger.info("fayfTransToOurRes start");
        ResponseModel responseModel = new ResponseModel();
        responseModel = transToOurRes(fyafMessage.getStatus(),fyafMessage.getMessage(),responseModel);
        ResponseDetailModel responseDetailModel = new ResponseDetailModel();
        responseDetailModel.setExternalReferenceNo(fyafMessage.getExternalReferenceNo());
        responseDetailModel.setMsgRef(fyafMessage.getMsgRef());
        responseModel.setData(responseDetailModel);
        logger.info("fayfTransToOurRes end");
        return  responseModel;
    }

    /**
     * 租赁公司事先动支单据接口返回值转换成我方返回值
     */
    public static ResponseModel fyzlTransToOurRes(com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.Message fyzlMessage){
        logger.info("fyzlTransToOurRes start");
        ResponseModel responseModel = new ResponseModel();
        responseModel = transToOurRes(fyzlMessage.getStatus(),fyzlMessage.getMessage(),responseModel);
        ResponseDetailModel responseDetailModel = new ResponseDetailModel();
        responseDetailModel.setExternalReferenceNo(fyzlMessage.getExternalReferenceNo());
        responseDetailModel.setMsgRef(fyzlMessage.getMsgRef());
        responseModel.setData(responseDetailModel);
        logger.info("fyzlTransToOurRes end");
        return  responseModel;
    }

    /**
     * 将共享状态查询接口返回值转换成我方返回值
     */
    public static ResponseModel billStatusTransToOur(List<BillStatusVO> list){
        logger.info("billStatusTransToOur start");
        ResponseModel responseModel = new ResponseModel();
        if(null == list || list.size() <= 0 || null == list.get(0)){
            responseModel.setReqCode(CommonStatusEnum.GX_RETURN_NULL.getCode());
            responseModel.setReqMsg(CommonStatusEnum.GX_RETURN_NULL.getMessage());
            return responseModel;
        }
        responseModel.setReqCode(CommonStatusEnum.SUCCESS.getCode());
        responseModel.setReqMsg(CommonStatusEnum.SUCCESS.getMessage());

        BillStatusResDetailModel resDetailModel = new BillStatusResDetailModel();
        resDetailModel.setSerialNo(list.get(0).getExternalReferenceNo());
        resDetailModel.setBillStatus(transToOurStatus(list.get(0).getState()));
        responseModel.setData(resDetailModel);
        logger.info("fyzlTransToOurRes start");
        return  responseModel;
    }


    /**
     * 将共享平台返回的状态码、失败信息转成异构定义的 目前汽车金融和租赁公司返回的相同 共用一个方法
     */
    private static ResponseModel transToOurRes(String status,String failMsg,ResponseModel responseModel){
        String reqCode = "";
        String reqMessage = "";
        if("recS".equals(status)){
            reqCode = CommonStatusEnum.SUCCESS.getCode();
            reqMessage = CommonStatusEnum.SUCCESS.getMessage();
        }
        //失败
        if("recF".equals(status)){
            reqCode = CommonStatusEnum.GX_RECEIVE_FAIL.getCode();
            reqMessage = CommonStatusEnum.GX_RECEIVE_FAIL.getMessage() + "," + failMsg;
        }
        responseModel.setReqCode(reqCode);
        responseModel.setReqMsg(reqMessage);
        return responseModel;
    }

    /**
     * 将共享状态查询接口返回值中的状态字段转换成我方返回值
     */
    private static String transToOurStatus(String resStatus){
        String status = "";
        if(StringUtils.isBlank(resStatus)){
            return status;
        }
        if("21".equals(resStatus)){
            status = CommonStatusEnum.DYNAMIC_BILL_END.getCode();
        }else if("22".equals(resStatus)){
            status = CommonStatusEnum.RETURN_HANDEL.getCode();
        }else {
            status = CommonStatusEnum.MIDDEL_STATUS.getCode();
        }
        return status;
    }

}
