package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showError extends HttpServlet{
  
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	       
		//设置错误代码和原因
		response.sendError(407, "Need authentication!!");
		
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		   doGet(request,response);
	}
}
