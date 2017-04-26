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
	 //允许上传文件的最大值
	 private int maxFileSize=50*1024;
	 //文件大小的最大值
	 private int maxMemSize=4*1024;
	 
	 private File file;
	
	 
	 public void init(){
		 
		 //获取文件的存储位置
		 filePath=getServletContext().getInitParameter("file-upload");
	 }
	 
	 public void doPost(HttpServletRequest request,
			 HttpServletResponse response)
					 throws ServletException,IOException{
		 
		 //检查是否有文件上传请求
		 isMulitipart=ServletFileUpload.isMultipartContent(request);
		 
		 
		 
		  response.setContentType("text/html;charset=UTF-8");
		  
		  PrintWriter out=response.getWriter();
		  
		  //检查是否有文件上传请求
		  if(!isMulitipart){
			String docType= "<!doctype html public \"-//w3c//dtd html 4.0 " +
				      "transitional//en\">\n";
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet文件上传</title>");
			out.println("</head>");
			out.println("<body>");
			out.print("<p>没有文件要上传</p>");
			out.print("</body>");
			out.println("</html>");
			
			return;
			
		  }
		  
		  DiskFileItemFactory factory=new DiskFileItemFactory();
		  //文件大小的最大值存储在内存中
		  factory.setSizeThreshold(maxMemSize);
		  
		  //过大的文件被存储在c:\\temp文件夹下
		  factory.setRepository(new File("c:\\temp"));
		  
		  //文件上传处理程序
		  ServletFileUpload upload=new ServletFileUpload(factory);
		  
		  //允许上传文件的最大值
		  upload.setSizeMax(maxFileSize);
		  
		  //解析文件上传请求
		  try{
			   
			  List fileItem=upload.parseRequest(request);
			  
			  Iterator i=fileItem.iterator();
			  
			  out.println("<html>");
			  out.println("<head>");
			  out.println("<title>Servlet上传</servlet>");
			  out.println("</head>");
			  out.println("<body>");
			  
			  while(i.hasNext()){
				  FileItem fi=(FileItem) i.next();
				  
				  if(!fi.isFormField()){
					  
				//获取上传文件的参数
			      String fieldName = fi.getFieldName();
			      String fileName = fi.getName();
			      String contentType = fi.getContentType();
			      boolean isInMemory = fi.isInMemory();
			      long sizeInBytes = fi.getSize();
			       
			      //写入文件
			      
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
