package exam2_2;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Display extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Rectangle> arr = new ArrayList<>();

	public void setArr(ArrayList<Rectangle> arr) {
		this.arr = arr;
	}

	public Display() {
        setBackground(Color.white);
    }
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    for (Rectangle r : arr) {
	    	r.draw(g);
	    }
	}
	
}
