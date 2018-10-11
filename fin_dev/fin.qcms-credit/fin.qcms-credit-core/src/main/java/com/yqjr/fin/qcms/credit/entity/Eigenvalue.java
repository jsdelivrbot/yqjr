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
* 特征值表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_eigenvalue", schema = "QCMS")
public class Eigenvalue extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_EIGENVALUE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 评分模型编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreModelCode;
    /**
     * 评分大项id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreMajorTermId;
    /**
     * 评分大项编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreMajorTermCode;
    /**
     * 评分子项编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreSubitemCode;
    /**
     * 评分子项id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long scoreSubitemId;
    /**
     * 顺序号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long sequenceNumber;
    /**
     * 规则因子编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String ruleFactorCode;
    /**
     * 规则因子名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String ruleFactorName;
    /**
     * 逻辑类型编码
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long logicTypeCode;
    /**
     * 逻辑类型名字
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long logicTypeName;
    /**
     * 匹配值
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String matchValue;
    /**
     * 分数
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long score;
    /**
     * 状态0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
