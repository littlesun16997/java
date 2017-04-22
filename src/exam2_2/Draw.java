package exam2_2;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class Draw extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Rectangle> arr = new ArrayList<>();
	private Display display = new Display();

	public Draw() {
		setTitle("Draw rectangle");
		JPanel panel = new JPanel();
		JTextField txt = new JTextField(20);
		JButton btn = new JButton("Draw");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try (BufferedReader input = new BufferedReader(new InputStreamReader(Draw.class.getResourceAsStream(txt.getText())))) {
					String line;
					String[] split;
					while ((line = input.readLine()) != null) {
						split = line.split(",");
						int x = Integer.parseInt(split[0]);
						int y = Integer.parseInt(split[1]);
						int w = Integer.parseInt(split[2]);
						int h = Integer.parseInt(split[3]);
						Rectangle rect = new Rectangle(x, y, w, h);
						arr.add(rect);
					}
					display.setArr(arr);
					repaint();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(txt);
		panel.add(btn);

		add(panel, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Draw myframe = new Draw();
		myframe.setVisible(true);
	}
}
