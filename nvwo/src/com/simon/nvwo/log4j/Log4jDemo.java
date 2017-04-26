package com.simon.nvwo.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//log4jʾ��
public class Log4jDemo {
	
	public static void main(String[] args) {
		
		//���һ������Ϊcom.nvwo��logger
		Logger logger=Logger.getLogger("com.nvwo");
		
		//����logger�ļ���
		//һ���������ļ������ã��˴�����ʾ��
		//DEBUG < INFO < WARN < ERROR < FATAL
		logger.setLevel(Level.INFO);
		
		//
		Logger nvwologger=Logger.getLogger("com.nvwo.logger");
		
		// This request is enabled, because WARN >= INFO.
		logger.warn("Low fuel level.");

		// This request is disabled, because DEBUG < INFO.
		logger.debug("Starting search for nearest gas station.");
	}
	

}
