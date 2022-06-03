import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class DrawG implements ActionListener {
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private static dataProcess board;
	
	public static int rows = 6;
    public static int cols = 7;
	private static int[][] valueGrid;
	private static int mode;//0 represent PVP mode,1 represent PVE mode
	private static int AIlvl;
	//Initial setup
	 public DrawG() {
	        frame = new JFrame("Chess Board");
	       
	        /*button1 = new JButton();
	        button1.setBounds(500,100, 100, 50);
	        button1.addActionListener(e -> System.out.println("boo"));
	        button1.setText("PvP");
	        button1.setFocusable(false);
	        
	        button2 = new JButton();
	        button2.setBounds(500,50, 100, 50);
	        button2.addActionListener(e -> System.out.println("bee"));
	        button2.setText("PvE");
	        button2.setFocusable(false);
	       */
	        
	        frame.setSize(650, 450);
	        //frame.add(button1);
	        //frame.add(button2);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setPreferredSize(frame.getSize());
	        frame.add(new MultiDraw(frame.getSize()));
	        frame.pack();
	      
	        
	        
	        frame.setVisible(true);
	        
	    }
	 	 
		public static void main(String... argv) {
			
			valueGrid = new int[cols][rows];
			board = new dataProcess(valueGrid);
			
	        new DrawG();
	       
	    }
		public static void getGamemode(int gamemode) {
			mode = gamemode;
		}
	 public static class MultiDraw extends JPanel  implements MouseListener {
	        int startX = 10;
	        int startY = 10;
	        int cellWidth = 60;
	        int turn = dataProcess.startPlayer();
	       
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
	        	
	        	
	        	//当PVE 且电脑先手时，第一步须在鼠标触发前写入矩阵且画在UI上
	        	if(mode == 1&& turn == 1) {
	        		
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
	        public void paintOnUI(int xSpot,int ySpot,int playerID) {
	        	if(playerID == 1) {
        			grid[ySpot][xSpot]= new Color(255,0,0);
        		}else if(playerID == 2){
        			grid[ySpot][xSpot]=new Color(255,255,0);
        		}
        		System.out.println(xSpot + " " + ySpot);
	        }
	        public void mousePressed(MouseEvent e) {
	        	int[] conditionVars;
	        	int playerNo;
	        	int x = e.getX();
	        	//int y = e.getY();
	        	int xSpot = x/cellWidth;
	        	//int ySpot = y/cellWidth;
	        	if(mode == 0){
	        		if(xSpot>=0&&xSpot<7&&!dataProcess.isColFull(xSpot)) {
	        			playerNo = board.getPlayerID(turn);
	        			int ySpot = board.setChessOnBoard(playerNo, xSpot);
	        			//output where did user clicked on
	        			paintOnUI(xSpot,ySpot,playerNo);
	        			conditionVars = board.winCondition(playerNo, 4);//
	        			if(conditionVars[0] == 1) {
	        				System.out.println(conditionVars[1]);
	        				
	        				return;
	        			}
	        		turn++;
	        		}
	        	}else if(mode == 1) {//PVE模式时的鼠标触发事件
	        		/*
	        		 *
	        		 * 
	        		 */
	        		if(xSpot>=0&&xSpot<7&&!dataProcess.isColFull(xSpot)) {
	        			playerNo=1;
	        		
	        			int ySpot = board.setChessOnBoard(playerNo, xSpot);
	        			//output where did user clicked on
	        			paintOnUI(xSpot,ySpot,playerNo);
	        			conditionVars = board.winCondition(playerNo, 4);//
	        			turn++;
	        			if(conditionVars[0] == 1) {
	        				System.out.println(conditionVars[1]);
	        				//在这写个锁定窗口输入还有胜利弹窗
	        				return;
	        			}
	        			int[][] dataOnBoard = board.readValueFromBoard();
	        			/*int[] xy = AI落子的方法名[dataOnBoard,AIlvl]; 
	        			*int[] ySpot = board.setChessOnBoard(2,int[0])把上一行得出的值写入矩阵
	        			*conditionVars = board.winCondition(playerNo, 4);
	        			*if(conditionVars[0] == 1) {
	        			*	System.out.println(conditionVars[1]);
	        			*	同169
	        			*	return;
	        			*}
	        			*/
	        		}
	        		turn++;
	        	}
	        	//平局判定写这
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