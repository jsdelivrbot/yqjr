package com.yqjr.fin.common.base.starter.enums;
/**
* 状态类型常量
* @Author:         zxd
* @CreateDate:     2018/9/6 10:49
*/
public enum ConstantsEnum {

    EFFECTIVE_FLAG(1L,"有效状态"),
    INVALID_FLAG(0L,"无效状态"),

    WAIT_SHELVES(5000L,"待上架"),
    ON_SHELVES(6000L,"已上架"),
    OFF_SHELVES(7000L,"已下架"),

    BEFORE_EXAMINE(1000L,"编辑"),
    IN_EXAMINE(2000L,"待审核"),
    REJECT_EXAMINE(3000L,"驳回"),
    AFTER_EXAMINE(4000L,"审核通过")
    ;
    private Long code;

    private String message;

    private ConstantsEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
