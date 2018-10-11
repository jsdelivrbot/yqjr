package com.yqjr.fin.fpms.product.bizz;

import com.yqjr.fin.fpms.product.entity.SubbrandCarModelEntity;
import com.yqjr.fin.fpms.product.dao.SubbrandCarModelDao;
import com.yqjr.fin.fpms.product.dto.SubbrandCarModelDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
* 子品牌车型关系主表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 10:51:20
*/
@Service
@Transactional(readOnly = true)
public class SubbrandCarModelBizz extends BaseMapperBizz<SubbrandCarModelDao, SubbrandCarModelEntity, Long,SubbrandCarModelDto> {
	
}