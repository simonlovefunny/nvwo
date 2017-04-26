
package com.simon.nvwo.kit;

/**
 * 对字符串形式的IP地址, 如"192.168.1.100"与<code>long</code>类型的数字做相互转换.
 * 
 * @author 昭毅
 * @since jdk1.7
 * @version 1.0
 *
 */
public class IPUtils {

	/**
	 * 字符串格式的IP转换为long类型.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * long longIp = IPUtils.ipToLong("192.168.1.100");
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * 传入<code>null</code>, 会抛出{@link NullPointerException}异常. 传入非
	 * <code>IPv4</code>的字符串, 会抛出
	 * {@link java.lang.StringIndexOutOfBoundsException}异常.
	 * 
	 * @param strIp
	 *            字符串类型ip
	 * @return 转换后的整型.
	 * @since jdk1.5
	 */
	public static long ipToLong(String strIp) {
		long[] ip = new long[4];
		int pos1 = strIp.indexOf('.');
		int pos2 = strIp.indexOf('.', pos1 + 1);
		int pos3 = strIp.indexOf('.', pos2 + 1);
		// 每段ip转换为整型
		ip[0] = Long.parseLong(strIp.substring(0, pos1));
		ip[1] = Long.parseLong(strIp.substring(pos1 + 1, pos2));
		ip[2] = Long.parseLong(strIp.substring(pos2 + 1, pos3));
		ip[3] = Long.parseLong(strIp.substring(pos3 + 1));

		long result = (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];

		return result;
	}

	/**
	 * 将<code>long</code>转为为<code>IPv4</code>格式的IP地址字符串.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * String ip = IPUtils.longToIp(3232235876);
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param longIp
	 *            转换数字
	 * @return 转换后<code>IPv4</code>格式的字符串.
	 * @since jdk1.5
	 */
	public static String longToIp(long longIp) {
		StringBuffer buffer = new StringBuffer();
		// 直接移位
		buffer.append(longIp >>> 24);
		buffer.append(".");
		// 补高8位0
		buffer.append((longIp & 0x0000ffffff) >>> 16);
		buffer.append(".");
		buffer.append((longIp & 0x0000ffff) >>> 8);
		buffer.append(".");
		buffer.append(longIp & 0x0000ff);
		return buffer.toString();
	}
}
