package com.myframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class JdbcTemplate<T> {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public JdbcTemplate(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int executeUpdate(String sql,Object ... arr) throws SQLException {
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<arr.length; i++) {
				pstmt.setObject(i+1, arr[i]);
			}
			return pstmt.executeUpdate();
		}finally {
			if(conn!=null)conn.close();
		}
	}
	
	public T queryForObject(String sql,RowMapper<T> mapper,Object ... arr) throws SQLException {
		return queryForList(sql,mapper,arr).get(0);
	}
	
	public List<T> queryForList(String sql,RowMapper<T> mapper) throws SQLException {
		return queryForList(sql,mapper,new Object[] {});
	}
	public List<T> queryForList(String sql,RowMapper<T> mapper,Object ... arr) throws SQLException {
		List<T> list=new ArrayList<T>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<arr.length; i++) {
				pstmt.setObject(i+1, arr[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				T obj=mapper.rowMap(rs);
				list.add(obj);
			}
		}finally {
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
}
