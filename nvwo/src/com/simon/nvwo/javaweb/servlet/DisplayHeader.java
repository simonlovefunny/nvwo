package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayHeader extends HttpServlet{
    
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		
		//getWriter()����һ�����Է��͸��ͻ��˵�text
		PrintWriter out=response.getWriter();
		
		String docType= "<!doctype html public \"-//w3c//dtd html 4.0 " +
			      "transitional//en\">\n";
		
		String title="HTTP header  ʵ��";
		out.print(docType+
				"<html>\n"+
		        "<head><title>" + title + "</title></head>\n"+
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + title + "</h1>\n" +
		        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
		        "<tr bgcolor=\"#949494\">\n" +
		        "<th>Header ����</th><th>Header ֵ</th>\n"+
		        "</tr>\n");
			
		Enumeration headNames=request.getHeaderNames();
		
		if(headNames.hasMoreElements()){
			//��ȡ��������
			String paramName=(String)headNames.nextElement();
			out.print("<tr><td>"+paramName+"</td></tr>");
			
			//��ȡ����ֵ,getHeader()���ַ�����ʽ����ָ��������ͷ��ֵ
			String paramValue=request.getHeader(paramName);
			out.print("<td>"+paramValue+"</td>");
		}
		out.println("</table>\n</body>\n</html>");
	}
	
	//����doGet()��������post����
	public  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
}
