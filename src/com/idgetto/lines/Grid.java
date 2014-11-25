package com.idgetto.lines;

import java.awt.Point;

public class Grid {
	// Grid should have hidden upper rows for insertion
	private final static byte NUM_ROWS = 24;
	private final static byte NUM_COLS = 10;
	
	// Where should the piece start?
	private static final Point PIECE_INSERT_POS = new Point(NUM_COLS / 2, 2);

	private Block[][] grid;
	
	public Grid() {
		grid = new Block[NUM_ROWS][NUM_COLS];
	}
	
	//
	// GET / SET
	//
	
	public Block get(int r, int c) {
		return grid[r][c];
	}
	
	public void set(int r, int c, Block b) {
		grid[r][c] = b;
	}
	
	//
	// CHECK
	//
	
	public boolean inBounds(int r, int c) {
		return (0 <= r && r < NUM_ROWS && 0 <= c && c < NUM_COLS);
	}

	public void insertPiece(Piece piece) {
		for (Block b : piece.getBlocks()) {
			int r = b.getRow();
			int c = b.getCol();
			if (inBounds(r, c))
                set(r, c, b);
		}
	}
	
	public void removePiece(Piece piece) {
		for (Block b : piece.getBlocks()) {
			int r = b.getRow();
			int c = b.getCol();
			if (inBounds(r, c))
                set(r, c, null);
		}
	}
	
	public void addNewPiece(PieceManager pm) {
		Piece currentPiece = pm.nextPiece();
		if (currentPiece != null) {
			currentPiece.setCenter(PIECE_INSERT_POS);
		}
	}
	
	public void removeFullRows() {
		for (int r = 0; r < NUM_ROWS; r++) {
			if (checkFullRow(r)) {
				removeRow(r);
			}
		}
	}
	
	private boolean checkFullRow(int row) {
		for (Block b : grid[row]) {
			if (b == null)
				return false;
		}
		return true;
	}
	
	private void removeRow(int row) {
		for (Block b : grid[row]) {
			b.remove();
		}
	}
	
	//
	// DEBUG
	// 
	
	public void print() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] != null)
                        System.out.print("X ");
				else
					System.out.print("_ ");
			}
			System.out.println();
		}
	}
}
