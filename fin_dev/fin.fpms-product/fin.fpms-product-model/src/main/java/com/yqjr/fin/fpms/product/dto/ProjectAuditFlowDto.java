package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案审核表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:20
*/

@Data
public class ProjectAuditFlowDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 金融专案id
     */
    private Long financeProjectId;
	
    /**
     * 审核状态编码 10 待审核 20 审核成功 30 驳回
     */
    private String examineStatusCode;
	
    /**
     * 审核状态名称
     */
    private String examineStatusName;
	
    /**
     * 审核意见
     */
    private String examineRemark;
	
    /**
     * 状态 1有效0无效
     */
    private Long flag;
	

}
