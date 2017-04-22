package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

// Class for manipulating data fetched from the web site
public class Data {
	private String date, month, year;
	private ArrayList<String> time = new ArrayList<>();
	private ArrayList<Double> temp = new ArrayList<>();
	private ArrayList<String> wind = new ArrayList<>();
	
	// Getters and setters
	public void setTime(ArrayList<String> time) {
		this.time = time;
	}

	public void setTemp(ArrayList<Double> temp) {
		this.temp = temp;
	}

	public void setWind(ArrayList<String> wind) {
		this.wind = wind;
	}

	public ArrayList<String> getTime() {
		return time;
	}

	public ArrayList<Double> getTemp() {
		return temp;
	}

	public ArrayList<String> getWind() {
		return wind;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	// Return the address according to date, month and year
	public String getAddress() {
		return "https://www.wunderground.com/history/airport/EFVA/"
				+ year
				+ "/"
				+ month
				+ "/"
				+ date
				+ "/DailyHistory.html?req_city=Vaasa+Airport&req_state=&req_statename=Finland&reqdb.zip=00000&reqdb.magic=&reqdb.wmo=&format=1";
	}

	// Fetch weather data from the web 
	public void fetchData() {
		try (InputStream in = new URL(getAddress()).openStream();
				BufferedReader rin = new BufferedReader(new InputStreamReader(
						in))) {
			// Skip those lines indicating column's name
			rin.readLine();	
			rin.readLine();
			String line;
			String[] data;
			while ((line = rin.readLine()) != null) {
				// Store needed values in an array 
				data = line.split(",");	
				time.add(data[0]);
				temp.add(Double.parseDouble(data[1]));
				wind.add(data[7]);
			}
		} catch (MalformedURLException ex1) {
			JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE); 
		} catch (IOException ex2) {
			JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Calculate the average temperature
	public double average() {
		int sum = 0;
		for (int i = 0; i < temp.size(); i++) {
			sum += temp.get(i);
		}
		return (double)(sum)/temp.size();
	}
}
