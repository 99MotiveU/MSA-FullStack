package com.my.sts;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.EmpRepo;
import com.my.sts.model.entity.Dept;
import com.my.sts.model.entity.Emp;

import jakarta.transaction.Transactional;
@EnableTransactionManagement
@SpringBootApplication
public class Sts27Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts27Application.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(DeptRepo deptRepo,EmpRepo empRepo) {
		return args->{
//			Dept dept1=Dept.builder().deptno(10).dname("test1").loc("test").build();
//			deptRepo.save(dept1);
//			Dept dept2=Dept.builder().deptno(20).dname("test2").loc("test").build();
//			deptRepo.save(dept2);
//////			
////////			Emp emp=Emp.builder().empno(1111).deptno(10).ename("user01").nalja(LocalDate.now()).build();
//			empRepo.save(Emp.builder().empno(1111).sal(1000).ename("user01").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(2222).sal(2000).ename("user02").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(3333).sal(3000).ename("user03").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(4444).sal(2500).ename("한글04").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(5555).sal(1500).ename("한글05").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(6666).sal(1200).ename("한글06").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(7777).sal(3000).ename("user77").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(8888).sal(4500).ename("user88").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().empno(9999).sal(2500).ename("user99").dept(dept1).nalja(LocalDate.now()).build());
//			
//			///////////////
			Emp emp1111=empRepo.findById(1111).get();
//			Dept Dept2=deptRepo.findById(emp2.getDeptno()).get();
//			System.out.println(Dept2);
			System.out.println(emp1111.getDept());
			System.out.println("///////////////////");
			Dept dept10=deptRepo.findById(10).get();
//			dept10.getEmps().add(Emp.builder().empno(1001).build());
			System.out.println(dept10.getEmps());
			////
//			System.out.println(empRepo.findByEname("user01"));
//			System.out.println(empRepo.findByEnameAndSal("user02",2000));
//			empRepo.findByEnameOrSal("user02", 1000).forEach(System.out::println);
//			empRepo.findBySalBetween(1000,2000).forEach(System.out::println);
//			empRepo.findBySalLessThanEqual(2000).forEach(System.out::println);
//			empRepo.findBySalIn(1000,2000).forEach(System.out::println);
//			empRepo.findBySalBetweenOrderBySalDesc(1000,2000).forEach(System.out::println);
//			empRepo.findByEnameLike("%0%").forEach(System.out::println);
			
			
//			Sort sort=Sort.by("sal").descending();
//			empRepo.findAll(sort).forEach(System.out::println);
//			Pageable pageable=PageRequest.of(1, 3).withSort(sort);
//			empRepo.findAll(pageable).forEach(System.out::println);
		};
	}

}












