package com.yqjr.fin.rems.rule.api;

import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.rems.rule.condition.CountryCondition;
import com.yqjr.fin.rems.rule.dto.CountryDto;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** 
 * @Author: lixue
 * @Description:  规则因子提供的对外接口
 * @Date:  2018/8/29 16:17
 * @params: 
 * @returns: 
 * 
 */
@FeignClient("FIN-REMS-RULE")
public interface RuleFactorApi {

	@GetMapping({"/ruleFactors/list"})
	ServiceResponse<List<RuleFactorDto>> ruleFactorList(@RequestParam("company") Long company);

/*	@PostMapping({"/page"})
	ServiceResponse<PageList<CountryDto>> findPage(@RequestBody CountryCondition condition);

	@PostMapping
	ServiceResponse<Long> create(@RequestBody CountryDto dto);

	@PutMapping
	ServiceResponse update(@RequestBody CountryDto dto);

	@DeleteMapping({"/{id}"})
	ServiceResponse delete(@PathVariable("id") Long id);*/
}
