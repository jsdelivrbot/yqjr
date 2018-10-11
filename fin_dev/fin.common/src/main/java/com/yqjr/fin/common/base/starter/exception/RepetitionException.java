package com.yqjr.fin.common.base.starter.exception;

import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;

public class RepetitionException extends CommonBizzException {
    private String code;

    public RepetitionException(ServiceResponseEnum serviceResponseEnum) {
        super(serviceResponseEnum);
        this.code = serviceResponseEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
