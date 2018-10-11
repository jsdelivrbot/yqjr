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
 * @description: 金融专案验证
 * @author: lixue
 * @date: 2018/08/22 09:14:13
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PROJECT_VERIFY", schema = "FPMS")
public class ProjectVerifyEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PROJECT_VERIFY.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *金融专案id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long projectId;

    /**
     *金融专案名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String projectName;

    /**
     *规则id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long ruleId;

    /**
     *批次号
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String batchNumber;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
