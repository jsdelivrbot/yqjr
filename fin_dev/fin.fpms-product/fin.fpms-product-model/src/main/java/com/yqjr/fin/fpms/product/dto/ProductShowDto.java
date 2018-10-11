package com.yqjr.fin.fpms.product.dto;

import lombok.Data;

/**
 * 金融产品所有配置信息 dto层
 * @Author:          zengxiaoran
 * @CreateDate:     2018-09-5 13:50:19
 */
@Data
public class ProductShowDto {
    /**
     * 金融产品主表 dto
     */
    private ProductDto productDto;

    /**
     * 金融产品验证表 dto
     */
    private ProductVerifyDto productVerifyDto;

    /**
     * 金融产品验证详情表 dto
     */
    private ProductVerifyDetailDto productVerifyDetailDto;

    /**
     * 金融产品审核主表
     */
    private ProductAuditFlowDto productAuditFlowDto;
}
