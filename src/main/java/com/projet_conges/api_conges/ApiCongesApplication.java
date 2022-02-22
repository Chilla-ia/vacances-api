package com.projet_conges.api_conges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.projet_conges.api_conges" })
public class ApiCongesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCongesApplication.class, args);
		
		
	}


}
