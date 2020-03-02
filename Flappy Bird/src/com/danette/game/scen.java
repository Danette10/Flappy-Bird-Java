package com.danette.game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.danette.objects.Tuyau;
import com.danette.skins.FlappyBird;

public class scen extends JPanel {
	
	// VARIABLES
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	
	public Tuyau tuyauHaut1;
	public Tuyau tuyauBas1;
	public Tuyau tuyauHaut2;
	public Tuyau tuyauBas2;
	public Tuyau tuyauHaut3;
	public Tuyau tuyauBas3;
	
	public FlappyBird flappyBird;
	
	private final int LARGEUR_BANDE_FOND = 288;
	private final int DISTANCE_TUYAUX = 250;
	private final int ECART_TUYAUX = 120;
	
	public int xFond;
	private int xTuyaux;
	
	private Random random;
	// CONSTRUCTEUR
	public scen() {
		
		super();
		this.icoBandeFond = new ImageIcon(getClass().getResource("/images/background-day.png"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		
		this.xFond = 0;
		this.xTuyaux = 100;
		
		this.tuyauHaut1 = new Tuyau(this.xTuyaux, -150, "/images/tuyau_vers_le_bas.png");
		this.tuyauBas1 = new Tuyau(this.xTuyaux, 250, "/images/tuyau_vers_le_haut.png");
		this.tuyauHaut2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX, -100, "/images/tuyau_vers_le_bas.png");
		this.tuyauBas2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX, 300, "/images/tuyau_vers_le_haut.png");
		this.tuyauHaut3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX * 2, -120, "/images/tuyau_vers_le_bas.png");
		this.tuyauBas3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX * 2, 280, "/images/tuyau_vers_le_haut.png");
		
		this.flappyBird = new FlappyBird(10, 150, "/images/flappy-bird.png");
		
		random = new Random();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	// METHODES
	private void deplacementFond(Graphics g) {
		if(this.xFond == -this.LARGEUR_BANDE_FOND) {this.xFond = 0;}
		g.drawImage(this.imgBandeFond, this.xFond, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND * 2, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND * 3, 0, null);
		
	} private void deplacementTuyaux(Graphics g) {
			// Tuyau 1
			this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
			this.tuyauBas1.setX(this.tuyauHaut1.getX());
			
			if(this.tuyauHaut1.getX() == -180) {
				this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DISTANCE_TUYAUX);
				this.tuyauHaut1.setY(-150 - 25 * this.random.nextInt(18));
				this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.ECART_TUYAUX);
			}
			g.drawImage(this.tuyauHaut1.getImgTuyau(), this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
			g.drawImage(this.tuyauBas1.getImgTuyau(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);
			
			// Tuyau 2
			this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
			this.tuyauBas2.setX(this.tuyauHaut2.getX());
			
			if(this.tuyauHaut2.getX() == -180) {
				this.tuyauHaut2.setX(this.tuyauHaut1.getX() + this.DISTANCE_TUYAUX);
				this.tuyauHaut2.setY(-150 - 25 * this.random.nextInt(18));
				this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.ECART_TUYAUX);
			}
			g.drawImage(this.tuyauHaut2.getImgTuyau(), this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
			g.drawImage(this.tuyauBas2.getImgTuyau(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
			
			// Tuyau 3
			this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
			this.tuyauBas3.setX(this.tuyauHaut3.getX());
			
			if(this.tuyauHaut3.getX() == -180) {
				this.tuyauHaut3.setX(this.tuyauHaut2.getX() + this.DISTANCE_TUYAUX);
				this.tuyauHaut3.setY(-150 - 25 * this.random.nextInt(18));
				this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.ECART_TUYAUX);
			}
			g.drawImage(this.tuyauHaut3.getImgTuyau(), this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
			g.drawImage(this.tuyauBas3.getImgTuyau(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
		}
	public void paintComponent(Graphics g) {
		this.deplacementFond(g);
		this.deplacementTuyaux(g);
		this.flappyBird.setY(this.flappyBird.getY() + 1);
		g.drawImage(this.flappyBird.getImgBird(), this.flappyBird.getX(), this.flappyBird.getY(), null);
	}

}
