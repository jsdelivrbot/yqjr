package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案经销商表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:20
*/

@Data
public class ProjectDealerDto extends FinBaseDto {

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
     * 区域编码
     */
    private String areaCode;
	
    /**
     * 经销商编码
     */
    private String dealerCode;
	
    /**
     * 状态 1有效0无效
     */
    private Long flag;
	

}
