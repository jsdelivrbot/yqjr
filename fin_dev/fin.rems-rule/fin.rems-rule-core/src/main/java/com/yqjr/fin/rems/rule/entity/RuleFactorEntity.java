package com.yqjr.fin.rems.rule.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description: 规则因子
 * @author: lixue
 * @date: 2018/08/23 13:40:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "REMS_RULE_FACTOR", schema = "REMS")
public class RuleFactorEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_REMS_RULE_FACTOR.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *规则因子名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorName;

    /**
     *规则因子编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorCode;

    /**
     *规则因子类型id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long factorTypeId;

    /**
     *规则因子类型名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorTypeName;

    /**
     *类型属性编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeAttributeCode;

    /**
     *类型属性名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String typeAttributeName;

    /**
     *数据类型编码
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer dataTypeCode;

    /**
     *数据类型名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dataTypeName;

    /**
     *说明
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String explain;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;


}
