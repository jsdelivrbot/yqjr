
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2018-06-07T15:07:00.963+08:00
 * Generated source version: 3.1.9
 * 
 */
public final class FYAFDynamicBillService_FYAFDynamicBillServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "FYAFDynamicBillServiceImplService");

    private FYAFDynamicBillService_FYAFDynamicBillServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = FYAFDynamicBillServiceImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        FYAFDynamicBillServiceImplService ss = new FYAFDynamicBillServiceImplService(wsdlURL, SERVICE_NAME);
        FYAFDynamicBillService port = ss.getFYAFDynamicBillServiceImplPort();  
        
        {
        System.out.println("Invoking createBill4FYAFDynamicBillService...");
        com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillMainVO _createBill4FYAFDynamicBillService_mainVO = null;
        java.util.List<com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillDetailVO> _createBill4FYAFDynamicBillService_detailVOList = null;
        try {
            com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.Message _createBill4FYAFDynamicBillService__return = port.createBill4FYAFDynamicBillService(_createBill4FYAFDynamicBillService_mainVO, _createBill4FYAFDynamicBillService_detailVOList);
            System.out.println("createBill4FYAFDynamicBillService.result=" + _createBill4FYAFDynamicBillService__return);

        } catch (Exception_Exception e) { 
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
