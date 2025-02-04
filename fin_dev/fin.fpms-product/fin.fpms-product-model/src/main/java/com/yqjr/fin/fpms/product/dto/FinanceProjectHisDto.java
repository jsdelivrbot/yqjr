package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融专案轨迹表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:51:19
*/

@Data
public class FinanceProjectHisDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 金融专案id
     */
    private Long financeProjectId;
	
    /**
     * 专案名称
     */
    private String vname;
	
    /**
     * 简称
     */
    private String vsimpleName;
	
    /**
     * 备注
     */
    private String vremark;
	
    /**
     * 上架日期
     */
    private Date dvalidDate;
	
    /**
     * 下架日期
     */
    private Date dexpireDate;
	
    /**
     * 放款失效日期
     */
    private Date dloanExpireDate;
	
    /**
     * 审核状态编码 5000、6000、7000
     */
    private Long examineStatusCode;
	
    /**
     * 审核状态名称 待上架、已上架、已下架
     */
    private String examineStatusName;
	
    /**
     * 专案状态编码 1000、2000、3000、4000
     */
    private Long projectStatusCode;
	
    /**
     * 专案状态名称 编辑、待审核、审核通过、驳回
     */
    private String projectStatusName;
	
    /**
     * 合同动态文本
     */
    private String vautoreMark;
	
    /**
     * 合同动态扩展信息
     */
    private String ndocId;
	
    /**
     * 还款计划编排类型
     */
    private String repaymentPlanArrangeType;
	
    /**
     * 提前还款计划编排类型
     */
    private String prepaymentPlanArrangeType;
	
    /**
     * 放款方式
     */
    private String vloanType;
	
    /**
     * 是否尾款金融专案
     */
    private String nisBalance;
	
    /**
     * 是否开具发票
     */
    private String nisInvoice;
	
    /**
     * 是否贴息
     */
    private String nisDtinterest;
	
    /**
     * 贴息来源
     */
    private String nwhoPayDinterest;
	
    /**
     * 第三方贴息账号
     */
    private String vapyDaccount;
	
    /**
     * 附件id
     */
    private String attachmentId;
	
    /**
     * 提交备注
     */
    private String applyRemark;
	
    /**
     * 审核id
     */
    private Long auditFlowId;
	
    /**
     * 公司
     */
    private Long company;
	
    /**
     * 节点ID
     */
    private Long nodeId;
	
    /**
     * 业务条线
     */
    private Long businessLine;
	
    /**
     * 状态 1 有效 0无效
     */
    private Long flag;
	

}
