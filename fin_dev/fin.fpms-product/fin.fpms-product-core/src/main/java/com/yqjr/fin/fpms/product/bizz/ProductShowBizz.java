package com.yqjr.fin.fpms.product.bizz;

import com.yqjr.fin.fpms.product.dto.ProductAuditFlowDto;
import com.yqjr.fin.fpms.product.dto.ProductDto;
import com.yqjr.fin.fpms.product.dto.ProductShowDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 金融产品所有配置信息展示逻辑处理层，该类为大的Bizz类,
 * @Author:         zengxiaoran
 * @CreateDate:     2018-09-05 14:25:56
 */
@Service
@Slf4j
@Transactional(readOnly = true)
public class ProductShowBizz {

    /**
     * @Description:金融产品所有配置信息预览
     * @Author zengxiaoran
     * @Date 2018/9/5 14:28
     * @Param [productId]
     * @Return com.yqjr.fin.fpms.product.dto.ProductDto
     */
    @Autowired
    ProductBizz productBizz;
    @Autowired
    ProductAuditFlowBizz productAuditFlowBizz;
    public ProductShowDto showBasicInfo(Long productId){
        ProductShowDto productShowDto = new ProductShowDto();
        ProductDto productDto = productBizz.showInfo(productId);
        ProductAuditFlowDto productAuditFlowDto = productAuditFlowBizz.findByProductId(productId);
        productShowDto.setProductAuditFlowDto(productAuditFlowDto);
        productShowDto.setProductDto(productDto);
        return productShowDto;
    }
}
