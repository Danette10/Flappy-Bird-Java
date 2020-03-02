package com.danette.skins;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlappyBird implements Runnable{
	// VARIABLES
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private int dy;
	private String strImage;
	private ImageIcon icoBird;
	private Image imgBird;
	
	private final int PAUSE = 10;
	// CONSTRUCTEURS
	public FlappyBird(int x, int y, String strImage) {
		
		this.largeur = 180;
		this.hauteur = 160;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.icoBird = new ImageIcon(getClass().getResource(this.strImage));
		this.imgBird = this.icoBird.getImage();
		
		Thread chronoWings = new Thread(this);
		chronoWings.start();
		
	}
		
	// GETTERS
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}

	public Image getImgBird() {return imgBird;}
	
	// SETTERS

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	// METHODES
	public void mounts() {
		this.dy = 50;}
	
	private void batementsWings(int dy) {
		if(dy > 10) {
			this.icoBird = new ImageIcon(getClass().getResource("/images/flappy-bird.png"));
			this.imgBird = this.icoBird.getImage();
			this.y = this.y - 3;
		}else if (dy > 5) {this.y = this.y - 2;}
		else if (dy > 1) {this.y = this.y - 1;}
		else if (dy == 1); {
			this.icoBird = new ImageIcon(getClass().getResource("/images/flappy-bird.png"));
			this.imgBird = this.icoBird.getImage();
		}
		
	}

	@Override
	public void run() {
		while(true) {
			this.batementsWings(dy);
			this.dy--;
			try {
				Thread.sleep(PAUSE);} catch (InterruptedException e) {}

			}
		}		
}
