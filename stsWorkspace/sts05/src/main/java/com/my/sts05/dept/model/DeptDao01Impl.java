package com.my.sts05.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDao01Impl implements DeptDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {

		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt("deptno")
						,rs.getString("dname"),rs.getString("loc"));
		}
		
	};

	@Override
	public List<DeptVo> selectAll() {
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo selectOne(int pk) {
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno()
					,bean.getDname(),bean.getLoc());
	}

	@Override
	public int updateOne(DeptVo bean) {
		return 0;
	}

	@Override
	public int deleteOne(int pk) {
		return 0;
	}

	@Override
	public int totSize() {
		return 0;
	}

}
