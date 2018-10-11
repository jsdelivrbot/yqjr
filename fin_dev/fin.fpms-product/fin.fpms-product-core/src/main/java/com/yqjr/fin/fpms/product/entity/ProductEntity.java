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
 * @description: 金融产品
 * @author: lixue
 * @date: 2018/08/21 15:39:21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT", schema = "FPMS")
public class ProductEntity extends FinBaseMapperEntity<Long> {
    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT.nextval from dual", order = ORDER.BEFORE)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long id;

    /**
     * 金融产品名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vname;

    /**
     * 上架日期
     */
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date dvalidDate;

    /**
     * 下架日期
     */
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date dexpireDate;

    /**
     * 档案配置编码
     */
    @Column(name = "FILE_CONFIG_CODE", length = 100)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fileConfigCode;

    /**
     * 档案配置名称
     */
    @Column(name = "FILE_CONFIG_NAME",  length = 100)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fileConfigName;

    /**
     * 附件id
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String attachmentId;

    /**
     * 备注信息
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String remark;

    /**
     * 提交备注
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String applyRemark;

    /**
     * 产品状态编码
     */
    @Column(name = "PRODUCT_STATUS_CODE")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer productStatusCode;

    /**
     * 产品状态名称
     */
    @Column(name = "PRODUCT_STATUS_NAME" ,length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String productStatusName;

    /**
     * 审核状态编码
     */
    @Column(name = "EXAMINE_STATUS_CODE")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long examineStatusCode;

    /**
     * 审核状态名称
     */
    @Column(name = "EXAMINE_STATUS_NAME", length = 50)
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusName;

    /**
     * 审核id
     */
    @Column(name = "AUDIT_FLOW_ID")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long auditFlowId;

    /**
     * 公司
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long company;

    /**
     * 树节点id
     */
    @Column(name = "TREE_NODE_ID", length = 50)
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long treeNodeId;

    /**
     * 业务条线
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long businessLine;

    /**
     * 状态 1 有效 0 无效
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long flag;

}
