package com.chenxue.jdbcutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsConfig {
	private static Connection con;
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {
			readConfig();
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readConfig() throws Exception {
		InputStream in = JDBCDemo.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(in);
		driverClass = pro.getProperty("driverClass");
		url=pro.getProperty("url");
		user=pro.getProperty("user");
		password=pro.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
	}
	public static Connection getConnection() {
		return con;
	}
	public static void close(Connection con,Statement stat,ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("close");
		
	}
}
