package com.my.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.SimpleTransactionStatus;
import org.springframework.transaction.support.TransactionOperations;
import org.springframework.transaction.support.TransactionTemplate;

public class DeptDao2Impl{// implements DeptDao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
	TransactionDefinition definition;//=new DefaultTransactionDefinition();
	
	private RowMapper<DeptDto> rowMapper=new RowMapper<DeptDto>() {
		
		public DeptDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptDto(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		}
	};
	public void setDefinition(TransactionDefinition definition) {
		this.definition = definition;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public List<DeptDto> selectAll(){
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}

	public void insertOne(DeptDto bean) {
		String sql="insert into dept values (?,?,?)";
		TransactionStatus status=transactionManager.getTransaction(definition);
		try {
			jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
			jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
	}
	
}









