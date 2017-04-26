package com.simon.nvwo.javaweb.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{
	
	
	 private boolean isMulitipart;
	 private String filePath;
	 //�����ϴ��ļ������ֵ
	 private int maxFileSize=50*1024;
	 //�ļ���С�����ֵ
	 private int maxMemSize=4*1024;
	 
	 private File file;
	
	 
	 public void init(){
		 
		 //��ȡ�ļ��Ĵ洢λ��
		 filePath=getServletContext().getInitParameter("file-upload");
	 }
	 
	 public void doPost(HttpServletRequest request,
			 HttpServletResponse response)
					 throws ServletException,IOException{
		 
		 //����Ƿ����ļ��ϴ�����
		 isMulitipart=ServletFileUpload.isMultipartContent(request);
		 
		 
		 
		  response.setContentType("text/html;charset=UTF-8");
		  
		  PrintWriter out=response.getWriter();
		  
		  //����Ƿ����ļ��ϴ�����
		  if(!isMulitipart){
			String docType= "<!doctype html public \"-//w3c//dtd html 4.0 " +
				      "transitional//en\">\n";
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet�ļ��ϴ�</title>");
			out.println("</head>");
			out.println("<body>");
			out.print("<p>û���ļ�Ҫ�ϴ�</p>");
			out.print("</body>");
			out.println("</html>");
			
			return;
			
		  }
		  
		  DiskFileItemFactory factory=new DiskFileItemFactory();
		  //�ļ���С�����ֵ�洢���ڴ���
		  factory.setSizeThreshold(maxMemSize);
		  
		  //������ļ����洢��c:\\temp�ļ�����
		  factory.setRepository(new File("c:\\temp"));
		  
		  //�ļ��ϴ��������
		  ServletFileUpload upload=new ServletFileUpload(factory);
		  
		  //�����ϴ��ļ������ֵ
		  upload.setSizeMax(maxFileSize);
		  
		  //�����ļ��ϴ�����
		  try{
			   
			  List fileItem=upload.parseRequest(request);
			  
			  Iterator i=fileItem.iterator();
			  
			  out.println("<html>");
			  out.println("<head>");
			  out.println("<title>Servlet�ϴ�</servlet>");
			  out.println("</head>");
			  out.println("<body>");
			  
			  while(i.hasNext()){
				  FileItem fi=(FileItem) i.next();
				  
				  if(!fi.isFormField()){
					  
				//��ȡ�ϴ��ļ��Ĳ���
			      String fieldName = fi.getFieldName();
			      String fileName = fi.getName();
			      String contentType = fi.getContentType();
			      boolean isInMemory = fi.isInMemory();
			      long sizeInBytes = fi.getSize();
			       
			      //д���ļ�
			      
			      if(fileName.lastIndexOf("\\") >= 0 ){
			    	    
			    	  file=new File(filePath+
			    			  fileName.substring(fileName.lastIndexOf("\\")));
			      }else{
		               file = new File( filePath + 
		                       fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			      }
			      
			      fi.write(file);
			      out.println("Uploaded Filename:"+fileName+"<br>");
			            
				  }
				     
			  }
			  out.println("</body>");
			  out.println("</html>");
		  }catch(Exception ex){
			  System.out.println(ex);
		  }
		  
	 }
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response)
					  throws ServletException,IOException{
		  
		  throw new ServletException("Get method used with"+
		      getClass().getName()+":Post method required.");
		  


	  }

	  
}
