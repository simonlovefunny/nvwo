package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookies extends HttpServlet{
    
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		Cookie cookie=null;
		Cookie[] cookies=null;
		
		cookies=request.getCookies();
		
		
		response.setContentType("text/http;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		 
	      
	      String title = "Delete Cookies Example";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" );
	      
	      for(int i=0;i<cookies.length;i++){
	    	  
	    	  cookie=cookies[i];
	    	  
	    	  //删除与当前first_name不相同的cookie
	    	  if((cookie.getName()).compareTo("first_name")==0){
	    		  
	    		  //将cookie年龄设置为0来消除
	    		  cookie.setMaxAge(0);
	    		  response.addCookie(cookie);
	    		  
	    		  out.println("已清除的Cookie："+
	    		    cookie.getName()+"<br/>"
	    				  );
	    		  
	    		  out.print("名称:"+cookie.getName()+".");
	    		  out.print("值:"+cookie.getValue()+"<br/>");
	    	  }else{
	    		  
	    		    out.println(
	    		            "<h2 >No cookies founds</h2>");
	    	  }
	    	  
	    	  out.println("</body>");
	    	  out.println("</html>");
	      }
	      
		
		
		
		
	}
}
