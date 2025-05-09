package com.my.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BbsDao {
	DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BbsDao() {
		try {
			Context initCtxt=new InitialContext();
			Context envCtxt=(Context) initCtxt.lookup("java:/comp/env");
			dataSource=(DataSource) envCtxt.lookup("jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<BbsDto> selectAll() throws SQLException{
		String sql="select * from bbs order by num desc";
		List<BbsDto> list=new ArrayList<BbsDto>();
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getTimestamp("nalja")
						));
		}finally {
			if(conn!=null)conn.close();
		}
		
		return list;
	}
}













