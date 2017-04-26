package com.simon.nvwo.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * MD�����㷨����
 * @author ����
 *
 */
public class MDUtils {
	

	/**
	 * ʹ��JDKʵ��md5����
	 * 
	 */
	@Test
	public void jdkMD5(){
		
		String src="Java demo MD5";
		
		System.out.println(src);
		
		try {
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			
			byte[] md5Bytes=md.digest(src.getBytes());
			
			//ʹ��commons-codecʵ��byte��string��ת��
			System.out.println("JDK MD5: "+Hex.encodeHexString(md5Bytes));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
