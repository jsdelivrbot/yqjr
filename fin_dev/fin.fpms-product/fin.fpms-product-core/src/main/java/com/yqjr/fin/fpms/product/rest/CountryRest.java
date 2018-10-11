package com.yqjr.fin.fpms.product.rest;

import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import com.yqjr.fin.fpms.product.bizz.CountryBizz;
import com.yqjr.fin.fpms.product.condition.CountryCondition;
import com.yqjr.fin.fpms.product.dto.CountryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/country")
@RestController
public class CountryRest extends BaseRest<CountryBizz, Long, CountryDto, CountryCondition> {
}
