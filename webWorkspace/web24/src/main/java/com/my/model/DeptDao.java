package com.my.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myframework.JdbcTemplate;
import com.myframework.RowMapper;
import com.mysql.cj.jdbc.Driver;

public class DeptDao {
	JdbcTemplate<DeptDto> template;
	RowMapper<DeptDto> rowMapper=new RowMapper<DeptDto>() {
		@Override
		public DeptDto rowMap(ResultSet rs) throws SQLException {
			return new DeptDto(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
	}};
	
	public DeptDao() {
//		setJdbcTemplate();
		try {
			Class.forName(Driver.class.getCanonicalName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setJdbcTemplate(){
		String url="jdbc:mysql://localhost:33306/xe";
		String user="scott";
		String password="tiger";
		try {
			template=new JdbcTemplate<DeptDto>(
					DriverManager.getConnection(url, user, password)
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<DeptDto> selectAll() throws SQLException {
		String sql="select * from dept";
		setJdbcTemplate();
		return  template.queryForList(sql, rowMapper);
	}
	
	public DeptDto selectOne(int pk) throws SQLException {
		String sql="select * from dept where deptno=?";
		setJdbcTemplate();
		return template.queryForObject(sql, rowMapper, pk);
	}
	
	public int insertOne(DeptDto bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		setJdbcTemplate();
		return template.executeUpdate(sql,bean.getDeptno(),bean.getDname(),bean.getLoc());
	}
	
	public int updateOne(DeptDto bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		setJdbcTemplate();
		return template.executeUpdate(sql, 
				bean.getDname(),bean.getLoc(),bean.getDeptno()
		);
	}
	
	public int deleteOne(int pk) throws SQLException {
		String sql="delete from dept where deptno=?";
		setJdbcTemplate();
		return template.executeUpdate(sql, pk);
	}
}












