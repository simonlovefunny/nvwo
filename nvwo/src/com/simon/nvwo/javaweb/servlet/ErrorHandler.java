package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet{
	
	  
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
  	  
  	  //获得异常产生的信息
  	  Throwable throwable=(Throwable)request.getAttribute("javax.servlet.error.exception");
  	  //异常信息的状态码，可以被解析
  	  Integer statusCode=(Integer) request.getAttribute("javax.servlet.error.status_code");
  	  //Servlet名称
  	  String servletName=(String) request.getAttribute("javax.servlet.error.servlet_name");
  	  
  	  
  	  if(servletName==null){
  		   servletName=null;
  	  }
  	  
  	  //url调用Servlet的信息
  	  String requestUrl=(String) request.getAttribute("javax.servlet.error.request_uri");
  	  
  	  if(requestUrl==null){
  		  
  		  requestUrl="Unknow";
  	  }
  	  
  	  response.setContentType("text/html;charset=UTF-8");
  	  
  	  PrintWriter out=response.getWriter();
  	  
  	  String title="Error/Exception Information";
  	  
  	  
  	   String docType =
  		      "<!doctype html public \"-//w3c//dtd html 4.0 " +
  		    	      "transitional//en\">\n";
  	  
        out.println(docType +
      	        "<html>\n" +
      	        "<head><title>" + title + "</title></head>\n" +
      	        "<body bgcolor=\"#f0f0f0\">\n");
        
        if(throwable==null&&statusCode==null){
      	  out.println("<h2>Error infromation is missing</h2>");
            out.println("Please return to the <a href=\""+
          		    response.encodeUrl("http://localtion:8080/")+
          		    "\">Home Page</a>.");
        }else if(statusCode!=null){
      	    out.println("The status code: "+statusCode);
        }else{
      	  
      	  out.println("<h2>Error information</h2>");
      	  out.println("Servlet Name :"+servletName+
      			  "</br><br>");
      	  
      	  out.println("Exception Type :"+ throwable.getClass().getName()+
      			   "</br><br>");
      	  
      	  out.println("The request URL: "+requestUrl+
      			   "</br><br>" );
      	  
      	   out.println("The exception message:"+ 
      	         throwable.getMessage());
        }
  	  
        
        out.println("</body>");
        out.println("</html>");
  	    
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
  	  
  	  
  	   doGet(request,response);
    }
}
