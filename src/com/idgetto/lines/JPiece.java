package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;

public class JPiece extends Piece {
	private Block[] blocks;
	private Point center;
	private Color color;
	private Grid grid;
	
	public JPiece(Grid grid) {
		blocks = new Block[4];
		blocks[0] = new Block(this, grid,  -1, -1);
		blocks[1] = new Block(this, grid,  -1, 0);
		blocks[2] = new Block(this, grid,  0, 0);
		blocks[3] = new Block(this, grid,  1, 0);
		
		center = new Point();
		color = Color.blue;
	}

	@Override
	protected Block[] blocks() {
		return blocks;
	}

	@Override
	protected Point center() {
		return center;
	}

	@Override
	protected Color color() {
		return color;
	}

	@Override
	public boolean canFall(Grid grid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canTurn(Grid grid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveLeft(Grid grid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveRight(Grid grid) {
		// TODO Auto-generated method stub
		return false;
	}
}
