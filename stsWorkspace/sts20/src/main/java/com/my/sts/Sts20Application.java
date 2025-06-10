package com.my.sts;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.model.DeptVo;

@SpringBootApplication
//@Controller
@RestController
public class Sts20Application implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		org.springframework.context.ApplicationContext ac = null;
		ac=SpringApplication.run(Sts20Application.class, args);
		
	}
	
	@GetMapping("/hello")
//	@ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name); 
    }
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01 page";
	}
	
	@GetMapping("/ex02")
	public List<?> ex02(){
		List<String> list = List.of("item1","item2","item3");
		return list;
	}
	@GetMapping("/ex03")
	public Map<String,Object> ex03(){
		Map<String,Object> map=Map.of("key1", 1111, "key2", "val2", "key3","val3");
		return map;
	}
	@GetMapping("/ex04")
	public Set<?> ex04(){
		Set<Object> list = Set.of("item1",2222,Map.of("key1", 1111, "key2", "val2", "key3","val3"));
		return list;
	}
	
	@GetMapping("/ex05")
	public DeptVo ex05() {
		return DeptVo.builder()
				.deptno(9999)
				.dname("TEST")
				.loc("test")
				.build(); 
	}
	
	@GetMapping("/ex06")
	public String ex06(@RequestParam(defaultValue = "test") String name) {
		return name;
	}
	
	@GetMapping("/ex07")
	public DeptVo ex07(DeptVo bean) {
		return bean;
	}
	@PostMapping("/ex08")
	public DeptVo ex08(@ModelAttribute DeptVo bean) {
		return bean;
	}
	@PostMapping("/ex09")
	public DeptVo ex09(@RequestBody DeptVo bean) {
		return bean;
	}
	@PutMapping("/ex10")
	public DeptVo ex10(@RequestBody DeptVo bean) {
		return bean;
	}
	
	@GetMapping("/ex11")
	public ResponseEntity<?> ex11(){
//		return ResponseEntity.ok("");
		return ResponseEntity.notFound().build();
	}
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		jdbcTemplate.execute("drop table dept");
		jdbcTemplate.execute("create table dept(deptno int primary key, dname varchar(10), loc varchar(10))");
		jdbcTemplate.update("insert into dept values (1111,'테스트1','테스트')");
		System.out.println(jdbcTemplate.queryForMap("select * from dept"));
	}

}








