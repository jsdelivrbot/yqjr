package com.yqjr.fin.risk.stat.mapper;

import com.yqjr.fin.risk.stat.condition.IndicatorRangesCondition;
import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;
import com.yqjr.fin.risk.stat.entity.Indicators;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.risk.stat.entity.IndicatorRanges;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface IndicatorRangesMapper extends Mapper<IndicatorRanges, Long> {
    public List<IndicatorRanges> selIndicatorRangesByPage(IndicatorsCondition condition, PageBounds of);
    public IndicatorRanges selectById2(IndicatorRangesCondition indicatorRangesCondition);
    public List<IndicatorRanges> selIndicatorRangesFive();
    public void patchById(IndicatorRangesCondition it);
    public List<IndicatorRanges> selAreatype();
    public List<IndicatorRanges> selAreacode();
    public List<IndicatorRanges> selDimType();
    public List<IndicatorRanges> selDimcode();
    public List<IndicatorRanges> selSignallamp();
}
