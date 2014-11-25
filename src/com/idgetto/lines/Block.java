package com.idgetto.lines;

import java.awt.Point;

public class Block {
	
	private Piece piece;
	private Point point;
	
	public Block(Piece piece, Point loc) {
		this.piece = piece;
		this.point = loc;
	}

	public Block(Piece piece, int x, int y) {
		this.piece = piece;
		this.point = new Point(x, y);
	}
	
	public void remove() {
		piece.getBlocks().remove(this);
	}

	public int getX() {
		return point.x;
	}

	public int getY() {
		return point.y;
	}
	
	public int getRow() {
		return coordToRow(point);
	}

	public int getCol() {
		return coordToCol(point);
	}
	
	public enum MoveDir {
		DOWN,
		LEFT,
		RIGHT,
		ROTATE,
		NONE;
	}

	public Point getMoveLoc(MoveDir dir) {
		switch (dir) {
        case DOWN:
        	return getFallLoc();
		case LEFT:
			return getMoveLeftLoc();
		case RIGHT:
			return getMoveRightLoc();
		case ROTATE:
			return getRotateLoc();
		case NONE:
			return getGridLocation();
		}
		return new Point();
	}
	
	public Point getFallLoc() {
		return new Point(getCol(), getRow() + 1);
	}
	
	public Point getMoveLeftLoc() {
		return new Point(getCol() - 1, getRow());
	}
	
	public Point getMoveRightLoc() {
		return new Point(getCol() + 1, getRow());
	}
	
	public Point getRotateLoc() {
		Point p = getRotatedPoint(point);
		return new Point(coordToRow(p), coordToCol(p));
	}
	
	/**
	 * Get the row column coordinates of the block
	 * @return the coordinates
	 */
	public Point getGridLocation() {
		return new Point(getRow(), getCol());
	}
	
	public void rotate() {
		point.setLocation(getRotatedPoint(point));
	}
	
	public void translate(int dx, int dy) {
		point.translate(dx, dy);
	}
	
	private int getRotatedX(Point p) {
		return -p.y;
	}
	
	private int getRotatedY(Point p) {
		return p.x;
	}
	
	private Point getRotatedPoint(Point p) {
		return new Point(getRotatedX(p), getRotatedY(p));
	}
	
	private int coordToRow(Point p) {
		return p.y + piece.getCenter().y;
	}

	private int coordToCol(Point p) {
		return p.x + piece.getCenter().x;
	}
}