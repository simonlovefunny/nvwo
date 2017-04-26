package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteHitCounter extends HttpServlet {
    
	private int hitCount;
	/**
	 * Constructor of the object.
	 */
	public SiteHitCounter() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
     
	
	public void doFilter(ServletRequest request,ServletResponse reponse,FilterChain chain)throws IOException,ServletException{
		
		
		//每次计数器+1
		 hitCount++;
		 
		 //输出计数器
		 
		 System.out.println("网站访问统计: "+hitCount);
		 
		 //将请求传回过滤器链
		 chain.doFilter(request, reponse);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
		// 重置点击计数器	
		hitCount=0;
	}
}
