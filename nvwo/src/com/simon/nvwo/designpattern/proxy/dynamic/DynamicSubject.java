package com.simon.nvwo.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author 昭毅
 *
 */
public class DynamicSubject implements  InvocationHandler{
	
	private Object sub;
	
	public DynamicSubject(){
		
	}
	
	public DynamicSubject(Object sub){
		
		this.sub=sub;
	}
	
	//动态代理的具体实现
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("before calling===="+method);
		
		method.invoke(sub, args);
		
		System.out.println("after calling===="+method);
		
		return null;
	}


}
