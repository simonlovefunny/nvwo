package com.simon.nvwo.kit;

import org.junit.Test;
/**
 * 
 * @author 昭毅
 *
 */
public class Base64Utils {
	
	
/*	*//**
	 * JDK实现的base64加密
	 * @param src
	 * @throws IOException 
	 *//*
	@Test
	public  void jdkBase64() throws IOException{
		
		String src="imooc java encode";
		//base64加密
		BASE64Encoder encoder=new BASE64Encoder();
		String encode=encoder.encode(src.getBytes());
		
		System.out.println(encode);
		
		//base64解密
		BASE64Decoder decoder=new BASE64Decoder();
		System.out.println(new String(decoder.decodeBuffer(encode)));
		
		
	}*/
	
/*	*//**
	 * commons-codec实现的base64编码/解码
	 *//*
	@Test
	public void commonsBase64Encode(){
		
		String src="imooc java encode";
		
		byte[] encodeBytes=org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		
		System.out.println(new String(encodeBytes));
		
		
		
		System.out.println(new String(org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes)));
	}*/
	
	/**
	 * bouncyCastl实现的base64编码/解码
	 */
	@Test
	public void bouncyCastleBase64(){
		String src="imooc java encode";
		
		byte[] encodeBytes=org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		
		System.out.println(new String(encodeBytes));
		
		
		
		System.out.println(new String(org.bouncycastle.util.encoders.Base64.decode(encodeBytes)));
		
	}

}
