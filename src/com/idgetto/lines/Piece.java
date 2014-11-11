package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;

public abstract class Piece {
	
	// accessors
	abstract protected Block[] blocks();
	abstract protected Point center();
	abstract protected Color color();
	
	// checking methods
	abstract public boolean canFall(Grid grid);
	abstract public boolean canTurn(Grid grid);
	abstract public boolean canMoveLeft(Grid grid);
	abstract public boolean canMoveRight(Grid grid);

	public boolean canMove(Grid grid) {
		return canFall(grid) || canMoveLeft(grid) || canMoveRight(grid);
	}
	
	// doing methods
	
	public void update(Grid grid) {
		if (canFall(grid)) {
			fall();
		}
	}
	
	public void fall() {
		for (Block b : blocks()) {
			b.translate(0, -1);
		}
	}
	
	public void moveLeft() {
		for (Block b : blocks()) {
			b.translate(-1, 0);
		}
	}
	
	public void moveRight() {
		for (Block b : blocks()) {
			b.translate(1, 0);
		}
	}
	
	/**
	 * Rotates a matrix 90 degrees clockwise
	 */
	public void rotate() {
		for (Block b : blocks()) {
			b.rotate();
		}
	}
	
	public void insertIntoGrid(Grid grid) {
		for (Block b : blocks()) {
			grid.set(b.getRow(center()), b.getCol(center()), b);
		}
	}
	
	public void removeFromGrid(Grid grid) {
		for (Block b : blocks()) {
			grid.set(b.getRow(center()), b.getCol(center()), null);
		}
	}
	
}
