package com.example.Pook;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PookApplication.class, args);
	}

}