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

public class menuUI

{

	private static final long serialVersionUID = 1L;
	static final int WIDTH=600;
	static final int HEIGHT=400;
	
	JPopupMenu pop;
	JMenuItem item2;
	JFrame f;
	JMenuItem item1;
	JPopupMenu popupMenu;
	JPanel p;
	JToolBar bar;

	public menuUI(){

		f=new JFrame("Connect 4");
		JMenuBar menubar1=new JMenuBar();
		p=new JPanel();
		
		f.add(new boardUI.MultiDraw(f.getSize()));
		f.pack();
		f.setContentPane(p);
		f.setJMenuBar(menubar1);

		
		
		
		JMenu menu1=new JMenu("Setting");
		JMenu menu2=new JMenu("options");
		
		
		
		
		
		menubar1.add(menu1);
		menubar1.add(menu2);

	
		item1=new JMenuItem("history");
		item2=new JMenuItem("menu2");

		JMenuItem item3=new JMenuItem("PVPmode");
		JMenu item4=new JMenu("PVEmode");
		
		JMenuItem item5=new JMenuItem("Easy");
		JMenuItem item6=new JMenuItem("Normal");
		JMenuItem item7=new JMenuItem("Hard");
		
		
		
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		
		menu2.add(item3);
		menu2.addSeparator();
		menu2.add(item4);
		
		item4.add(item5);
		
		item4.add(item6);
		item4.add(item7);

		
		bar = new JToolBar();
		BorderLayout bord = new BorderLayout();

		p.setLayout(bord);
		p.add("North",bar);
		
		f.setVisible(true);
		f.setSize(WIDTH,HEIGHT);

		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		f.setLocation(x,y);

	}

	public static void main(String[] args){
		new menuUI();
	}

}
