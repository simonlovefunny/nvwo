package com.simon.nvwo.kit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;



public class IoUtils {
	

	//UTF-8编码格式
	private static final String UTF8="UTF-8";
	
	//ISO-8859-1编码格式
	private static final String ISO88591="ISO-8859-1";
	
	//默认编码格式
	private static final String defaultCharset="UTF-8";
	
	
	/**
	 * 
	 * @param url   读取文件的url
	 * @throws MalformedURLException
	 * @throws IOException
	 * 运行时会逐行打印获取的文字信息,默认编码格式UTF-8
	 */
	public static  void printURLFile(String url) throws MalformedURLException, IOException{
		
		InputStream in=new URL(url).openStream();
		
		try {
			
			
			System.out.println(IOUtils.toString(in,defaultCharset));
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally{
			
			IOUtils.closeQuietly(in);
		}
		
		
		
	}
	
	
	/**
	 * 
	 * @param url 读取文件的url
	 * @param charset  目前提供了UTF8以及ISO88591两种默认编码方式
	 * @throws MalformedURLException
	 * @throws IOException
	 * 逐行打印网页信息
	 */
	public static  void printURLFile(String url,String charset) throws MalformedURLException, IOException{
		
		InputStream in=new URL(url).openStream();
		
		try {
			
			
			System.out.println(IOUtils.toString(in,charset));
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}finally{
			
			IOUtils.closeQuietly(in);
		}
		
		
	}
	
	
	//测试方法
	public static void main(String[] args) throws Exception{
		
		//去除文件目录中的...
	/*	String filename = "C:/commons/io/../lang/project.xml";
		String normalized = FilenameUtils.normalize(filename);
		// result is "C:/commons/lang/project.xml"
		
		System.out.println(filename+"->"+normalized);*/
		
		
		//逐行读取文件到List中
	     File file=new File("D://abc.txt");
	     
	/*   try {
	    	 
			List lines=FileUtils.readLines(file,UTF8);
			
			System.out.println(lines.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	     
	/*    //逐行获得文件的工厂方法，比较灵活
	     LineIterator iterator=FileUtils.lineIterator(file,UTF8);
	     try {
	    	 
			
			
			while(iterator.hasNext()){
				
				String line=iterator.next();
				
				System.out.println(line);
			}
			
		}finally{
			
			LineIterator.closeQuietly(iterator);
		}*/
	     
	     
	}
	
	
	
	
	
	
	
	

}
