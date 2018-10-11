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
* 评分卡模型验证表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_score_model_verify", schema = "QCMS")
public class ScoreModelVerify extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_SCORE_MODEL_VERIFY.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分卡模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 评分卡模型编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreModelCode;
    /**
     * 评分卡模型名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreModelName;
    /**
     * 规则id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;
    /**
     * 规则编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String ruleCode;
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
