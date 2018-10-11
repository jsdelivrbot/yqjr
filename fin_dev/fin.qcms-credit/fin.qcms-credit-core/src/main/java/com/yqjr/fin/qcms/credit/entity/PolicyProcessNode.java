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
* 政策流程节点关联表	
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_policy_process_node", schema = "QCMS")
public class PolicyProcessNode extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_POLICY_PROCESS_NODE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 政策id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long policyId;
    /**
     * 流程id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long processId;
    /**
     * 流程名字
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String processName;
    /**
     * 流程节点id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long processNodeId;
    /**
     * 流程节点名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String processNodeName;
    /**
     * 节点逻辑类型编码
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long nodeLogicalTypeCode;
    /**
     * 节点逻辑类型名称 出口、入口
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String nodeLogicalTypeName;
    /**
     * 状态 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
