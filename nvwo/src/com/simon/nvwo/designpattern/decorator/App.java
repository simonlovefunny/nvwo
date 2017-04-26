package com.simon.nvwo.designpattern.decorator;

import org.junit.Test;

/**
 * 验证装饰器类功能
 * @author 昭毅
 *
 */
public class App {
	
	@Test
	public static void testDecorator(){
		
		Shape entity=new ShapeEntity();
		
		Shape entityDecorator=new RedShapeDecorator(entity);
		
		System.out.println("原型的draw（）方法");
		entity.draw();
		System.out.println("装饰器的draw（）方法");
		entityDecorator.draw();
		
		
	}
	
	public static void main(String[] args) {
		
		testDecorator();
	}
}