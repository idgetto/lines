package com.idgetto.lines.pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import com.idgetto.lines.Block;
import com.idgetto.lines.Piece;

public class LPiece extends Piece {
	
	public LPiece() {
		blocks = new ArrayList<Block>();
		blocks.add(new Block(this, -1, 1));
		blocks.add(new Block(this, -1, 0));
		blocks.add(new Block(this, 0, 0));
		blocks.add(new Block(this, 1, 0));
		
		center = new Point();
		color = Color.blue;
	}

}