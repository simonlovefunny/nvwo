package com.simon.nvwo.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp {
	
	
	//��ȡһ����Ϊ MyApp��loggerʵ��
	static Logger logger=Logger.getLogger(MyApp.class);
	
	public static void main(String[] args) {
		
		//����һ���򵥵�����ڿ���̨������
		//BasicConfigurator.configure();
		
		logger.info("Entering application.");
		Bar bar=new Bar();		
		bar.doIt();
		logger.info("Exiting application.");
		
		
		
	}

}
