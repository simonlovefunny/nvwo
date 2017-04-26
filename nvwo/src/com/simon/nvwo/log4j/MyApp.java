package com.simon.nvwo.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp {
	
	
	//获取一个名为 MyApp的logger实例
	static Logger logger=Logger.getLogger(MyApp.class);
	
	public static void main(String[] args) {
		
		//启动一个简单的输出在控制台的配置
		//BasicConfigurator.configure();
		
		logger.info("Entering application.");
		Bar bar=new Bar();		
		bar.doIt();
		logger.info("Exiting application.");
		
		
		
	}

}
