package com.yqjr.fin.cvc.core.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.cvc.core.dao.TKInsuranceCorpDao;

import com.yqjr.fin.cvc.core.dto.TKInsuranceCorpDto;

import com.yqjr.fin.cvc.core.entity.TKInsuranceCorp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@Service
public class TKInsuranceCorpBizz extends BaseMapperBizz<TKInsuranceCorpDao, TKInsuranceCorp, Long,TKInsuranceCorpDto> {
}
