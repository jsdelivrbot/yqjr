package com.yqjr.fin.risk.stat.services;

import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.risk.stat.entity.Indicators;
import com.yqjr.fin.risk.stat.mapper.IndicatorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class IndicatorsService extends BaseService<IndicatorsMapper, Indicators, Long> {
    @Autowired
    private IndicatorsMapper indicatorsMapper;
    public List<Indicators> selByIndicatorTypes(Indicators indicators){
        return indicatorsMapper.selByIndicatorTypes(indicators);
    }
    public String selByIndicatorsName(String indicatorname){
        return indicatorsMapper.selByIndicatorsName(indicatorname);
    }


    public List<Indicators> selelctBy(Indicators indicators){
        return indicatorsMapper.selelctBy(indicators);

    }

    public  List<Indicators> selectLikeByNameAndCode(IndicatorsCondition it, PageBounds of){
        return indicatorsMapper.selectLikeByNameAndCode(it,of);
    }
    public int selectCountLikeByNameAndCode(Indicators it){
        return mapper.selectCountLikeByNameAndCode(it);
    }
    public List<Indicators> selectByIndicatorcode (Indicators it){
        return indicatorsMapper.selectByIndicatorcode(it);
    }

    public Indicators selectById2(Indicators it) {
       return indicatorsMapper.selectById2(it);
    }
    public List<Indicators> selIName(Indicators it){
        return mapper.selIName(it);
    }
    public Indicators selICode(Indicators it){
        return mapper.selICode(it);
    }
    public void patchById(IndicatorsCondition it){
        mapper.patchById(it);
    }
}