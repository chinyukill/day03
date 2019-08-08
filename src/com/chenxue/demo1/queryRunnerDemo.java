package com.chenxue.demo1;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.chenxue.jdbcutils.JDBCUtilsConfig;
/**
 * 使用queryRunner实现对数据库的增删改
 * 调用QueryRunner类的update(Connection con,String sql,Object..param)方法
 * @author chenxue
 *
 */
public class queryRunnerDemo {
	private static Connection con = JDBCUtilsConfig.getConnection();
	public static void main(String[] args) throws SQLException{
		insert();
		update();
		delete();
		DbUtils.closeQuietly(con);
	}
	public static void insert() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into sort2 (sname,sprice,sdesc) values(?,?,?)";
		Object[] param = {"鼠标",22,"拼多多促销"};
		int row = qr.update(con, sql, param);
		System.out.println(row);
		
	}
	public static void update() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql="update sort2 set sname=?,sprice=?,sdesc=? where sid=?";
		Object[] param = {"哈哈",22,"测试update",3};
		int row = qr.update(con, sql, param);
		System.out.println(row);
		
	}
	public static void delete() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql="delete from sort2 where sid=?";
		int param= 4;
		int row = qr.update(con, sql, param);
		System.out.println(row);
	}

}
