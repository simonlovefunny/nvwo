package com.simon.nvwo.kit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




/**
 * ��ȡ�����ļ��Ĺ�����
 * @author zhaoyi
 * ��Ҫ�޸�com.simon.nvwo.kit.PropertiesUtil.getValueByKey(String key)�������ļ�
 */
public class PropertiesUtil {
	
		private static Properties pro=null;
		
		
		/**
		 * ���������ļ�
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
		 * ͨ��key��ȡ��Ӧ��value
		 * @param key
		 * @return
		 */
		public static String getValueByKey(String key) {
			// TODO Auto-generated method stub
			
			load("db.properties");
			
			return pro.getProperty(key);
		}
}

