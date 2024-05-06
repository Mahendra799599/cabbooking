package com.abc.tripbookingservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
@EnableSpringConfigured
@SpringBootApplication
public class TripbookingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripbookingserviceApplication.class, args);
	}

}
