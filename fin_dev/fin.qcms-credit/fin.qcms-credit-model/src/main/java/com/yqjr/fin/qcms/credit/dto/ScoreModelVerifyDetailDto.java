package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 评分卡模型验证详情主表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/

@Data
public class ScoreModelVerifyDetailDto extends FinBaseDto {

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
     * 批次号
     */
    private java.lang.String batchtNumber;
	
    /**
     * 申请编号
     */
    private Long applyNumber;
	
    /**
     * 业务验证数据
     */
    private java.lang.String businessVerifyData;
	
    /**
     * 验证结果
     */
    private java.lang.String verifyResult;
	
    /**
     * 状态 1 有效 0无效
     */
    private Integer flag;
	

}
