package com.idgetto.lines;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Queue;

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
	
	public void update(PieceManager pm) {
		Piece currentPiece = pm.getCurrentPiece();
		if (currentPiece.stopped()) {
			System.out.println("Adding new piece");
			addNewPiece(pm);
		}
		for (Piece p : pm.piecesInPlay()) {
			removePiece(p);
			p.update(this);
			insertPiece(p);
		}
		removeFullRows();
		print();
	}
	
	public void insertPiece(Piece piece) {
		piece.insertIntoGrid(this);
	}
	
	public void removePiece(Piece piece) {
		piece.removeFromGrid(this);
	}
	
	public void addNewPiece(PieceManager pm) {
		Piece currentPiece = pm.nextPiece();
		if (currentPiece != null) {
			currentPiece.setCenter(PIECE_INSERT_POS);
		}
	}
	
	private void removeFullRows() {
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
