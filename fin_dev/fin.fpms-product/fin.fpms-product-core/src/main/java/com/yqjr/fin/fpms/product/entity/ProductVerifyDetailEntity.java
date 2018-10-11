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
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description: 金融产品验证详情
 * @author: lixue
 * @date: 2018/08/22 09:14:08
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT_VERIFY_DETAIL", schema = "FPMS")
public class ProductVerifyDetailEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT_VERIFY_DETAIL.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 金融产品id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long productId;

    /**
     * 批次号
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String batchtNumber;

    /**
     * 申请编号
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long applyNumber;

    /**
     * 主键id
     */
    @Column(name = "BUSINESS_VERIFY_DATA", length = 512)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String businessVerifyData;

    /**
     * 验证结果
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String verifyResult;

    /**
     * 状态 1有效 0无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
