package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class TPiece extends Piece {
	
	public TPiece() {
		blocks = new ArrayList<Block>();
		blocks.add(new Block(this, -1, 0));
		blocks.add(new Block(this, 0, 0));
		blocks.add(new Block(this, 1, 0));
		blocks.add(new Block(this, 0, 1));
		
		center = new Point();
		color = Color.blue;
		stopped = false;
	}

}