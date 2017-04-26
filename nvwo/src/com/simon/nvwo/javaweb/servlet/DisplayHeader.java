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
		
		//getWriter()返回一个可以发送给客户端的text
		PrintWriter out=response.getWriter();
		
		String docType= "<!doctype html public \"-//w3c//dtd html 4.0 " +
			      "transitional//en\">\n";
		
		String title="HTTP header  实例";
		out.print(docType+
				"<html>\n"+
		        "<head><title>" + title + "</title></head>\n"+
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + title + "</h1>\n" +
		        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
		        "<tr bgcolor=\"#949494\">\n" +
		        "<th>Header 名称</th><th>Header 值</th>\n"+
		        "</tr>\n");
			
		Enumeration headNames=request.getHeaderNames();
		
		if(headNames.hasMoreElements()){
			//获取参数名称
			String paramName=(String)headNames.nextElement();
			out.print("<tr><td>"+paramName+"</td></tr>");
			
			//获取参数值,getHeader()以字符串形式返回指定的请求头的值
			String paramValue=request.getHeader(paramName);
			out.print("<td>"+paramValue+"</td>");
		}
		out.println("</table>\n</body>\n</html>");
	}
	
	//调用doGet()方法处理post请求
	public  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
}
