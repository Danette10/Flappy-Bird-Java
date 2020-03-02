package com.danette.game;

import javax.swing.JFrame;

public class Main {
	public static JFrame window;
	public static scen scen;

	public static void main(String[] args) {
		window = new JFrame("Flappy Bird");
		scen = new scen();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(282, 525);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(true);
		
		window.setContentPane(scen);
		window.setVisible(true);

	}

}
