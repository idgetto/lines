package com.idgetto.lines;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisGame {
	private static long DELAY = 200;

	private GameManager gm;
	private PieceManager pm;
	private Grid grid;
	
	public TetrisGame() {
		gm = new GameManager();
		pm = new PieceManager();
		grid = new Grid();
	}
	
	public void start() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				gm.update(grid, pm);
			}
			
		}, 0, DELAY);
	}
}
