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
		int rand = (int) (Math.random() * 7);

		switch (rand) {
		case 0:
			return new OPiece();
		case 1:
			return new IPiece();
		case 2:
			return new SPiece();
		case 3:
			return new ZPiece();
		case 4:
			return new LPiece();
		case 5:
			return new JPiece();
        default:
			return new TPiece();
		}
	}
	
}
