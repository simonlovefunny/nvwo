package com.simon.nvwo.designpattern.proxy;

/**
 * 代理类
 * @author 昭毅
 *
 */
public class ProxySubject implements Subject{
	
	
	Subject realSubject;
	
	public ProxySubject(Subject realSubject){
		
		this.realSubject=realSubject;
	}
	@Override
	public void request() {
		// TODO Auto-generated method stub
		//调用被代理的类执行request()方法
		realSubject.request();
	}

}
