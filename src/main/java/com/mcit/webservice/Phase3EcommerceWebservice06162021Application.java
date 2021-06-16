package com.mcit.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Phase3EcommerceWebservice06162021Application {

	public static void main(String[] args) {
		SpringApplication.run(Phase3EcommerceWebservice06162021Application.class, args);
	}

	
	// @SpringBootApplication  : It used for auto configuration
	
	// @ComponentScan :- enable the component scan on the package
	// @EnableAutoConfiguration :- enable platform configuration
	// @Configuration :-register bean configurations
}
