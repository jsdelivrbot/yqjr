package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融产品审核表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/

@Data
public class ProductAuditFlowDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 金融产品id
     */
    private Long productId;
	
    /**
     * 审核状态编码  10 审核中 20 审核成功 30 驳回
     */
    private Long examineStatusCode;
	
    /**
     * 审核状态名称
     */
    private String examineStatusName;
	
    /**
     * 审核意见
     */
    private String examineRemark;
	
    /**
     * 1 有效 0无效
     */
    private Long flag;
	

}
