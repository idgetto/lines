package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;

public abstract class Piece {
	protected Color color;
	protected Point center;
	protected Block[] blocks;
	
	// checking methods
	abstract public boolean canFall();
	abstract public boolean canTurn();
	abstract public boolean canMoveLeft();
	abstract public boolean canMoveRight();

	public boolean canMove() {
		return canFall() || canMoveLeft() || canMoveRight();
	}
	
	// doing methods
	
	/**
	 * Rotates a matrix 90 degrees clockwise
	 */
	public void rotate() {
		for (int i = 0; i < blocks.length; i++) {
			Block b = blocks[i];

			int x = b.getCol();
			int y = b.getRow();
			
			// convert to coordinates
			x = x - center.x;
			y = y - center.y;
			
			// rotate
			int tmp = x;
			x = -y;
			y = tmp;
			
			// convert back to indexes
			x = x + center.x;
			y = y + center.y;
			
			b.setLocation(y, x);
		}
	}
	
}
