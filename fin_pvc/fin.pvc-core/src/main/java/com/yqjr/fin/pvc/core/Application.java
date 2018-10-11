package com.yqjr.fin.pvc.core;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * User: Kyll
 * Date: 2017-11-27 11:57
 */
@MapperScan(basePackages = {"com.yqjr.fin.pvc.core"})
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
