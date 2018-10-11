package com.yqjr.fin.scfw.isomer.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



/**
 * 2.1.	状态查询接口
 * Created by THINK on 2018/6/8.
 */

public class BillStatusSelectServiceCommand {

    private static final QName SERVICE_NAME = new QName("http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", "SelectBillCreateStatusServiceImplService");

    private static Logger logger = LoggerFactory.getLogger(BillStatusSelectServiceCommand.class.getName());


    /**
     * 调用共享平台查询状态
     */
    public static ResponseModel commandToOuterCxf(RequestCommon requestCommon, List<BillStatusVO> billStatusVOS,String url) throws Exception_Exception, MalformedURLException {
        logger.info("状态查询接口调用共享平台开始，requestCommon = " + JSONObject.toJSONString(requestCommon, SerializerFeature.WriteMapNullValue) +",list = " + JSONObject.toJSONString(billStatusVOS, SerializerFeature.WriteMapNullValue) + ",url = " + url);
        URL wsdlURL = new URL(url);
        SelectBillCreateStatusServiceImplService billStatusSelectService = new SelectBillCreateStatusServiceImplService(wsdlURL, SERVICE_NAME);
        SelectBillCreateStatusService port = billStatusSelectService.getSelectBillCreateStatusServiceImplPort();
        List<BillStatusVO> list = port.selectBillCreateStatusMethod(requestCommon, billStatusVOS);
        logger.info("状态查询接口调用共享平台结束，返回值：" + JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue) );
        return CommonTools.billStatusTransToOur(list);

    }

    /*@Override
    public String commandToOuteHttp() {
        return null;
    }

    @Override
    public String commandToOuteRest() {
        return null;
    }*/




}
