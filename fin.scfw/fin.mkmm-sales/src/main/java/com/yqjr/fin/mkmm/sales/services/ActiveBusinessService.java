package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.ActiveBusiness;
import com.yqjr.fin.mkmm.sales.mapper.ActiveBusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ActiveBusinessService extends BaseService<ActiveBusinessMapper, ActiveBusiness, Long> {

    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion

    @Autowired
    private ActiveBusinessMapper activeBusinessMapper;

    public List<ActiveBusiness> selectActiveBusinessByCode(String activeCode,String company){

        return activeBusinessMapper.selectActiveBusinessByCode(activeCode,company);
    }

    public void patchByActiveCode(ActiveBusiness activeBusiness) {
        activeBusinessMapper.patchByActiveCode(activeBusiness);
    }
}