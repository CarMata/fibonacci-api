package com.fibonacci.api.configuration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	  public GroupedOpenApi publicApi() {
	   return GroupedOpenApi.builder()
			   .group("com.fibonacci.api.controller")
			   .packagesToScan("com.fibonacci.api.controller")
			   .build();
	  }
	
	@Bean OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info().title("Fibonacci Rest Api")
				.description("SpringBoot Application to return fibonacci result.")
				.version("v1.0")
				.license(new License()
						.name("Carlos Mendoza")
						.url("https://github.com/CarMata/fibonacci-api")));
		
	}
}
