package com.bit.ai02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Ai02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ai02Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        System.out.println("start init...");
        event.getApplicationContext().getBean(ChatService.class).func01();
    }

}
