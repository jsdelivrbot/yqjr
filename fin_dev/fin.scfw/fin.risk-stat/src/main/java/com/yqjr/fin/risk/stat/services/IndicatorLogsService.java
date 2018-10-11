package com.yqjr.fin.risk.stat.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.risk.stat.entity.IndicatorLogs;
import com.yqjr.fin.risk.stat.mapper.IndicatorLogsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IndicatorLogsService extends BaseService<IndicatorLogsMapper, IndicatorLogs, Long> {

    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   public List<IndicatorLogs> selectByEventid(IndicatorLogs il){
        return mapper.selectByEventid(il);
    }
    //endregion
}