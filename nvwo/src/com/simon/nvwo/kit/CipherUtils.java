
package com.simon.nvwo.kit;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;




/**
 * 加密、解密相关工具.
 * <p>
 * <code>CipherUtils</code>类包括的方法可以对指定的字符串进行标准的<code>"MD5"</code>加密、基于
 * <code>"PBEWithMD5AndDES"</code>的加解密.
 * <p>
 * <code>CipherUtils</code>中的方法, 除非有特殊说明, 否则传入<code>null</code>将返回
 * <code>null</code>.
 * 
 * @author 昭毅
 * @since jdk1.7
 * @version 1.0
 *
 */
public class CipherUtils {

	private CipherUtils() {
	}

	private static final String PBE_WITH_MD5_AND_DES = "PBEWithMD5AndDES";

	private static byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35,
			(byte) 0xE3, (byte) 0x03 };

	private static final String passphrase = "BQA<vom_PMfcixSh123XEa#NLIw@Osj^U";

	/**
	 * 对指定参数做标准的<code>"MD5"</code>加密, 返回加密后的结果.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * String cipher = CipherUtils.md5("abc");
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param plain
	 *            加密的字符串.
	 * @return 加密后的字符串.
	 * @since jdk1.5
	 */
	public static String md5(String plain) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(plain.getBytes("UTF-8"));
		} catch (Exception e) {
			return null;
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				buff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			} else {
				buff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}

		return buff.toString();
	}

	/**
	 * 对指定参数做基于<code>"PBEWithMD5AndDES"</code>的加密, 返回加密后的结果.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * String cipher = CipherUtils.encrypt("abc");
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param plain
	 *            加密的字符串
	 * @return 加密后的字符串.
	 * 
	 * @since jdk1.5
	 * @see java.security.spec.KeySpec
	 * @see javax.crypto.SecretKey
	 */
	public static String encrypt(String plain) {
		try {
			KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt, 19);
			SecretKey key = SecretKeyFactory.getInstance(PBE_WITH_MD5_AND_DES).generateSecret(keySpec);
			Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, 19);
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			byte[] utf8 = plain.getBytes("UTF-8");
			byte[] enc = ecipher.doFinal(utf8);

			return new String(Base64.encode(enc));

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 对指定参数做基于<code>"PBEWithMD5AndDES"</code>的解密, 返回解密后的结果.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * String plain = CipherUtils.decrypt("/bvYmxEHqyM=");
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param secret
	 *            解密的字符串.
	 * @return 解密后的字符串
	 * @since jdk1.5
	 * @see #encrypt(java.lang.String)
	 */
	public static String decrypt(String secret) {
		try {
			KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt, 19);
			SecretKey key = SecretKeyFactory.getInstance(PBE_WITH_MD5_AND_DES).generateSecret(keySpec);
			byte[] dec = Base64.decode(secret.getBytes());
			Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, 19);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			byte[] utf8 = dcipher.doFinal(dec);
			return new String(utf8, "UTF-8");

		} catch (Exception e) {
			return null;
		}
	}

	/***
	 * 解码
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) {
		String rs = null;
		try {
			byte[] d = Base64.decodeBuffer(data);
			int c = -1;
			byte[] buf = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] tmpBuf = new byte[d.length];

			for (int i = 0, j = tmpBuf.length - 1, k = 0;; i++, j--) {
				if (i == j) {
					tmpBuf[k] = d[i];
					break;
				} else if (i > j) {
					break;
				}

				tmpBuf[k++] = d[i];
				tmpBuf[k++] = d[j];
			}

			Inflater inf = new Inflater(true);
			inf.setInput(tmpBuf);
			while (0 != (c = inf.inflate(buf))) {
				baos.write(buf, 0, c);
				baos.flush();
			}
			baos.close();
			inf.end();

			rs = new String(baos.toByteArray(), "utf-8");
		} catch (Exception e) {

		}

		return rs == null ? data : rs;
	}

	/**
	 * 编码
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encode(String data) {
		String rs = null;
		try {
			byte[] buf = new byte[1024];
			int c = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Deflater def = new Deflater(9, true);
			def.setInput(data.getBytes("utf-8"));
			def.finish();

			while (0 != (c = def.deflate(buf))) {
				baos.write(buf, 0, c);
				baos.flush();
			}
			baos.close();
			def.end();

			byte[] tmpBuf = baos.toByteArray();
			byte[] result = new byte[tmpBuf.length];
			for (int i = 0, j = 0, k = tmpBuf.length - 1; i < tmpBuf.length;) {
				result[j++] = tmpBuf[i++];
				if (i == tmpBuf.length)
					break;
				result[k--] = tmpBuf[i++];
			}
			rs = Base64.encodeBuffer(result);
		} catch (Exception e) {
		}

		return rs == null ? data : rs;
	}
}
