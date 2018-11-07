package com.xinyan.game.listener;

import com.xinyan.game.vo.Shape;

public interface ShapeListener {
	void shapeMoveDown(Shape shape);
	boolean isShapeMoveDownAble(Shape shape);
}
