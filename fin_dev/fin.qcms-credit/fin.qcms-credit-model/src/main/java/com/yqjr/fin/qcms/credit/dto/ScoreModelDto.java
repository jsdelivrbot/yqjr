package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;

import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 评分模型主表	 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/

@Data
public class ScoreModelDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 模型名称
     */
    private java.lang.String modelName;
	
    /**
     * 生效日期
     */
    private java.util.Date effectiveDate;
	
    /**
     * 备注信息
     */
    private java.lang.String remark;
	
    /**
     * 模型状态编码 5000、6000、7000
     */
    private java.lang.Long modelStatusCode;
	
    /**
     * 模型状态名称 待上架、已上架、已下架
     */
    private java.lang.String modelStatusName;
	
    /**
     * 审核状态编码 1000、2000、3000、4000
     */
    private java.lang.Long examineStatusCode;
	
    /**
     * 审核状态名称 编辑、待审核、审核通过、驳回
     */
    private java.lang.String examineStatusName;
	
    /**
     * 审核id
     */
    private Long auditFlowId;
	
    /**
     * 公司
     */
    private java.lang.Long company;
	
    /**
     * 公司名称
     */
    private java.lang.String companyName;
	
    /**
     * 业务条线
     */
    private java.lang.Long businessLine;
	
    /**
     * 状态 0 正常状态 -1 删除
     */
    private Integer flag;
	

}
