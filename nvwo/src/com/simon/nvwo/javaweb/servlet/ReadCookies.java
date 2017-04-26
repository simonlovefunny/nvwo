package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class ReadCookies extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		
		Cookie cookie=null;
		//����javax.servlet.http����������
		Cookie[] cookies=null;
		
		cookies=request.getCookies();
		//������Ӧ��������
		
		response.setContentType("text/html:charset=UTF-8");
		
	      PrintWriter out = response.getWriter();
	      String title = "Reading Cookies Example";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" );
	      if( cookies != null ){
	         out.println("<h2>���� Cookies ���ƺ�ֵ</h2>");
	         for (int i = 0; i < cookies.length; i++){
	            cookie = cookies[i];
	            out.print("���ƣ�" + cookie.getName( ) + "��");
	            out.print("ֵ��" + cookie.getValue( )+" <br/>");
	         }
	      }else{
	          out.println("<h2>δ�ҵ� Cookies</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
	}

}
