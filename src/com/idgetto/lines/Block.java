package com.idgetto.lines;

import java.awt.Point;

public class Block {
	private Piece piece;
	private int row;
	private int col;
	
	public Block(Piece piece, int row, int col) {
		this.piece = piece;
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public void setLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
