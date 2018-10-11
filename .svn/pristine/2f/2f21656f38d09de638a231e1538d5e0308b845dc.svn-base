package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.MaterialBase;
import org.springframework.stereotype.Service;

@Service
public interface MaterialBaseMapper extends Mapper<MaterialBase, Long> {

	/**
	 * 查询该素材名称是否存在
	 * @param materialBase
	 * @return
	 */
	public MaterialBase selectByMaterialName(MaterialBase materialBase);

    /**
     * 查询素材编码最大ID
     * @param company
     * @return
     */
    String queryMax(String company);
}
