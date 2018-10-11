package com.yqjr.fin.scfw.isomer.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}
	
	/**
	 * 获取当前请求对象
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		try{
			return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		}catch(Exception e){
			return null;
		}
	}
}
