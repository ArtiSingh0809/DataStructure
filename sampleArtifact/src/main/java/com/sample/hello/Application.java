package com.sample.hello;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		hmStudent = new HashMap<Long, Student>();
		Student one = new Student("John", "math");
		hmStudent.put(1L, one);
		Student two = new Student("Jane", "history");
		hmStudent.put(2L, two);
	}

}