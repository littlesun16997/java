package exercise8_3;

import exercise5_1.Distribution;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.util.Locale;

public class Display extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private DisplayDistribution panel = new DisplayDistribution();
	private Distribution freq = new Distribution(0, 6);
	private JTextField txtValue = new JTextField(10);
	private JLabel count = new JLabel("Count = ");
	private JLabel ave = new JLabel("Average = ");
	
	public Distribution getFreq() {
		return freq;
	}

	public Display() {
		setTitle("Distribution Display");
		JPanel insert = new JPanel();
		
		panel.setFreq(freq);
		panel.add(count);
		panel.add(ave);
		
		insert.add(txtValue);
		txtValue.addActionListener(this); // press enter to insert
		
		JButton insertBttn = new JButton("Insert");
        insertBttn.addActionListener(this);
        insert.add(insertBttn);
        
        add(insert, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);	         

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			freq.insert(Integer.parseInt(txtValue.getText()));
			count.setText("Count = " + freq.total());
			ave.setText("Average = " + String.format(Locale.ENGLISH, "%.2f", freq.average()));
			txtValue.setText(null);
			repaint();
		}
		catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please give a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public static void main(String[] args) {
		Display myframe = new Display();
		myframe.setVisible(true);
	}
}
