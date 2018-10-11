package com.yqjr.fin.risk.stat.mapper;

import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.risk.stat.entity.Indicators;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndicatorsMapper extends Mapper<Indicators, Long> {
    public List<Indicators> selByIndicatorTypes(Indicators indicators);
    public String selByIndicatorsName(String indicatorname);
    public List<Indicators> selelctBy(Indicators indicators);
    public List<Indicators> selectLikeByNameAndCode(IndicatorsCondition it, PageBounds of);
    public Indicators selectById2(Indicators it);
    public int selectCountLikeByNameAndCode(Indicators it);
    public List<Indicators> selectByIndicatorcode (Indicators it);
    public List<Indicators> selIName(Indicators it);
    public Indicators selICode(Indicators it);
    public void patchById(IndicatorsCondition it);
}
