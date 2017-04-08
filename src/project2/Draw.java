package project2;

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
	private int h, w;
	private FetchData data;
	private Point p1 = new Point();
	private JLabel label = new JLabel();
	private ArrayList<Point> graphPoints = new ArrayList<>();
	private ArrayList<Ellipse2D> graphOval = new ArrayList<>();
	private Ellipse2D oval = new Ellipse2D.Double();

	public void setData(FetchData data) {
		this.data = data;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public Draw() {
		setBackground(Color.white);
		textColor = Color.blue;
		textFont = new Font("Serif", Font.BOLD, 20);
		add(label);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				for (int i = 0; i < graphPoints.size(); i++) {
					if (graphOval.get(i).contains(evt.getX(), evt.getY())) {
						label.setText(data.getData().get(i).toString());
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
		w = getWidth();
		h = getHeight();
		// Draw y-axis.
		g2.drawLine(40, 30, 40, 500);
		g2.drawString("Value", 20, 20);
		// Draw x-axis.
		g2.drawLine(30, 480, 650, 480);
		g2.drawString("Time", w - 60, h / 2 + 80);
		// Mark data points.
		g2.setColor(Color.red);
		graphPoints.clear();
		graphOval.clear();
		label.setBounds(getWidth() / 2, 10, 100, 50);

		g2.drawLine(35, -h / 8 + h / 2 + 50, 45, -h / 8 + h / 2 + 50);
		g2.drawString("5", 10, -h / 8 + h / 2 + 50);
		g2.drawLine(35, -h / 4 + h / 2 + 50, 45, -h / 4 + h / 2 + 50);
		g2.drawString("10", 10, -h / 4 + h / 2 + 50);
		g2.drawLine(35, -h*3 / 8 + h / 2 + 50, 45, -h*3 / 8 + h / 2 + 50);
		g2.drawString("15", 10, -h*3 / 8 + h / 2 + 50);
		g2.drawLine(35, 50, 45, 50);
		g2.drawString("20", 10, 50);
		g2.drawLine(35, h / 8 + h / 2 + 50, 45, h / 8 + h / 2 + 50);
		g2.drawString("-5", 10, h / 8 + h / 2 + 50);
		g2.drawLine(35, h / 4 + h / 2 + 50, 45, h / 4 + h / 2 + 50);
		g2.drawString("-10", 5, h / 4 + h / 2 + 50);

		for (int i = 0; i < data.getData().size(); i++) {
			int x1 = (int) (i * 13 + 50);
			int y1 = (int) (-data.getData().get(i).getValue() * 13 + 300);
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
