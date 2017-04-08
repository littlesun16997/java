package project3;

import java.awt.BorderLayout;
import java.io.*;
import java.net.URL;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar(); // Menubar
	private JMenu fileMenu = new JMenu("File"); // File menu
	private JFileChooser fileDialog = new JFileChooser(); // standard file
															// dialog
	private HashMap<Integer, String> model = new HashMap<>();
	private ArrayList<String> values = new ArrayList<>();
	private Air air = new Air();
	private Draw draw = new Draw();
	private ArrayList<String> key = new ArrayList<>();
	private ArrayList<Double> data = new ArrayList<>();

	public Air getAir() {
		return air;
	}

	@SuppressWarnings("unchecked")
	public Frame() {
		setTitle("Air quality");
		JPanel panel = new JPanel();
		JLabel value = new JLabel("Value");
		JLabel station = new JLabel("Station");
		setJMenuBar(menuBar); // sets for the frame's menubar
		// Create the menu items

		JMenuItem t = new JMenuItem("Open");
		fileMenu.add(t);
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = fileDialog.showOpenDialog(fileMenu);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to
															// open the file
					try (BufferedReader inputfile = new BufferedReader(
							new FileReader(fileDialog.getSelectedFile()
									.getAbsolutePath()))) {
						String line;
						String[] split;
						while ((line = inputfile.readLine()) != null) {
							split = line.split(",");
							key.add(split[0]);
							data.add(Double.parseDouble(split[1]));
						}
						air.setKey(key);
						air.setValue(data);
						repaint();
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		t = new JMenuItem("Save");
		fileMenu.add(t);
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = fileDialog.showSaveDialog(fileMenu);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to
															// save the file
					try (PrintWriter outputfile = new PrintWriter(
							new FileOutputStream(fileDialog.getSelectedFile()
									.getAbsolutePath()), true)) {
						for (int i = 0; i < air.getKey().size(); i++) {
							outputfile.print(air.getKey().get(i) + ","
									+ air.getValue().get(i) + "\n");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		menuBar.add(fileMenu);
		@SuppressWarnings("rawtypes")
		JComboBox combo2 = new JComboBox<>();

		JComboBox<String> combo1 = new JComboBox<>(new String[] {
				"Nitrogen dioxide", "Particulates" });
		JButton graph = new JButton("Draw graph");
		graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					air.getValue().clear();
					String type = combo1.getSelectedItem().toString();
					if (type.equals("Nitrogen dioxide")) {
						air.setP("nitrogendioxide");
					} else {
						air.setP("particulateslt10um");
					}
					String station = combo2.getSelectedItem().toString();
					for (Integer k : model.keySet()) {
						String s = model.get(k);
						if (values.contains(s) && station.equals(s)) {
							air.setSs(k);
							break;
						}
					}
					air.test();
					repaint();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		readFromFile();
		for (int i = 0; i < values.size(); i++) {
			combo2.addItem(values.get(i));
		}

		draw.setAir(air);

		panel.add(value);
		panel.add(combo1);
		panel.add(station);
		panel.add(combo2);
		panel.add(graph);

		add(panel, BorderLayout.NORTH);
		add(draw, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
	}

	public void readFromFile() {
		ClassLoader cl = this.getClass().getClassLoader();
		URL url = cl.getResource("project3/Station");
		try (InputStream in = url.openStream();
				BufferedReader input = new BufferedReader(
						new InputStreamReader(in))) {
			String line;
			String[] split;
			while ((line = input.readLine()) != null) {
				split = line.split(" ", 2);
				model.put(Integer.parseInt(split[0]), split[1]);
				values.add(split[1]);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public static void main(String args[]) {
		Frame myframe = new Frame();
		myframe.setVisible(true);
	}
}
