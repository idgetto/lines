package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class JPiece extends Piece {
	
	public JPiece() {
		blocks = new ArrayList<Block>();
		blocks.add(new Block(this, -1, -1));
		blocks.add(new Block(this, -1, 0));
		blocks.add(new Block(this, 0, 0));
		blocks.add(new Block(this, 1, 0));
		
		center = new Point();
		color = Color.blue;
		stopped = false;
	}

}
