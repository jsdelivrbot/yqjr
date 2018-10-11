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
* 决策树模型验证表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_decision_tree_verify", schema = "QCMS")
public class DecisionTreeVerify extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_DECISION_TREE_VERIFY.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 决策树模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long decisionTreeModelId;
    /**
     * 决策树模型名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String decisionTreeModelName;
    /**
     * 规则id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;
    /**
     * 批次号
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String batchNumber;
    /**
     * 状态 1 有效 0无效
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
