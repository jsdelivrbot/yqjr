package com.yqjr.fin.rems.rule.dto;

import lombok.Data;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;


/**
* 赋值型子规则表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:32
*/

@Data
public class AssignSubruleDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 规则id
     */
    private Long ruleId;
	
    /**
     * 子规则编号 excel中规则行号
     */
    private Long subruleNumber;
	
    /**
     * 匹配值类型  0 区间类型 1 其它类型 放到codecode表
     */
    private Long matchValueType;
	
    /**
     * 因子类型
     */
    private Long factorType;
	
    /**
     * 规则因子编码
     */
    private String factorCode;
	
    /**
     * 规则因子名称
     */
    private String factorName;
	
    /**
     * 操作符说明
     */
    private String operatorDesc;
	
    /**
     * 操作符  “=”,“!=”,“>”,“<”,“>=”,“<=”,"(",“)",[","]" 当因子类型为输出时，操作符为”=“
     */
    private String operator;
	
    /**
     * 匹配值
     */
    private String matchValue;
	
    /**
     * 状态 1有效0无效
     */
    private Integer flag;

    /**
     *  规则因子id
     */
    private Long ruleFactorId;



}
