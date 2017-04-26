package com.simon.nvwo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ClassDemo {
	
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		Fool fool=new Fool();
		
		//三种获取类对应的class(类的类型 class type)的方法
		//任何一个类都有一个隐含的静态成员对象class
		Class clazz1=Fool.class;
		System.out.println(clazz1);
		//必须用类全称
		Class clazz2=Class.forName("com.simon.nvwo.reflect.Fool");
		System.out.println(clazz2);
		Class clazz3=fool.getClass();
		System.out.println(clazz3);
		
		Class[] classes = new Class[] { Integer.class, String.class };
		Constructor constructor=clazz1.getConstructor(classes);
		
		System.out.println(constructor.getAnnotations());

	}
	

}

class Fool{
	
	private Integer id;
	
	private String name;
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Fool(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Fool() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}