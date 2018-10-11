package com.yqjr.fin.mkmm.sales.common;

import java.io.Serializable;

public class ResultMsg<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private boolean isSuccess;
    private T result;

    /**
     * 构造方法
     */
    public ResultMsg() {
    }

    public ResultMsg(String code, String msg, boolean isSuccess, T result) {
        this.code = code;
        this.msg = msg;
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
