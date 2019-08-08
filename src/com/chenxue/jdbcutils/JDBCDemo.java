package com.chenxue.jdbcutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 加载properties配置文件
 * io读取文件，键值对存储到集合
 * @author chenxue
 *
 */
public class JDBCDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		InputStream in = JDBCDemo.class.getClassLoader().getResourceAsStream("database.properties");
		System.out.println(in);
		Properties pro = new Properties();
		pro.load(in);
		String driverClass = pro.getProperty("driverClass");
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
	}

}
