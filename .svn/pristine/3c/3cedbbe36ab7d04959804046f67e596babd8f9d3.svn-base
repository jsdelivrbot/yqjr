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
* 评分大项表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_score_major_term", schema = "QCMS")
public class ScoreMajorTerm extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_SCORE_MAJOR_TERM.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分卡模型ID
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 顺序号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long sequenceNumber;
    /**
     * 评分大项名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String scoreMajorTermName;
    /**
     * 备注
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String remark;
    /**
     * 状态 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
