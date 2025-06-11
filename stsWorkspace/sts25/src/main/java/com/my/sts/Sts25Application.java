package com.my.sts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.entity.Dept;

@SpringBootApplication
public class Sts25Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts25Application.class, args);
	}
	
	@Autowired
	DeptRepo deptRepo;
	
	@Bean
	public CommandLineRunner run() {
		return args->{
//			Dept dept=Dept.builder()
//					.deptno(1111)
//					.dname("test1")
//					.loc("test")
//					.build();
//			deptRepo.save(dept);
//			Optional<Dept> dept=deptRepo.findById(1111);
//			System.out.println(dept.get());
//			List<Dept> list=deptRepo.findByDname("test1");
//			System.out.println("size:"+list.stream().count());
//			list.stream().forEach(System.out::println);
			////////////////////////////
			deptRepo.save(Dept.builder().deptno(2222).dname("test2").loc("test").build());
			deptRepo.save(Dept.builder().deptno(3333).dname("test3").loc("test").build());
			deptRepo.save(Dept.builder().deptno(4444).dname("test4").loc("test").build());
			deptRepo.save(Dept.builder().deptno(5555).dname("test5").loc("test").build());
			deptRepo.findAll().forEach(System.out::println);
			deptRepo.findById(2222).ifPresent(System.out::println);
		};
	}

}





