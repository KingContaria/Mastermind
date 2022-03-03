package mastermind;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lose {
	
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
	public Lose() {

	frame.setSize(350, 200);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel);
	JLabel youlost = new JLabel("You lost the game!");
	JLabel usedallguesses = new JLabel("You used all your guesses.");
	JLabel text = new JLabel("To play another game, create a new Color Code.");
	JLabel solution = new JLabel("Solution:");
	panel.setLayout(null);
	usedallguesses.setBounds(90, 30, 210, 30);
	panel.add(usedallguesses);
	youlost.setBounds(112, 10, 210, 30);
	panel.add(youlost);
	text.setBounds(30, 110, 300, 30);
	text.setForeground(Color.GRAY);
	panel.add(text);
	solution.setBounds(60, 80, 50, 30);
	panel.add(solution);
	JButton result[] = new JButton[5];
	for(int i = 0; i < 5; i++) {
		result[i] = new JButton();
		result[i].setBounds(120 + i * 30, 83, 25, 25);
		panel.add(result[i]);
		switch(gui.getColor()[i]) {
			case 1: result[i].setBackground(Color.YELLOW); break;
			case 2: result[i].setBackground(Color.ORANGE); break;
			case 3: result[i].setBackground(Color.RED); break;
			case 4: result[i].setBackground(Color.MAGENTA); break;
			case 5: result[i].setBackground(Color.CYAN); break;
			case 6: result[i].setBackground(Color.GREEN); break;
		}}
	}
	
}