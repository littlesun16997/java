package examples8;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyApplication extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField txt1 = new JTextField(5);
	private JTextField txt2 = new JTextField(5);
	private JButton btn = new JButton("Calculate");
	private JLabel lbl = new JLabel("Result:");
	
	public MyApplication() {
		this.setLayout(new FlowLayout());
		add(new JLabel("Value 1"));
		add(txt1);
		add(new JLabel("Value 2"));
		add(txt2);
		add(btn);
		add(lbl);
		lbl.setForeground(Color.MAGENTA);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		MyApplication obj = new MyApplication();
		obj.setSize(300, 300);
		obj.setLocationRelativeTo(null);
		obj.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double val1 = Double.parseDouble(txt1.getText());
		double val2 = Double.parseDouble(txt2.getText());
		lbl.setText("Result: " + (val1 + val2));
	}

}
