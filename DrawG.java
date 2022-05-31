import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DrawG {
	private JFrame frame;
	
	 public DrawG() {
	        frame = new JFrame("Chess Board");
	        frame.setSize(650, 450);
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
	        int cellWidth = 50;
	        int turn = 2;
	        int rows = 6;
	        int cols = 7;

	        Color[][] grid = new Color[rows][cols];

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
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension d = getSize();
        g2.setColor(new Color(0, 0, 0));
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
       
            g2.drawString("pvp or pve",500,30);
       

    }

    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
       // System.out.println(x + " " + y);
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
}