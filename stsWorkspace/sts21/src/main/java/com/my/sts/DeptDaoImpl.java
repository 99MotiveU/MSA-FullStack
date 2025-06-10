package com.my.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void createTable() {
		jdbcTemplate.execute("create table dept (deptno int, dname varchar(10),loc varchar(10))");
	}
}
