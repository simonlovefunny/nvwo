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
		
		
		//ÿ�μ�����+1
		 hitCount++;
		 
		 //���������
		 
		 System.out.println("��վ����ͳ��: "+hitCount);
		 
		 //�����󴫻ع�������
		 chain.doFilter(request, reponse);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
		// ���õ��������	
		hitCount=0;
	}
}
