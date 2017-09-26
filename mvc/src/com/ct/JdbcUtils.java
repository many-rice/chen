package com.ct;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
	
	private static DataSource dataSource=null;
	
	static {
		//数据源只能被创建一次
		dataSource=new ComboPooledDataSource("mvcapp");
	}
	/**
	 * 释放connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		try {
			if(connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 返回一个数据院connection对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
