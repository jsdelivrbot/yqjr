package com.yqjr.fin.risk.stat.services;

import com.yqjr.fin.risk.stat.condition.IndicatorRangesCondition;
import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.risk.stat.entity.IndicatorRanges;
import com.yqjr.fin.risk.stat.mapper.IndicatorRangesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class IndicatorRangesService extends BaseService<IndicatorRangesMapper, IndicatorRanges, Long> {
    @Autowired
    private IndicatorRangesMapper indicatorRangesMapper;



    public List<IndicatorRanges> selIndicatorRangesByPage(IndicatorsCondition condition, PageBounds of){
        return indicatorRangesMapper.selIndicatorRangesByPage(condition,of);
    }

    public List<IndicatorRanges> selIndicatorRangesFive(){
        return mapper.selIndicatorRangesFive();
    };
    public IndicatorRanges selectById2(IndicatorRanges indicatorRanges){
        return indicatorRangesMapper.selectById2(indicatorRanges);
    }
    public void patchById(IndicatorRangesCondition it){
        indicatorRangesMapper.patchById(it);
    }

    public boolean selIndId(IndicatorRanges it){
        if(mapper.selIndId(it) == 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean  selByUp(IndicatorRanges it){
        if(mapper.selByUp(it) == 0){
            return true;
        }else {
            return false;
        }
    }
}