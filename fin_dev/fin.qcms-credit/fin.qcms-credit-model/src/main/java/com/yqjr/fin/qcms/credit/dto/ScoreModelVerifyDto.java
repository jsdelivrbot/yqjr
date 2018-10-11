package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 评分卡模型验证表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/

@Data
public class ScoreModelVerifyDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 评分卡模型id
     */
    private Long scoreModelId;
	
    /**
     * 评分卡模型编码
     */
    private java.lang.String scoreModelCode;
	
    /**
     * 评分卡模型名称
     */
    private java.lang.String scoreModelName;
	
    /**
     * 规则id
     */
    private Long ruleId;
	
    /**
     * 规则编码
     */
    private java.lang.String ruleCode;
	
    /**
     * 批次号
     */
    private java.lang.String batchNumber;
	
    /**
     * 状态 1 有效 0无效
     */
    private Integer flag;
	

}
