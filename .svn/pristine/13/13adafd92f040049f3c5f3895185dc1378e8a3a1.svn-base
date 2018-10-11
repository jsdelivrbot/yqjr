package com.yqjr.fin.qcms.credit.entity;

import com.yqjr.fin.common.base.starter.entity.FinBaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 评分子项表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_score_subitem", schema = "QCMS")
public class ScoreSubitem extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_SCORE_SUBITEM.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 评分大项id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreMajorTermId;
    /**
     * 顺序号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long sequenceNumber;
    /**
     * 评分子项名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreSubitemName;
    /**
     * 说明
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String remark;
    /**
     * 状态
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;
    /**
     * 单位
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String unit;

}
