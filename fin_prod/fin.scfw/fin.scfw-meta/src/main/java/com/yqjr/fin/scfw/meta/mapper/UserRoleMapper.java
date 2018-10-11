package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;
import com.yqjr.fin.scfw.meta.entity.UserRole;

public interface UserRoleMapper extends Mapper<UserRole, Long> {

	public List<Integer> selectByRoleId(Integer roleId);
	
}
