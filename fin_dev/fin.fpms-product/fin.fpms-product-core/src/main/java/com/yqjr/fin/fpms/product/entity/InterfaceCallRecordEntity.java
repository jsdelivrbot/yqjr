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
 * @description: 接口调用记录
 * @author: lixue
 * @date: 2018/08/22 09:14:06
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_INTERFACE_CALL_RECORD", schema = "FPMS")
public class InterfaceCallRecordEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_INTERFACE_CALL_RECORD.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     * 接口地址
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String interfaceUrl;

    /**
     * 接口名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String interfaceName;

    /**
     * 接口参数
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String interfaceParam;

    /**
     * 返回结果
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String returnResult;

    /**
     * 调用方
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String caller;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
