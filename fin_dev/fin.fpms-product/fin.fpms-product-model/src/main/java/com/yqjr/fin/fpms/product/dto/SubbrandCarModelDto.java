package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 子品牌车型关系主表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:20
*/

@Data
public class SubbrandCarModelDto extends FinBaseDto {

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
     * 子品牌编码
     */
    private String subbrandCode;
	
    /**
     * 车型编码
     */
    private String carModelCode;
	
    /**
     * 车辆V码
     */
    private String carVcdoe;
	
    /**
     * 净车指导价
     */
    private Long carPrice;
	
    /**
     * 状态 1有效0无效
     */
    private Long flag;
	

}
