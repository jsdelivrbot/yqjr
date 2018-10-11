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
 * @description: 金融专案经销商关系
 * @author: lixue
 * @date: 2018/08/22 09:14:12
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PROJECT_DEALER", schema = "FPMS")
public class ProjectDealerEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PROJECT_DEALER.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 金融专案id
     */
    @Column(name = "FINANCE_PROJECT_ID", nullable = true, precision = 0)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long financeProjectId;

    /**
     * 区域编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String areaCode;

    /**
     * 经销商编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dealerCode;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
