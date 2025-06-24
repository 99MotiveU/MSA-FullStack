package com.sts.emp02_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Emp021Application{

	public static void main(String[] args) {
		SpringApplication.run(Emp021Application.class, args);
	}

	// @EventListener
	// public void init(ApplicationContextEvent e){
	// 	System.out.println(e.getApplicationContext());
	// }

}
