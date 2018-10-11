package com.yqjr.fin.fpms.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.yqjr.fin.fpms.product")
@EnableFeignClients(basePackages = "com.yqjr.fin.rems.rule.api")
@ComponentScan(basePackages={"com.ritoinfo.framework.evo.sp.base.starter.advice","com.yqjr.fin.fpms.product"})
@EnableCircuitBreaker
@EnableSwagger2
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
