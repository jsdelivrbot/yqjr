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
* 评分卡模型验证详情主表
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_score_model_verify_detail", schema = "QCMS")
public class ScoreModelVerifyDetail extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_SCORE_MODEL_VERIFY_DETAIL.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 金融产品id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long productId;
    /**
     * 批次号
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String batchtNumber;
    /**
     * 申请编号
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long applyNumber;
    /**
     * 业务验证数据
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String businessVerifyData;
    /**
     * 验证结果
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String verifyResult;
    /**
     * 状态 1 有效 0无效
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
