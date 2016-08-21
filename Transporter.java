package game;

import java.awt.Color;
import java.awt.Graphics;

public class Transporter {

	int x = 400;
	int y = 300;
	Ball ball;
	
	Transporter(Ball ball) {
		
		this.ball = ball;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 55, 55);
		g.drawString("Transporter", x - 5, y - 5);
	}
	
}
