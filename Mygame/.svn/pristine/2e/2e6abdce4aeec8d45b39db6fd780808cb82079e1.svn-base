package com.xinyan.game.test;

import javax.swing.JFrame;

import com.xinyan.game.controller.Controller;
import com.xinyan.game.vo.GamePanel;
import com.xinyan.game.vo.Ground;
import com.xinyan.game.vo.ShapeFactory;

public class Test {
	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		Ground ground=new Ground();
		GamePanel gamePanel=new GamePanel();
		
		Controller controller=new Controller(
				shapeFactory,ground,gamePanel);
		//显示面板(JPanel的)
		JFrame frame=new JFrame();
		//设置开关
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置大小
		frame.setSize(gamePanel.getSize().width+10,
				gamePanel.getSize().height+35);
		//添加到frame
		frame.add(gamePanel);
		//给显示面板添加事件监听器
		gamePanel.addKeyListener(controller);
		//给按键添加监听事件
		frame.addKeyListener(controller);
		//主窗口可视
		frame.setVisible(true);
		//开始游戏
		controller.newGame();
	}	
}
