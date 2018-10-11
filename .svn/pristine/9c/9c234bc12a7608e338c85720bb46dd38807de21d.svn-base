package com.yqjr.scfw.common.session;

import com.yqjr.scfw.common.jwt.JwtToken;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kyll Date: 2017-12-07 15:14
 */
@Order(1)
@WebFilter(filterName = "SessionFilter", urlPatterns = "/*")
@Component
public class SessionFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);

	@Autowired
	private JwtToken jwtToken;

	//计划匹配定时，活动匹配定时，人员状态定时，业务数据获取定时  放行
	private static final Set<String> ALLOWED_PATHS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("/users/login","/activeTimedTask/build","/basicBussinesss/dataProcess","/activeTimedTask/match","/planTrackTimedTask/build",
                                                        "/planTrackTimedTask/track","/EffectiveChanges/changePersonStatus","/commodityOuts/queryCommodityList","/commodityOuts/receiveCommodity",
                                                        "/materialOuts/queryMaterialList","/materialOuts/receiveMaterial", "/dealerAreas/traverseInformation", "/dealerAreas/cleanTable",
                                                        "/dealerBrandss/traverseInformation", "/dealerBrandss/cleanTable", "/commodityOuts/queryCommodityList", "/commodityOuts/receiveCommodity",
                                                        "/materialOuts/queryMaterialList", "/materialOuts/MaterialOutToSave")));

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
		boolean allowedPath = ALLOWED_PATHS.contains(path);
		if (!allowedPath) {
			String uri = request.getRequestURI();
			String token = jwtToken.get(request);
			UserContext userContext = null;
			try {
				userContext = jwtToken.parse(token);
				SessionContext.getCurrentContext().unset();
				SessionContext.setContextClass(SessionHolder.class);
				SessionHolder.getCurrentHolder().setUserContext(userContext);
			} catch (Exception e) {
				logger.warn("URI: " + uri + " 令牌解析失败", e);
				//request.getRequestDispatcher("/ui/comm/login").forward(request, response);
				SessionContext.getCurrentContext().unset();
				SessionContext.setContextClass(SessionHolder.class);
				SessionHolder.getCurrentHolder().setUserContext(userContext);
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
