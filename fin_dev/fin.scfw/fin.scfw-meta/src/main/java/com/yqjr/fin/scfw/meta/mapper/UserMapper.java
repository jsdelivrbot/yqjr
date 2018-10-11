package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.fin.scfw.meta.entity.User;

public interface UserMapper extends Mapper<User, Long> {

	public List<User> selectByLoginName(String loginName);
	
	public List<UserDto> findUserLoginByName(@Param("loginName") String loginName  ,@Param("areaCode") String areaCode,@Param("comCode") String comCode); 
	
	public List<UserDto> getUserByName(String userName); 
}
