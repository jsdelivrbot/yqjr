package com.yqjr.scfw.common.jwt;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.session.UserContext;
import com.yqjr.scfw.common.utils.DateUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * User: Kyll
 * Date: 2017-12-07 14:20
 */
@Component
public class JwtToken {
	@Autowired
	private JwtConfig jwtConfig;

	public String create(UserContext userContext) {
		Claims claims = Jwts.claims().setSubject(userContext.getLoginName());
		claims.put(Const.JWT_CLAIMS_USER, userContext);
		Date now = DateUtils.now();
		return Jwts.builder()
				.setClaims(claims)
				.setIssuer(jwtConfig.getIssuer())
				.setIssuedAt(now)
				.setExpiration(DateUtils.plusMinutes(now, jwtConfig.getExpirationTime()))
				.signWith(SignatureAlgorithm.forName(jwtConfig.getAlgorithm()), jwtConfig.getSigningKey())
				.compact();
	}

	public String createRefresh(UserContext userContext) {
		Claims claims = Jwts.claims().setSubject(userContext.getLoginName());
		claims.put(Const.JWT_CLAIMS_USER, userContext);
		UserContext user=claims.get(Const.JWT_CLAIMS_USER, UserContext.class);
		Date now = DateUtils.now();
		return Jwts.builder()
				.setClaims(claims)
				.setIssuer(jwtConfig.getIssuer())
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(now)
				.setExpiration(DateUtils.plusMinutes(now, jwtConfig.getExpirationTime()))
				.signWith(SignatureAlgorithm.forName(jwtConfig.getAlgorithm()), jwtConfig.getSigningKey())
				.compact();
	}

	@SuppressWarnings("unchecked")
	public UserContext parse(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtConfig.getSigningKey()).parseClaimsJws(token).getBody();

		UserContext userContext = UserContext.create();
		Map<String,Object> map=claims.get(Const.JWT_CLAIMS_USER, Map.class);
		userContext.setId(map.get("id").toString());
		userContext.setLoginName(map.get("loginName").toString());
		userContext.setName(map.get("name").toString());
		userContext.setOaFdno(map.get("oaFdno")==null?"":map.get("oaFdno").toString());
		userContext.setComCode(map.get("comCode")==null?"":map.get("comCode").toString());
		userContext.setOrganizationNo(map.get("organizationNo")==null?"":map.get("organizationNo").toString());	
		userContext.setRegistDate(map.get("registDate")==null?null:DateUtils.TimeStamp(map.get("registDate").toString()));
		userContext.setRegistUser(map.get("registUser")==null?"":map.get("registUser").toString());
		userContext.setSex(map.get("sex")==null?"":map.get("sex").toString());
		userContext.setMobile(map.get("mobile")==null?"":map.get("mobile").toString());
		userContext.setEmail(map.get("email")==null?"":map.get("email").toString());
		userContext.setWcOpenid(map.get("wcOpenid")==null?"":map.get("wcOpenid").toString());
		userContext.setStatus(map.get("status")==null?"":map.get("status").toString());
		userContext.setPassInvalidDate(map.get("passInvalidDate")==null?null:DateUtils.TimeStamp(map.get("passInvalidDate").toString()));
		userContext.setDataAuthType(map.get("dataAuthType")==null?"":map.get("dataAuthType").toString());
		userContext.setComName(map.get("comName")==null?"":map.get("comName").toString());
		userContext.setIdcard(map.get("idcard")==null?"":map.get("idcard").toString());
		userContext.setBirthday(map.get("birthday")==null?null:DateUtils.TimeStamp(map.get("birthday").toString()));
		userContext.setPersonethnic(map.get("personethnic")==null?"":map.get("personethnic").toString());
		userContext.setPersonmarr(map.get("personmarr")==null?"":map.get("personmarr").toString());
		userContext.setPersonschool(map.get("personschool")==null?"":map.get("personschool").toString());
		userContext.setPersonsubject(map.get("personsubject")==null?"":map.get("personsubject").toString());
		userContext.setPersonedu(map.get("personedu")==null?"":map.get("personedu").toString());
		userContext.setPersonedulevel(map.get("personedulevel")==null?"":map.get("personedulevel").toString());
		userContext.setPersonjointime(map.get("personjointime")==null?null:DateUtils.TimeStamp(map.get("personjointime").toString()));
		userContext.setPersonnature(map.get("personnature")==null?"":map.get("personnature").toString());
		userContext.setPersonlevel(map.get("personlevel")==null?"":map.get("personlevel").toString());
		userContext.setAreaCode(map.get("areaCode")==null?"":map.get("areaCode").toString());
		userContext.setAreaName(map.get("areaName")==null?"":map.get("areaName").toString());
		userContext.setRoleIdList(map.get("roleIdList")==null?"":map.get("roleIdList").toString());
		userContext.setRoleCodeList(map.get("roleCodeList")==null?"":map.get("roleCodeList").toString());
		userContext.setRoleSystemIdList((List)map.get("roleSystemIdList"));
		userContext.setRoleSystemNameList((List)map.get("roleSystemNameList"));
		userContext.setJwtToken(token);
		userContext.setJwtExpiration(claims.getExpiration());
		return userContext;
	}

	public String get(HttpServletRequest request) {
		String token = null;

		String header = request.getHeader(jwtConfig.getHeader());
		if (StringUtils.isNotBlank(header)) {
		//	token = header.substring(jwtConfig.getHeadPrefix().length(), header.length()); TODO 安全加强方案
			token = header;
		}

		if (StringUtils.isBlank(token)) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (Const.JWT_TOKEN.equals(cookie.getName())) {
						token = cookie.getValue();
						break;
					}
				}
			}
		}

		return token;
	}

	public boolean verify(String token) {
		if (StringUtils.isBlank(token)) {
			return false;
		}

		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(jwtConfig.getSigningKey()).parseClaimsJws(token).getBody();
		} catch (Exception ignored) {
			return false;
		}

		return jwtConfig.getIssuer().equals(claims.getIssuer());
	}

	public String getConfigOfAlgorithm() {
		return jwtConfig.getAlgorithm();
	}

	public String getConfigOfIssuer() {
		return jwtConfig.getIssuer();
	}

	public String getConfigOfSigningKey() {
		return jwtConfig.getSigningKey();
	}

	public Integer getConfigOfExpirationTime() {
		return jwtConfig.getExpirationTime();
	}

	public Integer getConfigOfRefreshExpirationTime() {
		return jwtConfig.getRefreshExpirationTime();
	}

	public String getConfigOfHeader() {
		return jwtConfig.getHeader();
	}

	public String getConfigOfHeadPrefix() {
		return jwtConfig.getHeadPrefix();
	}
}
