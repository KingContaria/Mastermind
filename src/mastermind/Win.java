package mastermind;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Win {
	
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
	public Win() {

	frame.setSize(350, 170);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel);
	JLabel congratulations = new JLabel("Congratulations!");
	JLabel youwon = new JLabel("You won the game!");
	JLabel text = new JLabel("To play another game, create a new Color Code.");
	
	panel.setLayout(null);
	
	congratulations.setBounds(115, 10, 210, 30);
	panel.add(congratulations);
	youwon.setBounds(110, 30, 210, 30);
	panel.add(youwon);
	text.setBounds(30, 80, 300, 30);
	text.setForeground(Color.GRAY);
	panel.add(text);
	
}}