package com.yqjr.fin.cvc.core.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.cvc.core.dto.TkApplybasicDto;
import com.yqjr.fin.cvc.core.dao.TkApplybasicDao;
import com.yqjr.fin.cvc.core.entity.TkApplybasic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@Service
public class TkApplybasicBizz extends BaseMapperBizz<TkApplybasicDao, TkApplybasic, Long,TkApplybasicDto> {

    //region generated by CodeRobot

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}