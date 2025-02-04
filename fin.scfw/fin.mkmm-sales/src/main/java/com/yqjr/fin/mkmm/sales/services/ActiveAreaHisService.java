package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.ActiveAreaHis;
import com.yqjr.fin.mkmm.sales.mapper.ActiveAreaHisMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ActiveAreaHisService extends BaseService<ActiveAreaHisMapper, ActiveAreaHis, Long> {

    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}