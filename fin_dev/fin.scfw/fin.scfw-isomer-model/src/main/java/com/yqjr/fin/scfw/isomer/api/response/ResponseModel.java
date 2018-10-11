package com.yqjr.fin.scfw.isomer.api.response;

import java.util.List;

/**
 * @description: 返回结果对象
 * @author: lixue
 * @date: 2018/06/08 16:10:10
 **/
public class ResponseModel {

    private String reqCode;

    private String reqMsg;

    private Object data;

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }

    public Object getData() { return data; }

    public void setData(Object data) {
        this.data = data;
    }
}
