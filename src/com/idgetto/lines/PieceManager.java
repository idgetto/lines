package com.idgetto.lines;

import java.util.ArrayList;
import java.util.List;

import com.idgetto.lines.pieces.IPiece;
import com.idgetto.lines.pieces.JPiece;
import com.idgetto.lines.pieces.LPiece;
import com.idgetto.lines.pieces.OPiece;
import com.idgetto.lines.pieces.SPiece;
import com.idgetto.lines.pieces.TPiece;
import com.idgetto.lines.pieces.ZPiece;

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
