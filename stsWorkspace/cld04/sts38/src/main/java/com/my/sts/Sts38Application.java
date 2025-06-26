package com.my.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Sts38Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts38Application.class, args);
	}

}
