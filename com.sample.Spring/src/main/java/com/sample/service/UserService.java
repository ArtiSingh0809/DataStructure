package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.drivers.DatabaseDriver;

@Service
public class UserService {
	@Autowired
    @Qualifier("oracleDriver")
    private DatabaseDriver dataBaseDriver;

    public String getDriverInfo(){
        return dataBaseDriver.getInfo();
    }

}
