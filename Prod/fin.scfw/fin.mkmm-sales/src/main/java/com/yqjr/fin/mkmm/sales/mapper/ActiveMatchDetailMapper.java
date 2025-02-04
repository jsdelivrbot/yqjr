package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.condition.ActiveMatchDetailVoCondition;
import com.yqjr.fin.mkmm.sales.condition.TeamWorkCondition;
import com.yqjr.fin.mkmm.sales.model.TeamReviewWork;
import com.yqjr.fin.mkmm.sales.vo.domin.ActiveMatchVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.ActiveMatchDetail;
import org.apache.ibatis.annotations.Param;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActiveMatchDetailMapper extends Mapper<ActiveMatchDetail, Long> {

	//region generated by CodeRobot
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~此线上方代码自动生成，在此下方编写自定义代码。
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
    /**
     * 查询活动向下全部计算费用的业务明细
     * @param businessCode
     * @param isSettle
     * @return
     */
    public List<ActiveMatchDetail> selectInfoBySettle(@Param("businessCode")String businessCode, @Param("isSettle")String isSettle,@Param("company")String company) ;

    //促销活动业务明细查询
    List<ActiveMatchVo> queryActiveDetil(ActiveMatchDetailVoCondition condition, PageBounds... pageBounds);
    //查出要导出的数据
    List<ActiveMatchVo> selectActiveDetil(ActiveMatchVo activeMatchVo);
    //根据code查明细
    List<ActiveMatchDetail> selectActiveMatchByCode(String activeCode,String company);
	
}
