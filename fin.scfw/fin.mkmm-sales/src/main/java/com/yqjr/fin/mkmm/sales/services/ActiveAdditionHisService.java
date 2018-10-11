package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.ActiveAdditionHis;
import com.yqjr.fin.mkmm.sales.mapper.ActiveAdditionHisMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ActiveAdditionHisService extends BaseService<ActiveAdditionHisMapper, ActiveAdditionHis, Long> {

    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}