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
 * @description: 金融产品审核
 * @author: lixue
 * @date: 2018/08/21 15:39:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT_AUDIT_FLOW", schema = "FPMS", catalog = "")
public class ProductAuditFlowEntity extends FinBaseMapperEntity<Long> {

    /**
     *主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT_AUDIT_FLOW.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *金融产品id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long productId;

    /**
     *审核状态编码
     */
    @Column(name = "EXAMINE_STATUS_CODE", nullable = true, precision = 0)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long examineStatusCode;

    /**
     *审核状态名称
     */
    @Column(name = "EXAMINE_STATUS_NAME", nullable = true, length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusName;

    /**
     *审核意见
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineRemark;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
