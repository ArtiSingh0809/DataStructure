package com.sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sample.config.AppConfig;
import com.sample.drivers.DatabaseDriver;
import com.sample.service.UserService;
public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		DatabaseDriver oracleDriver = abstractApplicationContext.getBean("oracleDriver" , DatabaseDriver.class);
		DatabaseDriver mysqlDriver = abstractApplicationContext.getBean("mysqlDriver", DatabaseDriver.class);
		
		System.out.println("Oracle driver info:");
        System.out.println(oracleDriver.getInfo());
        
        System.out.println("MySQL driver info:");
        System.out.println(mysqlDriver.getInfo());

        System.out.println("UserService Information");
        UserService userService = abstractApplicationContext.getBean(UserService.class);
        System.out.println(userService.getDriverInfo());

        abstractApplicationContext.close();
	}

}
