import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class gameOverWindow extends JFrame implements ActionListener{
	
	
	JPanel buttonsPanel = new JPanel();
	JPanel InstrPanel = new JPanel();
	JLabel InstrLabel = new JLabel();
	JButton backButton = new JButton("Back to Menu");
    JButton exitButton = new JButton("Exit");
    public gameOverWindow(int gameStatus) {
 
    	setTitle("Game Over!");
        setSize(360, 230);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout layout1 = new GridLayout(3,1);  
        FlowLayout buttonsLayout1 = new FlowLayout(); 
       
        setLayout(layout1);
        buttonsPanel.setLayout(buttonsLayout1);
  	  	InstrPanel.setLayout(buttonsLayout1);
        if(gameStatus == 3){
        	 InstrLabel = new JLabel("Draw!!");
        }else {
        	 InstrLabel = new JLabel("Player "+gameStatus+" wins this game!");
        }
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        InstrLabel.setFont(new Font("Arial",Font.PLAIN,18));
        
        InstrPanel.add(InstrLabel);
  	  	buttonsPanel.add(backButton);
  	  	buttonsPanel.add(exitButton);  
        
  	  	
  	  	add(InstrPanel);
  	  	add(buttonsPanel);
       
  	  	setVisible(true);
    }
    public void actionPerformed(ActionEvent event)  {
        String command = event.getActionCommand();//gets the name of the button
       
        
        if (command.equals("Exit")) {
        	System.exit(0);
        }
        if(command.equals("Back to Menu")){
        	//menuUI.main("");
        	System.exit(0);
        }
        
      }
    public static void main(String[] args) {
    	
        new gameOverWindow(0).setVisible(true);
    }
}