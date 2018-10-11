package com.yqjr.fin.scfw.meta;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * User: Kyll
 * Date: 2017-11-27 11:57
 */
@ComponentScan(basePackages = {"com.yqjr.fin.scfw.meta", "com.yqjr.scfw.common"})
@EnableSwagger2
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class Application {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("express-services online api document")
						.description("Base服务")
						.contact(new Contact("", "", ""))//new Contact("作者名字", "http://作者介绍网址", "作者@邮箱.com")
						.version("1.0.0")
						.build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yqjr.fin.scfw.meta.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
