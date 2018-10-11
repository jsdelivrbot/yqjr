package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.condition.CommodityReviewCondition;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.CommodityReview;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityReviewMapper extends Mapper<CommodityReview, Long> {

    public List<CommodityReview> selectReviewMsg(String batchCode);

    /**
     * 通过批次修改同一批次的审核信息
     * @param commodityReview
     */
    public void updateByBatchCode(CommodityReview commodityReview);

    /**
     * 通过批次号查询同一批数据
     * @param batchCode
     * @return
     */
    public List<CommodityReview> selectByBatchCode(String batchCode);

    /**
     * 出库审核列表页
     * @param commodityReviewCondition
     * @param pageBounds
     * @return
     */
    List<CommodityReview> queryOutReviewList(CommodityReviewCondition commodityReviewCondition, PageBounds... pageBounds);

    /**
     * 入库审核列表页
     * @param commodityReviewCondition
     * @param pageBounds
     * @return
     */
    List<CommodityReview> queryInReviewList(CommodityReviewCondition commodityReviewCondition, PageBounds... pageBounds);

    /**
     * 查询物料审核进度处理信息
     * @param commodityReviewCondition
     * @param pageBounds
     * @return
     */
    List<CommodityReview> queryInProcessList(CommodityReviewCondition commodityReviewCondition, PageBounds... pageBounds);
    /**
     * 查询物料审核进度处理信息
     * @param commodityReviewCondition
     * @param pageBounds
     * @return
     */
    List<CommodityReview> queryOutProcessList(CommodityReviewCondition commodityReviewCondition, PageBounds... pageBounds);
}
