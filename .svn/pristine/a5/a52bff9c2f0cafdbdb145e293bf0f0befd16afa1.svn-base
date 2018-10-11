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
* 评分卡调节系数表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_adjust_coefficient", schema = "QCMS")
public class AdjustCoefficient extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 主键
     */
	@Id
	@KeySql(sql = "select SEQ_ADJ_COEFFICIENT_RULE.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 调节系数
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long adjustCoefficient;
    /**
     * 规则id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;
    /**
     * 状态  0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
