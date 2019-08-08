package com.chenxue.demo1;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.ldap.SortControl;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chenxue.jdbcdomain.sort2;
import com.chenxue.jdbcutils.JDBCUtilsConfig;

public class queryRunnerDemo2 {

	private static Connection conn = JDBCUtilsConfig.getConnection();
	private static String sql="select * from sort2";
	private static QueryRunner qr = new QueryRunner();
	public static void main(String[] args) throws SQLException {
//		arrayHandler();
//		System.out.println();
//		arrayListHandler();
//		System.out.println();
//		beanHandler();
//		beanListHandler();
//		columnListHandler();
//		scalarHandler();
//		mapHandler();
		mapListHandler();
		DbUtils.closeQuietly(conn);
	}

	/*结果集第一种处理方式ArrayHandler
	*将结果集的第一行存储到object数组中
	*/
	public static void arrayHandler() throws SQLException {
		Object[] result = qr.query(conn,sql, new ArrayHandler());
		for(Object obj:result) {
			System.out.print(obj+"\t");
		}
	}
	/*结果集第二种处理方法ArrayListHandler
	 * 将结果集的每一行封装到对象数组中，会出现很多对象数组
	 * 对象数组存到List集合
	 */
	public static void arrayListHandler() throws SQLException {
		List<Object[]> result = qr.query(conn, sql, new ArrayListHandler());
		for(Object[] obj:result) {
			for(Object obj2:obj) {
				System.out.print(obj2+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * 结果集的第三种处理方式，
	 * 将第一行数据封装成javabean对象
	 * 这个bean类必须有空参构造
	 * @throws SQLException 
	 */
	public static void beanHandler() throws SQLException {
		sort2 result = qr.query(conn, sql, new BeanHandler<sort2>(sort2.class));
		System.out.println(result);
	}
	/**
	 * 结果集第四种处理方式
	 * BeanListhandler
	 * @throws SQLException 
	 * 
	 */
	public static void beanListHandler() throws SQLException {
		
		
		List<sort2> result = qr.query(conn, sql, new BeanListHandler<sort2>(sort2.class));
		for(sort2 list:result) {
			System.out.println(list);
		}
	}
	/**
	 * 结果集第五种处理方式
	 * columnListHandler
	 * 结果集指定列数据，存储到list集合中
	 * List<object>每个列数据类型不同
	 * @throws SQLException 
	 */
	public static void columnListHandler() throws SQLException {
		List<Object> result = qr.query(conn, sql, new ColumnListHandler<Object>("sname"));
		for(Object obj:result) {
			System.out.println(obj);
		}
	}
	/**
	 * 第六种处理方式Scalarhandler
	 * 查询后只有一种结果
	 * @throws SQLException 
	 */
	public static void scalarHandler() throws SQLException {
		sql= "select count(*) from sort2";
		Long count = qr.query(conn, sql, new ScalarHandler<Long>());
		System.out.println(count);
	}
	/**
	 * 第七种mapHandler
	 * 第一行数据封装到map集合中
	 * 键值对
	 * @throws SQLException 
	 */
	public static void mapHandler() throws SQLException {
		Map<String, Object> result = qr.query(conn, sql, new MapHandler());
		for(String key:result.keySet()) {
			System.out.println(key+"..."+result.get(key));
		}
	}
	/**
	 * 第八种
	 * mapListHandler
	 * 将结果集每一行封装到map集合中
	 * @throws SQLException 
	 */
	public static void mapListHandler() throws SQLException {
		List<Map<String, Object>> result = qr.query(conn, sql, new MapListHandler());
		for(Map<String, Object> list:result) {
			for(String key:list.keySet()) {
				System.out.print(key+":"+list.get(key)+"\t");
			}
			System.out.println();
		}
	}
}
