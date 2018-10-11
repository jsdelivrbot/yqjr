package com.yqjr.fin.scfw.meta.rest;

import java.util.*;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.BizzException;
import com.yqjr.scfw.common.jwt.JwtToken;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.scfw.meta.entity.User;
import com.yqjr.fin.scfw.meta.services.AuthService;
import com.yqjr.fin.scfw.meta.services.RedisService;
import com.yqjr.fin.scfw.meta.common.JQGridJsonResult;
import com.yqjr.fin.scfw.meta.condition.UserCondition;
import com.yqjr.fin.scfw.meta.services.UserService;


@Api(consumes = "application/json", produces = "application/json", protocols = "http",  basePath = "users")
@RestController
@RequestMapping(value = "/users")
public class UserRest extends BaseRest<UserService, User> {
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtToken jwtToken;
	@Autowired
	private RedisService redisService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ApiOperation(value = "分页查询用户表（参数：实体对象属性、pageNum、pageSize）", tags = "用户表信息：UserRest")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
	})
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public PageResultResponse<User> page(
			@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			UserCondition condition) {

		List<User> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
		PageInfo<User> p = new PageInfo<>(list);
		return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

	}

	@ApiOperation(value = "分页查询用户表信息（参数：实体对象属性、pageNum、pageSize）", tags = "用户表信息：UserRest")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
	})
	@RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
	public JQGridJsonResult<User> pageByJqGrid(
			@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "sord", required = true) String sord,
			UserCondition condition) {
		List<User> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

		PageInfo<User> pageList = new PageInfo<>(list);
		JQGridJsonResult<User> jqGridJson = new JQGridJsonResult<>();
		jqGridJson.setPage(pageList.getPageNum());
		jqGridJson.setTotal(pageList.getPages());
		jqGridJson.setRecords(pageList.getTotal());
		jqGridJson.setRows(list);

		return jqGridJson;
	}
	@ApiOperation(value = "获取当前登录用户信息", tags = "用户信息：UserController")
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ObjectResultResponse<UserContext> getUser() {
		UserContext uc = SessionHolder.getUserContext();
		return createGetSuccess(uc);
	}
	@ApiOperation(value = "用于用户登录，根据用户名称和密码获取用户和角色信息", tags = "用户信息：UserRest")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ObjectResultResponse<Map<String, Object>> login(
			@NotBlank(message = "用户名不能为空") @RequestParam String loginName,
			@NotBlank(message = "用户密码不能为空") @RequestParam String password) throws BizzException {
		logger.info("验证登录用户: " + loginName);
		UserContext userContext = authService.authorize(loginName, password);//查询用户信息
		if(userContext.getStatus().equals("2")){
			return  createFalse("用户名不存在");
		}else if(userContext.getStatus().equals("3")){
			return  createFalse("密码不正确");
		}
		String token = jwtToken.create(userContext);
		String refreshToken = jwtToken.createRefresh(userContext);
		logger.info("生成用户令牌: " + loginName + ", " + token + ", " + refreshToken);
		logger.info("存储用户令牌: " + loginName);
		System.out.println(userContext.getLoginName());
		//redisService.add(RedisKeyPrefix.ZUUL_LOGINTOKEN,userContext.getLoginName(), token, jwtToken.parse(token).getJwtExpiration());
		Map<String, Object> tokenMap = new HashMap<>();
		tokenMap.put(Const.JWT_CLAIMS_USER, userContext);
		tokenMap.put(Const.JWT_TOKEN, token);
		tokenMap.put(Const.JWT_REFRESH_TOKEN, refreshToken);
		return createGetSuccess(tokenMap);
	}
	@ApiOperation(value = "获取当前登录用户信息", tags = "用户信息：UserController")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ObjectResultResponse<String> logout() {
		UserContext userContext = SessionHolder.getUserContext();

		if (userContext == null) {
			logger.info("用户退出登录: 没有当前用户");
		} else {
			String loginName = userContext.getLoginName();
			logger.info("用户退出登录: " + loginName);

			logger.info("删除用户令牌: " + loginName);
			//redisService.delete(RedisKeyPrefix.ZUUL_LOGINTOKEN,loginName);
		}
		return createSuccess();
	}

}