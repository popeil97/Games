package game;

import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener {
	
	
	int width = 700;
	int height = 500;
	Thread thread;
	PlayerOne p1;
	PlayerTwo p2;
	Transporter trans;
	Ball ball;
	boolean gameOver = false;
	boolean startOver = false;
	boolean mainScreen = true;
	int players;
	boolean gameStarted = false;
	
	
	
	public void init() {
		
		
		this.resize(width, height);
		this.addKeyListener(this);
		p1 = new PlayerOne();
		ball = new Ball();
		trans = new Transporter(ball);
		p2 = new PlayerTwo();
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	public void run() {
		while(!gameOver) {
			if(gameStarted == true) {
				p1.move();
				p2.move();
				ball.move();
				ball.checkPaddleCollision(p1, p2);
				ball.checkTransporterCollision(trans);
				repaint();
			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.white);
		g.fillOval(300, 200, 80, 80);
		g.setColor(Color.blue);
		g.drawString("PONG", 340, 100);
		g.setColor(Color.red);
		g.fillOval(320, 220, 40, 40);
		
		if (ball.getX() < -10 || ball.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("GAME OVER", 350, 250);
			gameOver = true;
			if(startOver == true) {
				g.drawString("PRESS ENTER TO RESTART", 320, 280);
			}
		}
		
		else {
			p1.draw(g);
			p2.draw(g);
			ball.draw(g);
			trans.draw(g);
		}
		
		
		
		if(gameStarted == false) {
			g.setColor(Color.blue);
			//g.drawString("PONG", 340, 100);
			g.drawString("PRESS ENTER TO BEGIN", 310, 130);
		}
	}
	
	
	
	
	public void update(Graphics g) {
		paint(g);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		
		if(i == KeyEvent.VK_UP) {
			p2.setAccel(true);
		}
		
		if(i == KeyEvent.VK_DOWN) {
			p2.setDeAccel(true);
		}
		
		if(i == KeyEvent.VK_W) {
			p1.setAccel(true);
		}
		
		if(i == KeyEvent.VK_S) {
			p1.setDeAccel(true);
		}
		
		if(i == KeyEvent.VK_ENTER) {
			gameStarted = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int i = e.getKeyCode();
		
		if(i == KeyEvent.VK_UP) {
			p2.setAccel(false);
		}
		
		if(i == KeyEvent.VK_DOWN) {
			p2.setDeAccel(false);
		}
		
		if(i == KeyEvent.VK_W) {
			p1.setAccel(false);
		}
		
		if(i == KeyEvent.VK_S) {
			p1.setDeAccel(false);
		}
		
	}

	

}
