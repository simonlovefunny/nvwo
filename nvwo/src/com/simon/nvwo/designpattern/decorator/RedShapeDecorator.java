package com.simon.nvwo.designpattern.decorator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape shapeDecorator) {
		super(shapeDecorator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//父类ShapeDecorator的shape实例
		shapeDecorator.draw();
		
		setRedColor(shapeDecorator);
	}
	
	/**
	 * 添加功能
	 * @param shapeDecorator
	 */
	private void setRedColor(Shape shapeDecorator){
		
		System.out.println("给加一个红色特效");
	}
	
	

}
