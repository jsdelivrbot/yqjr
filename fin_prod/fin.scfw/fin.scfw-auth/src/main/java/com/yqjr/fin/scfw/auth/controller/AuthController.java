package com.yqjr.fin.scfw.auth.controller;


import com.yqjr.fin.scfw.auth.service.AuthService;
import com.yqjr.fin.scfw.auth.service.RedisService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.controller.ScfwController;
import com.yqjr.scfw.common.exception.BizzException;
import com.yqjr.scfw.common.jwt.JwtToken;
import com.yqjr.scfw.common.redis.RedisKeyPrefix;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Validated
@RestController
public class AuthController extends ScfwController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;
	@Autowired
	private JwtToken jwtToken;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/login")
	public ObjectResultResponse<Map<String, Object>> login(
			@NotBlank(message = "用户名不能为空") @RequestParam String loginName,
			@NotBlank(message = "用户密码不能为空") @RequestParam String password) throws BizzException {
		logger.info("验证登录用户: " + loginName);
		UserContext userContext = authService.authorize(loginName, password);//查询用户信息
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

	@RequestMapping(value = "/logout")
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
