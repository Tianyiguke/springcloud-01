package com.xinyan.game.vo;


import java.awt.Color;
import java.awt.Graphics;

import com.xinyan.game.listener.ShapeListener;
import com.xinyan.game.util.Global;

public class Shape {
	private ShapeListener listener;
	public static final int ROTATE=0;
	public static final int LEFT=1;
	public static final int RIGHT=2;
	public static final int DOWN=3;
	private int[][] body;
	private int status;
	private int left;
	private int top;
	
	public void moveLeft() {
		System.out.println("Shape's moveLeft");
		left--;
	}
	
	public void moveRight() {
		System.out.println("Shape's moveRight");
		left++;
	}
	
	public void moveDown() {
		System.out.println("Shape's moveDown");
		top++;
	}
	
	public void rotate() {
		System.out.println("Shape's rotate");
		status=(status+1)%body.length;
	}
	
	public void drawMe(Graphics graphics) {
		System.out.println("Shape's drawMe");
		
		graphics.setColor(Color.GREEN);
		for(int x=0;x<4;x++) {
			for (int y = 0; y < body.length; y++) {
				if(getFlagByPoint(x, y)) {
					graphics.fill3DRect((left+x)*Global.CELL_SIZE,
							(top+y)*Global.CELL_SIZE , Global.CELL_SIZE, Global.CELL_SIZE,true);
				}
			}
		}
	}
	private boolean getFlagByPoint(int x,int y) {
		return body[status][y*4+x]==1;
	}
	public boolean isNember(int x,int y,boolean rotate) {
		int s=status;
		if(rotate) {
			s=(status+1)%body.length;
		}
		return body[s][y*4+x]==1;
	}
	
	//开线程，让线程不停调用moveDown方法
	private class ShapeDriver implements Runnable{

		@Override
		public void run() {
			while(listener.isShapeMoveDownAble(Shape.this)) {
				moveDown();
				//下移监听
				listener.shapeMoveDown(Shape.this);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public Shape() {
		new Thread(new ShapeDriver()).start();
	}
	//注册监听器
	public void addShapeListener(ShapeListener l) {
		if(l!=null) {
			this.listener=l;
		}
	}
	public void setBody(int[][] body) {
		this.body = body;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTop() {
		return top;
	}
	public int getLeft() {
		return left;
	}
}
