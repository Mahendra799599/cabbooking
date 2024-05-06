package com.abc.driverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
@EnableSpringConfigured
@SpringBootApplication
public class DriverserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverserviceApplication.class, args);
	}

}
