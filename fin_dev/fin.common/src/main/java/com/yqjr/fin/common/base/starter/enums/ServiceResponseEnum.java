package com.yqjr.fin.common.base.starter.enums;

/**
 * @description: 服务响应枚举值
 * @author: lixue
 * @date: 2018/08/28 10:00:07
 **/
public enum ServiceResponseEnum {

    NAME_ALREADY_EXIST("200","该名称已存在"),
    CODE_ALREADY_EXIST("201","该代码已存在"),
    ADD_FAIL("202","添加失败"),
    UPDATE_FAIL("203","修改失败"),
    DELETE_FAIL("204","删除失败"),
    CAN_NOT_DELETE("204","该数据正在使用,不能被删除"),
    IMPORT_FAIL("205","导入失败"),
    NO_QUERY_RESULT("206","无查询结果"),
    NO_COMPANY("207","该公司不存在"),
    PARAM_ERROR("208","参数错误"),
    SYSTEM_EXCEPTION("999","系统异常")

    ;

    private String code;

    private String message;

    private ServiceResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

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
