package com.yqjr.fin.scfw.meta.config;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperConfig /*implements EnvironmentAware*/ {
	//private String basePackage;

	/*@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(basePackage);
		return mapperScannerConfigurer;
	}


	public void setEnvironment(Environment environment) {
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, null);
		this.basePackage = propertyResolver.getProperty("mybatis.basepackage");
	}*/
}
