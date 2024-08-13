package chaos.renderer;

import java.awt.Color;
import java.awt.Graphics;

import chaos.Handler;

public class Ball {
	
	private double radius;
	private double x, y;
	
	private double velX, velY;
	
	private Handler handler;
	private Color color;
	
	public Ball(Handler handler, double x, double y, double radius, Color color) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.radius = radius;
		
		this.color = color;
		
		velX = 0;
		velY = 0;
	}
	
	public void tick() {
		double tx = x + velX;
		double ty = y + velY;
		
		double dx = (tx - handler.getRenderer().getCircleCentreX());
		double dy = (ty - handler.getRenderer().getCircleCentreY());
		
		double r2 = dx * dx + dy * dy;
		
		if (Math.sqrt(r2) > (handler.getRenderer().getRadius() - radius)) {
			//System.out.println("Touching boundary");
			
			double normalM = dy / dx;
			double tM = -1/normalM;
			
			double tC = ty - tx * tM;
			
			double vx = tx + velX;
			double vy = ty + velY;
			
			double k = 2 * (vy - tM*vx - tC) / (1 + tM*tM);
			double vxf = vx + tM*k;
			double vyf = vy - k;
			
			k = (handler.getRenderer().getRadius() - radius) / handler.getRenderer().getRadius() * (handler.getRenderer().getCircleCentreY() - tM * handler.getRenderer().getCircleCentreX() - tC) / (1 + tM * tM);
			
			//x = handler.getRenderer().getCircleCentreX() + tM * k;
			//y = handler.getRenderer().getCircleCentreY() + k;
			
			velY = vyf - ty;
			velX = vxf - tx;
		} else {
		
			x = tx;
			y = ty;
		}
		
		velY += handler.getRenderer().g;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x - radius + handler.getWidth()/2), (int)(-y - radius + handler.getHeight()/2), (int) (radius*2), (int) (radius*2));
	}

}
