package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Piece {
	
	// accessors
	abstract protected ArrayList<Block> blocks();
	abstract protected Color color();
	abstract public Point getCenter();

	// checking methods
	public boolean canFall(Grid grid) {
		for (Point p : getFallLocs()) {
			if (grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) != null)
				return false;
		}
		return true;
	}

	// TODO: can you turn if something is in the way?
	public boolean canRotate(Grid grid) {
		for (Point p : getRotateLocs()) {
			if (grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) != null)
				return false;
		}
		return true;
	}

	public boolean canMoveLeft(Grid grid) {
		for (Point p : getMoveLeftLocs()) {
			if (grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) != null)
				return false;
		}
		return true;
	}

	public boolean canMoveRight(Grid grid) {
		for (Point p : getMoveRightLocs()) {
			if (grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) != null)
				return false;
		}
		return true;
	}

	public boolean canMove(Grid grid) {
		return canFall(grid) || canMoveLeft(grid) || canMoveRight(grid);
	}
	
	// doing methods
	
	public void update(Grid grid) {
		if (canFall(grid)) {
			fall();
		}
	}
	
	public void fall() {
        getCenter().translate(-1, 0);
	}
	
	public void moveLeft() {
		getCenter().translate(0, -1);
	}
	
	public void moveRight() {
		getCenter().translate(0, 1);
	}

    /**
	 * Rotates a matrix 90 degrees clockwise
	 */
	public void rotate() {
		for (Block b : blocks()) {
			b.rotate();
		}
	}
	
	public ArrayList<Point> getFallLocs() {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : blocks()) {
			locs.add(b.getFallLoc());
		}
		return locs;
	}
	
	public ArrayList<Point> getMoveLeftLocs() {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : blocks()) {
			locs.add(b.getMoveLeftLoc());
		}
		return locs;
	}
	
	public ArrayList<Point> getMoveRightLocs() {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : blocks()) {
			locs.add(b.getMoveRightLoc());
		}
		return locs;
	}
	
	public ArrayList<Point> getRotateLocs() {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : blocks()) {
			locs.add(b.getRotateLoc());
		}
		return locs;
	}
	

	public void insertIntoGrid(Grid grid) {
		for (Block b : blocks()) {
			grid.set(b.getRow(), b.getCol(), b);
		}
	}
	
	public void removeFromGrid(Grid grid) {
		for (Block b : blocks()) {
			grid.set(b.getRow(), b.getCol(), null);
		}
	}
	
}