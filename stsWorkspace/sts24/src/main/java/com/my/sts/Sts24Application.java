package com.my.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Sts24Application{
	//implements CommandLineRunner,ApplicationRunner{

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = null;
		ctxt=SpringApplication.run(Sts24Application.class, args);
//		ctxt.addApplicationListener(a->System.out.println("이벤트 실행"));
		
	}
	@EventListener
	public void init(ApplicationReadyEvent e) {
		System.out.println("init"+e);
	}
	
	@Autowired
	MyService service;
	
//	@Bean
//	public ApplicationRunner runner() {
//		return a->{
//			System.out.println(service);
//		};
//	}
	
//	@Bean
//	public CommandLineRunner runner() {
//		return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("run.."+service);
//			}
//		};
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("CommandLineRunner run..."+Arrays.toString(args));
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("ApplicationRunner run..."+args);
//		System.out.println(args.getNonOptionArgs());
//		System.out.println("ApplicationRunner run..."+Arrays.toString(args.getSourceArgs()));
//	}

}
