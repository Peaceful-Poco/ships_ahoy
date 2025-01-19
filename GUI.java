
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GUI {
	EnemyShips ship;
	int sunkenships = 0;
	JLabel label;
	String names[] = {"Destroyer", "Submarine" , "Cruiser", "Battleship", "Carrier"};
	
		public GUI(EnemyShips ship){
		Piece[][]enemy = ship.getMatrix();
		this.ship = ship;
		JFrame frame = new JFrame(); 
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(enemy.length, ship.getMatrix()[0].length, 0,0));
		
		for(int row = 0; row < enemy.length; row++) {
			for(int col = 0; col< enemy[0].length; col++){
				Piece button = enemy[row][col];
				button.setOpaque(true);
				button.addActionListener(createActionlist());
				panel.add(button);
			}
		}
		
		
		frame.add(panel, BorderLayout.CENTER);
		label = ship.getLabel();
		frame.add(createFooter(),BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		
	}
	private JPanel createFooter() {
		JPanel panel = new JPanel();
		panel.add(label);
		label.setVisible(false);
		return panel;
	}
	
	
	public ActionListener createActionlist() {
		//TODO Create toString print info about ship
		
		
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				Piece button = (Piece)e.getSource();
				
					if(button.getPiecelength()!= 0) {
						if(button.getFound()) {
							return;
						}
						button.setFound(true);
						button.setForeground(Color.red);
						button.setBackground(Color.red);
						boolean see = ship.checkPiece(button);
						if(see) {
							sunkenships++;
							
							if(sunkenships == 5) {
								label.setVisible(true);
							}
							int index = button.getPiecelength()-2;
							JOptionPane.showMessageDialog(null, names[index], "Ship Sunk", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(names[index]);
						}
						
						button.setText("HIT");
					}
					else {
						
						button.setBackground(Color.blue);
						button.setText("Ocean");
					
				}
			
				
			}};
			
		return action;
	}
	

}

