package mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EnterColors implements ActionListener {

	static private int color[] = new int[5];
	int selectedcolor[] = new int[5];

	
	public static int[] getColor() {
		return color;
	}

	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton code[] = new JButton[5];
	JButton start = new JButton("Start");
	JButton random = new JButton("Play with random code");
		
		public EnterColors() {
			
			
			frame.setSize(360, 350);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			frame.add(panel);
			
			panel.setLayout(null);
			
			start.setBounds(75, 120, 200, 75);
			panel.add(start);
			random.setBounds(75, 205, 200, 75);
			panel.add(random);
			
			for(int i = 0; i < code.length; i++) {
				code[i] = new JButton();
				code[i].setBounds(30 + i * 60, 30, 50, 50);
				panel.add(code[i]);
				code[i].addActionListener(this);
			}
			
			start.addActionListener(this);
			random.addActionListener(this);
		}		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i = 0; i < 5; i++) {
				if(e.getSource()==code[i]) {
					selectedcolor[i]++;
					code[i].setOpaque(true);
					switch(selectedcolor[i]) {
					case 1: code[i].setBackground(Color.YELLOW); break;
					case 2: code[i].setBackground(Color.ORANGE); break;
					case 3: code[i].setBackground(Color.RED); break;
					case 4: code[i].setBackground(Color.MAGENTA); break;
					case 5: code[i].setBackground(Color.CYAN); break;
					case 6: code[i].setBackground(Color.GREEN); break;
					default: selectedcolor[i] = 0;
					code[i].setOpaque(false);
					}}
			}
			
			if(e.getSource()==start) {
				if(selectedcolor[0] * selectedcolor[1] * selectedcolor[2] * selectedcolor[3] * selectedcolor[4] == 0) {
					new Error();
				}
				else {
					for(int i = 0; i < 5; i++) {
						color[i] = selectedcolor[i];
					}
					new gui();
				}
			}
			
			if(e.getSource()==random) {
				for(int i = 0; i < 5; i++) {
					color[i] = generaterandomnumber.random();
				}
				System.out.println(color[0] + " & " + color[1] + " & " + color[2] + " & " + color[3] + " & " + color[4]);
				new gui();
				}
			}
		}
	

			

			
			
		
	

