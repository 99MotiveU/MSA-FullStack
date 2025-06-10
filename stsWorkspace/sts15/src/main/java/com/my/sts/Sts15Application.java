package com.my.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
public class Sts15Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts15Application.class, args);
		new Bean().setSu(1234);
	}

	@Data
	static class Bean{
		int su;
		String name;
	}
}


