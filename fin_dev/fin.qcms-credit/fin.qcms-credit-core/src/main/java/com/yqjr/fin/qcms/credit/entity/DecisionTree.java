package com.yqjr.fin.qcms.credit.entity;

import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 决策树表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_decision_tree", schema = "QCMS")
public class DecisionTree extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_DECISION_TREE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 决策树模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long decisionTreeModelId;
    /**
     * 决策树模型编号
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String decisionTreeModelCode;
    /**
     * 层级编号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long levelNumber;
    /**
     * 是否最终节点 10 根节点 20  叶子节点
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long isFinalNode;
    /**
     * 节点描述
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
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
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long nodeScore;
    /**
     * 状态 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
