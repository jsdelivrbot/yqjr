package com.yqjr.fin.common.base.starter.enums;

/**
 * @description: 业务枚举值
 * @author: lixue
 * @date: 2018/08/28 10:00:07
 **/
public enum BusinessEnum {
    //公共模块
    FIN_COMPANY("1","金融公司"),
    RENT_COMPANY("2","租赁公司"),
    EFFECTIVE_FLAG("1","有效状态"),
    INVALID_FLAG("0","无效状态"),

    //规则因子模块
    COMMON_TYPE_ATTRIBUTE("0","公共类型属性"),
    FIN_TYPE_ATTRIBUTE("1","金融类型属性"),
    RENT_TYPE_ATTRIBUTE("2","租赁类型属性"),

    // 产品树模块
    ROOT_NODE_LEVEL_NUMBER("1","根节点层级编号"),
    FINAL_NODE("10","是最终节点"),
    NOT_FINAL_NODE("20","不是最终节点"),
    BUTTON_ADD_NODE("10","添加子节点"),
    BUTTON_DEL_NODE("20","删除子节点"),
    BUTTON_ADD_DEL_NODE("30","添加子节点、删除子节点")
    ;

    private String code;

    private String name;

    private BusinessEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
