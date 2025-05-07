package com.mvc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.util.Mysql;

public class BoardDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public int getTotalCount(String keyword) {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM board WHERE title LIKE '%" + keyword + "%' OR content LIKE '%" + keyword + "%'";
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return count;
	}
	
	public List<BoardDto> getList(int page, String keyword) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		int limit = 10;
		
		String sql = "SELECT * FROM board " + 
					 "WHERE title LIKE '%" + keyword + "%' OR content LIKE '%" + keyword + "%' " +
					 "ORDER BY group_id DESC, order_in_group ASC, depth ASC " +
					 "LIMIT " + ((page - 1) * limit) + ", " + limit;
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BoardDto bean = new BoardDto(
							rs.getInt("id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("user_id"),
							rs.getDate("created_at"),
							rs.getInt("group_id"),
							rs.getInt("order_in_group"),
							rs.getInt("depth")
						);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return list;
	}
	
	private int getNextGroupId() {
		int nextGroupId = 1;
		String sql = "SELECT MAX(group_id) FROM board";
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				nextGroupId = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nextGroupId;
	}
	
	public void insertOne(String title, String content, String userId) {
		int groupId = getNextGroupId();
		
		String sql = "INSERT INTO board (title, content, user_id, created_at, group_id, order_in_group, depth) VALUES ('" + title + "', '" + content + "', '" + userId + "', NOW(), '" + groupId + "', 0, 0)";
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertReply(String title, String content, String userId, int groupId, int orderInGroup, int depth) {
		try {
			conn = Mysql.getConnection();
			
			String updateSql = "UPDATE board SET order_in_group = order_in_group + 1 WHERE group_id = " + groupId + " AND order_in_group > " + orderInGroup;
			stmt = conn.createStatement();
			stmt.executeUpdate(updateSql);
			
			String insertSql = "INSERT INTO board (title, content, user_id, created_at, group_id, order_in_group, depth) " +
							   "VALUES ('" + title + "', '" + content + "', '" + userId + "', NoW(), " +
							   groupId + ", " + (orderInGroup + 1) + ", " + (depth + 1) + ")";
			stmt.executeUpdate(insertSql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BoardDto selectOne(int id) {
		BoardDto bean = null;
		String sql = "SELECT * FROM board WHERE id = " + id;
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				bean = new BoardDto(
							rs.getInt("id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("user_id"),
							rs.getDate("created_at"),
							rs.getInt("group_id"),
							rs.getInt("order_in_group"),
							rs.getInt("depth")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	public int editOne(int id, String title, String content) {
		String sql = "UPDATE board SET title='" + title + "', content='" + content + "' WHERE id=" + id;
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteOne(int id) {
		String sql = "DELETE FROM board WHERE id=" + id;
		
		try {
			conn = Mysql.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}

