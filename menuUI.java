import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;

//import boardUI.MultiDraw;

import javax.swing.*;

import java.awt.*;

public class menuUI

{

	private static final long serialVersionUID = 1L;
	static final int WIDTH=700;
	static final int HEIGHT=500;
	static final int BOARDWIDTH = 500;
	
	JFrame frame;
	JPanel chessBoardPanel;
	JPanel infoPanel;
	
	public static int rows = 6;
    public static int cols = 7;
	private static int[][] valueGrid;
	private static int gameStatus = 0;//for check game is over or still continue,0 fro continue, 1 for player1 win, 2for player2 win, 3 for draw;
	private static int mode = 0 ;//0 represent PVP mode,1 represent PVE mode
	private static int AIlvl = 0;

	public menuUI(){

				
		//intialize window
		frame =new JFrame("Connect 4");
		JMenuBar menubar1=new JMenuBar();
		menubar1=menuUI.setMenuBar(menubar1);
		frame.setJMenuBar(menubar1);
		frame.setBackground(Color.lightGray);
		frame.setResizable(false);
		
		chessBoardPanel = new JPanel();
		infoPanel = new JPanel();
		
		
		
		
		chessBoardPanel.setLocation(0, 0);
		chessBoardPanel.setSize(BOARDWIDTH, HEIGHT);
		chessBoardPanel.setBackground(Color.lightGray);
		
		infoPanel.setLocation(500,0);
		infoPanel.setSize(WIDTH-BOARDWIDTH, HEIGHT);
		infoPanel.setBackground(Color.GRAY);
		//add components to frame 
		
		chessBoardPanel.add(new MultiDraw(chessBoardPanel.getSize()));

	
		frame.add(chessBoardPanel);
		frame.add(infoPanel);
		
		
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
	
	public static JMenuBar setMenuBar(JMenuBar toolBar) {
		
		actionListeners toolbarListener = new actionListeners();
		
		JMenu menu1;
		JMenu menu2;
		JMenuItem subMenu3;
		JMenu subMenu4;
		JMenuItem item0;
		JMenuItem item1;
		JMenuItem item2;
		JMenuItem item5;
		JMenuItem item6;
		JMenuItem item7;
		
		menu1=new JMenu("Setting");
		menu2=new JMenu("options");
		item0=new JMenuItem("Restart the Game");
		item1=new JMenuItem("History");
		item2=new JMenuItem("Exit");

		subMenu3=new JMenuItem("PVP");
		subMenu4=new JMenu("PVE");
		
		 item5=new JMenuItem("Easy");
		 item6=new JMenuItem("Normal");
		 item7=new JMenuItem("Hard");
		
		
		//draw tool bar subitems
		 menu1.add(item0);
		 menu1.addSeparator();
		 menu1.add(item1);
		 menu1.addSeparator();
		 menu1.add(item2);
		
		menu2.add(subMenu3);
		menu2.addSeparator();
		menu2.add(subMenu4);
		
		subMenu4.add(item5);
		subMenu4.add(item6);
		subMenu4.add(item7);

		toolBar.add(menu1);
		toolBar.add(menu2);
		//
		
		
		
		//actionListers for menus
		item0.addActionListener(toolbarListener);
		item1.addActionListener(toolbarListener);
		item2.addActionListener(toolbarListener);
		subMenu3.addActionListener(toolbarListener);
		item5.addActionListener(toolbarListener);
		item6.addActionListener(toolbarListener);
		item7.addActionListener(toolbarListener);
		return toolBar;
	}
	public static JPanel setInfoPanel(JPanel infoPanel) {
		infoPanel.setLayout(new FlowLayout());
		
		return infoPanel;
	}
	public static class MultiDraw extends JPanel {
	        int startX = 10;
	        int startY = 10;
	        int cellWidth = 65;
	        int turn = dataProcess.startPlayer();
	        final static int rows = 6;
	        final static int cols = 7;
	        int mode;
	        
	        //Set details
	        static Color[][] grid = new Color[rows][cols];
	        actionListeners mouseListener = new actionListeners();
	//Draw grid
	        public MultiDraw(Dimension dimension) {
	        	setSize(dimension);
	        	setPreferredSize(dimension);
	        	addMouseListener(mouseListener);
	        	int x = 0;
	        	for (int row = 0; row < grid.length; row++) {
	        		for (int col = 0; col < grid[0].length; col++) {
	        			grid[row][col] = new Color(255,255,255);
	        			
	        		}
	        	}
	        	
	        	
	        	//当PVE 且电脑先手时，第一步须在鼠标触发前写入矩阵且画在UI上
	        	/*if(mode == 1&& turn == 1) {
	        		
	        		// this following methods return the col for later use
	        		int col=pveObj.AILevelOne(valueGrid); 
	        		int yPosition = board.setPieceOnBoard(col,2);
	        		paintOnUI(col,yPosition,2);
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        	}
	        	*/
	        }

	        @Override
	        //paint background
	        public void paintComponent(Graphics g) {
	        	Graphics2D g2 = (Graphics2D)g;
	        	Dimension d = getSize();
	        	startX = 10;
	        	startY = 10;

	        	for (int row = 0; row < grid.length; row++) {
	        			for (int col = 0; col < grid[0].length; col++) {
	        				g2.setColor(grid[row][col]);
	        				g2.fillOval(startX,startY,cellWidth,cellWidth);
	        				startX = startX+cellWidth;
         	
	        			}
	        			startX=10;
	        			startY += cellWidth;

        
	        	}

	        	g2.setColor(new Color(255, 255, 255));
	        	
        

	        }
	        public static void paintOnUI(int xSpot,int ySpot,int playerID) {
	        	if(playerID == 1) {
     			grid[ySpot][xSpot]= new Color(255,0,0);
     		}else if(playerID == 2){
     			grid[ySpot][xSpot]=new Color(255,255,0);
     		}
     		//System.out.println(xSpot + " " + ySpot);
	        }
	        public void gameOver(int gameStatus) {
	        	new gameOverWindow(gameStatus);
	        }
	

	
	

}
	public static class actionListeners implements ActionListener,MouseListener{
		
		
		
		public void actionPerformed(ActionEvent event)  {
	        String command = event.getActionCommand();//gets the name of the button
	       
	        //System.out.println(command);
	        switch(command) {
	        case "Restart the Game":
	        	
	        	System.out.println(command);
	        	break;
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
	        case "Exit" :
	        	System.out.println(command);
	        	System.exit(0);
	        	break;
	        }
	        
	      }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
	    	int x = e.getX();
	    	int y = e.getY();
	    	int cellWidth = 65;
	    	int xSpot = x/cellWidth;
	    	int ySpot = y/cellWidth;
	    	int playerID =1;
	    	System.out.println(x+","+y);
	    	menuUI.MultiDraw.paintOnUI(xSpot,ySpot,playerID);    	
	    	//int[] info= {xSpot,ySpot,playerID};
	    	//repaint();
	    	
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

	}
	 public static void main(String[] args){
			new menuUI();
		}
}


 
