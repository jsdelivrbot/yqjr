package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案附加信息主表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/

@Data
public class ProjectAdditionalInfoDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 金融专案id
     */
    private Long projectId;
	
    /**
     * 专案名称
     */
    private String projectName;
	
    /**
     * 附加信息id
     */
    private Long additionalInfoId;
	
    /**
     * 状态 1有效 0无效
     */
    private Long flag;
	

}
