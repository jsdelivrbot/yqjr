package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.entity.DealerSale;
import com.yqjr.scfw.common.mapper.Mapper;

import java.util.Date;
import java.util.List;

public interface DealerSaleMapper extends Mapper<DealerSale, Long> {

	//region generated by CodeRobot
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~此线上方代码自动生成，在此下方编写自定义代码。
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion

    //根据日期查询数每日数据
    List<DealerSale> selectDataByDate(Date date);


}
