
package com.simon.nvwo.kit;

/**
 * ���ַ�����ʽ��IP��ַ, ��"192.168.1.100"��<code>long</code>���͵��������໥ת��.
 * 
 * @author ����
 * @since jdk1.7
 * @version 1.0
 *
 */
public class IPUtils {

	/**
	 * �ַ�����ʽ��IPת��Ϊlong����.
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * long longIp = IPUtils.ipToLong("192.168.1.100");
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * ����<code>null</code>, ���׳�{@link NullPointerException}�쳣. �����
	 * <code>IPv4</code>���ַ���, ���׳�
	 * {@link java.lang.StringIndexOutOfBoundsException}�쳣.
	 * 
	 * @param strIp
	 *            �ַ�������ip
	 * @return ת���������.
	 * @since jdk1.5
	 */
	public static long ipToLong(String strIp) {
		long[] ip = new long[4];
		int pos1 = strIp.indexOf('.');
		int pos2 = strIp.indexOf('.', pos1 + 1);
		int pos3 = strIp.indexOf('.', pos2 + 1);
		// ÿ��ipת��Ϊ����
		ip[0] = Long.parseLong(strIp.substring(0, pos1));
		ip[1] = Long.parseLong(strIp.substring(pos1 + 1, pos2));
		ip[2] = Long.parseLong(strIp.substring(pos2 + 1, pos3));
		ip[3] = Long.parseLong(strIp.substring(pos3 + 1));

		long result = (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];

		return result;
	}

	/**
	 * ��<code>long</code>תΪΪ<code>IPv4</code>��ʽ��IP��ַ�ַ���.
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
	 *            ת������
	 * @return ת����<code>IPv4</code>��ʽ���ַ���.
	 * @since jdk1.5
	 */
	public static String longToIp(long longIp) {
		StringBuffer buffer = new StringBuffer();
		// ֱ����λ
		buffer.append(longIp >>> 24);
		buffer.append(".");
		// ����8λ0
		buffer.append((longIp & 0x0000ffffff) >>> 16);
		buffer.append(".");
		buffer.append((longIp & 0x0000ffff) >>> 8);
		buffer.append(".");
		buffer.append(longIp & 0x0000ff);
		return buffer.toString();
	}
}
