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
* 政策规则关系表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_policy_rule", schema = "QCMS")
public class PolicyRule extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_POLICY_RULE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 政策id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long policyId;
    /**
     * 规则id 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;
    /**
     * 状态
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
