package com.simon.nvwo.kit;

import org.junit.Test;
/**
 * 
 * @author ����
 *
 */
public class Base64Utils {
	
	
/*	*//**
	 * JDKʵ�ֵ�base64����
	 * @param src
	 * @throws IOException 
	 *//*
	@Test
	public  void jdkBase64() throws IOException{
		
		String src="imooc java encode";
		//base64����
		BASE64Encoder encoder=new BASE64Encoder();
		String encode=encoder.encode(src.getBytes());
		
		System.out.println(encode);
		
		//base64����
		BASE64Decoder decoder=new BASE64Decoder();
		System.out.println(new String(decoder.decodeBuffer(encode)));
		
		
	}*/
	
/*	*//**
	 * commons-codecʵ�ֵ�base64����/����
	 *//*
	@Test
	public void commonsBase64Encode(){
		
		String src="imooc java encode";
		
		byte[] encodeBytes=org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		
		System.out.println(new String(encodeBytes));
		
		
		
		System.out.println(new String(org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes)));
	}*/
	
	/**
	 * bouncyCastlʵ�ֵ�base64����/����
	 */
	@Test
	public void bouncyCastleBase64(){
		String src="imooc java encode";
		
		byte[] encodeBytes=org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		
		System.out.println(new String(encodeBytes));
		
		
		
		System.out.println(new String(org.bouncycastle.util.encoders.Base64.decode(encodeBytes)));
		
	}

}
