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
* 决策树规则表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_decision_tree_rule", schema = "QCMS")
public class DecisionTreeRule extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_DECISION_TREE_RULE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 决策树模型ID
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String decisionTreeModelId;
    /**
     * 决策树id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long decisionTreeId;
    /**
     * 决策树节点id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long treeNodeId;
    /**
     * 因子编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String factorCode;
    /**
     * 因子名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String factorName;
    /**
     * 操作符
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String operator;
    /**
     * 匹配值
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String matchValue;
    /**
     * 状态 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
