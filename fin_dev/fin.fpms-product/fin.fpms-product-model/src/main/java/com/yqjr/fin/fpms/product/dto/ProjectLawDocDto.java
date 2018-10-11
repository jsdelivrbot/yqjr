package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案法律文本关系表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:20
*/

@Data
public class ProjectLawDocDto extends FinBaseDto {

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
     * 法律文本id
     */
    private Long nlawDocId;
	
    /**
     * 法律文本名称
     */
    private String nlawDocName;
	
    /**
     * 状态
     */
    private Long flag;
	

}
