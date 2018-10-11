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
* 评分模型轨迹表	
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_score_model_his", schema = "QCMS")
public class ScoreModelHis extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_SCORE_MODEL_HIS.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 评分模型id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long scoreModelId;
    /**
     * 模型名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String modelName;
    /**
     * 模型编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String modelCode;
    /**
     * 生效日期
     */
	@ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private java.util.Date effectiveDate;
    /**
     * 备注信息
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String remark;
    /**
     * 模型状态编码 5000、6000、7000
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long modelStatusCode;
    /**
     * 模型状态名称 待上架、已上架、已下架
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String modelStatusName;
    /**
     * 审核状态编码 1000、2000、3000、4000
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long examineStatusCode;
    /**
     * 审核状态名称 编辑、待审核、审核通过、驳回
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String examineStatusName;
    /**
     * 审核id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long auditFlowId;
    /**
     * 公司
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long company;
    /**
     * 公司名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String companyName;
    /**
     * 业务条线
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long businessLine;
    /**
     * 状态 0 正常状态 -1 删除
     */
	@ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer flag;

}
