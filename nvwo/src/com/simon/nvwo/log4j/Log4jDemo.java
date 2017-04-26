package com.simon.nvwo.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//log4j示例
public class Log4jDemo {
	
	public static void main(String[] args) {
		
		//获得一个名字为com.nvwo的logger
		Logger logger=Logger.getLogger("com.nvwo");
		
		//设置logger的级别
		//一般在配置文件中配置，此处用于示例
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
