package com.simon.nvwo.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理客户端类
 * @author 昭毅
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		   RealSubject rs = new RealSubject(); // 在这里指定被代理类
		   InvocationHandler ds = new DynamicSubject(rs);
		   Class cls = rs.getClass();

		   // 以下是一次性生成代理
		   Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),ds );
		   subject.request();
	}

}
