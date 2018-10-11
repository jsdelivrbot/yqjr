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

/**
 * @description: 金融专案附加信息关系
 * @author: lixue
 * @date: 2018/08/21 15:39:08
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS _PROJECT_ADDITIONAL_INFO", schema = "FPMS", catalog = "")
public class ProjectAdditionalInfoEntity extends FinBaseMapperEntity<Long> {

    /**
     *主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_ADDITIONAL_INFO.nextval from dual", order = ORDER.BEFORE)
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
     *附加信息id
     */
    @Column(name = "ADDITIONAL_INFO_ID")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long additionalInfoId;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
