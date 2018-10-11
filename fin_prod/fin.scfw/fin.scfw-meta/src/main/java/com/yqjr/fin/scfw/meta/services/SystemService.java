package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;

import com.yqjr.fin.scfw.meta.entity.System;
import com.yqjr.fin.scfw.meta.mapper.SystemMapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SystemService extends BaseService<SystemMapper, System, Long> {

	public List<System> getSystemById(String systemId){
		return mapper.getRoleByUserId(systemId);
	}
}