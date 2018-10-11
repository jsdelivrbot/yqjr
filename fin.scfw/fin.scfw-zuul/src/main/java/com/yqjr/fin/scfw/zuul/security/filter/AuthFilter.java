package com.yqjr.fin.scfw.zuul.security.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yqjr.fin.scfw.zuul.service.RedisService;
import com.yqjr.scfw.common.jwt.JwtToken;
import com.yqjr.scfw.common.redis.RedisKeyPrefix;
import com.yqjr.scfw.common.security.AuthConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Kyll
 * Date: 2017-12-17 09:16
 */
@Configuration
public class AuthFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

//    @Autowired
//    private AuthConfig authConfig;
//    @Autowired
//    private JwtToken jwtToken;
//    @Autowired
//    private RedisService redisService;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//
//        HttpServletRequest request = requestContext.getRequest();
//        String uri = request.getRequestURI();
//
//        boolean exclude = false;
//        for (String path : authConfig.getExcludePaths()) {
//            if (uri.matches(path.replace("**/*", ".*"))) {
//                exclude = true;
//                break;
//            }
//        }
//        logger.info("URI: " + uri + " 忽略验证: " + exclude);
//
//        if (!exclude) {
//            String token = jwtToken.get(request);
//            logger.info("URI: " + uri + " 获取令牌: " + token);
//
//            //是否合法
//            boolean accept = jwtToken.verify(token);
//            logger.info("URI: " + uri + " 验证令牌: " + accept);
//
//            //是否过期
//            if (accept) {
//                accept = redisService.exists(RedisKeyPrefix.ZUUL_LOGINTOKEN,jwtToken.parse(token).getLoginName());
//            }
//
//            if (!accept) {
//                logger.info("URI: " + uri + " 禁止访问");
//
//                requestContext.setSendZuulResponse(false);
//                requestContext.setResponseStatusCode(401);
//            }
//        }

        return null;
    }
}
