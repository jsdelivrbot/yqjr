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
 * @description: 金融专案法律文本关系
 * @author: lixue
 * @date: 2018/08/22 09:14:04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS _PROJECT_LAW_DOC", schema = "FPMS")
public class ProjectLawDocEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PROJECT_LAW_DOC.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 金融专案id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long projectId;

    /**
     * 金融专案名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String projectName;

    /**
     * 法律文本id
     */
    @Column(name = "NLAW_DOC_ID")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long nlawDocId;

    /**
     * 法律文本名称
     */
    @Column(name = "NLAW_DOC_NAME", length = 512)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nlawDocName;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
