package com.yqjr.fin.fpms.product.entity;

import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;

/**
 * @description: 附加信息
 * @author: lixue
 * @date: 2018/08/21 15:39:11
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_ADDITIONAL_INFO", schema = "FPMS")
public class AdditionalInfoEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_ADDITIONAL_INFO.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 附加信息名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    /**
     * 数据类型
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dataType;


    /**
     * 是否必填
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String isNecessary;

    /**
     * 页面元素类型
     */
    @Column(name = "PAGE_ELEMENT_TYPE", length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String pageElementType;

    /**
     * 单选框取值
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String selectValue;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
