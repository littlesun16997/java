package project3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.ArrayList;

public class Draw extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color textColor;
	private Font textFont;
	private Air data;
	private Point p1 = new Point();
	private JLabel label = new JLabel();
	private ArrayList<Point> graphPoints = new ArrayList<>();
	private ArrayList<Ellipse2D> graphOval = new ArrayList<>();
	private Ellipse2D oval = new Ellipse2D.Double();

	public void setAir(Air data) {
		this.data = data;
	}

	public Draw() {
		setBackground(Color.white);
		textColor = Color.blue;
		textFont = new Font("Serif", Font.BOLD, 24);
		add(label);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				for (int i = 0; i < graphPoints.size(); i++) {
					if (graphOval.get(i).contains(evt.getX(), evt.getY())) {
						label.setText(data.getValue().get(i).toString());
						break;
					}
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Sets the drawing color and font of the graphics context
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(textColor);
		g2.setFont(textFont);
		int w = getWidth();
		int h = getHeight();
		// Draw y-axis.
		g2.drawLine(40, 30, 40, h - 30);
		g2.drawString("Value", 20, 20);
		// Draw x-axis.
		g2.drawLine(30, h - 50, w - 20, h - 50);
		g2.drawString("Time", w - 60, h - 30);
		// Mark data points.
		g2.setColor(Color.red);
		graphPoints.clear();
		graphOval.clear();
		label.setBounds(getWidth() / 2, 10, 100, 50);

		for (int i = 0; i < data.getValue().size(); i++) {
			int x1 = (int) (2 * i * w / 30 + 50);
			int y1 = (int) (-data.getValue().get(i) * h / 70 + h - 50);
			p1 = new Point(x1, y1);
			graphPoints.add(p1);
		}

		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - 3;
			int y = graphPoints.get(i).y - 3;
			int ovalW = 6;
			int ovalH = 6;
			oval = new Ellipse2D.Double(x, y, ovalW, ovalH);
			graphOval.add(oval);
			g2.fill(oval);
		}
	}
}
