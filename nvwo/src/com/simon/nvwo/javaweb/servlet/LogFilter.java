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
		
		//获取初始化参数
		String testParam=config.getInitParameter("test-param");
		
		System.out.println("Test Param:"+testParam);
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//获取客户机的IP地址
		String ipAddress=request.getRemoteAddr();
		
		//记录IP地址和当前时间戳
		
		System.out.println("IP"+ipAddress+",Time"+
		                                  new Date().toString());
		
		//将请求传回过滤连
		chain.doFilter(request,response);
	}


	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
