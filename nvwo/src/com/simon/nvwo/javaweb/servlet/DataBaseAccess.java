package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DataBaseAccess extends HttpServlet{
	
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver"; 
	public static final  String DB_URL="jdbc:mysql://lcoalhost/test";
	
	public static final String USER="root";
	public static final String PASS="root";
	
	public  void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		  
		response.setContentType("text/html;charset=UTF-8");
		
		
	     PrintWriter out = response.getWriter();
	     String title = "���ݿ���";
	     
	      String docType =
	    	        "<!doctype html public \"-//w3c//dtd html 4.0 " +
	    	         "transitional//en\">\n";
	    	         out.println(docType +
	    	         "<html>\n" +
	    	         "<head><title>" + title + "</title></head>\n" +
	    	         "<body bgcolor=\"#f0f0f0\">\n" +
	    	         "<h1 align=\"center\">" + title + "</h1>\n");
	    	         
	    	
	    	         try{
	    	        	 
	    	        	 //ע��JDBC������
	    	        	 Class.forName(JDBC_DRIVER);
	    	        	 
	    	        	 
	    	        	 //��������һ������
	    	        	Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
	    	        	 
	    	        	//�������ݿ�
	    	        	Statement stmt=conn.createStatement();
	    	        	
	    	        	ResultSet rs=stmt.executeQuery("select * from employees");
	    	        	 
	    	            //�ӽ��������ȡ����
	    	        	
	    	        	while(rs.next()){
	    	        		
	    	        		int id=rs.getInt("id");
	    	        		int age=rs.getInt("age");
	    	        		String first=rs.getString("first");
	    	        		String last=rs.getString("last");
	    	        		
	    	        		//��ʾֵ
	    	        		out.println("ID:"+id+"<br/>");
	    	                out.println(", Age: " + age + "<br>");
	    	                out.println(", First: " + first + "<br>");
	    	                out.println(", Last: " + last + "<br>");
	    	        	}
	    	        	
	    	        	out.println("</body></html>");
	    	            // ������
	    	            rs.close();
	    	            stmt.close();
	    	            conn.close();
	    	         }catch(SQLException se){
	    	            // ���� JDBC ����
	    	            se.printStackTrace();
	    	         }catch(Exception e){
	    	            // ���� Class.forName ����
	    	            e.printStackTrace();
	    	         }
	  
	}
}
