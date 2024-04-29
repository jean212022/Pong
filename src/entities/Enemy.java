package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Enemy {
	public double x, y;
	public int width, height;
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		x += (Game.ball.x - x - 6) * 0.4;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, this.width, this.height);
	}
}
