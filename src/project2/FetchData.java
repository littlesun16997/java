package project2;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class FetchData {
	private ArrayList<Data> data = new ArrayList<>();

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	public void writeToFile(String filename) {
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(filename))) {
			fout.writeObject(data);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void readFromFile(String filename) {
		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(
				filename))) {
			data = (ArrayList<Data>) fin.readObject();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	public Data toData(String line) {
		Data d = new Data();
		String[] split = line.split(",");
		String[] div = split[0].split("/");
		d.setMonth(div[0]);
		d.setYear(div[1]);
		d.setValue(Double.parseDouble(split[1]));
		return d;
	}
	
	public double total() {
		double sum = 0;
		for (int i = 0; i < data.size(); i++) {
			sum += data.get(i).getValue();
		}
		return sum;
	}
	public double average() {
		return total()/data.size();
	}
	public double min() {
		double min = data.get(0).getValue();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getValue() < min) {
				min = data.get(i).getValue();
			}
		}
		return min;
	}
	public double max() {
		double max = data.get(0).getValue();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getValue() > max) {
				max = data.get(i).getValue();
			}
		}
		return max;
	}
}
