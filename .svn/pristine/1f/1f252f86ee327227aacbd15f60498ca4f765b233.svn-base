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
 * @description: 金融产品轨迹
 * @author: lixue
 * @date: 2018/08/21 15:39:13
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "FPMS_PRODUCT_HIS", schema = "FPMS")
public class ProductHisEntity extends FinBaseMapperEntity<Long> {

    /**
     * 主键id
     */
    @Id
    @KeySql(sql = "select SEQ_FPMS_PRODUCT_HIS.nextval from dual", order = ORDER.BEFORE)
    private Long id;
    /**
     * 金融产品id
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long financeProductId;

    /**
     * 金融产品名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String vname;

    /**
     * 上架日期
     */
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date dvalidDate;

    /**
     * 下架日期
     */
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date dexpireDate;

    /**
     * 档案配置编码
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fileConfigCode;

    /**
     * 档案配置名称
     */
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
     * 金融产品状态编码
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long productStatusCode;

    /**
     * 金融产品状态名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String productStatusName;

    /**
     * 审核状态编码
     */
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long examineStatusCode;

    /**
     * 审核状态名称
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String examineStatusName;

    /**
     * 审核表id
     */
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
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String treeNodeId;

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
