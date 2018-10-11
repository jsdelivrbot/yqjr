package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;

import com.yqjr.fin.scfw.meta.entity.Role;

public interface RoleMapper extends Mapper<Role, Long> {

	public List<Role> getRoleByUserId(Long userId);
	
}
