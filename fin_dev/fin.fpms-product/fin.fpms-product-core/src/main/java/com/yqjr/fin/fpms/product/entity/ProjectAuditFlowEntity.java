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
 * @description: 金融专案审核
 * @author: lixue
 * @date: 2018/08/22 09:14:10
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PROJECT_AUDIT_FLOW", schema = "FPMS")
public class ProjectAuditFlowEntity extends FinBaseMapperEntity<Long> {

    /**
     *主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PROJECT_AUDIT_FLOW.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *金融专案id
     */
    @Column(name = "FINANCE_PROJECT_ID")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long financeProjectId;

    /**
     *审核状态编码
     */
    @Column(name = "EXAMINE_STATUS_CODE",  length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusCode;

    /**
     *审核状态名称
     */
    @Column(name = "EXAMINE_STATUS_NAME",  length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusName;

    /**
     *审核意见
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineRemark;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
