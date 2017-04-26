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
 * �ԳƼ��ܹ�����
 * <p>
 * 
 * <code>  </code>
 * </p>
 * @author ����
 *
 */
public class SymmetricEncryptUtils {
	
	//DES�㷨
	static String DES = "DES/ECB/NoPadding";
	//����DES�㷨
    static String TriDes = "DESede/ECB/NoPadding"; 
    //AES�㷨
    static String AES="AES/ECB/PKCS5Padding";
    //PBE�㷨
    static String PBE="PBEWITHMD5andDES";
   
    /**
     * ʮ�������ַ���ת������
     * @param str ʮ�����ƴ�
     * @return
     */
    public static byte[] hex2byte(String str) { //�ַ���ת������
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
     * ������תʮ�������ַ���
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) { //������ת�ַ���
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
     * des����
     * @param key ��Կ
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return  ��������
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
     * des����
     * @param key ��Կ
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return ��������
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
     * 3des����
     * <p>
	 * <code>��Ek()��Dk()����DES�㷨�ļ��ܺͽ��ܹ��̣�K����DES�㷨ʹ�õ���Կ��M�������ģ�C��������</code><br/>
	 * 
	 * <code>3DES���ܹ���Ϊ��C=Ek3(Dk2(Ek1(M)))</code><br/>
	 * <code>3DES���ܹ���Ϊ��M=Dk1(EK2(Dk3(C)))</code><br/>
	 * 
	 * </p>
     * @param key ��Կ
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return  ��������
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
     * 3des����
     * @param key ��Կ
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return   ��������
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
     * ���ݽ���
     * @param key ��Կ ֧�ֵ����Ͷ౶��Կ
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return ��������
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
     * ��������
     * @param key ��Կ 16�����ҳ���Ϊ16��������
     * @param data �������� 16�����ҳ���Ϊ16��������
     * @return  ��������
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
    	
     //���ؼ��ܲ���
     String key = "11223344556677888877665544332211";
     String data = "1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";
     
     String encData = Hex.encodeHexString(Union3DesEncrypt(key.getBytes(),data.getBytes()));
     System.out.println("encData = "+encData);
     
     String sourData = new String(Union3DesDecrypt(key.getBytes(),Union3DesEncrypt(key.getBytes(),data.getBytes())));
     System.out.println("sourData = "+sourData);
     
     
    }  
    
    
    /**
	 * jdkʵ��des���� /����
	 * DES�㷨����ڲ���������:Key��Data��Mode��<br/>
	 * ����KeyΪ7���ֽڹ�56λ,��DES�㷨�Ĺ�����Կ;DataΪ8���ֽ�64λ,��Ҫ�����ܻ򱻽��ܵ�����;<br/>
	 * ModeΪDES�Ĺ�����ʽ,������:���ܻ����
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
		
		//����key
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
		//Ĭ��56λ
		keyGenerator.init(56);
		SecretKey secretKey=keyGenerator.generateKey();	
		byte[] bytesKey=secretKey.getEncoded();
		
		//keyת��
		DESKeySpec desKeySpec=new DESKeySpec(bytesKey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");	
		Key convertKey=factory.generateSecret(desKeySpec);
		
		//����
		//������䷽ʽ
		Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
		//���ü��� Cipher.ENCRYPT_MODE ���ǽ���ģʽ Cipher.DECRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, convertKey);
		
		byte[] result=cipher.doFinal(src.getBytes());
		
		
		System.out.println("jdk des encode: "+Hex.encodeHexString(result));
		
		
		//����
		//���ü��� Cipher.ENCRYPT_MODE ���ǽ���ģʽ Cipher.DECRYPT_MODE
		cipher.init(Cipher.DECRYPT_MODE, convertKey);
		
		result=cipher.doFinal(result);
		
		
		System.out.println("jdk des decode: "+new String(result));
	}
	*/
    
    /**
     * AES������DES��������
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
    	
    	//����KEY
    	KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");	
    	keyGenerator.init(128);
    	
    	SecretKey secretKey=keyGenerator.generateKey();
    	byte[] keyBytes=secretKey.getEncoded();
    	
    	//keyת��
    	Key key=new SecretKeySpec(keyBytes, "AES");
    	
    	//����
    	Cipher cipher=Cipher.getInstance(AES);
    	//���ô���ģʽΪ����
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	byte[] result=cipher.doFinal(src.getBytes());
    	
    	System.out.println("JDK AES ENCRYPT: "+Hex.encodeHexString(result));
    	
    	//����
    	//���ô���ģʽΪ����
    	cipher.init(Cipher.DECRYPT_MODE, key);
    	result=cipher.doFinal(result);
    	
    	System.out.println("JDK AES DECRYPT: "+new String(result));
    }*/
    
    /**
     * JDK����PBE����
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
    	
    	//��ʼ�� salt(���ڼ��ܵ�����ַ���)
    	SecureRandom random=new SecureRandom(); 	
    	byte[] salt=random.generateSeed(8);
    	
    	
    	//�������Կ
    	String password="encrypt";  	
    	PBEKeySpec pbeKeySpec=new  PBEKeySpec(password.toCharArray());
    	
    	SecretKeyFactory factory=SecretKeyFactory.getInstance(PBE);
    	
    	Key key=factory.generateSecret(pbeKeySpec);
    	
    	//����
    	//���κ͵�����������pbe��������
    	PBEParameterSpec pbePramaterSpec=new PBEParameterSpec(salt, 100);
    	
    	Cipher cipher=Cipher.getInstance(PBE);
    	
    	cipher.init(Cipher.ENCRYPT_MODE, key,pbePramaterSpec);
    	
    	
    	byte[] result=cipher.doFinal(src.getBytes());
    	
    	System.out.println("PBE ENCRYPT: "+Hex.encodeHexString(result));
    	
    	//����
    	cipher.init(Cipher.DECRYPT_MODE, key,pbePramaterSpec);
    	
    	
    	result=cipher.doFinal(result);
    	
    	System.out.println("PBE DECRYPT: "+new String(result));
    	
    }
}
