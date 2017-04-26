package com.simon.nvwo.kit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;



public class IoUtils {
	

	//UTF-8�����ʽ
	private static final String UTF8="UTF-8";
	
	//ISO-8859-1�����ʽ
	private static final String ISO88591="ISO-8859-1";
	
	//Ĭ�ϱ����ʽ
	private static final String defaultCharset="UTF-8";
	
	
	/**
	 * 
	 * @param url   ��ȡ�ļ���url
	 * @throws MalformedURLException
	 * @throws IOException
	 * ����ʱ�����д�ӡ��ȡ��������Ϣ,Ĭ�ϱ����ʽUTF-8
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
	 * @param url ��ȡ�ļ���url
	 * @param charset  Ŀǰ�ṩ��UTF8�Լ�ISO88591����Ĭ�ϱ��뷽ʽ
	 * @throws MalformedURLException
	 * @throws IOException
	 * ���д�ӡ��ҳ��Ϣ
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
	
	
	//���Է���
	public static void main(String[] args) throws Exception{
		
		//ȥ���ļ�Ŀ¼�е�...
	/*	String filename = "C:/commons/io/../lang/project.xml";
		String normalized = FilenameUtils.normalize(filename);
		// result is "C:/commons/lang/project.xml"
		
		System.out.println(filename+"->"+normalized);*/
		
		
		//���ж�ȡ�ļ���List��
	     File file=new File("D://abc.txt");
	     
	/*   try {
	    	 
			List lines=FileUtils.readLines(file,UTF8);
			
			System.out.println(lines.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	     
	/*    //���л���ļ��Ĺ����������Ƚ����
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
