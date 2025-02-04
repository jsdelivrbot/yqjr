package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.condition.FeeMainReviewCondition;
import com.yqjr.fin.mkmm.sales.condition.FeeMainWorkCondition;
import com.yqjr.fin.mkmm.sales.entity.FeeMainHis;
import com.yqjr.fin.mkmm.sales.model.Active;
import com.yqjr.fin.mkmm.sales.rest.vo.fee.FeeMainReviewQueryVo;
import com.yqjr.fin.mkmm.sales.rest.vo.fee.FeeMainReviewWorkVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.FeeMainReview;
import com.yqjr.scfw.common.pagination.model.PageBounds;

import java.util.List;

public interface FeeMainReviewMapper extends Mapper<FeeMainReview, Long> {

    //region generated by CodeRobot
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~此线上方代码自动生成，在此下方编写自定义代码。
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion

    /**
     * 费用审核列表查询方法
     * @param condition
     * @param
     * @return
     */
    List<FeeMainReviewWorkVo> selectReviewList(FeeMainWorkCondition condition, PageBounds... pageBounds);

    /**
     * 审核单条数据查询
     * @param condition
     * @param pageBounds
     * @return
     */
    List<FeeMainReviewQueryVo> selectReviewQueryList(FeeMainReviewCondition condition, PageBounds... pageBounds);

    /**
     * 根据活动代码查审核对象
     * create by fanna 20180605
     * @param businessCode
     * @return
     */
    List<FeeMainReview> selectActiveReviewByCode(String businessCode,String company);

    /**
     * 根据id找活代编码
     * create by fanna 20180605
     * @param id
     * @return
     */
    String selectFeeMainReviewById(Long id);

    /**
     * 修改提交金额
     * @param
     * @param fmr
     */
    void updateFeeMainReviewByCode(FeeMainReview fmr);

    void updateFeeMainReviewStatus(FeeMainReview  feeMainReview);

    void updateFeeMainHis(FeeMainHis fmh );
}
