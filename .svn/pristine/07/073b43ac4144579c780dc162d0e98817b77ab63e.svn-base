package com.yqjr.fin.mkmm.sales.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.yqjr.scfw.common.mapper.spring.MapperFactoryBean;
import com.yqjr.scfw.common.pagination.interceptor.PaginationInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.yqjr.fin.mkmm.sales.mapper" , factoryBean = MapperFactoryBean.class)
public class MybatisConfig implements EnvironmentAware {
	private String driveClassName;
	private String url;
	private String userName;
	private String password;
	private String xmlLocation;
	private String typeAliasesPackage;
	/////////////////////druid参数///////////////////////////////////////////////////
	private String filters;
	private String maxActive;
	private String initialSize;
	private String maxWait;
	private String minIdle;
	private String timeBetweenEvictionRunsMillis;
	private String minEvictableIdleTimeMillis;
	private String validationQuery;
	private String testWhileIdle;
	private String testOnBorrow;
	private String testOnReturn;
	private String poolPreparedStatements;
	private String maxOpenPreparedStatements;
	//////////////////////////////////////////////////////////////////////////

	@Bean
	public DataSource druidDataSource() throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(userName);
		druidDataSource.setPassword(password);
		druidDataSource.setDriverClassName(StringUtils.isNotBlank(driveClassName) ? driveClassName : "com.mysql.jdbc.Driver");
		druidDataSource.setMaxActive(StringUtils.isNotBlank(maxActive) ? Integer.parseInt(maxActive) : 10);
		druidDataSource.setInitialSize(StringUtils.isNotBlank(initialSize) ? Integer.parseInt(initialSize) : 1);
		druidDataSource.setMaxWait(StringUtils.isNotBlank(maxWait) ? Integer.parseInt(maxWait) : 60000);
		druidDataSource.setMinIdle(StringUtils.isNotBlank(minIdle) ? Integer.parseInt(minIdle) : 3);
		druidDataSource.setTimeBetweenEvictionRunsMillis(StringUtils.isNotBlank(timeBetweenEvictionRunsMillis) ? Integer.parseInt(timeBetweenEvictionRunsMillis) : 60000);
		druidDataSource.setMinEvictableIdleTimeMillis(StringUtils.isNotBlank(minEvictableIdleTimeMillis) ? Integer.parseInt(minEvictableIdleTimeMillis) : 300000);
		druidDataSource.setValidationQuery(StringUtils.isNotBlank(validationQuery) ? validationQuery : "select 'x'");
		druidDataSource.setTestWhileIdle(!StringUtils.isNotBlank(testWhileIdle) || Boolean.parseBoolean(testWhileIdle));
		druidDataSource.setTestOnBorrow(StringUtils.isNotBlank(testOnBorrow) && Boolean.parseBoolean(testOnBorrow));
		druidDataSource.setTestOnReturn(StringUtils.isNotBlank(testOnReturn) && Boolean.parseBoolean(testOnReturn));
		druidDataSource.setPoolPreparedStatements(!StringUtils.isNotBlank(poolPreparedStatements) || Boolean.parseBoolean(poolPreparedStatements));
		druidDataSource.setMaxOpenPreparedStatements(StringUtils.isNotBlank(maxOpenPreparedStatements) ? Integer.parseInt(maxOpenPreparedStatements) : 20);

		druidDataSource.setFilters(StringUtils.isNotBlank(filters) ? filters : "stat, wall");
		return druidDataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		if (StringUtils.isNotBlank(typeAliasesPackage)) {
			bean.setTypeAliasesPackage(typeAliasesPackage);
		}
		//分页插件
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("reasonable", "true");
//		properties.setProperty("supportMethodsArguments", "true");
//		properties.setProperty("returnPageInfo", "check");
//		properties.setProperty("params", "count=countSql");
//		pageHelper.setProperties(properties);
		Interceptor interceptor = new PaginationInterceptor();
		Properties properties = new Properties();
		interceptor.setProperties(properties);
		Interceptor[] plugins = new Interceptor[]{interceptor};
		bean.setPlugins(plugins);
		//添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(xmlLocation));
		return bean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	public void setEnvironment(Environment environment) {
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, null);
		this.url = propertyResolver.getProperty("spring.cloud.datasource.url");
		this.userName = propertyResolver.getProperty("spring.cloud.datasource.username");
		this.password = propertyResolver.getProperty("spring.cloud.datasource.password");
		this.driveClassName = propertyResolver.getProperty("spring.cloud.datasource.driver-class-name");
		this.filters = propertyResolver.getProperty("spring.cloud.datasource.filters");
		this.maxActive = propertyResolver.getProperty("spring.cloud.datasource.maxActive");
		this.initialSize = propertyResolver.getProperty("spring.cloud.datasource.initialSize");
		this.maxWait = propertyResolver.getProperty("spring.cloud.datasource.maxWait");
		this.minIdle = propertyResolver.getProperty("spring.cloud.datasource.minIdle");
		this.timeBetweenEvictionRunsMillis = propertyResolver.getProperty("spring.cloud.datasource.timeBetweenEvictionRunsMillis");
		this.minEvictableIdleTimeMillis = propertyResolver.getProperty("spring.cloud.datasource.minEvictableIdleTimeMillis");
		this.validationQuery = propertyResolver.getProperty("spring.cloud.datasource.validationQuery");
		this.testWhileIdle = propertyResolver.getProperty("spring.cloud.datasource.testWhileIdle");
		this.testOnBorrow = propertyResolver.getProperty("spring.cloud.datasource.testOnBorrow");
		this.testOnReturn = propertyResolver.getProperty("spring.cloud.datasource.testOnReturn");
		this.poolPreparedStatements = propertyResolver.getProperty("spring.cloud.datasource.poolPreparedStatements");
		this.maxOpenPreparedStatements = propertyResolver.getProperty("springcloud..datasource.maxOpenPreparedStatements");
		this.typeAliasesPackage = propertyResolver.getProperty("mybatis.typeAliasesPackage");
		this.xmlLocation = propertyResolver.getProperty("mybatis.xmlLocation");
	}

	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("druidDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
