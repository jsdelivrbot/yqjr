package com.yqjr.fin.risk.stat.mapper;

import com.yqjr.fin.risk.stat.condition.IndicatorTypesCondition;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.risk.stat.entity.IndicatorTypes;
import com.yqjr.scfw.common.pagination.model.PageBounds;

import java.util.List;
public interface IndicatorTypesMapper extends Mapper<IndicatorTypes, Long> {
    public int SelectCountLikeByNameAndCode(IndicatorTypes it);
    public List<IndicatorTypes> SelectLikeByNameAndCode(IndicatorTypesCondition condition, PageBounds of);

	public List<IndicatorTypes> selItypes();
}
