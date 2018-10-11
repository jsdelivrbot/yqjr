package com.yqjr.fin.qcms.credit.api;

import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.qcms.credit.condition.CountryCondition;
import com.yqjr.fin.qcms.credit.dto.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo", path = "/country")
public interface CountryApi {
	@GetMapping({"/id/{id}"})
	ServiceResponse<CountryDto> get(@PathVariable("id") Long id);

	@PostMapping({"/page"})
	ServiceResponse<PageList<CountryDto>> findPage(@RequestBody CountryCondition condition);

	@PostMapping
	ServiceResponse<Long> create(@RequestBody CountryDto dto);

	@PutMapping
	ServiceResponse update(@RequestBody CountryDto dto);

	@DeleteMapping({"/{id}"})
	ServiceResponse delete(@PathVariable("id") Long id);
}
