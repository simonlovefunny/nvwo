package com.simon.nvwo.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



/**
 * 数据库连接工具类
 * @author 昭毅
 *获取数据库连接connection
 */
public class DBUtil {
	
	//JDBC链接
	//数据库驱动
	private final static String driver=PropertiesUtil.getValueByKey("jdbc.driverClass");
	private final static String url=PropertiesUtil.getValueByKey("jdbc.jdbcUrl");;
	private final static String username=PropertiesUtil.getValueByKey("jdbc.user");;
	private final static String password=PropertiesUtil.getValueByKey("jdbc.password");;

	//连接数据库
	public static Connection open(){
		
		
		try {
			
			Class.forName(driver);
			
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	//关闭数据库连接
	public static void close(Connection conn){
		
		if(conn!=null){
			
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//C3P0链接
	
	private static DataSource dataSource=null;
	
	
	static{
		
		dataSource=new ComboPooledDataSource("nvwo");
	}
	/**
	 * 释放数据库链接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
	}
	
	/**
	 * 获取数据库连接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		
		return dataSource.getConnection();
		
	}
	

}
