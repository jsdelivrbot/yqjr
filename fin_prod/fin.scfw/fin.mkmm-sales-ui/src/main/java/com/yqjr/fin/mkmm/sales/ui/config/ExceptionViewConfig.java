package com.yqjr.mkmm.sales.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.Locale;

/**
 * User: Kyll
 * Date: 2018-01-02 20:34
 */
@Configuration
public class ExceptionViewConfig {
	@Autowired
	private ThymeleafViewResolver thymeleafViewResolver;

	@Bean
	public View error() throws Exception {
		return thymeleafViewResolver.resolveViewName("framework/error", Locale.getDefault());
	}
}
