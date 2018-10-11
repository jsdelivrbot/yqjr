package com.yqjr.fin.scfw.isomer.api;

/**
 * @description: 销管系统和异构交互返回值枚举
 * @author: lixue
 * @date: 2018/06/13 09:49:23
 **/
public enum CommonStatusEnum {

    // 账销管系统和异构交互  接口状态枚举
    SUCCESS("100","请求成功"),

    ISOMER_FAIL("101","异构平台系统异常"),

    REQUEST_GX_FAIL("102","调用共享平台异常"),

    GX_RECEIVE_FAIL("103","共享平台接收失败"),

    GX_RETURN_NULL("104","共享平台返回空值"),

    // 账单状态查询接口，返回的账单状态枚举
    DYNAMIC_BILL_END("201","已动支"),
    RETURN_HANDEL("202","打回处理"),
    MIDDEL_STATUS("203","中间状态")
    ;

    private CommonStatusEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

