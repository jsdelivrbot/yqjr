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
* 评分卡调节系数规则轨迹表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_adj_coefficient_rule_his", schema = "QCMS")
public class AdjCoefficientRuleHis extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_ADJ_COEFFICIENT_RULE_HIS.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 规则id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;
    /**
     * 规则编号 excel中规则行号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long subruleNumber;
    /**
     * 匹配值类型 0 区间类型 1 其它类型 放到codecode表
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long matchValueType;
    /**
     * 规则因子编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String factorCode;
    /**
     * 规则因子名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String factorName;
    /**
     * 操作符说明
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String operatorDesc;
    /**
     * 操作符   “=”,“!=”,“>”,“<”,“>=”,“<=”,"(",“)",[","]"
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
