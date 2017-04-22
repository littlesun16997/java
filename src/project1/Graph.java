package project1;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// Main class for user interface
public class Graph extends JFrame {
	private static final long serialVersionUID = 1L;

	private ArrayList<String> time = new ArrayList<>();
	private ArrayList<Double> temp = new ArrayList<>();
	private ArrayList<String> wind = new ArrayList<>();
	private Data data = new Data();
	private Draw draw = new Draw();

	public Data getData() {
		return data;
	}

	// Constructor
	public Graph() {
		setTitle("Weather data");
		JPanel panel = new JPanel();
		draw.setData(data);

		// Text fields for user to input a date, month and year
		JLabel date = new JLabel("Date");
		panel.add(date);
		JTextField input1 = new JTextField(10);
		panel.add(input1);

		JLabel month = new JLabel("Month");
		panel.add(month);
		JTextField input2 = new JTextField(10);
		panel.add(input2);

		JLabel year = new JLabel("Year");
		panel.add(year);
		JTextField input3 = new JTextField(10);
		panel.add(input3);

		// Button when clicked will draw a graph of temperature of the day the
		// user chose
		JButton graph = new JButton("Generate a graph");
		graph.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				data.getTemp().clear();
				// Get the day user wanted and fetch data from that day
				data.setDate(input1.getText());
				data.setMonth(input2.getText());
				data.setYear(input3.getText());
				data.getAddress();
				data.fetchData();

				// Draw the graph according to the values fetched from above
				repaint();
			}
		});
		draw.setLayout(null);
		panel.add(graph);

		// Create a file menu
		JFileChooser file = new JFileChooser();
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu();
		menu.setText("File");
		JMenuItem open = new JMenuItem();
		open.setText("Open");

		// When user wants to open a file
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = file.showOpenDialog(panel);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to open the
															// file
					try (BufferedReader inputfile = new BufferedReader(
							new FileReader(file.getSelectedFile()
									.getAbsolutePath()))) {
						String line, day;
						String[] split;
						// Get the day from the first line of the file
						day = inputfile.readLine();	
						split = day.split("/");
						data.setDate(split[0]);
						data.setMonth(split[1]);
						data.setYear(split[2]);
						
						// Get time, temperature and wind speed from the rest of the file
						while ((line = inputfile.readLine()) != null) {
							split = line.split(",");
							time.add(split[0]);
							temp.add(Double.parseDouble(split[1]));
							wind.add(split[2]);
						}
						data.setTime(time);
						data.setTemp(temp);
						data.setWind(wind);
						repaint();	// draw the graph
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		menu.add(open);

		JMenuItem save = new JMenuItem();
		save.setText("Save");
		// When user wants to save data to a file
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = file.showSaveDialog(panel);
				if (value == JFileChooser.APPROVE_OPTION) {
					try (PrintWriter outputfile = new PrintWriter(
							new FileOutputStream(file.getSelectedFile()
									.getAbsolutePath()), true)) {
						outputfile.print(data.getDate() + "/" + data.getMonth()
								+ "/" + data.getYear() + "\n");	// write the day
						for (int i = 0; i < data.getTemp().size(); i++) {
							// write time, temperature and wind speed
							outputfile.print(data.getTime().get(i) + ","
									+ data.getTemp().get(i) + ","
									+ data.getWind().get(i) + "\n");
						}
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		menu.add(save);
		bar.add(menu);

		setJMenuBar(bar);
		add(panel, BorderLayout.NORTH);
		add(draw, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
	}

	// Main function
	public static void main(String[] args) {
		Graph myframe = new Graph();
		myframe.setVisible(true);
	}

}
