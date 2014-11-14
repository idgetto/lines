package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.idgetto.lines.Block.MoveDir;

public abstract class Piece {
	protected boolean stopped = false;
	
	//
	// GET / SET
	// 

	abstract protected ArrayList<Block> blocks();
	abstract protected Color color();
	abstract public Point getCenter();

	public void setCenter(Point point) {
		getCenter().setLocation(point);
	}
	
	public boolean stopped() {
		return stopped;
	}
	
	public void setStopped() {
		this.stopped = true;
	}

	//
	// CHECK
	//
	
	
	public boolean canMoveTo(Grid grid, List<Point> locs) {
		for (Point p : locs) {
			if (!(grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) == null))
				return false;
		}
		return true;
	}
	
	public boolean canFall(Grid grid) {
		boolean canFall = canMoveTo(grid, getFallLocs());
		if (!canFall) setStopped();
		return canFall; 
	}

	// TODO: can you turn if something is in the way?
	public boolean canRotate(Grid grid) {
		return canMoveTo(grid, getRotateLocs());
	}

	public boolean canMoveLeft(Grid grid) {
		return canMoveTo(grid, getMoveLeftLocs());
	}

	public boolean canMoveRight(Grid grid) {
		return canMoveTo(grid, getMoveRightLocs());
	}

	//
	// MOVEMENTS
	//

	public void update(Grid grid) {
		if (canFall(grid)) {
			System.out.println("Can Fall");
			fall();
		} else {
			System.out.println("Cannot Fall");
		}
	}

	public void fall() {
        getCenter().translate(0, 1);
	}
	
	public void moveLeft() {
		getCenter().translate(-1, 0);
	}
	
	public void moveRight() {
		getCenter().translate(1, 0);
	}
	
    /**
	 * Rotates a matrix 90 degrees clockwise
	 */
	public void rotate() {
		for (Block b : blocks()) {
			b.rotate();
		}
	}
	
	//
	// MOVE LOCS
	//
	
	public ArrayList<Point> getMoveLocs(MoveDir dir) {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : blocks()) {
			locs.add(b.getMoveLoc(dir));
		}
		return locs;
	}
	
	public ArrayList<Point> getFallLocs() {
		return getMoveLocs(MoveDir.DOWN);
	}
	
	public ArrayList<Point> getMoveLeftLocs() {
		return getMoveLocs(MoveDir.LEFT);
	}
	
	public ArrayList<Point> getMoveRightLocs() {
		return getMoveLocs(MoveDir.RIGHT);
	}
	
	public ArrayList<Point> getRotateLocs() {
		return getMoveLocs(MoveDir.ROTATE);
	}
	
	public ArrayList<Point> getCurrentLocs() {
		return getMoveLocs(MoveDir.NONE);
	}
	
	//
	// BLOCK
	//
	
	public void removeBlock(Block b) {
		blocks().remove(b);
	}

	//
	// GRID
	//

	public void insertIntoGrid(Grid grid) {
		for (Block b : blocks()) {
			int r = b.getRow();
			int c = b.getCol();
			if (grid.inBounds(r, c))
				grid.set(b.getRow(), b.getCol(), b);
		}
	}
	
	public void removeFromGrid(Grid grid) {
		for (Block b : blocks()) {
			int r = b.getRow();
			int c = b.getCol();
			if (grid.inBounds(r, c))
                grid.set(b.getRow(), b.getCol(), null);
		}
	}
	
}