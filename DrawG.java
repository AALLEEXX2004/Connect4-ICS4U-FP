import javax.swing.BorderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DrawG implements ActionListener {
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	//Initial setup
	 public DrawG() {
	        frame = new JFrame("Chess Board");
	       
	        button1 = new JButton();
	        button1.setBounds(500,100, 100, 50);
	        button1.addActionListener(e -> System.out.println("boo"));
	        button1.setText("PvP");
	        button1.setFocusable(false);
	        
	        button2 = new JButton();
	        button2.setBounds(500,50, 100, 50);
	        button2.addActionListener(e -> System.out.println("bee"));
	        button2.setText("PvE");
	        button2.setFocusable(false);
	       
	        
	        frame.setSize(650, 450);
	        frame.add(button1);
	        frame.add(button2);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setPreferredSize(frame.getSize());
	        frame.add(new MultiDraw(frame.getSize()));
	        frame.pack();
	      
	        
	        
	        frame.setVisible(true);
	        
	    }
	 	 
		public static void main(String... argv) {
	        new DrawG();
	       
	    }
	 public static class MultiDraw extends JPanel  implements MouseListener {
	        int startX = 10;
	        int startY = 10;
	        int cellWidth = 60;
	        int turn = 2;
	        int rows = 6;
	        int cols = 7;
	        //Set details
	        Color[][] grid = new Color[rows][cols];

	//Draw grid
	 public MultiDraw(Dimension dimension) {
         setSize(dimension);
         setPreferredSize(dimension);
         addMouseListener(this);
         int x = 0;
         for (int row = 0; row < grid.length; row++) {
             for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new Color(255,255,255);
             }
         }
     }

	@Override
	//paint background
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension d = getSize();
        g2.setColor(new Color(160,238,225));
        g2.fillRect(0,0,d.width,d.height);
        startX = 0;
        startY = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
            	g2.setColor(grid[row][col]);
            	g2.fillOval(startX,startY,cellWidth,cellWidth);
            	startX = startX+cellWidth;
            	
            }
            startX=0;
            startY += cellWidth;

           
        }

        g2.setColor(new Color(255, 255, 255));
       
            g2.drawString("pvp or pve",450,200);
           

    }

    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        int xSpot = x/cellWidth;
        int ySpot = y/cellWidth;
        if(turn%2==0) {
        	grid[ySpot][xSpot]= new Color(255,0,0);
        }else {
        	grid[ySpot][xSpot]=new Color(255,255,0);
        }
        System.out.println(xSpot + " " + ySpot);
        //output where did user clicked on
        turn++;
        repaint();
    }

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}