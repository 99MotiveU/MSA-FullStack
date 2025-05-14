package com.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDaoTemp {
	DataSource dataSource;
	
	public DeptDaoTemp() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://c19270c18ce4:3306/xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource=dataSource;
	}
	
	public List<DeptDto> selectAll() throws SQLException{
		String sql="select deptno,dname,loc from dept order by deptno";
		List<DeptDto> list=new ArrayList<DeptDto>();
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptDto(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						));
		}
		
		return list;
	}
	
	public void insertOne(DeptDto bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			pstmt.executeUpdate();
		}
	}
	
	public DeptDto selectOne(int pk) throws SQLException {
		String sql="select deptno,dname,loc from dept where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, pk);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) return new DeptDto(
					rs.getInt(1),rs.getString(2),rs.getString(3)
					);
		}
		return null;
	}
}













