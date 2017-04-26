package com.simon.nvwo.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.junit.Test;

/**
 * SHA�㷨����
 * <p>
 * <code>SHA-1��JDKʵ��</code><br/>
 * <code>SHA-224��Bouncy Castleʵ��</code><br/>
 * <code>SHA-256��JDKʵ��</code><br/>
 * <code>SHA-384��JDKʵ��</code><br/>
 * <code>SHA-512��JDKʵ��</code><br/>
 * </p>
 * @author ����
 *
 */
public class SHAUtils {
	
	/**
	 * JDKʵ�ֵ�SHA����
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void jdkSHA() throws NoSuchAlgorithmException{
		
		
		String src="Java Demo SHA";
		System.out.println(src);
		
		//SHA-1  SHA-224  SHA-256  SHA-384  SHA-512ͨ��
		MessageDigest md=MessageDigest.getInstance("SHA-1");
		byte[] shaBytes=md.digest(src.getBytes());
		
		System.out.println("JDK SHA: "+Hex.encodeHexString(shaBytes));
		
		
		
	}
	
	/**
	 * bcprovʵ�ֵ�SHA-224����
	 * 
	 */
	@Test
	public void bcprovSHA(){
		
		String src="Java Demo SHA-224";
		System.out.println(src);
		Digest digest=new SHA224Digest();
		//��ѡ����ʼλ�ü���
		digest.update(src.getBytes(), 0, src.getBytes().length);
		
		byte[] sha224Bytes=new byte[digest.getDigestSize()];
		
		digest.doFinal(sha224Bytes, 0);
		
		System.out.println("bcprov SHA-224: "+Hex.encodeHexString(sha224Bytes));
		
		
	}
	
	
	
	

}
