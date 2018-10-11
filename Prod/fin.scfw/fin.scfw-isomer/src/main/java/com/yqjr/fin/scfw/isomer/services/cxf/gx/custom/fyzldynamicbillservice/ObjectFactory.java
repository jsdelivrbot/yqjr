
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.lang.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epoch.cc.webservice.yqjr.charge.server.fyzldynamicbillservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateBill4FYZLDynamicBillService_QNAME = new QName("http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "createBill4FYZLDynamicBillService");
    private final static QName _CreateBill4FYZLDynamicBillServiceResponse_QNAME = new QName("http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "createBill4FYZLDynamicBillServiceResponse");
    private final static QName _Exception_QNAME = new QName("http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epoch.cc.webservice.yqjr.charge.server.fyzldynamicbillservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateBill4FYZLDynamicBillService }
     * 
     */
    public CreateBill4FYZLDynamicBillService createCreateBill4FYZLDynamicBillService() {
        return new CreateBill4FYZLDynamicBillService();
    }

    /**
     * Create an instance of {@link CreateBill4FYZLDynamicBillServiceResponse }
     * 
     */
    public CreateBill4FYZLDynamicBillServiceResponse createCreateBill4FYZLDynamicBillServiceResponse() {
        return new CreateBill4FYZLDynamicBillServiceResponse();
    }

    /**
     * Create an instance of {@link java.lang.Exception }
     * 
     */
    public java.lang.Exception createException() {
        return new java.lang.Exception();
    }

    /**
     * Create an instance of {@link FyzlDynamicBillMainVO }
     * 
     */
    public FyzlDynamicBillMainVO createFyzlDynamicBillMainVO() {
        return new FyzlDynamicBillMainVO();
    }

    /**
     * Create an instance of {@link RequestCommon }
     * 
     */
    public RequestCommon createRequestCommon() {
        return new RequestCommon();
    }

    /**
     * Create an instance of {@link FyzlDynamicBillDetailVO }
     * 
     */
    public FyzlDynamicBillDetailVO createFyzlDynamicBillDetailVO() {
        return new FyzlDynamicBillDetailVO();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBill4FYZLDynamicBillService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", name = "createBill4FYZLDynamicBillService")
    public JAXBElement<CreateBill4FYZLDynamicBillService> createCreateBill4FYZLDynamicBillService(CreateBill4FYZLDynamicBillService value) {
        return new JAXBElement<CreateBill4FYZLDynamicBillService>(_CreateBill4FYZLDynamicBillService_QNAME, CreateBill4FYZLDynamicBillService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBill4FYZLDynamicBillServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", name = "createBill4FYZLDynamicBillServiceResponse")
    public JAXBElement<CreateBill4FYZLDynamicBillServiceResponse> createCreateBill4FYZLDynamicBillServiceResponse(CreateBill4FYZLDynamicBillServiceResponse value) {
        return new JAXBElement<CreateBill4FYZLDynamicBillServiceResponse>(_CreateBill4FYZLDynamicBillServiceResponse_QNAME, CreateBill4FYZLDynamicBillServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/", name = "Exception")
    public JAXBElement<java.lang.Exception> createException(java.lang.Exception value) {
        return new JAXBElement<java.lang.Exception>(_Exception_QNAME, java.lang.Exception.class, null, value);
    }

}
