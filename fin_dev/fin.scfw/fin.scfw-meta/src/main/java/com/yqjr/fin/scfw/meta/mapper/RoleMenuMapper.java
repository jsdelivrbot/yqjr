package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;

import com.yqjr.fin.scfw.meta.entity.RoleMenu;

public interface RoleMenuMapper extends Mapper<RoleMenu, Long> {

	public List<Integer> getRoleByUserId(Long roleId);
	
}
