package com.yqjr.fin.scfw.meta.rest;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.yqjr.fin.fcsw.meta.api.dto.UserDto;
import com.yqjr.fin.scfw.meta.services.UserService;


@Api(consumes = "application/json", produces = "application/json", protocols = "http",  basePath = "users")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseRest<UserService, UserDto> {


    private Logger logger = LoggerFactory.getLogger(getClass());
   
	@ApiOperation(value = "用于用户登录，根据用户名称和密码获取用户和角色信息", tags = "用户信息：UserRest")
	@RequestMapping(value = "/loginName", method = RequestMethod.GET)
	public ListResultResponse<UserDto> getByloginName(
			@RequestParam(value="loginName", required=true ) String loginName) {
		UserContext uc = SessionHolder.getUserContext();
		List<UserDto> list =baseService.findUserLoginByName(loginName,uc.getAreaCode(),uc.getComCode());
		return getListResultResponse(true,"1", "成功", list);
	}
	
	@ApiOperation(value = "用于用户登录，根据用户名称和密码获取用户和角色信息", tags = "用户信息：UserRest")
	@RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
	public ListResultResponse<UserDto> getUserByName(
			@RequestParam(value="userName", required=true ) String userName) {
		List<UserDto> list =baseService.getUserByName(userName);
		return getListResultResponse(true,"1", "成功", list);
	}


}