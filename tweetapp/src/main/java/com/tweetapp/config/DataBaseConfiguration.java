package com.tweetapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
// @PropertySource(ignoreResourceNotFound=true,value="classpath:jdbc-${spring.profiles.active}.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:db.properties")
public class DataBaseConfiguration {

	@Value("${jdbc.driver}")
	private String jdbcDriver;

	@Value("${jdbc.host}")
	private String jdbcHost;

	@Value("${jdbc.username}")
	private String jdbcUserName;

	@Value("${jdbc.password}")
	private String password;

	
	public DataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(jdbcDriver);
		dataSource.setUrl(jdbcHost);
		dataSource.setUsername(jdbcUserName);
		dataSource.setPassword(password);

		return dataSource;
	}

}
