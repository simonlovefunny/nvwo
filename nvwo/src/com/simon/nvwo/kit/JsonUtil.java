package com.simon.nvwo.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;




public class JsonUtil {
	
	

	/* Object parse(String text); // ��JSON�ı�parseΪJSONObject����JSONArray 
    JSONObject parseObject(String text)�� // ��JSON�ı�parse��JSONObject    
	parseObject(String text, Class<T> clazz); // ��JSON�ı�parseΪJavaBean 
	JSONArray parseArray(String text); // ��JSON�ı�parse��JSONArray 
    List<T> parseArray(String text, Class<T> clazz); //��JSON�ı�parse��JavaBean���� 
	String toJSONString(Object object); // ��JavaBean���л�ΪJSON�ı� 
	String toJSONString(Object object, boolean prettyFormat); // ��JavaBean���л�Ϊ����ʽ��JSON�ı� 
	Object toJSON(Object javaObject); ��JavaBeanת��ΪJSONObject����JSONArray��*/
	
	


	
	///////////////////////////////////////�����л�///////////////////////////////////
		
	
	/**
	* ����jsonΪ��Ӧ��bean
	*/
	public static void jsonToBean(){
	
	
	String json="{\"age\":24,\"userName\":\"����\"}";
	
	User user=JSON.parseObject(json, User.class);
	
	
	}
	
	/**
	 * ����jsonΪstring
	 */
	public static void jsonToJava(){
		
		String jsonStr="{\"name\":\"����̳�\" , \"url\":\"www.runoob.com\" }";
		
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		
		String name=jsonObj.getString("name");
		
		String url=jsonObj.getString("url");
	}
	
	
	/**
	 *����json
	 */
	public static void javaToJson(){
		
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("partnerId", "2088678977");
		jsonObj.put("merchId", "100001");
		
		System.out.println(jsonObj.toString());
	
	}
	
	/**
	 * ת��jsonΪ����
	 */
	public static void jsonToArray(){
		
		JSONArray jsonarray = new JSONArray("[{'name':'xiazdong','age':20},{'name':'xzdong','age':15}]"); 
		
		List<String> names=new ArrayList<String>();
		
		List<String> values=new ArrayList<String>();
		
	    for(int i=0;i<jsonarray.length();i++){
	    	
	    	JSONObject obj=jsonarray.getJSONObject(i);
	    	
	    	names.add(i, obj.getString("name"));
	    	
	    	values.add(i, obj.getString("age"));
	    }
		
	}



	///////////////////////////////////////���л�////////////////////////////////////
	
	/**
	* mapתjson
	* @return  {"key1":"value1","key2":"value2"}
	*/
	public static String mapToJson(){
	
	Map<String,String> map=new HashMap<String,String>();
	
	map.put("key1", "value1");
	
	map.put("key2", "value2");
	
	String mapToString=JSON.toJSONString(map);
	
	return mapToString;
	
	}
	
	/**
	* �б�mapתjson
	* @return  [{"key1":"One","key2":"Two"},{"key1":"Three","key2":"Four"}]
	
	*/
	public static String listMapToJson(){
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	Map<String, Object> map1 = new HashMap<String, Object>();
	map1.put("key1", "One");
	map1.put("key2", "Two");
	
	Map<String, Object> map2 = new HashMap<String, Object>();
	map2.put("key1", "Three");
	map2.put("key2", "Four");
	
	list.add(map1);
	list.add(map2);
	
	String listJson = JSON.toJSONString(list);
	
	return listJson;
	
	}
	
	/**
	* ת��beanΪjson
	* @return  {"age":24,"userName":"����"}
	*/
	public static String beanToJson(){
	
	User user = new User();
	user.setName("����");
	user.setAge(24);
	
	String userJson = JSON.toJSONString(user);
	
	return userJson;
	
	}
	
	
	}
	
	
	/**
	* ������bean
	* @author zhaoyi
	*
	*/
	class User{
	
	
	private String name;
	
	private int age;
	
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public int getAge() {
	return age;
	}
	
	public void setAge(int age) {
	this.age = age;
	}
	
	
	
}
