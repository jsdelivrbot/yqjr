package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.fin.scfw.meta.entity.User;
import com.yqjr.fin.scfw.meta.mapper.UserMapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserMapper, User, Long> {

	public User selectByLoginName(String loginName) {
		List<User> userList = mapper.selectByLoginName(loginName);
		return userList.isEmpty() ? null : userList.get(0);
	}
	
	public List<UserDto> findUserLoginByName(String loginName,String areaCode,String comCode) {
		return mapper.findUserLoginByName(loginName,areaCode,comCode);
	}
	public List<UserDto> getUserByName(String userName) {
		return mapper.getUserByName(userName);
	}
}