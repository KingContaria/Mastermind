package mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class gui implements ActionListener {
	
	static int color[] = EnterColors.getColor();
	
	static public int[] getColor() {
		return color;
	}
	
	int xcolor[] = new int[5];
	int guesses = 0;
	int lines;
	int correctness[] = new int[2];

	JPanel panel = new JPanel();
	JButton send = new JButton("Guess");
	JLabel guessnumber[] = new JLabel[6];
	
	JButton result[][] = new JButton[6][5];
	JButton row[][] = new JButton[7][5];

	
	public gui() {
	
	JFrame frame = new JFrame();
	frame.setSize(360, 300);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel);
	
	panel.setLayout(null);
	
	for(int i = 0; i < guessnumber.length; i++) {
		int j = i + 1;
		guessnumber[i] = new JLabel("(" + j + ")");
		guessnumber[i].setBounds(20, 160 - i * 30, 30, 30);
		panel.add(guessnumber[i]);
	}	
	
	send.setBounds(240, 210, 75, 25);
	panel.add(send);
	
	for(int r1 = 0; r1 < result.length; r1++) {
		for(int r2 = 0; r2 < result[0].length; r2++) {
			result[r1][r2] = new JButton();
			result[r1][r2].setBounds(253 + r2 * 13, 167 - r1 * 30, 7, 21);
			panel.add(result[r1][r2]);
		}
	}
	
	for(int r1 = 0; r1 < row.length; r1++) {
		for(int r2 = 0; r2 < row[0].length; r2++) {
			int x = 0;
			if(r1 == 6) {
				x = 15;
			}
			row[r1][r2] = new JButton();
			row[r1][r2].setBounds(80 + r2 * 30, 15 + r1 * 30 + x, 25, 25);
			panel.add(row[r1][r2]);
		}
	}
	
	
	for(int i = 0; i < 5; i++) {
		row[6][i].addActionListener(this);
	}
	send.addActionListener(this);
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 5; i++) {
			if(e.getSource()==row[6][i]) {
				xcolor[i]++;
				row[6][i].setOpaque(true);
				switch(xcolor[i]) {
				case 1: row[6][i].setBackground(Color.YELLOW); break;
				case 2: row[6][i].setBackground(Color.ORANGE); break;
				case 3: row[6][i].setBackground(Color.RED); break;
				case 4: row[6][i].setBackground(Color.MAGENTA); break;
				case 5: row[6][i].setBackground(Color.CYAN); break;
				case 6: row[6][i].setBackground(Color.GREEN); break;
				default: xcolor[i] = 0;
				row[6][i].setOpaque(false);
				}}
		}
		
		if(e.getSource()==send) {
				
			if(xcolor[0] * xcolor[1] * xcolor[2] * xcolor[3] * xcolor[4] == 0) {
					new Error();
			}
			else {
							
				for(int i = 0; i < 5; i++) {
					row[5 - guesses][i].setBackground(row[6][i].getBackground());
				}							
							
				int[] eliminated = new int[10];
				int[] eliminatedx = new int[10];
							
				for(int i = 0; i < 5; i++) {
					if(color[i] == xcolor[i]) {
						correctness[0] += 1;
						eliminated[5+i] = i+1;
						eliminatedx[5+i] = i+1;
					}
				}
							
				for(int i = 0; i < 5; i++) {
					boolean used = false;
					for(int f: eliminated) {
						if(i == f-1) {
							used = true;
						}
					}
					if(used == false) {
						for(int j = 0; j < 5; j++) {
							used = false;
							for(int f: eliminatedx) {
								if(j == f-1) {
									used = true;
								}
							}
							if(used == false) {
								if(i != j) {
									if(color[i] == xcolor[j]) {
										eliminatedx[i] = j+1;
										correctness[1] += 1;
										j = 5;
									}
								}
							}
						}
					}
				}
							
				for(int i = 0; correctness[0] - i > 0; i++) {
					result[guesses][i].setBackground(Color.BLACK);			
				}

				for(int i = 0; correctness[1] - i > 0; i++) {
					result[guesses][i+correctness[0]].setBackground(Color.WHITE);			
				}
				
				guesses++;
				
				if(correctness[0] == 5) {
					new Win();
					guesses = 7;
				}
				else {
					if(guesses == 6) {
						new Lose();
					}
				}
						
				for(int i = 0; i < 5; i++) {
					row[6][i].setOpaque(false);
					row[6][i].setBackground(Color.LIGHT_GRAY);
					xcolor[i] = 0;
				}
							
				correctness[0] = 0;
				correctness[1] = 0;
	
			}		
		}
	}
}