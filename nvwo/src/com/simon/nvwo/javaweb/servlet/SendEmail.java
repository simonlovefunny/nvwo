package com.simon.nvwo.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmail extends HttpServlet {



	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		
		//收件人的电子邮箱
		String to="abcd@gmail.com";
		
		//发件人的电子邮箱
		String from="1234@gmail.com";
		
		
		//设置主机
		String host="localhost";
		
		//获取配置参数	
		Properties properties=System.getProperties();
		
		//设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		
		//获取默认的Session对象
		Session session=Session.getDefaultInstance(properties);
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		try{
			    //创建默认的MimeMessage对象
			  MimeMessage message=new MimeMessage(session);
			  
			  //设置From:header field of the header.
			  
			  message.setFrom(new InternetAddress(from));
			  //设置To：header field of the header
			  
			  message.addRecipient( Message.RecipientType.TO, new InternetAddress(to));
			  //设置Subject：header field
			  message.setSubject("This is the Subject Line!");
			  
			  //设置HTML消息
			  message.setContent("<h1>This is actual message</h1>","text/html");
			  //发送消息		  
			  Transport.send(message);
			  
			  String title="发送电子邮件";
			  
			  String res="成功发送邮件...";
			  
		         String docType =
		                 "<!doctype html public \"-//w3c//dtd html 4.0 " +
		                 "transitional//en\">\n";
		                 out.println(docType +
		                 "<html>\n" +
		                 "<head><title>" + title + "</title></head>\n" +
		                 "<body bgcolor=\"#f0f0f0\">\n" +
		                 "<h1 align=\"center\">" + title + "</h1>\n" +
		                 "<p align=\"center\">" + res + "</p>\n" +
		                 "</body></html>");
			  
		}catch(MessagingException mex){
			mex.printStackTrace();
		}
		 

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        doGet(request,response);
	}



}
