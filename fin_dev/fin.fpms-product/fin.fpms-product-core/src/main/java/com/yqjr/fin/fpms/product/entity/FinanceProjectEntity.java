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
import java.util.Date;

/**
 * @description: 金融专案
 * @author: lixue
 * @date: 2018/08/21 15:39:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_FINANCE_PROJECT", schema = "FPMS")
public class FinanceProjectEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_FINANCE_PROJECT.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    /**
     *金融专案名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vname;

    /**
     *简称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vsimpleName;

    /**
     *备注
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vremark;

    /**
     *上架日期
     */
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date dvalidDate;

    /**
     *下架日期
     */
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date dexpireDate;

    /**
     *放款失效日期
     */
    @Column(name = "DLOAN_EXPIRE_DATE", length = 100)
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date dloanExpireDate;

    /**
     *审核状态编码
     */
    @Column(name = "EXAMINE_STATUS_CODE",length = 50)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long examineStatusCode;

    /**
     *审核状态名称
     */
    @Column(name = "EXAMINE_STATUS_NAME",length = 100)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusName;

    /**
     *专案状态编码
     */
    @Column(name = "PROJECT_STATUS_CODE",length = 50)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long projectStatusCode;

    /**
     *专案状态名称
     */
    @Column(name = "PROJECT_STATUS_NAME",length = 100)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String projectStatusName;

    /**
     *合同动态文本
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vautoreMark;

    /**
     *合同动态扩展信息
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String ndocId;

    /**
     *还款计划编排类型
     */
    @Column(name = "REPAYMENT_PLAN_ARRANGE_TYPE",length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String repaymentPlanArrangeType;

    /**
     *提前还款计划编排类型
     */
    @Column(name = "PREPAYMENT_PLAN_ARRANGE_TYPE",length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String prepaymentPlanArrangeType;

    /**
     *放款方式
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vloanType;

    /**
     *是否尾款金融专案
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nisBalance;

    /**
     *是否开具发票
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nisInvoice;

    /**
     *是否贴息
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nisDtinterest;

    /**
     *贴息来源
     */
    @Column(name = "NWHO_PAY_DINTEREST", length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String nwhoPayDinterest;

    /**
     *第三方贴息账号
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vapyDaccount;

    /**
     *附件id
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String attachmentId;

    /**
     *提交审核备注
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String applyRemark;

    /**
     *审核id
     */
    @Column(name = "AUDIT_FLOW_ID",length =50)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long auditFlowId;

    /**
     *公司
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer company;

    /**
     *节点id
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer nodeId;

    /**
     *业务条线
     */
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer businessLine;

    /**
     *状态 1有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
