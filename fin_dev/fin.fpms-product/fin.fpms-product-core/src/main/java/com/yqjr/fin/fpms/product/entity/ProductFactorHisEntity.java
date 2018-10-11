package com.yqjr.fin.fpms.product.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @description: 金融产品规则因子关系实体
 * @author: lixue
 * @date: 2018/08/21 15:39:24
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT_FACTOR_HIS", schema = "FPMS")
public class ProductFactorHisEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT_FACTOR_HIS.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 产品因子关系id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long productFactorId;

    /**
     * 节点id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long nodeId;

    /**
     * 因子id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long factorId;

    /**
     * 规则因子编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String factorCode;

    /**
     * 流程id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long processId;

    /**
     * 流程名字
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String processName;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
