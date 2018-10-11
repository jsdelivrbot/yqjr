package com.yqjr.fin.qcms.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.yqjr.fin.qcms.credit")
@ComponentScan(basePackages={"com.ritoinfo.framework.evo.sp.base.starter.advice","com.yqjr.fin.qcms.credit"})
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
