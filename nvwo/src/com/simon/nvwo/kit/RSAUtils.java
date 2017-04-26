package com.simon.nvwo.kit;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;



/**
 * ����<code>RSA</code>�ļӽ��ܹ�����.
 * 
 * @author ����
 * @since jdk1.7
 * @version 1.0
 *
 */
public class RSAUtils {

	/**
	 * �����㷨RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * ǩ���㷨
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * ��ȡ��Կ��key
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * ��ȡ˽Կ��key
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * RSA���������Ĵ�С
	 */
	// private static final int MAX_ENCRYPT_BLOCK = 117;
	private static final int MAX_ENCRYPT_BLOCK = 53;

	/**
	 * RSA���������Ĵ�С
	 */
	// private static final int MAX_DECRYPT_BLOCK = 128;
	private static final int MAX_DECRYPT_BLOCK = 64;

	/**
	 * RSA��Կ����
	 */
	private static final int KEY_LONG = 512;
	// private static final int KEY_LONG = 1024;

	/**
	 * <p>
	 * ������Կ��(��Կ��˽Կ)
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(KEY_LONG);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	/**
	 * <p>
	 * ��˽Կ����Ϣ��������ǩ��
	 * </p>
	 * 
	 * @param data
	 *            �Ѽ�������
	 * @param privateKey
	 *            ˽Կ(BASE64����)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(data);
		return Base64.encodeBuffer(signature.sign());
	}

	/**
	 * <p>
	 * У������ǩ��
	 * </p>
	 * 
	 * @param data
	 *            �Ѽ�������
	 * @param publicKey
	 *            ��Կ(BASE64����)
	 * @param sign
	 *            ����ǩ��
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(Base64.decodeBuffer(sign));
	}

	/**
	 * <P>
	 * ˽Կ����
	 * </p>
	 * 
	 * @param encryptedData
	 *            �Ѽ�������
	 * @param privateKey
	 *            ˽Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶν���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 * <p>
	 * ��Կ����
	 * </p>
	 * 
	 * @param encryptedData
	 *            �Ѽ�������
	 * @param publicKey
	 *            ��Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶν���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 * <p>
	 * ��Կ����
	 * </p>
	 * 
	 * @param data
	 *            Դ����
	 * @param publicKey
	 *            ��Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶμ���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	 * <p>
	 * ˽Կ����
	 * </p>
	 * 
	 * @param data
	 *            Դ����
	 * @param privateKey
	 *            ˽Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBuffer(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶμ���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	 * <p>
	 * ��ȡ˽Կ
	 * </p>
	 * 
	 * @param keyMap
	 *            ��Կ��
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return Base64.encodeBuffer(key.getEncoded());
	}

	/**
	 * <p>
	 * ��ȡ��Կ
	 * </p>
	 * 
	 * @param keyMap
	 *            ��Կ��
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return Base64.encodeBuffer(key.getEncoded());
	}

	public static void main(String[] args) throws Exception {
		Map<String, Object> keyMap = genKeyPair();
		String publicKey = getPublicKey(keyMap);
		String privateKey = getPrivateKey(keyMap);

		System.out.println("��Կ:\r\n" + publicKey);
		System.out.println("˽Կ:\r\n" + privateKey);

		String source = "{\"gamekey\":\"f8907fab\",\"tid\":\"123\",\"ver\":\"2.3\",\"network\":\"123\",\"imei\":\"123\",\"os\":\"Android\",\"model\":\"huawei\"}";
		// System.out.println("��Կ���� --- ˽Կ����");
		//
		// System.out.println("����ǰ����: \r\n" + source);
		// byte[] encodeData = encryptByPublicKey(source.getBytes(), publicKey);
		// System.out.println("���ܺ�����: \r\n" + Base64.encodeBuffer(encodeData));
		//
		// // ˽Կ����
		// byte[] decodeData = decryptByPrivateKey(encodeData, privateKey);
		// System.out.println("���ܺ������: \r\n" + new String(decodeData));

		System.out.println("˽Կ���� --- ��Կ����");
		byte[] encodeData = encryptByPrivateKey(source.getBytes(), privateKey);
		System.out.println("���ܺ�����: \r\n" + Base64.encodeBuffer(encodeData));
		// ��Կ����
		byte[] decodeData = decryptByPublicKey(encodeData, publicKey);
		System.out.println("���ܺ�����: \r\n" + new String(decodeData));

		String sign = sign(encodeData, privateKey); // ˽Կǩ��
		System.out.println("˽Կǩ��: \r\n" + sign);

		boolean status = verify(encodeData, publicKey, sign);
		System.out.println("��֤���: \r\n" + status);
	}
}

