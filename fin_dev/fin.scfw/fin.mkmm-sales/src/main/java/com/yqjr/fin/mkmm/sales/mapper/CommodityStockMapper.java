package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.CommodityStock;


public interface CommodityStockMapper extends Mapper<CommodityStock, Long> {

    CommodityStock selectCommodityStock(CommodityStock commodityStock);
	
}
