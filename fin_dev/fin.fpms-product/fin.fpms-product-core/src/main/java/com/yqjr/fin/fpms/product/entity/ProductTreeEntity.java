package com.yqjr.fin.fpms.product.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @description: 产品树
 * @author: lixue
 * @date: 2018/08/21 15:39:26
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT_TREE", schema = "FPMS")
public class ProductTreeEntity extends FinBaseMapperEntity<Long> {
    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT_TREE.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 节点名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nodeName;

    /**
     * 层级编号
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long levelNumber;

    /**
     * 是否最终节点
     */
    @Column(name = "IS_FINAL_NODE", length = 50)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long isFinalNode;

    /**
     * 父节点id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long parentId;

    /**
     * 公司
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long company;

    /**
     *状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
