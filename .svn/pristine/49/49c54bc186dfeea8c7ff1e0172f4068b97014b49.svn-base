package com.yqjr.scfw.common.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * User: Kyll
 * Date: 2017-12-07 14:30
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
	private String algorithm="HS512";
	private String issuer="http://yqjr.com";
	private String signingKey="xm8EV6Hy5RMFK4EEACIDAwQus";
	private Integer expirationTime=240;
	private Integer refreshExpirationTime=240;
	private String header="X-Authorization";
	private String headPrefix="Bearer";

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSigningKey() {
		return signingKey;
	}

	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}

	public Integer getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Integer expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Integer getRefreshExpirationTime() {
		return refreshExpirationTime;
	}

	public void setRefreshExpirationTime(Integer refreshExpirationTime) {
		this.refreshExpirationTime = refreshExpirationTime;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeadPrefix() {
		return headPrefix;
	}

	public void setHeadPrefix(String headPrefix) {
		this.headPrefix = headPrefix;
	}
}
