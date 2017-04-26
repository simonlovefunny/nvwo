package com.simon.nvwo.designpattern.decorator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape shapeDecorator) {
		super(shapeDecorator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//����ShapeDecorator��shapeʵ��
		shapeDecorator.draw();
		
		setRedColor(shapeDecorator);
	}
	
	/**
	 * ��ӹ���
	 * @param shapeDecorator
	 */
	private void setRedColor(Shape shapeDecorator){
		
		System.out.println("����һ����ɫ��Ч");
	}
	
	

}
