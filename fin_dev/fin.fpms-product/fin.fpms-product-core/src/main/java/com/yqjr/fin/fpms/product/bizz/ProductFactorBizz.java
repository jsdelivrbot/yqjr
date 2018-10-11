package com.yqjr.fin.fpms.product.bizz;

import com.yqjr.fin.fpms.product.entity.ProductFactorEntity;
import com.yqjr.fin.fpms.product.dao.ProductFactorDao;
import com.yqjr.fin.fpms.product.dto.ProductFactorDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
* 产品因子关联表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 10:51:19
*/
@Service
@Transactional(readOnly = true)
public class ProductFactorBizz extends BaseMapperBizz<ProductFactorDao, ProductFactorEntity, Long,ProductFactorDto> {
	
}