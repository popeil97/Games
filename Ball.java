package game;

import java.awt.Color;
import java.awt.Graphics;


public class Ball {

	double x;
	double y;
	double xVelocity;
	double yVelocity;
	
	Ball() {
		x = 350;
		y = 250;
		xVelocity = getSpeed() * getDirection();
		yVelocity = getSpeed() * getDirection();
	}
	
	public int getDirection() {
		int rando = (int)(Math.random() * 2);
		
		if(rando == 1) {
			return 1;
		}
		
		else
			return -1;
	}
	
	public double getSpeed() {
		double speed = (Math.random() * 3) + 2;
		return speed;
	}
	
	
	public void move() {
		y += yVelocity;
		x += xVelocity;
		
		if(y < 10) {
			yVelocity = -(yVelocity);
		}
		
		if(y > 490) {
			yVelocity = -(yVelocity);
		}
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(getX()-10, getY()-10, 20, 20);
		
	}
	
	
	public void checkPaddleCollision(Paddle p1, Paddle p2) {
		if(getX() <= 50) {
			if(getY() >= p1.getY() && getY() <= p1.getY() + 80) {
				xVelocity = -xVelocity;
			}
		}
		
		else if(getX() >= 650) {
			if(getY() >= p2.getY() && getY() <= p2.getY() + 80) {
				xVelocity = -xVelocity;
			}
		}
	}
	
	public void checkTransporterCollision(Transporter trans) {
		if((x >= trans.x && x <= trans.x + 55) && (y >= trans.y && y <= trans.y + 55)) {
			changeBallPosition();
			xVelocity = getSpeed() * getDirection();
			yVelocity = getSpeed() * getDirection();
		}
	}
	
	public void changeBallPosition() {
		 int range = (680 - 20) + 1;
		 x = (int)(Math.random() * range) + 20;
		 
	}
	
	
	
	
}
