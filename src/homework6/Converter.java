package homework6;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.util.Locale;

public class Converter extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Currency currency = new Currency();
	
	private JLabel from = new JLabel("From: ");
	JComboBox<String> in = new JComboBox<>(currency.getNames());	
	
	private JLabel to = new JLabel("To: ");
	JComboBox<String> out = new JComboBox<>(currency.getNames());
	
	private JLabel amount = new JLabel("Amount: ");
	private JTextField txt = new JTextField(10);
	private JLabel lbl = new JLabel("\n");
	
	public Converter() {
		setTitle("Currency converter");
		JPanel panel = new JPanel();
		
		panel.add(from);
		panel.add(in);
		panel.add(to);
		panel.add(out);
		panel.add(amount);
		panel.add(txt);
		
		JButton insertBttn = new JButton("Calculate");
        insertBttn.addActionListener(this);
        panel.add(insertBttn);
        panel.add(lbl);
        
        add(panel, BorderLayout.CENTER);	         

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String conv_from = in.getSelectedItem().toString();
		String conv_to = out.getSelectedItem().toString();
		double amount = Double.parseDouble(txt.getText());
		
		lbl.setText(amount + " " + conv_from + " = " + String.format(Locale.ENGLISH, "%.3f", currency.convert(conv_from, conv_to, amount)) + " " + conv_to);
	}
	
	public static void main(String[] args) {
		Converter myframe = new Converter();
		myframe.setVisible(true);
	}

}
