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
* 决策树模型审核表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_decision_tree_audit_flow", schema = "QCMS")
public class DecisionTreeAuditFlow extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_DECISION_TREE_AUDIT_FLOW.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 决策树模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long decisionTreeId;
    /**
     * 审核状态编码 10 审核中 20 审核成功 30 驳回
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long examineStatusCode;
    /**
     * 审核状态名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String examineStatusName;
    /**
     * 审核意见
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String examineRemark;
    /**
     * 状态 1 有效 0无效
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
