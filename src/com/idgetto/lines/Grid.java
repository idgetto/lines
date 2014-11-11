package com.idgetto.lines;

import java.util.ArrayList;
import java.util.Queue;

public class Grid {
	private static byte NUM_ROWS = 15;
	private static byte NUM_COLS = 7;

	private Block[][] grid;
	private Queue<Piece> pieceQueue;
	private ArrayList<Piece> piecesInPlay;
	private Piece currentPiece;
	
	public Grid() {
		grid = new Block[NUM_ROWS][NUM_COLS];
		piecesInPlay = new ArrayList<Piece>();
	}
	
	public Grid(Queue<Piece> pieces) {
		grid = new Block[NUM_ROWS][NUM_COLS];
		pieceQueue = pieces;
		piecesInPlay = new ArrayList<Piece>();
	}
	
	public void set(int r, int c, Block b) {
		grid[r][c] = b;
	}
	
	
	public void update() {
		for (Piece p : piecesInPlay) {
			removePiece(p);
			p.update(this);
			insertPiece(p);
		}
	}
	
	public void insertPiece(Piece piece) {
		piece.insertIntoGrid(this);
	}
	
	public void removePiece(Piece piece) {
		piece.removeFromGrid(this);
	}
	
	private void addNewPiece() {
		currentPiece = pieceQueue.poll();
		insertPiece(currentPiece);
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
