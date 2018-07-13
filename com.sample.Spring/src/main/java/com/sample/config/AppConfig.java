package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.sample.drivers.DatabaseDriver;
import com.sample.drivers.MySqlDriver;
import com.sample.drivers.OracleDriver;

@Configuration
@ComponentScan("com.sample")
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {

	
	@Autowired
    Environment environment;
	
	@Bean
	DatabaseDriver oracleDriver() {
        OracleDriver oracleDriver = new OracleDriver();
        oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));
        return oracleDriver;
	}

	@Bean
	DatabaseDriver mysqlDriver() {
		System.out.println("11");
		return new MySqlDriver();
	}
	
	@Bean
	DatabaseDriver mysqlDriver(String s) {
		System.out.println("22");
		return new MySqlDriver();
	}
}
