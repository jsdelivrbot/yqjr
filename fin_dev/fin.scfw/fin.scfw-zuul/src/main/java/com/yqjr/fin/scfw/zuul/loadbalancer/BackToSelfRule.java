package com.yqjr.fin.scfw.zuul.loadbalancer;

import com.netflix.loadbalancer.*;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;

/**
 * User: Kyll Date: 2018-01-10 18:50
 */
public class BackToSelfRule extends RoundRobinRule {
	private static final Logger logger = LoggerFactory.getLogger(BackToSelfRule.class);

	/**
	 * 开发模式时重写服务调用策略 查询来源IP，判断是否有匹配当前IP的服务，如有返回开发者服务。
	 * 
	 * @param loadBalancer
	 * @param key
	 * @return
	 */
	public Server choose(ILoadBalancer loadBalancer, Object key) {
		Server finalServer = super.choose(loadBalancer, key);
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String remoteHost = request.getRemoteHost();
		String headerHostPort = request.getHeader("host");
		logger.info("Client Request Info: " + request.getRequestURL() + ", addr: " + request.getRemoteAddr()
				+ ", host: " + remoteHost + ", port: " + request.getRemotePort() + ", headerHost: " + headerHostPort);
		boolean findService = false;
       logger.info("----打印size-----"+loadBalancer.getReachableServers().size());
		for (Server server : loadBalancer.getReachableServers()) {
			logger.info("serverHost:" + server.getHost());
			if (server.getHost().equals(remoteHost)) {
				finalServer = server;
				findService = true;
				logger.warn("server on " + remoteHost + " is not exist, use default server");
				break;
			}
		}
		
		if (!findService) {
			for (Server server : loadBalancer.getReachableServers()) {
				if (server.getHost().equals("10.20.133.98")) {
					finalServer = server;
					findService = true;
					logger.warn("server on " + remoteHost + " is not exist, use default server");
					break;
				}
			}
		}
		
		if (!findService) {
			for (Server server : loadBalancer.getReachableServers()) {
				if (server.getHost().equals(headerHostPort.split(":")[0])) {
					finalServer = server;
					logger.warn("server on " + remoteHost + " is not exist, use default server");
					break;
				}
			}
		}
		logger.info("this service IP:" + finalServer.getHost() + "-------request IP:" + remoteHost);
		return finalServer;
	}

	// @Override
	// public void initWithNiwsConfig(IClientConfig iClientConfig) {
	// }
	//
	// @Override
	// public Server choose(Object key) {
	// return this.choose(this.getLoadBalancer(), key);
	// }
	//
	// private Server choose(ILoadBalancer loadBalancer, Object key) {
	// if (loadBalancer == null) {
	// logger.warn("no load balancer");
	// return null;
	// }
	//
	// RequestContext requestContext = RequestContext.getCurrentContext();
	// HttpServletRequest request = requestContext.getRequest();
	// String remoteHost = request.getRemoteHost();
	// String headerHostPort = request.getHeader("host");
	//
	// logger.info("Client Request Info: " + request.getRequestURL() + ", addr: " +
	// request.getRemoteAddr() + ", host: " + remoteHost + ", port: " +
	// request.getRemotePort() + ", headerHost: " + headerHostPort);
	//
	// System.out.print("Client Request Info: " + request.getRequestURL() + ", addr:
	// " + request.getRemoteAddr() + ", host: " + remoteHost + ", port: " +
	// request.getRemotePort() + ", headerHost: " + headerHostPort);
	// Server finalServer = null;
	// for (Server server : loadBalancer.getReachableServers()) {
	// if (server.getHost().equals(remoteHost)) {
	// finalServer = server;
	// break;
	// }
	// }
	//
	// if (finalServer == null) {
	// for (Server server : loadBalancer.getReachableServers()) {
	// if (server.getHost().equals(headerHostPort.split(":")[0])) {
	// finalServer = server;
	// break;
	// }
	// }
	//
	// logger.warn("server on " + remoteHost + " is not exist, use default server");
	// } else {
	// logger.info("find server on " + remoteHost);
	// }
	//
	// return finalServer;
	// }
}
