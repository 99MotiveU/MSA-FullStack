package com.my.sts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.sts.model")
public class Sts13Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts13Application.class, args);
	}

}
