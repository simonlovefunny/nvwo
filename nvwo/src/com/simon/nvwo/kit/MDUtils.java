package com.simon.nvwo.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * MD加密算法工具
 * @author 昭毅
 *
 */
public class MDUtils {
	

	/**
	 * 使用JDK实现md5加密
	 * 
	 */
	@Test
	public void jdkMD5(){
		
		String src="Java demo MD5";
		
		System.out.println(src);
		
		try {
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			
			byte[] md5Bytes=md.digest(src.getBytes());
			
			//使用commons-codec实现byte到string的转换
			System.out.println("JDK MD5: "+Hex.encodeHexString(md5Bytes));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
