package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ReadParams(){
    	super();
    }
    
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	
    	String title="��ȡ���еı�����";
    	
    	String docType="<!doctype html public \"-//w3c//dtd html 4.0 " +
    			"transitional//en\">\n";
    	
    	out.print(docType+
    			"<html>\n" +
    			"<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
    			"<body bgcolor=\"#f0f0f0\">\n" +
    			"<h1 align=\"center\">" + title + "</h1>\n" +
    			"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
    			"<tr bgcolor=\"#949494\">\n" +
    			"<th>��������</th><th>����ֵ</th>\n"+
    			"</tr>\n");
    	
    	      Enumeration paramNames=request.getParameterNames();
    	      
    	     /* ѭ����ȡ��������*/
    	      while(paramNames.hasMoreElements()){
    	    	  String paramName=(String)paramNames.nextElement();
    	    	  out.print("<tr><td>" + paramName + "</td>\n");
    	          
    	    	  String[] paramValues=request.getParameterValues(paramName);
    	    	  
    	    	  /*�жϲ�������ĸ������ֱ����*/
    	    	  if(paramValues.length==1){
    	    		  String paramValue=paramValues[0];
    	    		  if(paramValue.length()==0){
    	    		  out.print("<td><i>û��ֵ</i></td>");
    	    		  } else{
    	    			  out.print("<td><i>"+paramValue+"</i></td>");
    	    		  }
    	    	  }else{
    	    		    //��ȡ�������
    	    		  out.print("<td><ul>");
    	    		  
    	    		  for(int i=0;i<paramValues.length;i++){
    	    			  out.print("<li>"+paramValues[i]+"</li>");
    	    			  
    	    		  }
    	    		  out.print("</ul></td>");
    	    	  }
    	    	  out.print("</tr>");
    	      }
    	      out.print("\n</table>\n</body></html>");
    }
    
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	
    	
    	doGet(request,response);
    }

}
