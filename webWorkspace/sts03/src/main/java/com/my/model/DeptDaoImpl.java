package com.my.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DeptDaoImpl{// implements DeptDao {
	JdbcTemplate jdbcTemplate;
	private RowMapper<DeptDto> rowMapper=new RowMapper<DeptDto>() {
		
		@Override
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
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}

	public void insertOne(DeptDto bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}
	
}









