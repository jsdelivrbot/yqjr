package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.CommodityBase;

public interface CommodityBaseMapper extends Mapper<CommodityBase, Long> {

    /**
     * 查询物料编码最大ID
     * @param company
     * @return
     */
    String queryMax(String company);
	
}
