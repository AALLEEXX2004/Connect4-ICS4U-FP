import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import boardUI.MultiDraw;

import javax.swing.*;

import java.awt.*;

public class menuUI implements ActionListener

{

	private static final long serialVersionUID = 1L;
	static final int WIDTH=600;
	static final int HEIGHT=400;
	

	JMenuItem item2;
	JFrame frame;
	JMenuItem item1;
	JPanel panel;
	JToolBar bar;

	public menuUI(){

		//intialize window
		frame=new JFrame("Connect 4");
		JMenuBar menubar1=new JMenuBar();
		panel=new JPanel();

		frame.add(new MultiDraw.MultiDraw(frame.getSize()));
		frame.setContentPane(panel);
		frame.setJMenuBar(menubar1);

		
		
		
		JMenu menu1=new JMenu("Setting");
		JMenu menu2=new JMenu("options");
		
		
		
		

	
		item1=new JMenuItem("History");
		item2=new JMenuItem("Exit");

		JMenuItem subMenu3=new JMenuItem("PVP");
		JMenu subMenu4=new JMenu("PVE");
		
		JMenuItem item5=new JMenuItem("Easy");
		JMenuItem item6=new JMenuItem("Normal");
		JMenuItem item7=new JMenuItem("Hard");
		
		
		
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		
		menu2.add(subMenu3);
		menu2.addSeparator();
		menu2.add(subMenu4);
		
		subMenu4.add(item5);
		subMenu4.add(item6);
		subMenu4.add(item7);

		menubar1.add(menu1);
		menubar1.add(menu2);
		
		
		//actionListers for menus
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		subMenu3.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		
		bar = new JToolBar();
		BorderLayout bord = new BorderLayout();

		panel.setLayout(bord);
		panel.add("North",bar);
		
		frame.setVisible(true);
		frame.setSize(WIDTH,HEIGHT);

		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		frame.setLocation(x,y);

	}
	public void actionPerformed(ActionEvent event)  {
        String command = event.getActionCommand();//gets the name of the button
       
        //System.out.println(command);
        switch(command) {
        case "PVP":
        	System.out.println(command);
        	break;
        case "Easy":
        	System.out.println(command);
        	break;
        case "Normal":
        	System.out.println(command);
        	break;
        case "Hard":
        	System.out.println(command);
        	break;
        case "History" :
        	System.out.println(command);
        	break;
        case "exit" :
        	System.out.println(command);
        	break;
        }
        
      }
	public static void main(String[] args){
		new menuUI();
	}

}
