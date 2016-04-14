package com.mysql.proxy.amoeba.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {

	private static final Logger logger = Logger.getLogger(DataSourceConfiguration.class);

	@Autowired
	private Environment env;

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		logger.info("Create dataSource...");
		return jdbcTemplate;
	}

	@Bean(name = "txManager")
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource());
		logger.info("Create dataSource...");
		return txManager;
	}

	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
		dataSource.setUrl(env.getProperty("jdbc.jdbcUrl"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setValidationQuery("SELECT 'x'");
		logger.info("Create dataSource...");
		return dataSource;
	}
}