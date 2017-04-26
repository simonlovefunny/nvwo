package com.simon.nvwo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.simon.nvwo.kit.UtilTest;


/**
 * 读取配置文件的工具类
 * @author zhaoyi
 *
 */
public class PropertiesUtil {
	
		private static Properties pro=null;
		
		
		/**
		 * 加载配置文件
		 * @param filename
		 */
		public static void load(String filename){
			
		pro=new Properties();
		
		InputStream in=PropertiesUtil.class.getResourceAsStream(filename);
		
		try{
			
			pro.load(in);
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
		
	}
		
		/**
		 * 通过key获取对应的value
		 * @param key
		 * @return
		 */
		public static String getValueByKey(String key) {
			// TODO Auto-generated method stub
			
			load("db.properties");
			
			return pro.getProperty(key);
		}
}
