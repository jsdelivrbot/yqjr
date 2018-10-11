package com.yqjr.fin.fpms.product.dto;

import lombok.Data;
import java.util.Date;
import com.yqjr.fin.common.base.starter.dto.FinBaseDto;

/**
* 金融产品主表 dto层
* @Author:          lixue
* @CreateDate:     2018-08-27 10:49:56
*/

@Data
public class ProductDto extends FinBaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
	
    /**
     * 产品名称
     */
    private String vname;
	
    /**
     * 上架日期
     */
    private Date dvalidDate;
	
    /**
     * 下架日期
     */
    private Date dexpireDate;
	
    /**
     * 档案配置编码
     */
    private String fileConfigCode;
	
    /**
     * 档案配置名称
     */
    private String fileConfigName;
	
    /**
     * 附件id
     */
    private String attachmentId;
	
    /**
     * 备注信息
     */
    private String remark;
	
    /**
     * 提交备注
     */
    private String applyRemark;
	
    /**
     * 产品状态编码  5000 6000 7000
     */
    private Long productStatusCode;
	
    /**
     * 产品状态名称  待上架、已上架、已下架
     */
    private String productStatusName;
	
    /**
     * 审核状态编码 1000、2000、3000、4000
     */
    private Long examineStatusCode;
	
    /**
     * 审核状态名称  编辑、待审核、审核通过、驳回
     */
    private String examineStatusName;
	
    /**
     * 审核id
     */
    private Long auditFlowId;
	
    /**
     * 公司
     */
    private Long company;
	
    /**
     * 树节点ID
     */
    private Long treeNodeId;
	
    /**
     * 业务条线
     */
    private Long businessLine;
	
    /**
     * 状态 1 有效 0无效
     */
    private Long flag;
	

}
