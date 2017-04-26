package com.simon.nvwo.designpattern.decorator;

/**
 * 需要被拓展的实体类ShapeEntity
 * @author 昭毅
 *
 */
public class ShapeEntity implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("画一个原型");
	}

}
