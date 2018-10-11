package com.yqjr.fin.qcms.credit.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 决策树表 dto层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/

@Data
public class DecisionTreeDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 决策树模型id
     */
    private Long decisionTreeModelId;
	
    /**
     * 决策树模型编号
     */
    private java.lang.String decisionTreeModelCode;
	
    /**
     * 层级编号
     */
    private java.lang.Long levelNumber;
	
    /**
     * 是否最终节点 10 根节点 20  叶子节点
     */
    private java.lang.Long isFinalNode;
	
    /**
     * 节点描述
     */
    private java.lang.String nodeDescribition;
	
    /**
     * 父节点id
     */
    private java.lang.Integer parentId;
	
    /**
     * 是否符合父层级规则 0 是  1 否
     */
    private java.lang.Integer isConform;
	
    /**
     * 节点分数 当叶子节点时，存在值
     */
    private Long nodeScore;
	
    /**
     * 状态 0 正常状态 -1 删除
     */
    private Integer flag;
	

}
