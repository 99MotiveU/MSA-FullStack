package com.my.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class Sts26Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts26Application.class, args);
	}
	
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("DEPT API")
	              .description("dept api service")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org"))
	              );
	  }

}
