
package com.simon.nvwo.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * �ַ���������
 * 
 * @author Zero.zhao, zhangtao
 *
 */
public class StringUtils {

	/**
	 * �滻�ַ�����{0}{1}��־.
	 * <p>
	 * �ַ���ʹ�ñ�־λ{0}{1}{2}��, ����־λ�滻Ϊִ��ֵ. <blockquote>
	 * 
	 * <pre>
	 * String str = "string_{0}_{1}";
	 * str = StringUtils.replace(str, "hello", "world");
	 * </pre>
	 * 
	 * </blockquote> ת�����ֵΪ<code>"string_hello_world"</code>.
	 * 
	 * @param string
	 *            Ҫ�滻���ַ���
	 * @param values
	 *            ��Ӧλ�õ�ֵ
	 * @return �滻��Ľ��
	 */
	public static String replace(String string, Object... values) {
		if (values == null || values.length == 0) {
			return string;
		}

		for (int i = 0; i < values.length; i++) {
			string = string.replace("{" + i + "}", String.valueOf(values[i]));
		}

		return string;
	}

	/**
	 * ��֤�ַ����Ƿ�Ϊ����
	 * 
	 * @param str
	 *            Ҫ�жϵ��ַ���
	 * @return boolean true�����ͣ�false��������
	 * @author zhangtao
	 */
	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * ��֤�ַ����Ƿ�Ϊ������
	 * 
	 * @param str
	 *            Ҫ�жϵ��ַ���
	 * @return boolean true�������ͣ�false����������
	 * @author zhangtao
	 */
	public static boolean isPositiveInt(String str) {
		if (isInt(str)) {
			return Integer.parseInt(str) > 0;
		}
		return false;
	}

	/**
	 * ������пո�
	 * 
	 * @param str
	 * @return
	 */
	public static String trimAll(String str) {
		if (str == null)
			return str;
		return str.replaceAll(" ", "").trim();
	}

	/**
	 * ���в�������Ϊnull
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean notNull(String... strings) {
		boolean result = true;
		if (strings == null || strings.length == 0) {
			result = false;
		}

		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null || strings[i].length() == 0) { // �����һ��Ϊ��,
																	// ����֤ʧ��, ����
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�հ�.
	 * 
	 * <pre>
	 * StringUtils.isBlank("a") == false
	 * StringUtils.isBlank(" ") == true
	 * </pre>
	 * 
	 * @param string
	 *            ��֤���ַ���
	 * @return
	 */
	public static boolean isBlank(String string) {
		if (string == null || string.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�մ�.
	 * 
	 * <pre>
	 * StringUtils.isEmpty("a") == false
	 * StringUtils.isEmpty(" ") == false
	 * StringUtils.isEmpty("") == true
	 * </pre>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string == null || string.length() == 0)
			return true;
		return false;
	}
	

	/**
	 * ���һ������Ϊlength������ַ���
	 * @param length
	 * @return ����ַ���
	 */
	public static String getRandomStringByLength(int length){
		
		String base="abcdefghijklmnopqrstuvwxyz0123456789";
		
		StringBuffer sb=new StringBuffer();
		
		Random r=new Random();
		
		for(int i=0;i<length;i++){
		  
		  int number=r.nextInt(base.length());
		  sb.append(base.charAt(number));
			
		}
		
		return sb.toString();
	}
	
	
	/**
	 * ��ȥ����Ŀո񡢿�ֵ���ض���defaultֵ
	 * @param sPara
	 * @return �µ�����
	 */
	public static Map<String,String> paraFilter(Map<String,String> sPara){
		
		Map<String,String> result=new HashMap<String,String>();
		
		
		if(sPara==null||sPara.size()<=0){
			
			return null;
		}
		
		
		for(String key:sPara.keySet()){
			
			String value=sPara.get(key);
			
			if(value==null||value.equals("")||value.equalsIgnoreCase("default")){
				
				continue;
			}
			
			result.put(key, value);
		}
		return result;
		
		
	}
	
	/**
	 * 
	* @Title: getArrayFromString
	* @Description: �������ŷָ����ַ���Ϊ����
	* @param @param str
	* @param @return    ����
	* @return String[]    ��������
	* @throws
	 */
	public static String[] getArrayFromString(String str){
		
		String[] strArray=null;
		
		strArray=str.split(",");
		
		return strArray;
		
	}
}
