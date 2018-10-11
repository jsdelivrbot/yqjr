package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案附加信息表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:18
*/

@Data
public class AdditionalInfoDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 附加信息名称
     */
    private String name;
	
    /**
     * 数据类型 string、int、money、dictionary
     */
    private String dataType;
	
    /**
     * 是否必填
     */
    private String isNecessary;
	
    /**
     * 页面元素类型
     */
    private String pageElementType;
	
    /**
     * 单选框取值
     */
    private String selectValue;
	
    /**
     * 状态 1 有效 0无效
     */
    private Long flag;
	

}
