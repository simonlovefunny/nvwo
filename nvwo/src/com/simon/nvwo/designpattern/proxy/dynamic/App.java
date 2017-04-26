package com.simon.nvwo.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ��̬����ͻ�����
 * @author ����
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		   RealSubject rs = new RealSubject(); // ������ָ����������
		   InvocationHandler ds = new DynamicSubject(rs);
		   Class cls = rs.getClass();

		   // ������һ�������ɴ���
		   Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),ds );
		   subject.request();
	}

}
