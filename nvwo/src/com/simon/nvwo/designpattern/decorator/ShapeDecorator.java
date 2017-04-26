package com.simon.nvwo.designpattern.decorator;

/**
 * 实现了Shape接口的抽象类，拥有一个shape对象作为实例变量
 * @author 昭毅
 *
 */
public abstract class ShapeDecorator implements Shape{
	
	/**
	 * shape对象
	 */
	protected Shape shapeDecorator;
	
	public ShapeDecorator(Shape shapeDecorator){
		
		this.shapeDecorator=shapeDecorator;
	}
	
	public void draw(){
		
		shapeDecorator.draw();
	}

}
