package com.danette.game;

public class Chrono implements Runnable {
	private final int PAUSE = 5;

	@Override
	public void run() {
		while(true) {
			
			Main.scen.xFond--;
			Main.scen.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}	
	}
}
