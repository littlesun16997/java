package project2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Locale;

import javax.swing.*;

public class Graph extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar(); // Menubar
	private JMenu fileMenu = new JMenu("File"); // File menu
	private JFileChooser fileDialog = new JFileChooser(); // standard file
															// dialog
	private JTextArea data = new JTextArea(500, 500);
	private JTabbedPane tab = new JTabbedPane();
	private FetchData collection = new FetchData();
	private Draw draw = new Draw();
	private ArrayList<Data> arr = new ArrayList<>();

	public FetchData getCollection() {
		return collection;
	}

	public Graph() {
		setTitle("Electricity consumption");
		setJMenuBar(menuBar); // sets for the frame's menubar
		// Create the menu items

		JMenuItem t = new JMenuItem("Open");
		fileMenu.add(t);
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = fileDialog.showOpenDialog(tab);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to
															// open the file
					String filename = fileDialog.getSelectedFile()
							.getAbsolutePath();
					collection.readFromFile(filename);
					update();
				}
			}
		});
		t = new JMenuItem("Save");
		fileMenu.add(t);
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = fileDialog.showSaveDialog(tab);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to
															// save the file
					String filename = fileDialog.getSelectedFile()
							.getAbsolutePath();
					collection.writeToFile(filename);
				}
			}
		});
		t = new JMenuItem("Exit");
		fileMenu.add(t);
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		menuBar.add(fileMenu); // add the file menu to the menu bar

		// set the properties of text area and add it to the frame
		data.setLineWrap(true);
		data.setWrapStyleWord(true);

		JPanel panel2 = new JPanel();
		JLabel label1 = new JLabel("Month");
		panel2.add(label1);
		JTextField txt1 = new JTextField(10);
		panel2.add(txt1);
		JLabel label2 = new JLabel("Year");
		panel2.add(label2);
		JTextField txt2 = new JTextField(10);
		panel2.add(txt2);
		JLabel label3 = new JLabel("Amount");
		panel2.add(label3);
		JTextField txt3 = new JTextField(10);
		panel2.add(txt3);
		JButton insert = new JButton("Insert");
		panel2.add(insert);
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Data d = new Data();
				d.setMonth(txt1.getText());
				d.setYear(txt2.getText());
				d.setValue(Double.parseDouble(txt3.getText()));
				collection.getData().add(d);
				update();
			}
		});

		draw.setData(collection);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(draw, BorderLayout.CENTER);
		draw.setH(panel1.getHeight());
		draw.setW(panel1.getWidth());
		String[] split = data.getText().split("\n");
		for (int i = 0; i < split.length - 5; i++) {
			arr.add(collection.toData(split[i]));
		}
		collection.setData(arr);
		draw.setData(collection);
		repaint();
	
		tab.addTab("File", data);
		tab.addTab("Insert", panel2);
		tab.addTab("Graph", panel1);
		
		add(tab, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
	}

	private void update() {
		data.setText(null);

		for (Data d : collection.getData()) {
			data.append(d.toString() + "\n");
		}
		data.append("Total consumption: " + collection.total() + "\n");
		data.append("Average: "
				+ String.format(Locale.ENGLISH, "%.2f", collection.average())
				+ "\n");
		data.append("Minimum: " + collection.min() + "\n");
		data.append("Max: " + collection.max() + "\n");
	}

	public static void main(String[] args) {
		Graph myframe = new Graph();
		myframe.setVisible(true);
	}
}
