package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.Role;
import com.yqjr.fin.scfw.meta.mapper.RoleMapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoleService extends BaseService<RoleMapper, Role, Long> {

	public List<Role> getRoleByUserId(Long userId){
		return mapper.getRoleByUserId(userId);
	}
}