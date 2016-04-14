package com.mysql.proxy.amoeba.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.mysql.proxy.amoeba.dao", "com.mysql.proxy.amoeba.service" })
@Import(DataSourceConfiguration.class)
public class AppConfig {

}
