package com.simon.nvwo.designpattern.decorator;

import org.junit.Test;

/**
 * ��֤װ�����๦��
 * @author ����
 *
 */
public class App {
	
	@Test
	public static void testDecorator(){
		
		Shape entity=new ShapeEntity();
		
		Shape entityDecorator=new RedShapeDecorator(entity);
		
		System.out.println("ԭ�͵�draw��������");
		entity.draw();
		System.out.println("װ������draw��������");
		entityDecorator.draw();
		
		
	}
	
	public static void main(String[] args) {
		
		testDecorator();
	}
}