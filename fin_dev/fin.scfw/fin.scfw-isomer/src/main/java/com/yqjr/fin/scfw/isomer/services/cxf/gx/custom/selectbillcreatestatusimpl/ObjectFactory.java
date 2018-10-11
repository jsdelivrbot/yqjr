
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.lang.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epoch.cc.webservice.yqjr.expense.server.selectbillcreatestatusimpl.service package. 
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

    private final static QName _SelectBillCreateStatusMethod_QNAME = new QName("http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", "selectBillCreateStatusMethod");
    private final static QName _SelectBillCreateStatusMethodResponse_QNAME = new QName("http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", "selectBillCreateStatusMethodResponse");
    private final static QName _Exception_QNAME = new QName("http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epoch.cc.webservice.yqjr.expense.server.selectbillcreatestatusimpl.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SelectBillCreateStatusMethod }
     * 
     */
    public SelectBillCreateStatusMethod createSelectBillCreateStatusMethod() {
        return new SelectBillCreateStatusMethod();
    }

    /**
     * Create an instance of {@link SelectBillCreateStatusMethodResponse }
     * 
     */
    public SelectBillCreateStatusMethodResponse createSelectBillCreateStatusMethodResponse() {
        return new SelectBillCreateStatusMethodResponse();
    }

    /**
     * Create an instance of {@link java.lang.Exception }
     * 
     */
    public java.lang.Exception createException() {
        return new java.lang.Exception();
    }

    /**
     * Create an instance of {@link RequestCommon }
     * 
     */
    public RequestCommon createRequestCommon() {
        return new RequestCommon();
    }

    /**
     * Create an instance of {@link BillStatusVO }
     * 
     */
    public BillStatusVO createBillStatusVO() {
        return new BillStatusVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectBillCreateStatusMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", name = "selectBillCreateStatusMethod")
    public JAXBElement<SelectBillCreateStatusMethod> createSelectBillCreateStatusMethod(SelectBillCreateStatusMethod value) {
        return new JAXBElement<SelectBillCreateStatusMethod>(_SelectBillCreateStatusMethod_QNAME, SelectBillCreateStatusMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectBillCreateStatusMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", name = "selectBillCreateStatusMethodResponse")
    public JAXBElement<SelectBillCreateStatusMethodResponse> createSelectBillCreateStatusMethodResponse(SelectBillCreateStatusMethodResponse value) {
        return new JAXBElement<SelectBillCreateStatusMethodResponse>(_SelectBillCreateStatusMethodResponse_QNAME, SelectBillCreateStatusMethodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/", name = "Exception")
    public JAXBElement<java.lang.Exception> createException(java.lang.Exception value) {
        return new JAXBElement<java.lang.Exception>(_Exception_QNAME, java.lang.Exception.class, null, value);
    }

}
