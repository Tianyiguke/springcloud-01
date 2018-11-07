package com.xinyan.game.vo;

import java.util.Random;

import com.xinyan.game.listener.ShapeListener;

public class ShapeFactory {
	
	private int shapes[][][]=new int[][][] {
		{
		{1,0,0,0,  1,1,1,0,
		 0,0,0,0,  0,0,0,0},
		{1,1,0,0,  1,0,0,0,
		 1,0,0,0,  0,0,0,0},
		{1,1,1,0,  1,0,0,0,
		 0,0,0,0,  0,0,0,0},
		{0,1,0,0,  0,1,0,0,
		 1,1,0,0,  0,0,0,0}
		}
	};
			
	public Shape getShape(ShapeListener listener) {
		System.out.println("ShapeFactory's getShape");
		Shape shape= new Shape();
		//给图像添加监听器
		shape.addShapeListener(listener);
		int type=new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		shape.setStatus(0);
		return shape;
	}
}
