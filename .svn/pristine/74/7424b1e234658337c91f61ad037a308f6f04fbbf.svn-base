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
* 政策轨迹表	
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "qcms_policy_his", schema = "QCMS")
public class PolicyHis extends FinBaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@Id
	@KeySql(sql = "select SEQ_QCMS_POLICY_HIS.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 政策id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long policyId;
    /**
     * 政策名称
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String name;
    /**
     * 政策类型  10 基本政策  20 差异政策
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long policyTypeCode;
    /**
     * 政策子类型编码 10 信贷政策 20 风险政策 30 利率政策
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long policySubtypesCode;
    /**
     * 政策子类型名称 10 信贷政策 20 风险政策 30 利率政策
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String policySubtypesName;
    /**
     * 备注
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String remark;
    /**
     * 生效日期
     */
	@ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private java.util.Date effectiveDate;
    /**
     * 失效日期
     */
	@ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private java.util.Date expirationDate;
    /**
     * 政策状态编码 5000、6000、7000
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private java.lang.Long policyStatusCode;
    /**
     * 政策状态名称 待上架、已上架、已下架
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String policytStatusName;
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
     * 区域编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String areaCode;
    /**
     * 流程id
     */
	@ColumnType(jdbcType = JdbcType.BIGINT)
    private Long processId;
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
     * 节点编码
     */
	@ColumnType(jdbcType = JdbcType.VARCHAR)
    private java.lang.String nodeCode;
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
