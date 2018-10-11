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
import java.math.BigDecimal;
/**
 * @description: 子品牌车型关系
 * @author: lixue
 * @date: 2018/08/22 09:43:31
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_SUBBRAND_CAR_MODEL", schema = "FPMS")
public class SubbrandCarModelEntity extends FinBaseMapperEntity<Long> {

    /**
     *主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_SUBBRAND_CAR_MODEL.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *金融专案id
     */
    @Column(name = "FINANCE_PROJECT_ID")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long financeProjectId;

    /**
     *子品牌编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String subbrandCode;

    /**
     *车型编码
     */
    @Column(name = "CAR_MODEL_CODE", length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String carModelCode;

    /**
     *车辆V码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String carVcdoe;

    /**
     *净车指导价
     */
    @ColumnType(jdbcType = JdbcType.NUMERIC)
    private BigDecimal carPrice;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;
}
