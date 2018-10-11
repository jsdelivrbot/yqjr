package com.yqjr.scfw.common.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * User: Kyll
 * Date: 2017-12-05 22:14
 */
@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthConfig {
	private String loginPath;
	private String loginAction;
	private String logoutAction;
	private String failurePath;
	private String[] excludePaths;

	public String getLoginPath() {
		return loginPath;
	}

	public void setLoginPath(String loginPath) {
		this.loginPath = loginPath;
	}

	public String getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(String loginAction) {
		this.loginAction = loginAction;
	}

	public String getLogoutAction() {
		return logoutAction;
	}

	public void setLogoutAction(String logoutAction) {
		this.logoutAction = logoutAction;
	}

	public String getFailurePath() {
		return failurePath;
	}

	public void setFailurePath(String failurePath) {
		this.failurePath = failurePath;
	}

	public String[] getExcludePaths() {
		return excludePaths;
	}

	public void setExcludePaths(String[] excludePaths) {
		this.excludePaths = excludePaths;
	}
}
