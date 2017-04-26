package com.simon.nvwo.kit;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * 对称加密工具类
 * <p>
 * 
 * <code>  </code>
 * </p>
 * @author 昭毅
 *
 */
public class SymmetricEncryptUtils {
	
	//DES算法
	static String DES = "DES/ECB/NoPadding";
	//三重DES算法
    static String TriDes = "DESede/ECB/NoPadding"; 
    //AES算法
    static String AES="AES/ECB/PKCS5Padding";
    //PBE算法
    static String PBE="PBEWITHMD5andDES";
   
    /**
     * 十六进制字符串转二进制
     * @param str 十六进制串
     * @return
     */
    public static byte[] hex2byte(String str) { //字符串转二进制
        int len = str.length();
        String stmp = null;
        byte bt[] = new byte[len / 2];
        for (int n = 0; n < len / 2; n++) {
            stmp = str.substring(n * 2, n * 2 + 2);
            bt[n] = (byte) (java.lang.Integer.parseInt(stmp, 16));
        }
        return bt;
    }
   
    /**
     * 二进制转十六进制字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) { //二行制转字符串
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs + "";
            }
        }
        return hs.toUpperCase();
    }
   
    /**
     * des加密
     * @param key 密钥
     * @param data 明文数据 16进制且长度为16的整数倍
     * @return  密文数据
     */
    public static byte[] UnionDesEncrypt(byte key[], byte data[]) { 
 
        try { 
            KeySpec ks = new DESKeySpec(key); 
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES"); 
            SecretKey ky = kf.generateSecret(ks); 
 
            Cipher c = Cipher.getInstance(DES); 
            c.init(Cipher.ENCRYPT_MODE, ky); 
            return c.doFinal(data); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
 
    /**
     * des解密
     * @param key 密钥
     * @param data 密文数据 16进制且长度为16的整数倍
     * @return 明文数据
     */
    public static byte[] UnionDesDecrypt(byte key[], byte data[]) { 
 
        try { 
            KeySpec ks = new DESKeySpec(key); 
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES"); 
            SecretKey ky = kf.generateSecret(ks); 
 
            Cipher c = Cipher.getInstance(DES); 
            c.init(Cipher.DECRYPT_MODE, ky); 
            return c.doFinal(data); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
   
    /**
     * 3des加密
     * <p>
	 * <code>设Ek()和Dk()代表DES算法的加密和解密过程，K代表DES算法使用的密钥，M代表明文，C代表密文</code><br/>
	 * 
	 * <code>3DES加密过程为：C=Ek3(Dk2(Ek1(M)))</code><br/>
	 * <code>3DES解密过程为：M=Dk1(EK2(Dk3(C)))</code><br/>
	 * 
	 * </p>
     * @param key 密钥
     * @param data 明文数据 16进制且长度为16的整数倍
     * @return  密文数据
     */
    public static byte[] Union3DesEncrypt(byte key[], byte data[]) { 
        try { 
            byte[] k = new byte[24]; 
 
            int len = data.length; 
            if(data.length % 8 != 0){ 
                len = data.length - data.length % 8 + 8; 
            } 
            byte [] needData = null; 
            if(len != 0) 
                needData = new byte[len]; 
             
            for(int i = 0 ; i< len ; i++){ 
                needData[i] = 0x00; 
            } 
             
            System.arraycopy(data, 0, needData, 0, data.length); 
             
            if (key.length == 16) { 
                System.arraycopy(key, 0, k, 0, key.length); 
                System.arraycopy(key, 0, k, 16, 8); 
            } else { 
                System.arraycopy(key, 0, k, 0, 24); 
            } 
 
            KeySpec ks = new DESedeKeySpec(k); 
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede"); 
            SecretKey ky = kf.generateSecret(ks); 
 
            Cipher c = Cipher.getInstance(TriDes); 
            c.init(Cipher.ENCRYPT_MODE, ky); 
            return c.doFinal(needData); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
 
    } 
   
    /**
     * 3des解密
     * @param key 密钥
     * @param data 密文数据 16进制且长度为16的整数倍
     * @return   明文数据
     */
    public static byte[] Union3DesDecrypt(byte key[], byte data[]) { 
        try { 
            byte[] k = new byte[24]; 
 
            int len = data.length; 
            if(data.length % 8 != 0){ 
                len = data.length - data.length % 8 + 8; 
            } 
            byte [] needData = null; 
            if(len != 0) 
                needData = new byte[len]; 
             
            for(int i = 0 ; i< len ; i++){ 
                needData[i] = 0x00; 
            } 
             
            System.arraycopy(data, 0, needData, 0, data.length); 
             
            if (key.length == 16) { 
                System.arraycopy(key, 0, k, 0, key.length); 
                System.arraycopy(key, 0, k, 16, 8); 
            } else { 
                System.arraycopy(key, 0, k, 0, 24); 
            } 
            KeySpec ks = new DESedeKeySpec(k); 
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede"); 
            SecretKey ky = kf.generateSecret(ks); 
 
            Cipher c = Cipher.getInstance(TriDes); 
            c.init(Cipher.DECRYPT_MODE, ky); 
            return c.doFinal(needData); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
 
    } 
    /**
     * 数据解密
     * @param key 密钥 支持单倍和多倍密钥
     * @param data 密文数据 16进制且长度为16的整数倍
     * @return 明文数据
     */
    public static String UnionDecryptData(String key, String data)
    {
     if((key.length() != 16) && (key.length() != 32) && (key.length() != 48))
     {
      return(null);
     }
     if(data.length()%16 != 0)
     {
      return"";
     }
     int lenOfKey = 0;
     lenOfKey = key.length();
     String strEncrypt = "";
     byte sourData[] = hex2byte(data);
     switch(lenOfKey)
     {
     case 16:
      byte deskey8[] = hex2byte(key);      
      byte encrypt[] = UnionDesDecrypt(deskey8, sourData);
      strEncrypt = byte2hex(encrypt);
      break;
     case 32:
     case 48:
      String newkey1 = "";
      if(lenOfKey == 32)
      {
       String newkey = key.substring(0, 16);
       newkey1 = key+newkey;
      }else
      {
       newkey1 = key;
      }
      byte deskey24[] = hex2byte(newkey1);
      byte desEncrypt[] = Union3DesDecrypt(deskey24, sourData);
      strEncrypt = byte2hex(desEncrypt);
     }
     return strEncrypt;
    }
   
    /**
     * 加密数据
     * @param key 密钥 16进制且长度为16的整数倍
     * @param data 明文数据 16进制且长度为16的整数倍
     * @return  密文数据
     */
 public static String UnionEncryptData(String key, String data)
    {
     if((key.length() != 16) && (key.length() != 32) && (key.length() != 48))
     {
      return(null);
     }
     if(data.length()%16 != 0)
     {
      return"";
     }
     int lenOfKey = 0;
     lenOfKey = key.length();
     String strEncrypt = "";
     byte sourData[] = hex2byte(data);
     switch(lenOfKey)
     {
     case 16:
      byte deskey8[] = hex2byte(key);      
      byte encrypt[] = UnionDesEncrypt(deskey8, sourData);
      strEncrypt = byte2hex(encrypt);
      break;
     case 32:
     case 48:
      String newkey1 = "";
      if(lenOfKey == 32)
      {
       String newkey = key.substring(0, 16);
       newkey1 = key+newkey;
      }else
      {
       newkey1 = key;
      }
      byte deskey24[] = hex2byte(newkey1);
      byte desEncrypt[] = Union3DesEncrypt(deskey24, sourData);
      strEncrypt = byte2hex(desEncrypt);
      break;
     }
     return strEncrypt;
    }
 
    public static void main(String[] args) { 
    	
     //三重加密测试
     String key = "11223344556677888877665544332211";
     String data = "1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";
     
     String encData = Hex.encodeHexString(Union3DesEncrypt(key.getBytes(),data.getBytes()));
     System.out.println("encData = "+encData);
     
     String sourData = new String(Union3DesDecrypt(key.getBytes(),Union3DesEncrypt(key.getBytes(),data.getBytes())));
     System.out.println("sourData = "+sourData);
     
     
    }  
    
    
    /**
	 * jdk实现des加密 /解密
	 * DES算法的入口参数有三个:Key、Data、Mode。<br/>
	 * 其中Key为7个字节共56位,是DES算法的工作密钥;Data为8个字节64位,是要被加密或被解密的数据;<br/>
	 * Mode为DES的工作方式,有两种:加密或解密
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws UnsupportedEncodingException 
	 */
/*	@Test
	public void jdkDES() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		
		String src="Java JDK DES";
		
		//生成key
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
		//默认56位
		keyGenerator.init(56);
		SecretKey secretKey=keyGenerator.generateKey();	
		byte[] bytesKey=secretKey.getEncoded();
		
		//key转换
		DESKeySpec desKeySpec=new DESKeySpec(bytesKey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");	
		Key convertKey=factory.generateSecret(desKeySpec);
		
		//加密
		//设置填充方式
		Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
		//设置加密 Cipher.ENCRYPT_MODE 还是解密模式 Cipher.DECRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, convertKey);
		
		byte[] result=cipher.doFinal(src.getBytes());
		
		
		System.out.println("jdk des encode: "+Hex.encodeHexString(result));
		
		
		//解密
		//设置加密 Cipher.ENCRYPT_MODE 还是解密模式 Cipher.DECRYPT_MODE
		cipher.init(Cipher.DECRYPT_MODE, convertKey);
		
		result=cipher.doFinal(result);
		
		
		System.out.println("jdk des decode: "+new String(result));
	}
	*/
    
    /**
     * AES加密是DES的升级版
     * 
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     */
/*    @Test
    public void jdkAES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    	
    	
    	String src="Java JDK AES";
    	System.out.println("data: "+src);
    	
    	//生成KEY
    	KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");	
    	keyGenerator.init(128);
    	
    	SecretKey secretKey=keyGenerator.generateKey();
    	byte[] keyBytes=secretKey.getEncoded();
    	
    	//key转换
    	Key key=new SecretKeySpec(keyBytes, "AES");
    	
    	//加密
    	Cipher cipher=Cipher.getInstance(AES);
    	//设置处理模式为加密
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	byte[] result=cipher.doFinal(src.getBytes());
    	
    	System.out.println("JDK AES ENCRYPT: "+Hex.encodeHexString(result));
    	
    	//解密
    	//设置处理模式为加密
    	cipher.init(Cipher.DECRYPT_MODE, key);
    	result=cipher.doFinal(result);
    	
    	System.out.println("JDK AES DECRYPT: "+new String(result));
    }*/
    
    /**
     * JDK进行PBE加密
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidAlgorithmParameterException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws c 
     */
    @Test
    public void jdkPBE() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
    	
    	String src="Java JDK PBE";
    	
    	System.out.println("data: "+src);
    	
    	//初始化 salt(用于加密的随机字符串)
    	SecureRandom random=new SecureRandom(); 	
    	byte[] salt=random.generateSeed(8);
    	
    	
    	//口令和密钥
    	String password="encrypt";  	
    	PBEKeySpec pbeKeySpec=new  PBEKeySpec(password.toCharArray());
    	
    	SecretKeyFactory factory=SecretKeyFactory.getInstance(PBE);
    	
    	Key key=factory.generateSecret(pbeKeySpec);
    	
    	//加密
    	//用盐和迭代次数构造pbe参数对象
    	PBEParameterSpec pbePramaterSpec=new PBEParameterSpec(salt, 100);
    	
    	Cipher cipher=Cipher.getInstance(PBE);
    	
    	cipher.init(Cipher.ENCRYPT_MODE, key,pbePramaterSpec);
    	
    	
    	byte[] result=cipher.doFinal(src.getBytes());
    	
    	System.out.println("PBE ENCRYPT: "+Hex.encodeHexString(result));
    	
    	//解密
    	cipher.init(Cipher.DECRYPT_MODE, key,pbePramaterSpec);
    	
    	
    	result=cipher.doFinal(result);
    	
    	System.out.println("PBE DECRYPT: "+new String(result));
    	
    }
}
