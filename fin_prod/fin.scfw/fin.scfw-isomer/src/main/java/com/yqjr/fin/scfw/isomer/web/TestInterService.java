package com.yqjr.fin.scfw.isomer.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by THINK on 2018/6/6.
 */
@WebService(targetNamespace="http://com.yqjr.fin.scfw.isomer.web/",name = "TestInterService")
public interface TestInterService {
    @WebMethod
    public String getName(@WebParam(name = "userId") Test userId);

}
