package com.my.sts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.my.sts.model.DeptRepo;
import com.my.sts.model.DeptVo;
import com.my.sts.model.entity.Dept;
import com.my.sts.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DeptController {
	private final DeptService deptService;

	@GetMapping("/dept/")
	public List<DeptVo> getList(){
		return deptService.selectAll();
	}
	
	@GetMapping("/dept/{deptno}")
	public DeptVo pullList(@PathVariable int deptno) {
		return deptService.selectOne(deptno);
	}
	
	@PostMapping("/dept/")
	public ResponseEntity<?> addList(@ModelAttribute DeptVo deptVo){
		log.debug(deptVo.toString());
		try {
			deptVo =deptService.insertOne(deptVo);
			return ResponseEntity.status(HttpStatus.CREATED).body(deptVo);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<?> editList(@PathVariable int deptno,@RequestBody DeptVo bean){
		try {
			DeptVo result=deptService.updateOne(bean);
			return ResponseEntity.ok(List.of(result));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<?> rmlist(@PathVariable int deptno){
		try {
			deptService.deleteOne(deptno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
}







