package com.simon.nvwo.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.junit.Test;

/**
 * SHA算法工具
 * <p>
 * <code>SHA-1由JDK实现</code><br/>
 * <code>SHA-224由Bouncy Castle实现</code><br/>
 * <code>SHA-256由JDK实现</code><br/>
 * <code>SHA-384由JDK实现</code><br/>
 * <code>SHA-512由JDK实现</code><br/>
 * </p>
 * @author 昭毅
 *
 */
public class SHAUtils {
	
	/**
	 * JDK实现的SHA加密
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void jdkSHA() throws NoSuchAlgorithmException{
		
		
		String src="Java Demo SHA";
		System.out.println(src);
		
		//SHA-1  SHA-224  SHA-256  SHA-384  SHA-512通用
		MessageDigest md=MessageDigest.getInstance("SHA-1");
		byte[] shaBytes=md.digest(src.getBytes());
		
		System.out.println("JDK SHA: "+Hex.encodeHexString(shaBytes));
		
		
		
	}
	
	/**
	 * bcprov实现的SHA-224加密
	 * 
	 */
	@Test
	public void bcprovSHA(){
		
		String src="Java Demo SHA-224";
		System.out.println(src);
		Digest digest=new SHA224Digest();
		//可选择起始位置加密
		digest.update(src.getBytes(), 0, src.getBytes().length);
		
		byte[] sha224Bytes=new byte[digest.getDigestSize()];
		
		digest.doFinal(sha224Bytes, 0);
		
		System.out.println("bcprov SHA-224: "+Hex.encodeHexString(sha224Bytes));
		
		
	}
	
	
	
	

}
