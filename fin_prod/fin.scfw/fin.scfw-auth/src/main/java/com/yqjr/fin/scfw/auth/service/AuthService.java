package com.yqjr.fin.scfw.auth.service;

import com.yqjr.fin.scfw.auth.infa.BaseService;
import com.yqjr.fin.scfw.auth.infa.model.Role;
import com.yqjr.fin.scfw.auth.infa.model.System;
import com.yqjr.fin.scfw.auth.infa.model.User;
import com.yqjr.fin.scfw.auth.infa.model.Zone;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.BizzException;
import com.yqjr.scfw.common.session.UserContext;
import com.yqjr.scfw.common.utils.MD5Utils;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User: Kyll Date: 2018-01-04 13:51
 */
@Service
public class AuthService {
	@Autowired
	private BaseService baseService;

	public UserContext authorize(String loginName, String password) throws BizzException {
		User user = baseService.getUserByLoginName(loginName).getResult();
		if (user == null) {
			throw new BizzException("", "用户不存在");
		}

		if (!Objects.equals(MD5Utils.encode(password), user.getLoginPassword())) {
			throw new BizzException("", "密码无效");
		}	
		List<Role> roleList = baseService.listByUser(user.getId()).getResult();
		List<Integer> roleSystemIdList = new ArrayList<>();
		List<String> roleSystemNameList = new ArrayList<>();
		String str = "";
		String roleIdList = "";
		String roleCodeList = "";
		for (Role role : roleList) {
			roleIdList += "'" + role.getId() + "',";
			str += "'" + role.getSystemId() + "',";		
			roleCodeList += "'" + role.getRoleCode() + "',";
		}
		str = str.substring(0, str.length() - 1);
		roleIdList = roleIdList.substring(0, roleIdList.length() - 1);
		roleCodeList = roleCodeList.substring(0, roleCodeList.length() - 1);
		List<System> systemList = baseService.listByRole(str).getResult();
		systemList.forEach(system -> {
			roleSystemIdList.add(system.getId().intValue());
			roleSystemNameList.add(system.getSystemName());
		});
		if (roleList.isEmpty()) {
			throw new BizzException(Const.EC_AUTH_ROLE_NOT_EXIST, "角色不存在");
		}
		return UserContext.create()
				.setId(String.valueOf(user.getId()))
				.setLoginName(user.getLoginName())
				.setName(user.getUserName())
				.setOaFdno(user.getOaFdno())
				.setComCode(user.getComCode())
				.setOrganizationNo(user.getOrganizationNo())
				.setRegistDate(user.getRegistDate())
				.setRegistUser(user.getRegistUser())
				.setSex(user.getSex())
				.setMobile(user.getMobile())
				.setEmail(user.getEmail())
				.setWcOpenid(user.getWcOpenid())
				.setStatus(user.getStatus())
				.setPassInvalidDate(user.getPassInvalidDate())
				.setDataAuthType(user.getDataAuthType())
				.setComName(user.getComName())
				.setIdcard(user.getIdcard())
				.setBirthday(user.getBirthday())
				.setPersonethnic(user.getPersonethnic())
				.setPersonmarr(user.getPersonmarr())
				.setPersonschool(user.getPersonschool())
				.setPersonsubject(user.getPersonsubject())
				.setPersonedu(user.getPersonedu())
				.setPersonedulevel(user.getPersonedulevel())
				.setPersonjointime(user.getPersonjointime())
				.setPersonnature(user.getPersonnature())
				.setPersonlevel(user.getPersonlevel())
				.setAreaCode(user.getAreaCode())
				.setAreaName(user.getAreaName())			
				.setRoleIdList(roleIdList)
				.setRoleCodeList(roleCodeList)
				.setRoleSystemIdList(roleSystemIdList)
				.setRoleSystemNameList(roleSystemNameList);
	}
}
