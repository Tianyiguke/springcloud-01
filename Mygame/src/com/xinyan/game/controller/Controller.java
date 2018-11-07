package com.xinyan.game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.xinyan.game.listener.ShapeListener;
import com.xinyan.game.vo.GamePanel;
import com.xinyan.game.vo.Ground;
import com.xinyan.game.vo.Shape;
import com.xinyan.game.vo.ShapeFactory;

public class Controller extends KeyAdapter implements ShapeListener{
	
	private Shape shape;
	private ShapeFactory shapeFactory;
	private Ground ground;
	private GamePanel gamePanel;
	
	public Controller(ShapeFactory shapeFactory,
			Ground ground,GamePanel gamePanel) {
		this.gamePanel=gamePanel;
		this.ground=ground;
		this.shapeFactory=shapeFactory;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(ground.isMoveable(shape, Shape.ROTATE))
				shape.rotate();
			break;
		case KeyEvent.VK_DOWN:
			if(isShapeMoveDownAble(shape))
				shape.moveDown();
			break;
		case KeyEvent.VK_RIGHT:
			if(ground.isMoveable(shape, Shape.RIGHT))
				shape.moveRight();
			break;
		case KeyEvent.VK_LEFT:
			if(ground.isMoveable(shape, Shape.LEFT))
				shape.moveLeft();
			break;
		}
		gamePanel.display(ground, shape);
	}	
	//重新监听器方法
	@Override
	public void shapeMoveDown(Shape shape) {
		gamePanel.display(ground, shape);
	}
	//开始新游戏
		public void newGame() {
			shape=shapeFactory.getShape(this);
		}
		@Override
		public synchronized boolean isShapeMoveDownAble(Shape shape) {
			// TODO Auto-generated method stub
			if(this.shape!=shape) {
				return false;
			}
			
			if(ground.isMoveable(shape, Shape.DOWN))
			return true;
			ground.accept(this.shape);
			if(!ground.isFull()) {
				this.shape=shapeFactory.getShape(this);
			}
			return false;
		}
}
