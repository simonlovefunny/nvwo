package com.simon.nvwo.kit;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * 非对称加密工具类
 * @author 昭毅
 *
 */
public class AsymmetricEncryptionUtils {
	
	//DH算法
	private static String DH="DH";
	
	//RSA算法
	private static String RSA="RSA";
	
/*	*//**
	 * 
	 * <p> 
	 * <code>初始化发送方密钥</code><br/>
	 * </p>
	 * <p> 
	 * <code>初始化接收方密钥</code><br/>
	 * </p>
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * 
	 *//*
	@Test
	public void jdkDH() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		
		String src="JDK DH";
		System.out.println("Data: "+src);
		
		//初始化发送发密钥
		
		KeyPairGenerator senderKeyPairGenerator=KeyPairGenerator.getInstance(DH);
		senderKeyPairGenerator.initialize(512);
		KeyPair senderKeyPair=senderKeyPairGenerator.generateKeyPair();
		//发送方公钥
		byte[] senderPublicKetEnc=senderKeyPair.getPublic().getEncoded();
		
		//初始化接收方密钥
		KeyFactory receiverKeyFactory=KeyFactory.getInstance(DH);

		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(senderPublicKetEnc);
		PublicKey receiverPublicKey=receiverKeyFactory.generatePublic(x509EncodedKeySpec);
		
		DHParameterSpec dhParameterSpec=((DHPublicKey)receiverPublicKey).getParams();
		 
		KeyPairGenerator receiverKeyPairGenerator=KeyPairGenerator.getInstance(DH);
		
		receiverKeyPairGenerator.initialize(dhParameterSpec);
		
		KeyPair receiverKeyPair=receiverKeyPairGenerator.generateKeyPair();
		
		PrivateKey receiverPrivateKey=receiverKeyPair.getPrivate();
		
		byte[] receiverPublicKeyEnc=receiverKeyPair.getPublic().getEncoded();
		
		//构建密钥
		KeyAgreement receiverKeyAgreement=KeyAgreement.getInstance(DH);
		receiverKeyAgreement.init(receiverPrivateKey);
		
		receiverKeyAgreement.doPhase(receiverPublicKey, true);
		
		SecretKey receiverDESKey=receiverKeyAgreement.generateSecret("DES");

		
		KeyFactory senderKeyFactory=KeyFactory.getInstance(DH);
		x509EncodedKeySpec=new X509EncodedKeySpec(receiverPublicKeyEnc);
		PublicKey senderPublicKey=senderKeyFactory.generatePublic(x509EncodedKeySpec);
		
		KeyAgreement senderKeyAgreement=KeyAgreement.getInstance(DH);
		senderKeyAgreement.init(senderKeyPair.getPrivate());
		senderKeyAgreement.doPhase(senderPublicKey, true);
		
		
		SecretKey senderDESKey=senderKeyAgreement.generateSecret("DES");
		
		if(Objects.equals(receiverDESKey, senderDESKey)){
			
			System.out.println("双方密钥相同");
		}
		
		//加密
		Cipher cipher=Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderDESKey);
		
		byte[] result=cipher.doFinal(src.getBytes());
		
		System.out.println("JDK DH: "+Hex.encodeHexString(result));
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, receiverDESKey);
		
		result=cipher.doFinal(result);
		
		System.out.println("JDK DH: "+new String(result));
				
	}*/
	
	@Test
	public void jdkRSA() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		String src="JDK RSA";
		System.out.println("data: "+src);
		//初始化RSA公私钥
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(RSA);
		keyPairGenerator.initialize(512);
		
		KeyPair keyPair=keyPairGenerator.generateKeyPair();
		
		RSAPublicKey rsaPublicKey=(RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey=(RSAPrivateKey) keyPair.getPrivate();
		
		System.out.println("RSA Public Key: "+Base64.encodeToString(rsaPublicKey.getEncoded()));
		System.out.println("RSA Private Key: "+Base64.encodeToString(rsaPrivateKey.getEncoded()));
		
		//用私钥加密，公钥解密
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory keyFactory=KeyFactory.getInstance(RSA);
		PrivateKey privateKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		
		Cipher cipher=Cipher.getInstance(RSA);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		
		byte[] result=cipher.doFinal(src.getBytes());
		System.out.println("RSA ENCODE DATA: "+Base64.encodeToString(result));
		
		//公钥解密
		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
		
		cipher=Cipher.getInstance(RSA);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		result=cipher.doFinal(result);
		
		System.out.println("RSA DECRYPT DATA: "+new String(result));
		
	
	}

}
