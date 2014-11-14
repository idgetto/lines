package com.idgetto.lines;

import java.util.ArrayList;
import java.util.List;

public class PieceManager {
	private List<Piece> piecesInPlay;
	private Piece currentPiece;
	
	public PieceManager() {
		piecesInPlay = new ArrayList<Piece>();
		nextPiece();
	}
	
	public Piece getCurrentPiece() {
		return currentPiece;
	}
	
	public List<Piece> piecesInPlay() {
		return piecesInPlay;
	}
	
	public void updatePieces(Grid grid) {
		for (Piece p : piecesInPlay) {
			p.update(grid);
		}
	}
	
	public Piece nextPiece() {
		currentPiece = genPiece();
		piecesInPlay.add(currentPiece);
		return currentPiece;
	}
	
	private Piece genPiece() {
		return new JPiece();
	}
	
}
