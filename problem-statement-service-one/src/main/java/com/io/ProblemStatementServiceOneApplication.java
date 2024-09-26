package com.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProblemStatementServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProblemStatementServiceOneApplication.class, args);
	}

}