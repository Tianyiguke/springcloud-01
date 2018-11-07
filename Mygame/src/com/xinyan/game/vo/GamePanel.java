package com.xinyan.game.vo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.xinyan.game.util.Global;

//继承JPanel类可以画图组件
public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4849066203902785702L;
	private Ground ground;
	private Shape shape;	
	
	public void display(Ground ground, Shape shape) {
		System.out.println("GamePanel's display");
		this.ground=ground;
		this.shape=shape;
		this.repaint();//重会
	}
	//重新写绘图方法
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//重新显示
		g.setColor(new Color(0X278BF4));
		g.fillRect(0, 0,Global.WIDTH*Global.CELL_SIZE,
				Global.HEIGHT*Global.CELL_SIZE);
		if(shape!=null) {
			shape.drawMe(g);
			ground.drawMe(g);
		}
	}
	public GamePanel() {
		this.setSize(Global.WIDTH*Global.CELL_SIZE,
				Global.HEIGHT*Global.CELL_SIZE);
	}

}
