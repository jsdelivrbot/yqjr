package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 特征值表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/

@Data
public class EigenvalueDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 评分模型id
     */
    private Long scoreModelId;
	
    /**
     * 评分模型编码
     */
    private java.lang.String scoreModelCode;
	
    /**
     * 评分大项id
     */
    private Long scoreMajorTermId;
	
    /**
     * 评分大项编码
     */
    private java.lang.String scoreMajorTermCode;
	
    /**
     * 评分子项编码
     */
    private java.lang.String scoreSubitemCode;
	
    /**
     * 评分子项id
     */
    private java.lang.Long scoreSubitemId;
	
    /**
     * 顺序号
     */
    private Long sequenceNumber;
	
    /**
     * 规则因子编码
     */
    private java.lang.String ruleFactorCode;
	
    /**
     * 规则因子名称
     */
    private java.lang.String ruleFactorName;
	
    /**
     * 逻辑类型编码
     */
    private Long logicTypeCode;
	
    /**
     * 逻辑类型名字
     */
    private java.lang.Long logicTypeName;
	
    /**
     * 匹配值
     */
    private java.lang.String matchValue;
	
    /**
     * 分数
     */
    private Long score;
	
    /**
     * 状态0 正常状态 -1 删除
     */
    private Integer flag;
	

}
