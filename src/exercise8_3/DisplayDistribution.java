package exercise8_3;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import exercise5_1.Distribution;

public class DisplayDistribution extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Distribution freq;
	private Color textColor;
	private Font textFont;
	
	public void setFreq(Distribution freq) {
		this.freq = freq;
	}
	public DisplayDistribution() {
        setBackground(Color.white);
        textColor = Color.blue;
        textFont = new Font("Serif", Font.BOLD, 24);
    }
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    //Sets the drawing color and font of the graphics context
	    g.setColor(textColor);
	    g.setFont(textFont);
	    g.drawString("20", 20, 80);
	    g.drawLine(50, 70, 650, 70);
	    g.drawString("10", 20, 280);
	    g.drawLine(50, 270, 650, 270);
	    g.drawString("0", 20, 470);
	    g.drawLine(50, 470, 650, 470);
	    for (int i = 0; i < 6; i++) {
	    	g.setColor(Color.red);
	    	g.fillRect(60 + 100*i, 470, 70, -freq.frequency(i)*20);
	    	g.setColor(Color.black);
	    	g.drawString(Integer.toString(freq.frequency(i)), 90 + 100*i, 470);
	    	g.setColor(Color.green);
	    	g.drawString(Integer.toString(i), 90 + 100*i, 500);
	    }
	}
	
}
