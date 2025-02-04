package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 产品规则关系主表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/

@Data
public class ProductRuleDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 产品id
     */
    private Long productId;
	
    /**
     * 规则id
     */
    private Long ruleId;
	
    /**
     * 状态
     */
    private Long flag;
	

}
