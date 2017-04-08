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
import java.util.Locale;

public class Graph extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> time = new ArrayList<>();
	private ArrayList<Double> temp = new ArrayList<>();
	private Data data = new Data();
	private Draw draw = new Draw();

	public Data getData() {
		return data;
	}

	public Graph() {
		setTitle("Weather data");
		JPanel panel = new JPanel();
		draw.setData(data);

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

		JLabel average = new JLabel("Average temperature = ");
		average.setBounds(300, 0, 200, 50);
		draw.add(average);

		JButton graph = new JButton("Generate a graph");
		graph.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				data.getTemp().clear();
				data.setDate(input1.getText());
				data.setMonth(input2.getText());
				data.setYear(input3.getText());
				data.getAddress();
				data.fetchData();
				repaint();
				average.setBounds(draw.getWidth()/2, -15, 200, 50);
				average.setText("Average temperature = "
						+ String.format(Locale.ENGLISH, "%.2f", data.average()));
			}
		});
		draw.setLayout(null);
		panel.add(graph);
		JFileChooser file = new JFileChooser();
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu();
		menu.setText("File");
		JMenuItem open = new JMenuItem();
		open.setText("Open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = file.showOpenDialog(panel);
				if (value == JFileChooser.APPROVE_OPTION) { // if user really
															// wants to open the
															// file
					try (BufferedReader inputfile = 
			                new BufferedReader(new FileReader(file
			                        .getSelectedFile().getAbsolutePath()))) {
			                String line;
			                String[] split;
			                while ((line = inputfile.readLine()) != null){
			                    split = line.split(",");
			                    time.add(split[0]);
			                    temp.add(Double.parseDouble(split[1]));
			                }
			                data.setTime(time);
			                data.setTemp(temp);
			                repaint();
			                average.setBounds(draw.getWidth()/2, -15, 200, 50);
							average.setText("Average temperature = "
									+ String.format(Locale.ENGLISH, "%.2f", data.average()));
			            } 
			            catch (IOException ex) {
			            	JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
			            } 
				}
			}
		});
		menu.add(open);

		JMenuItem save = new JMenuItem();
		save.setText("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int value = file.showSaveDialog(panel);
				if (value == JFileChooser.APPROVE_OPTION) {
					try (PrintWriter outputfile = new PrintWriter(
		                    new FileOutputStream(file.getSelectedFile().getAbsolutePath()),
		                    true)) {
		                for (int i = 0; i < data.getTemp().size(); i++) {
		                 	outputfile.print(data.getTime().get(i) + "," + data.getTemp().get(i) + "," + data.getWind().get(i) + "\n");
		                }
		            }
		            catch (Exception ex) {
		            	JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
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

	public static void main(String[] args) {
		Graph myframe = new Graph();
		myframe.setVisible(true);
	}

}
