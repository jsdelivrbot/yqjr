package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 评分子项表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/

@Data
public class ScoreSubitemDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 评分模型id
     */
    private Long scoreModelId;
	
    /**
     * 评分大项id
     */
    private Long scoreMajorTermId;
	
    /**
     * 顺序号
     */
    private Long sequenceNumber;
	
    /**
     * 评分子项名称
     */
    private java.lang.String scoreSubitemName;
	
    /**
     * 说明
     */
    private java.lang.String remark;
	
    /**
     * 状态
     */
    private Integer flag;
	
    /**
     * 单位
     */
    private java.lang.String unit;
	

}
