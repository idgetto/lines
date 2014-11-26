package com.idgetto.lines;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.idgetto.lines.Block.MoveDir;

public abstract class Piece {
	protected Point center;
	protected Color color;
	protected List<Block> blocks;
	
	//
	// GET / SET
	// 

	protected List<Block> getBlocks() {
		return blocks;
	}

	protected Color getColor() {
		return color;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point point) {
		getCenter().setLocation(point);
	}
	
	//
	// CHECK
	//
	
	public boolean canMoveTo(Grid grid, List<Point> locs) {
		locs.removeAll(getCurrentLocs());
		System.out.println("locs size: " + locs.size());
		for (Point p : locs) {
			if (!(grid.inBounds(p.y, p.x) && grid.get(p.y, p.x) == null)) {
                System.out.println(this + " cannot move");
				System.out.println("Can't move to r: " + p.y + ", c: " + p.x);
				return false;
			}
		}
		return true;
	}
	
	public boolean canFall(Grid grid) {
		return canMoveTo(grid, getFallLocs()); 
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
			fall();
		}
	}

	public void fall() {
        move(0, 1);
	}
	
	public void moveLeft() {
		move(-1, 0);
	}
	
	public void moveRight() {
		move(1, 0);
	}
	
	private void move(int dx, int dy) {
		getCenter().translate(dx, dy);
	}
	
    /**
	 * Rotates a matrix 90 degrees clockwise
	 */
	public void rotate() {
		for (Block b : getBlocks()) {
			b.rotate();
		}
	}
	
	//
	// MOVE LOCS
	//
	
	public List<Point> getMoveLocs(MoveDir dir) {
		ArrayList<Point> locs = new ArrayList<Point>();
		for (Block b : getBlocks()) {
			locs.add(b.getMoveLoc(dir));
		}
		return locs;
	}
	
	public List<Point> getFallLocs() {
		return getMoveLocs(MoveDir.DOWN);
	}
	
	public List<Point> getMoveLeftLocs() {
		return getMoveLocs(MoveDir.LEFT);
	}
	
	public List<Point> getMoveRightLocs() {
		return getMoveLocs(MoveDir.RIGHT);
	}
	
	public List<Point> getRotateLocs() {
		return getMoveLocs(MoveDir.ROTATE);
	}
	
	public List<Point> getCurrentLocs() {
		return getMoveLocs(MoveDir.NONE);
	}

}