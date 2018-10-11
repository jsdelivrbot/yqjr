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
 * @description: 验证型子规则
 * @author: lixue
 * @date: 2018/08/23 13:41:09
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "REMS_VERIFY_SUBRULE", schema = "REMS")
public class VerifySubruleEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_REMS_VERIFY_SUBRULE.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 规则id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;

    /**
     *子规则编号
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer subruleNumber;

    /**
     *匹配值类型
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer matchValueType;

    /**
     *规则因子编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorCode;

    /**
     *规则因子名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorName;

    /**
     *操作符说明
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String operatorDesc;

    /**
     *操作符
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String operator;

    /**
     *匹配值
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String matchValue;

    /**
     *状态  1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

    /**
     *  规则因子id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleFactorId;


}
