package com.my.sts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.entity.Dept;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class MainController {
	private final DeptRepo deptRepo;

	@GetMapping("/")
	public List list() {
		List list=new ArrayList();
		deptRepo.findAll().forEach(ele->list.add(ele));
//		deptRepo.findAll().forEach(System.out::println);
		
		return list;
	}
	
	@GetMapping("/add")
	public Dept add() {
		Dept dept=deptRepo.save(Dept.builder().deptno(1111).dname("test1").loc("test").build());
		return dept;
	}
	
}









