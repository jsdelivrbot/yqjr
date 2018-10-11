package com.yqjr.fin.scfw.auth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * User: Kyll
 * Date: 2017-11-27 11:57
 */
@ComponentScan(basePackages = {"com.yqjr.fin.scfw.auth", "com.yqjr.scfw.common"})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application {
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
