package com.ct;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class JdbcUtilsTest {

	@Test
	public void testReleaseConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection=JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
