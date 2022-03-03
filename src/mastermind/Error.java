package mastermind;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error {
	
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
	public Error() {

	frame.setSize(250, 70);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel);
	JLabel errormsg = new JLabel("Please select a color for every field!");
	
	panel.setLayout(null);
	
	errormsg.setForeground(Color.RED);
	errormsg.setBounds(20, 0, 210, 30);
	panel.add(errormsg);
	
}}