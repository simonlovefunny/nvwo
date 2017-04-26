package com.simon.nvwo.designpattern.proxy;

/**
 * ������
 * @author ����
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
		//���ñ��������ִ��request()����
		realSubject.request();
	}

}
