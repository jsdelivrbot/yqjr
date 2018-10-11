package com.yqjr.fin.common.base.starter.exception;

import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;

public class ModelIncompleteException extends  CommonBizzException {
    private String code;

    public ModelIncompleteException(ServiceResponseEnum serviceResponseEnum) {
        super(serviceResponseEnum);
        this.code = serviceResponseEnum.getCode();
    }
    public ModelIncompleteException(String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
