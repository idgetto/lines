package com.idgetto.lines;

import java.awt.Point;

public class Block {
	private Piece piece;
	private Grid grid;
	private int x;
	private int y;
	
	public Block(Piece piece, Grid grid, int x, int y) {
		this.piece = piece;
		this.grid = grid;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getRow(Point center) {
		return y + center.y;
	}

	public int getCol(Point center) {
		return x + center.x;
	}
	
	public void rotate() {
        // rotate
        int tmp = x;
        x = -y;
        y = tmp;
	}
	
	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
}