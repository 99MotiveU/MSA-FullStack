package com.my.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

public class DeptDao3Impl{// implements DeptDao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
	TransactionDefinition definition;
	public void setDefinition(TransactionDefinition definition) {
		this.definition = definition;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	private RowMapper<DeptDto> rowMapper=new RowMapper<DeptDto>() {
		
		public DeptDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptDto(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<DeptDto> selectAll(){
		String sql="select * from dept order by deptno desc";
		PreparedStatementCreator psc=null;
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				System.out.println(conn);
				return conn.prepareStatement(sql);
			}
		};
		TransactionStatus status=transactionManager.getTransaction(definition);
		try {
			jdbcTemplate.query(psc, rowMapper);
			List<DeptDto> result= jdbcTemplate.query(psc, rowMapper);
			transactionManager.commit(status);
			return result;
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return null;
	}

	public void insertOne(DeptDto bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}
	
}









