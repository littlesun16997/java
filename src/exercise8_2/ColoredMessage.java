package exercise8_2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;

public class ColoredMessage extends JFrame {

    private static final long serialVersionUID = 1L;

    private ColoredMessagePanel messagePanel = new ColoredMessagePanel();
    private JTextField txtValue = new JTextField(10);
    
    public ColoredMessage() {
    	//EventHandler handler = new EventHandler();

          setTitle("Colored Message");
          JPanel buttonBar = new JPanel();
          JPanel textBar = new JPanel();

          JButton redBttn = new JButton("Red");
          redBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				messagePanel.setTextColor(Color.red);
			}
          });
          buttonBar.add(redBttn);

          JButton greenBttn = new JButton("Green");
          greenBttn.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				messagePanel.setTextColor(Color.green);
  			}
            });
          buttonBar.add(greenBttn);

          JButton blueBttn = new JButton("Blue");
          blueBttn.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				messagePanel.setTextColor(Color.blue);
  			}
            });
          buttonBar.add(blueBttn);
          
          textBar.add(txtValue);
          
          JButton btnPrint = new JButton("Print");
          btnPrint.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				messagePanel.setText(txtValue.getText());
  				repaint();
  			}
            });
          textBar.add(btnPrint);

          add(buttonBar, BorderLayout.SOUTH);
          add(textBar, BorderLayout.NORTH);
          add(messagePanel, BorderLayout.CENTER);	         

          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(350, 200);
          setLocationRelativeTo(null);
       }  
    
    public static void main(String[] args) {
          ColoredMessage myframe = new ColoredMessage();
          myframe.setVisible(true);
    } 
    
   /* class EventHandler implements ActionListener {
    	   
    	   public void actionPerformed(ActionEvent evt) {
    	   //Gets the command text on the button which was clicked
    	   String command = evt.getActionCommand(); 
    	   
    	   if (command.equals("Red"))
    		   messagePanel.setTextColor(Color.red);
    	   else if (command.equals("Green"))
    	       messagePanel.setTextColor(Color.green);
    	   else if (command.equals("Blue"))
    	       messagePanel.setTextColor(Color.blue);
    	   if (command.equals("Print"))
    		   messagePanel.setText(txtValue.getText());
    	       repaint();
    	   } 
       }*/
} 