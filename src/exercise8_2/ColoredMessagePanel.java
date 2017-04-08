package exercise8_2;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*
 *  Component for showing text "Hello World" on a white
 *  background, using bold font. The text color can be changed.
 */
public class ColoredMessagePanel extends JPanel{

    private static final long serialVersionUID = 1L;

    private Color textColor;
    private Font textFont;
    private String textString = "Hello";
    
    public ColoredMessagePanel() {
        setBackground(Color.white);
        textColor = Color.red;
        textFont = new Font("Serif", Font.BOLD, 24);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Sets the drawing color and font of the graphics context
        g.setColor(textColor);
        g.setFont(textFont);
        //Draws text, baseline of the leftmost character is at position (100, 50)
        g.drawString(textString, 100, 50);
    }

    //Sets a new text color and repaints this component
    public void setTextColor(Color color) {
        textColor = color;
        repaint();
    }
    
    public void setText(String text) {
    	textString = text; 
    }

} 