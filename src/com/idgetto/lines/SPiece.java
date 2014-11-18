package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class SPiece extends Piece {
	
	public SPiece() {
		blocks = new ArrayList<Block>();
		blocks.add(new Block(this, 1, 0));
		blocks.add(new Block(this, 0, 0));
		blocks.add(new Block(this, 0, 1));
		blocks.add(new Block(this, -1, 1));
		
		center = new Point();
		color = Color.blue;
		stopped = false;
	}

}