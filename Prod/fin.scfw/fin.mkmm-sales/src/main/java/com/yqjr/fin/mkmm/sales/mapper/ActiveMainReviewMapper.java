package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.condition.ActiveMainProcessCondition;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainReviewCondition;
import com.yqjr.fin.mkmm.sales.condition.ActiveReviewListCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.ActiveMainProcessReviewVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.ActiveMainReview;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActiveMainReviewMapper extends Mapper<ActiveMainReview, Long> {

	//region generated by CodeRobot
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~此线上方代码自动生成，在此下方编写自定义代码。
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
    public int queryActiveMainReviewCount(ActiveMainReviewCondition activeMainReviewCondition);

    public String queryMaxID(String likeID);

    List<ActiveMainReview> selectReviewList(ActiveReviewListCondition condition, PageBounds... pageBounds);

    List<ActiveMainProcessReviewVo> selectProcessReviewList(ActiveMainProcessCondition condition, PageBounds... pageBounds);

    void updateFlagById(@Param("mid") Long mid);

    void updateStatusById(@Param("status") String status,@Param("id") Long id,@Param("modifier") Long modifier);
}
