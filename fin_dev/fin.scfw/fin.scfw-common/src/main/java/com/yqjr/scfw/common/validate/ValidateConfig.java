package com.yqjr.scfw.common.validate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * User: Kyll
 * Date: 2018-01-02 11:00
 */
@Configuration
public class ValidateConfig {
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor(){
		return new MethodValidationPostProcessor();
	}
}
