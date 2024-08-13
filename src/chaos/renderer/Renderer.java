package chaos.renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import chaos.Handler;

public class Renderer {

	private Handler handler;

	private int circleCentreX, circleCentreY;
	private int radius;
	
	public double g = -0.098;
	
	private ArrayList<Ball> balls;

	public Renderer(Handler handler) {
		this.handler = handler;

		circleCentreX = 0;
		circleCentreY = 0;
		radius = handler.getWidth() / 2;
		
		balls = new ArrayList<Ball>();
		
		int numBalls = 100;
		
		for (int i=0; i<numBalls; i++) {
			double rad = 5;
			double randX = (Math.random() - 0.5) * handler.getWidth();
			double randY = (Math.random() - 0.5) * handler.getHeight();
			double d = randX * randX + randY * randY;
			while (d >= (radius - rad) * (radius - rad)) {
				randX = (Math.random() - 0.5) * handler.getWidth();
				randY = (Math.random() - 0.5) * handler.getHeight();
				d = randX * randX + randY * randY;
			}
				
			balls.add(new Ball(handler, randX, randY, rad, new Color((int) Math.floor(Math.random() * 128 + 128), (int) Math.floor(Math.random() * 128 + 128), (int) Math.floor(Math.random() * 128 + 128))));
		}
		
//		balls.add(new Ball(handler, 320 / Math.sqrt(2), 320 / Math.sqrt(2) + 100, 10, Color.white));
	}

	public void tick() {
		for (Ball b : balls) {
			b.tick();
		}
		
		g = (handler.getKeyManager().dir ? +1 : -1) * 0.098;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval((circleCentreX + handler.getWidth() / 2) - radius,
				(-circleCentreY + handler.getHeight() / 2) - radius, radius * 2, radius * 2);
		
		for (Ball b : balls) {
			b.render(g);
		}
	}

	public int getCircleCentreX() {
		return circleCentreX;
	}

	public void setCircleCentreX(int circleCentreX) {
		this.circleCentreX = circleCentreX;
	}

	public int getCircleCentreY() {
		return circleCentreY;
	}

	public void setCircleCentreY(int circleCentreY) {
		this.circleCentreY = circleCentreY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
