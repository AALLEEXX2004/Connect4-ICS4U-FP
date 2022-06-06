import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;

public class DrawC {

	private JFrame framein;
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	
	public DrawC(){
	
		framein = new JFrame("Connect Four");
	 
	    button1 = new JButton();
	    button1.addActionListener(e -> getGameMode(0);DrawG.main(););
	    button1.setText("PvP");
	    button1.setFocusable(false);
	        
	    button2 = new JButton();
	    button2.addActionListener(e -> getGameMode(1);DrawG.main(););
	    button2.setText("PvE-Hard");
	    button2.setFocusable(false);
	    
	    button3 = new JButton();
	    button3.addActionListener(e -> getGameMode(1);DrawG.main(););
	    button3.setText("PvE-Medium");
	    button3.setFocusable(false);

	    button4 = new JButton();
	    button4.addActionListener(e -> getGameMode(1);DrawG.main(););
	    button4.setText("PvE-Easy");
	    button4.setFocusable(false);

	        
	 	
	 	panel = new JPanel();
	 	panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	 	panel.setLayout(new GridLayout(0,1));
	 	panel.add(button1);
	 	panel.add(button2);
	 	panel.add(button3);
	 	panel.add(button4);

		
	 	framein.add(panel, BorderLayout.CENTER);
        framein.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framein.pack();
        framein.setVisible(true);
        
	 	
        
        
        
	 	
	}

	public static void main(String[] args) {
		new DrawC();

	}
	
}
