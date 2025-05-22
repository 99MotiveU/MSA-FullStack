package com.my.sts.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
	};
	@Override
	public List<DeptVo> selectAll() {
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}

}
