
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.9
 * 2018-06-07T15:04:56.747+08:00
 * Generated source version: 3.1.9
 */

@WebFault(name = "Exception", targetNamespace = "http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/")
public class Exception_Exception extends java.lang.Exception {
    
    private com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.Exception getFaultInfo() {
        return this.exception;
    }
}
