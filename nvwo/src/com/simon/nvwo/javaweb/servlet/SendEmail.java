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
        
		
		//�ռ��˵ĵ�������
		String to="abcd@gmail.com";
		
		//�����˵ĵ�������
		String from="1234@gmail.com";
		
		
		//��������
		String host="localhost";
		
		//��ȡ���ò���	
		Properties properties=System.getProperties();
		
		//�����ʼ�������
		properties.setProperty("mail.smtp.host", host);
		
		//��ȡĬ�ϵ�Session����
		Session session=Session.getDefaultInstance(properties);
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		try{
			    //����Ĭ�ϵ�MimeMessage����
			  MimeMessage message=new MimeMessage(session);
			  
			  //����From:header field of the header.
			  
			  message.setFrom(new InternetAddress(from));
			  //����To��header field of the header
			  
			  message.addRecipient( Message.RecipientType.TO, new InternetAddress(to));
			  //����Subject��header field
			  message.setSubject("This is the Subject Line!");
			  
			  //����HTML��Ϣ
			  message.setContent("<h1>This is actual message</h1>","text/html");
			  //������Ϣ		  
			  Transport.send(message);
			  
			  String title="���͵����ʼ�";
			  
			  String res="�ɹ������ʼ�...";
			  
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
