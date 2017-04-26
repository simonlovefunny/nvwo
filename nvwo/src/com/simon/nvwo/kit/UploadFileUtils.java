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
	
	//�������洢�ռ�Ϊ50M
	private static final int  MAX_SIZE=1024*1024*50;
	
	//UTF-8�����ʽ
	private static final String UTF8="UTF-8";
	
	//ISO-8859-1�����ʽ
	private static final String ISO88591="ISO-8859-1";
	
	//Ĭ�ϱ����ʽ
	private static final String defaultCharset="UTF-8";
	
	//�ױ���
	private static final long megaByte=1000000;
	
	
	/**
	 * 
	 * @param request
	 * @return �ж�request�����Ƿ��������
	 */
	public static boolean isMultipart(HttpServletRequest request){
		
		
		return ServletFileUpload.isMultipartContent(request);
		
	}
	
	/**
	 * 
	 * @param request
	 * isMultipart����falseʱ���ã��������ı����޸���)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotMultiPartRequest(HttpServletRequest request){
		
		
		if(!isMultipart(request)){
		//�ļ�����·��
		File path=new File("D:\\cookies\\");
		
		//���·�������ڣ������ļ���
		if(!path.exists()){
			
			path.mkdirs();
		}
		
		//��ʱ�ļ���
		File temp=new File("D:\\temp\\");
		
		if(temp.exists()){
			
			temp.mkdirs();
		}
		
		DiskFileItemFactory itemFactory=new DiskFileItemFactory(MAX_SIZE,temp);
		
		
		ServletFileUpload upload=new ServletFileUpload(itemFactory);
		
		//����httpЭ��ͷβUTF-8�����ʽ
		upload.setHeaderEncoding(UTF8);
		
		
		try {
			
			
			List<FileItem> items=upload.parseRequest(request);
			
			
			
			Iterator iterator=items.iterator();
			
			if(iterator.hasNext()){
				
				FileItem item=(FileItem) iterator.next();
				
				//�������
				
					
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
	 * @return isMultipart����trueʱ���ã�������и�����request����
	 * @throws UnsupportedEncodingException
	 */
	public static boolean isMultiPartrequest(HttpServletRequest request) throws UnsupportedEncodingException{
		
         if(isMultipart(request)){
			
			
			//�ļ�����·��
			File path=new File("D:\\cookies\\");
			
			//���·�������ڣ������ļ���
			if(!path.exists()){
				
				path.mkdirs();
			}
			
			//��ʱ�ļ���
			File temp=new File("D:\\temp\\");
			
			if(temp.exists()){
				
				temp.mkdirs();
			}
			
			DiskFileItemFactory itemFactory=new DiskFileItemFactory(MAX_SIZE,temp);
			
			
			ServletFileUpload upload=new ServletFileUpload(itemFactory);
			
			//����httpЭ��ͷβUTF-8�����ʽ
			upload.setHeaderEncoding(UTF8);
			
			
			try {
				
				
				List<FileItem> items=upload.parseRequest(request);
				
				
				Iterator iterator=items.iterator();
				
				if(iterator.hasNext()){
					
					FileItem item=(FileItem) iterator.next();
					
					//�������
					if(item.isFormField()){
						
						String name=item.getFieldName();
						
						String value=item.getString(UTF8);
						
						System.out.println("name:"+name+","+"value+"+value);
						
					}else{
						
						//������
						
						 String fieldName=item.getFieldName();
						 
						 String fileName=item.getName();
						 
						 long _file_size=item.getSize();
						 
						 
						 System.out.println("name:"+fileName+","+"size:"+((_file_size)/1024)+"KB");
						
						 
						 fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
						 
						 File uploadFile=new File(path+fileName);
						 
						 if(!uploadFile.exists()){
							 
							 try {
								 //�����ļ�������
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
    
	
	//������
	public static ProgressListener progressListencer(long pBytesRead, long pContentLength, int pItems){
		
		
		String answer="http://www.cnblogs.com/ybase/archive/2011/11/15/2249298.html";
				
		return null;
		

	}
}
