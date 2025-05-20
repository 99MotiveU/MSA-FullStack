package com.my.sts.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDaoJdbcImpl implements DeptDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		}
	};

	@Override
	public List<DeptVo> selectAll() {
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo select(int pk) {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,pk);
	}

	@Override
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql,bean.getDeptno()
						,bean.getDname(),bean.getLoc());
	}

	@Override
	public int updateOne(DeptVo bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate.update(sql,bean.getDname()
						,bean.getLoc(),bean.getDeptno());
	}

	@Override
	public int deleteOne(int pk) {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,pk);
	}

}
