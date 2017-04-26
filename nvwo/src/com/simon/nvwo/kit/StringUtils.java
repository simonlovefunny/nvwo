
package com.simon.nvwo.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 字符串处理类
 * 
 * @author Zero.zhao, zhangtao
 *
 */
public class StringUtils {

	/**
	 * 替换字符串中{0}{1}标志.
	 * <p>
	 * 字符串使用标志位{0}{1}{2}等, 将标志位替换为执行值. <blockquote>
	 * 
	 * <pre>
	 * String str = "string_{0}_{1}";
	 * str = StringUtils.replace(str, "hello", "world");
	 * </pre>
	 * 
	 * </blockquote> 转换后的值为<code>"string_hello_world"</code>.
	 * 
	 * @param string
	 *            要替换的字符串
	 * @param values
	 *            对应位置的值
	 * @return 替换后的结果
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
	 * 验证字符串是否为整型
	 * 
	 * @param str
	 *            要判断的字符串
	 * @return boolean true是整型，false不是整型
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
	 * 验证字符串是否为正整型
	 * 
	 * @param str
	 *            要判断的字符串
	 * @return boolean true是正整型，false不是正整型
	 * @author zhangtao
	 */
	public static boolean isPositiveInt(String str) {
		if (isInt(str)) {
			return Integer.parseInt(str) > 0;
		}
		return false;
	}

	/**
	 * 清除所有空格
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
	 * 所有参数不能为null
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
			if (strings[i] == null || strings[i].length() == 0) { // 如果有一个为空,
																	// 则验证失败, 返回
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 判断字符串是否为空白.
	 * 
	 * <pre>
	 * StringUtils.isBlank("a") == false
	 * StringUtils.isBlank(" ") == true
	 * </pre>
	 * 
	 * @param string
	 *            验证的字符串
	 * @return
	 */
	public static boolean isBlank(String string) {
		if (string == null || string.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 判断字符串是否为空串.
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
	 * 获得一个长度为length的随机字符串
	 * @param length
	 * @return 随机字符串
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
	 * 除去数组的空格、空值和特定的default值
	 * @param sPara
	 * @return 新的数组
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
	* @Description: 解析逗号分隔的字符串为数组
	* @param @param str
	* @param @return    参数
	* @return String[]    返回类型
	* @throws
	 */
	public static String[] getArrayFromString(String str){
		
		String[] strArray=null;
		
		strArray=str.split(",");
		
		return strArray;
		
	}
}
