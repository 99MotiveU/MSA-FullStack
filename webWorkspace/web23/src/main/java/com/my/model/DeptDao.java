package com.my.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.myframework.JdbcTemplate1;
import com.myframework.JdbcTemplate2;

public class DeptDao {
	Logger logger=Logger.getLogger(this.getClass().getCanonicalName());
	
	public DeptDao() {
		logger.setLevel(Level.INFO);
	}

	public List<DeptDto> selectAll() throws SQLException{
		String sql="select * from dept";
		JdbcTemplate1 template=new JdbcTemplate1(MyData.getConnection()) {

			@Override
			public Object rowMap(ResultSet rs) throws SQLException {
				return new DeptDto(
						rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")
						);
			}

			@Override
			public void setPrepare(PreparedStatement pstmt) throws SQLException {
			}};
		return template.executeList(sql);
	}
	
	public DeptDto selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		JdbcTemplate1 template=new JdbcTemplate1(MyData.getConnection()) {
			
			@Override
			public void setPrepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, deptno);
			}
			
			@Override
			public Object rowMap(ResultSet rs) throws SQLException {
				return new DeptDto(
						rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")
						);
			}
		};
		return (DeptDto) template.executeOne(sql);
	}
	
	public int insertOne(DeptDto bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		JdbcTemplate2 template=new JdbcTemplate2() {
			public void setPrepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bean.getDeptno());
				pstmt.setString(2, bean.getDname());
				pstmt.setString(3, bean.getLoc());
			}
		};
		template.setConn(MyData.getConnection());
		return template.executeUpdate(sql);
	}
	
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		JdbcTemplate2 template=new JdbcTemplate2() {

			@Override
			public void setPrepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, deptno);
			}
			
		};
		template.setConn(MyData.getConnection());
		return template.executeUpdate(sql);
	}
	
	public int updateOne(DeptDto bean) throws SQLException {
		String sql="update dept set dname=?, loc=? where deptno=?";
		JdbcTemplate2 template=new JdbcTemplate2(MyData.getConnection()) {
			
			@Override
			public void setPrepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bean.getDname());
				pstmt.setString(2, bean.getLoc());
				pstmt.setInt(3, bean.getDeptno());
			}
		};
		return template.executeUpdate(sql);
	}
	
	
	
	public void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}













