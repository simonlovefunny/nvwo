package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{
	   
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//��ȡ��ʼ������
		String testParam=config.getInitParameter("test-param");
		
		System.out.println("Test Param:"+testParam);
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//��ȡ�ͻ�����IP��ַ
		String ipAddress=request.getRemoteAddr();
		
		//��¼IP��ַ�͵�ǰʱ���
		
		System.out.println("IP"+ipAddress+",Time"+
		                                  new Date().toString());
		
		//�����󴫻ع�����
		chain.doFilter(request,response);
	}


	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
