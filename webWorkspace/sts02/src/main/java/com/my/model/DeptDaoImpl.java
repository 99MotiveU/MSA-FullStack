package com.my.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao{
	
	RowMapper<DeptDto> rowMapper=new RowMapper<DeptDto>() {
		
		@Override
		public DeptDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptDto bean=new DeptDto(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
			return bean;
		}
	};
	
	@Override
	public List<DeptDto> selectAll(){
		String sql="select * from dept";
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	@Override
	public DeptDto selectOne(int deptno) {
		String sql="select * from dept where deptno=?";
		return getJdbcTemplate().queryForObject(sql,rowMapper,deptno);
	}
	
	@Override
	public void insertOne(DeptDto bean) {
		String sql="insert into dept values (?,?,?)";
		getJdbcTemplate().update(sql,bean.getDeptno()
						,bean.getDname(),bean.getLoc());
	}
	
	@Override
	public int updateOne(DeptDto bean) {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return getJdbcTemplate().update(sql,bean.getDname()
					,bean.getLoc(),bean.getDeptno());
	}
	
	@Override
	public int deleteOne(int deptno) {
		String sql="delete from dept where deptno=?";
		return getJdbcTemplate().update(sql,deptno);
	}
}










