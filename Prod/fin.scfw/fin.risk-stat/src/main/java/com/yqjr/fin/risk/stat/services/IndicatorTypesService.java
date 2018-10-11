package com.yqjr.fin.risk.stat.services;

import com.yqjr.fin.risk.stat.condition.IndicatorTypesCondition;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.risk.stat.entity.IndicatorTypes;
import com.yqjr.fin.risk.stat.mapper.IndicatorTypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class IndicatorTypesService extends BaseService<IndicatorTypesMapper, IndicatorTypes, Long> {

    public int SelectCountLikeByNameAndCode(IndicatorTypes it){
        return  mapper.SelectCountLikeByNameAndCode(it);

    }
    public List<IndicatorTypes> selItypes(){
        return mapper.selItypes();
    }
    public List<IndicatorTypes> selectLikeByNameAndCode(IndicatorTypesCondition condition, PageBounds of){
        return  mapper.SelectLikeByNameAndCode(condition,of);

    }

}