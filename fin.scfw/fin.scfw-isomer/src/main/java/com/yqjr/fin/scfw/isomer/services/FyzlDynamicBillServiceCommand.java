package com.yqjr.fin.scfw.isomer.services;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2.2.	租赁公司事先动支单据接口
 * Created by THINK on 2018/6/8.
 */
public class FyzlDynamicBillServiceCommand {

    private static final QName SERVICE_NAME = new QName("http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "FYZLDynamicBillServiceImplService");

    private static Logger logger = LoggerFactory.getLogger(FyzlDynamicBillServiceCommand.class.getName());


    /**
     * 租赁公司调用共享事先动支单据接口
     */
    public static ResponseModel commandToOuterCxf(FyzlDynamicBillMainVO fyzlDynamicBillMainVO, List<FyzlDynamicBillDetailVO> fyzlDynamicBillDetailVOS,String url) throws MalformedURLException, Exception_Exception{
        logger.info(" 租赁公司调用共享开始,fyzlDynamicBillMainVO = " + JSONObject.toJSONString(fyzlDynamicBillMainVO, SerializerFeature.WriteMapNullValue) +",details = " + JSONObject.toJSONString(fyzlDynamicBillDetailVOS, SerializerFeature.WriteMapNullValue) +",url = " + url);
        URL wsdlURL = new URL(url);
        FYZLDynamicBillServiceImplService fyzlDynamicBillServiceImplService = new FYZLDynamicBillServiceImplService(wsdlURL, SERVICE_NAME);
        FYZLDynamicBillService port = fyzlDynamicBillServiceImplService.getFYZLDynamicBillServiceImplPort();
        Message message = port.createBill4FYZLDynamicBillService(fyzlDynamicBillMainVO, fyzlDynamicBillDetailVOS);
        logger.info("租赁公司调用共享结束, message = " + JSONObject.toJSONString(message, SerializerFeature.WriteMapNullValue));
        return CommonTools.fyzlTransToOurRes(message);

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
