package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{
	
	
	private String message;
	
	public void init(){
		
		message="DemoServlet World!";
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		   
		   //������Ӧ��������
		   response.setContentType("text/html");
		   
		   //ҳ�����message
		   PrintWriter out=response.getWriter();
		   out.print("<h1>"+message+"</h1>");
	}
	
	
	public void destory(){
		
	}

}
