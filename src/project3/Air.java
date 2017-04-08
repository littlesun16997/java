package project3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.JOptionPane;

public class Air {
	private String p;
	private int ss;
	private ArrayList<String> key = new ArrayList<>();
	private ArrayList<Double> value = new ArrayList<>();

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}

	public ArrayList<String> getKey() {
		return key;
	}

	public void setKey(ArrayList<String> key) {
		this.key = key;
	}

	public ArrayList<Double> getValue() {
		return value;
	}

	public void setValue(ArrayList<Double> value) {
		this.value = value;
	}

	public void test() {
		try (InputStream in = new URL(
				"http://biomi.kapsi.fi/tools/airquality/?p=" + getP() + "&ss="
						+ getSs()).openStream();
				JsonReader reader = Json.createReader(in)) {
			JsonObject jo = reader.readObject();
			JsonObject today = jo.getJsonObject("today");
			for (String a : today.keySet()) {
				key.add(a);
				value.add(Double.parseDouble(today.get(a).toString()));
			}
		} catch (MalformedURLException ex1) {
			JOptionPane.showMessageDialog(null, "Error: " + ex1.getMessage());
		} catch (IOException ex2) {
			JOptionPane.showMessageDialog(null, "Error: " + ex2.getMessage());
		} catch (NullPointerException ex3) {
			JOptionPane.showMessageDialog(null, "Error: " + "Station does not have this measurement");
		}
	}
}
