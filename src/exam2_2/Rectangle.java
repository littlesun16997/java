package exam2_2;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Describes the characteristics of a rectangle which can be
 * drawn on a graphics context.
 */
public class Rectangle {
	
	private int x, y;
	private int width, height;
	private Color color;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		//random colour
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		color = new Color(r, g, b);
	}
	
	/*
	 * Draws this rectangle on the graphics context which is
	 * passed as a parameter.
	 */
	public void draw(Graphics g){
		Color prev = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(prev);
	}	

}
