package com.idgetto.lines;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisGame {
	private static long DELAY = 200;

	private Grid grid;
	private PieceManager pm;
	
	public TetrisGame() {
		grid = new Grid();
		pm = new PieceManager();
	}
	
	public void start() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				grid.update(pm);
			}
			
		}, 0, DELAY);
	}
}
