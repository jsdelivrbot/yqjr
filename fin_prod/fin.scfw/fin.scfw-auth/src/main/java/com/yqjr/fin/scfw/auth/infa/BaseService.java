package com.yqjr.fin.scfw.auth.infa;

import com.yqjr.fin.scfw.auth.infa.model.Role;
import com.yqjr.fin.scfw.auth.infa.model.System;
import com.yqjr.fin.scfw.auth.infa.model.User;
import com.yqjr.fin.scfw.auth.infa.model.Zone;
import com.yqjr.scfw.common.results.ObjectResultResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: Kyll
 * Date: 2018-01-04 08:23
 */
@FeignClient("fin-scfw-meta")
public interface BaseService {
	@RequestMapping(value = "/users/loginName/{loginName}", method = RequestMethod.GET)
	ObjectResultResponse<User> getUserByLoginName(@PathVariable("loginName") String loginName);

	@RequestMapping(value = "/roles/user/{id}", method = RequestMethod.GET)
	ObjectResultResponse<List<Role>> listByUser(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/systems/user/{systemId}", method = RequestMethod.GET)
	ObjectResultResponse<List<System>> listByRole(@PathVariable("systemId") String systemId);
	
	@RequestMapping(value = "/zones/getZoneById/{id}", method = RequestMethod.GET)
	ObjectResultResponse<List<Zone>> getZoneById(@PathVariable("id") Long id);
}
