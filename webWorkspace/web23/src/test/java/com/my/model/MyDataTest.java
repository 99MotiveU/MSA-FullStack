package com.my.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class MyDataTest {

	@Test
	public void testGetConnection() {
		Connection  conn=null;
		try {
			conn=MyData.getConnection();
			assertNotNull("conn is null",conn);
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

}
