package com.yqjr.fin.scfw.isomer.rest;


import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.*;
import com.yqjr.fin.scfw.isomer.web.Test;
import com.yqjr.fin.scfw.isomer.web.TestInterService;
import com.yqjr.fin.scfw.isomer.web.TestInterServiceImpl;
import org.apache.cxf.common.i18n.Exception;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;

import javax.validation.metadata.PropertyDescriptor;
import javax.xml.namespace.QName;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class CxfClient {
    private static final QName SERVICE_NAME = new QName("http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "FYAFDynamicBillServiceImplService");

    /**
     * 动态调用方式
     */
    public static void main(String args[]) throws Exception, MalformedURLException, Exception_Exception {
        URL wsdlURL = new URL("http://10.21.118.239:8081/cc_ws/FYAFDynamicBillService?wsdl");
        FYAFDynamicBillServiceImplService fyafDynamicBillServiceImplService = new FYAFDynamicBillServiceImplService(wsdlURL,SERVICE_NAME);
        FYAFDynamicBillService port = fyafDynamicBillServiceImplService.getFYAFDynamicBillServiceImplPort();
        FyafDynamicBillMainVO fyafDynamicBillMainVO = null;
        List<FyafDynamicBillDetailVO> fyafDynamicBillDetailVOs = null;
        Message message =    port.createBill4FYAFDynamicBillService(fyafDynamicBillMainVO,fyafDynamicBillDetailVOs);
        System.out.println(message.getStatus());


    }

}