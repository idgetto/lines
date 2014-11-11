package com.idgetto.lines;

import java.util.Queue;

public class Grid {
	private static byte NUM_ROWS = 15;
	private static byte NUM_COLS = 7;

	private Block[][] grid;
	private Queue<Piece> pieceQueue;
	private Piece currentPiece;
	
	public Grid(Queue<Piece> pieces) {
		grid = new Block[NUM_ROWS][NUM_COLS];
		pieceQueue = pieces;
	}
	
	
	public void update() {
	}
	
	public void insert(Piece piece) {
	}
	
	private void addNewPiece() {
		currentPiece = pieceQueue.poll();
		insert(currentPiece);
	}
}
