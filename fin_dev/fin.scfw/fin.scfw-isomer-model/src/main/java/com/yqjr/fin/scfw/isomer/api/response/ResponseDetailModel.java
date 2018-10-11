package com.yqjr.fin.scfw.isomer.api.response;

import java.util.List;

/**
 * @description: 事先动支接口返回结果对象
 * @author: lixue
 * @date: 2018/06/08 16:10:10
 **/
public class ResponseDetailModel {

    //业务流水号
    private String msgRef;

    //通讯流水号
    private String externalReferenceNo;

    public String getMsgRef() {
        return msgRef;
    }

    public void setMsgRef(String msgRef) {
        this.msgRef = msgRef;
    }

    public String getExternalReferenceNo() {
        return externalReferenceNo;
    }

    public void setExternalReferenceNo(String externalReferenceNo) {
        this.externalReferenceNo = externalReferenceNo;
    }
}
