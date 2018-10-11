package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 决策树模型审核表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/

@Data
public class DecisionTreeAuditFlowDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 决策树模型id
     */
    private Long decisionTreeId;
	
    /**
     * 审核状态编码 10 审核中 20 审核成功 30 驳回
     */
    private java.lang.Long examineStatusCode;
	
    /**
     * 审核状态名称
     */
    private java.lang.String examineStatusName;
	
    /**
     * 审核意见
     */
    private java.lang.String examineRemark;
	
    /**
     * 状态 1 有效 0无效
     */
    private Integer flag;
	

}
