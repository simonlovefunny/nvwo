package com.simon.nvwo.designpattern.decorator;

/**
 * ʵ����Shape�ӿڵĳ����࣬ӵ��һ��shape������Ϊʵ������
 * @author ����
 *
 */
public abstract class ShapeDecorator implements Shape{
	
	/**
	 * shape����
	 */
	protected Shape shapeDecorator;
	
	public ShapeDecorator(Shape shapeDecorator){
		
		this.shapeDecorator=shapeDecorator;
	}
	
	public void draw(){
		
		shapeDecorator.draw();
	}

}
