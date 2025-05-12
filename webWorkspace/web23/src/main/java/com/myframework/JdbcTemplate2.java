package com.myframework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.my.model.MyData;

public abstract class JdbcTemplate2 {
//	DataSource dataSource;
	Connection conn;

	public JdbcTemplate2() {
	}

	public JdbcTemplate2(Connection conn) {
		super();
		this.conn = conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	public int executeUpdate(String sql) throws SQLException {
//		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
//			conn=dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			setPrepare(pstmt);
			return pstmt.executeUpdate();
		} finally {
			close(null, pstmt, conn);
		}
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	public abstract void setPrepare(PreparedStatement pstmt) throws SQLException;
}
