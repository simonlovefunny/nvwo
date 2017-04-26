package com.simon.nvwo.kit;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * 
 * @author zhaoyi
 *
 */
public class UploadFileUtils {
	
	//设置最大存储空间为50M
	private static final int  MAX_SIZE=1024*1024*50;
	
	//UTF-8编码格式
	private static final String UTF8="UTF-8";
	
	//ISO-8859-1编码格式
	private static final String ISO88591="ISO-8859-1";
	
	//默认编码格式
	private static final String defaultCharset="UTF-8";
	
	//兆比特
	private static final long megaByte=1000000;
	
	
	/**
	 * 
	 * @param request
	 * @return 判断request请求是否包含附件
	 */
	public static boolean isMultipart(HttpServletRequest request){
		
		
		return ServletFileUpload.isMultipartContent(request);
		
	}
	
	/**
	 * 
	 * @param request
	 * isMultipart返回false时调用，处理单纯的表单（无附件)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotMultiPartRequest(HttpServletRequest request){
		
		
		if(!isMultipart(request)){
		//文件缓存路径
		File path=new File("D:\\cookies\\");
		
		//如果路径不存在，创建文件夹
		if(!path.exists()){
			
			path.mkdirs();
		}
		
		//临时文件夹
		File temp=new File("D:\\temp\\");
		
		if(temp.exists()){
			
			temp.mkdirs();
		}
		
		DiskFileItemFactory itemFactory=new DiskFileItemFactory(MAX_SIZE,temp);
		
		
		ServletFileUpload upload=new ServletFileUpload(itemFactory);
		
		//设置http协议头尾UTF-8编码格式
		upload.setHeaderEncoding(UTF8);
		
		
		try {
			
			
			List<FileItem> items=upload.parseRequest(request);
			
			
			
			Iterator iterator=items.iterator();
			
			if(iterator.hasNext()){
				
				FileItem item=(FileItem) iterator.next();
				
				//处理常规表单
				
					
					String name=item.getFieldName();
					
					String value=item.getString(UTF8);
					
					System.out.println("name:"+name+","+"value+"+value);
					
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
			
		
		return true;
		}else{
			
			return false;
		}

		
		
	}
	
	/**
	 * 
	 * @param request  
	 * @return isMultipart返回true时调用，处理带有附件的request请求
	 * @throws UnsupportedEncodingException
	 */
	public static boolean isMultiPartrequest(HttpServletRequest request) throws UnsupportedEncodingException{
		
         if(isMultipart(request)){
			
			
			//文件缓存路径
			File path=new File("D:\\cookies\\");
			
			//如果路径不存在，创建文件夹
			if(!path.exists()){
				
				path.mkdirs();
			}
			
			//临时文件夹
			File temp=new File("D:\\temp\\");
			
			if(temp.exists()){
				
				temp.mkdirs();
			}
			
			DiskFileItemFactory itemFactory=new DiskFileItemFactory(MAX_SIZE,temp);
			
			
			ServletFileUpload upload=new ServletFileUpload(itemFactory);
			
			//设置http协议头尾UTF-8编码格式
			upload.setHeaderEncoding(UTF8);
			
			
			try {
				
				
				List<FileItem> items=upload.parseRequest(request);
				
				
				Iterator iterator=items.iterator();
				
				if(iterator.hasNext()){
					
					FileItem item=(FileItem) iterator.next();
					
					//处理常规表单
					if(item.isFormField()){
						
						String name=item.getFieldName();
						
						String value=item.getString(UTF8);
						
						System.out.println("name:"+name+","+"value+"+value);
						
					}else{
						
						//处理附件
						
						 String fieldName=item.getFieldName();
						 
						 String fileName=item.getName();
						 
						 long _file_size=item.getSize();
						 
						 
						 System.out.println("name:"+fileName+","+"size:"+((_file_size)/1024)+"KB");
						
						 
						 fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
						 
						 File uploadFile=new File(path+fileName);
						 
						 if(!uploadFile.exists()){
							 
							 try {
								 //保存文件到本地
								item.write(uploadFile);
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								
								e.printStackTrace();
							}
							 
						 }else{
							 
							 System.out.println("name:"+fileName+"is already exists");
							 
						 }
						 
					
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		   return true;	
		}
		
		   return false;
	}
    
	
	//进度条
	public static ProgressListener progressListencer(long pBytesRead, long pContentLength, int pItems){
		
		
		String answer="http://www.cnblogs.com/ybase/archive/2011/11/15/2249298.html";
				
		return null;
		

	}
}
