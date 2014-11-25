package com.idgetto.lines;

public class GameManager {
		
	public void update(Grid grid, PieceManager pm) {
		Piece currentPiece = pm.getCurrentPiece();
		if (currentPiece == null || currentPiece.canFall(grid)) {
			System.out.println("Adding new piece");
			addNewPiece(pm, grid);
		}

		updatePieces(pm, grid);
		checkForFullRows(grid);
		displayGrid(grid);
	}
	
	private void addNewPiece(PieceManager pm, Grid grid) {
		grid.addNewPiece(pm);
	}
	
	private void updatePieces(PieceManager pm, Grid grid) {
		for (Piece p : pm.piecesInPlay()) {
			updatePiece(p, grid);
		}
	}

	private void updatePiece(Piece p, Grid grid) {
			grid.removePiece(p);
			p.update(grid);
			grid.insertPiece(p);
	}
	
	private void checkForFullRows(Grid grid) {
		grid.removeFullRows();
	}
	
	private void displayGrid(Grid grid) {
		grid.print();
	}
}