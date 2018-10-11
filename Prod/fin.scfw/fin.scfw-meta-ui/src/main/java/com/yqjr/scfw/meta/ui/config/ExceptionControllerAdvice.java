package com.yqjr.scfw.meta.ui.config;

import com.yqjr.scfw.common.utils.DateUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Kyll
 * Date: 2018-01-02 20:09
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler
	public ModelAndView defaultHandler(HttpServletRequest requset, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", requset.getRequestURL());
		mav.addObject("path", requset.getServletPath());
		mav.addObject("timestamp", DateUtils.formatDatetime(DateUtils.now()));
		mav.addObject("message", e.getMessage());
		mav.addObject("exception", e);
		mav.setViewName("error");
		return mav;
	}
}
