package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
/*	//HttpServlet�Ĺ��췽��
	public HelloForm(){
		
		super();
	}*/
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		//Ϊ��������������Cookies
		
		Cookie firstName=new Cookie("first_name",request.getParameter("first_name"));
		
		Cookie lastName=new Cookie("last_name",request.getParameter("last_name"));
		
		//��������Cookies���ù�������Ϊ24Сʱ
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		
		//����Ӧͷ���������Cookies
		response.addCookie(firstName);
		response.addCookie(lastName);
		
		
		//������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		
		String title="ʹ��Get������ȡ������";
		
		PrintWriter out=response.getWriter();
		
		String docType =
		"<!doctype html public \"-//w3c//dtd html 4.0 " +
		"transitional//en\">\n";
		out.println(docType +
		    "<html>\n" +
		    "<head><title>" + title + "</title></head>\n" +
		    "<body bgcolor=\"#f0f0f0\">\n" +
		    "<h1 align=\"center\">" + title + "</h1>\n" +
		    "<ul>\n" +
		    "  <li><b>����</b>��"
		    + request.getParameter("first_name") + "\n" +
		    "  <li><b>����</b>��"
		    + request.getParameter("last_name") + "\n" +
		    "</ul>\n" +
		    "</body></html>");
		
		
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		

		   doGet(request,response);
	}
	
}
