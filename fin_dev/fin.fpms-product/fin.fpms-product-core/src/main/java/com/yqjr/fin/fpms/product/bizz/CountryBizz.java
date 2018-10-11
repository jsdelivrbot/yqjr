package com.yqjr.fin.fpms.product.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.fpms.product.dao.CountryDao;
import com.yqjr.fin.fpms.product.dto.CountryDto;
import com.yqjr.fin.fpms.product.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true) // 根据业务需要选择是否需要事务注解以及传播机制
@Service
public class CountryBizz extends BaseMapperBizz<CountryDao, Country, Long, CountryDto> {
}
