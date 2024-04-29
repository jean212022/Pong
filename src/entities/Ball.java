package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import main.Game;

public class Ball {
	public int x, y, width, height;
	public double dx, dy, speed = 0.4;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		int angle = new Random().nextInt(80);
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		if(x + (dx*speed) + width >= Game.WIDTH) {
			dx*=(-1);
		} else if(x+(dx*speed) < 0) {
			dx*=(-1);	
		}
		
		if(y >= Game.HEIGHT) {
			System.out.println("Ponto do inimigo!");
			new Game();
			return;
		} else if (y < 0) {
			//Ponto do jogador
			System.out.println("Ponto do jogador!");
			new Game();
			return;
		}
		Rectangle bounds = new Rectangle((int)(x+dx*speed), (int)(y+dy*speed), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			dy*=-1;
		} else if(bounds.intersects(boundsEnemy)) {
			dy*=-1;
		}
		x += dx*speed;
		y += dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, this.width, this.height);
	}
}
