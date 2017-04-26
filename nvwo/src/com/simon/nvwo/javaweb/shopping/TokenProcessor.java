package com.simon.nvwo.javaweb.shopping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 
* @ClassName: TokenProcessor
* @Description: JSP表单重复标记生成类
* @author zhaoyi 1508108406@qq.com
* @date 2017年4月5日 下午9:01:48
*
 */
public class TokenProcessor {
	
	private static final String TOKEN_KEY = "NVWO.TOKEN_KEY";

	private static final String TRANSACTION_TOKEN_KEY = "TRANSACTION_TOKEN_KEY";

	private static TokenProcessor instance = new TokenProcessor();

	private long previous;

	protected TokenProcessor() {
		super();
	}

	public static TokenProcessor getInstance() {
		return instance;
	}
	/**
	 * 
	* @Title: isTokenValid
	* @Description: token重复性检验
	* @param @param request
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	 */
	public synchronized boolean isTokenValid(HttpServletRequest request) {
		return this.isTokenValid(request, false);
	}

	public synchronized boolean isTokenValid(HttpServletRequest request,
			boolean reset) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return false;
		}

		String saved = (String) session.getAttribute(TRANSACTION_TOKEN_KEY);

		if (saved == null) {
			return false;
		}

		if (reset) {
			this.resetToken(request);
		}

		String token = request.getParameter(TOKEN_KEY);

		if (token == null) {
			return false;
		}

		return saved.equals(token);
	}

	public synchronized void resetToken(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(TRANSACTION_TOKEN_KEY);
	}
	/**
	 * 
	* @Title: saveToken
	* @Description: 若tokenbu为null，保存token到session中，name为TRANSACTION_TOKEN_KEY
	* @param @param request
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	public synchronized String saveToken(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String token = generateToken(request);

		if (token != null) {
			session.setAttribute(TRANSACTION_TOKEN_KEY, token);
		}
		
		return token;
	}
	
	/**
	 * 
	* @Title: generateToken
	* @Description: 生成token
	* @param @param request
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	public synchronized String generateToken(HttpServletRequest request) {
		HttpSession session = request.getSession();

		return generateToken(session.getId());
	}

	public synchronized String generateToken(String id) {
		try {
			long current = System.currentTimeMillis();

			if (current == previous) {
				current++;
			}

			previous = current;
			//MD5加密
			byte[] now = new Long(current).toString().getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(id.getBytes());
			md.update(now);

			return toHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	/**
	 * 
	* @Title: toHex
	* @Description: 转换成16进制
	* @param @param buffer
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	private String toHex(byte[] buffer) {
		StringBuffer sb = new StringBuffer(buffer.length * 2);

		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
		}

		return sb.toString();
	}
}
