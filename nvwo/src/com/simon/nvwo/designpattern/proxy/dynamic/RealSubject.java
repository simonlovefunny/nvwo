package com.simon.nvwo.designpattern.proxy.dynamic;


/**
 * 被代理的类
 * @author 昭毅
 *
 */
public class RealSubject implements Subject{
	
	public RealSubject(){
		
	}
	@Override
	public void request() {
		// TODO Auto-generated method stub
		
		System.out.println("============我要被代理了2333333");
	}

}
