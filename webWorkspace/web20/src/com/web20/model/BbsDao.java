package com.web20.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class BbsDao {
	DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Logger logger=Logger.getLogger(this.getClass().getCanonicalName());
	public BbsDao() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:33306/xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource=dataSource;
	}
	public List<BbsDto> selectAll() throws SQLException{
		List<BbsDto> list=new ArrayList<BbsDto>();
		String sql="select * from bbs order by num desc";
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BbsDto bean=new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getTimestamp("nalja")
						);
				logger.info(bean.toString());
				list.add(bean);
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	} 
	
	public void insertOne(String sub,String content,String id) throws SQLException {
		String sql="insert into bbs (sub,content,id,nalja) values (?,?,?,now())";
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, content);
			pstmt.setString(3, id);			
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public BbsDto selectOne(int num) throws SQLException {
		String sql="select * from bbs where num=?";
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) 
				return new BbsDto(
					rs.getInt("num"),rs.getString("sub"),rs.getString("content")
					,rs.getString("id"),rs.getTimestamp("nalja")
					);
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return null;
	}
}









