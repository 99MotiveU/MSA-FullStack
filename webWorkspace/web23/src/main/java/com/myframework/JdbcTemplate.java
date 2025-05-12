package com.myframework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {
	Connection conn;
	
	public JdbcTemplate() {
	}

	public JdbcTemplate(Connection conn) {
		super();
		this.conn = conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	public Object executeOne(String sql) throws SQLException{
		return executeList(sql).get(0);
	}
	public List executeList(String sql) throws SQLException{
		List list=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			setPrepare(pstmt);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMap(rs));
			}
		}finally {
			close(rs,pstmt,conn);
		}
		
		return list;
	}
	public int executeUpdate(String sql) throws SQLException {
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			setPrepare(pstmt);
			return pstmt.executeUpdate();
		}finally {
			close(null,pstmt,conn);
		}
	}
	public abstract void setPrepare(PreparedStatement pstmt) throws SQLException;
	public abstract Object rowMap(ResultSet rs) throws SQLException;
}
