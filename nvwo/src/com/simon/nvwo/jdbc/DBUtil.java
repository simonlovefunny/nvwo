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
 * ���ݿ����ӹ�����
 * @author ����
 *��ȡ���ݿ�����connection
 */
public class DBUtil {
	
	//JDBC����
	//���ݿ�����
	private final static String driver=PropertiesUtil.getValueByKey("jdbc.driverClass");
	private final static String url=PropertiesUtil.getValueByKey("jdbc.jdbcUrl");;
	private final static String username=PropertiesUtil.getValueByKey("jdbc.user");;
	private final static String password=PropertiesUtil.getValueByKey("jdbc.password");;

	//�������ݿ�
	public static Connection open(){
		
		
		try {
			
			Class.forName(driver);
			
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	//�ر����ݿ�����
	public static void close(Connection conn){
		
		if(conn!=null){
			
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//C3P0����
	
	private static DataSource dataSource=null;
	
	
	static{
		
		dataSource=new ComboPooledDataSource("nvwo");
	}
	/**
	 * �ͷ����ݿ�����
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		
		return dataSource.getConnection();
		
	}
	

}
