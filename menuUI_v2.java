import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import boardUI.MultiDraw;

import javax.swing.*;

import java.awt.*;

public class menuUI_v2 implements ActionListener,MouseListener

{

    
    
    static final int WIDTH=700;
    static final int HEIGHT=500;
    static final int BOARDWIDTH = 500;
    
    JFrame frame;
    static JPanel chessBoardPanel;
    static JPanel infoPanel;
    
    private static dataProcess board ;
     PVE pveObj = new PVE(valueGrid);
     static MultiDraw MD;
     
     
    public static final int rows = 6;
    public static final int cols = 7;
    private static int[][] valueGrid =new int[cols-1][rows+1];
    static Color[][] grid = new Color[rows][cols];
    private static int gameStatus = 0;//for check game is over or still continue,0 fro continue, 1 for player1 win, 2for player2 win, 3 for draw;
    private static int mode = 0 ;//0 represent PVP mode,1 represent PVE mode
    private static int AIlvl = 0;
    public static int turn =0;

    public menuUI_v2(){

                
        //intialize window
        frame =new JFrame("Connect 4 v2");
        JMenuBar menubar1=new JMenuBar();
        menubar1=setMenuBar(menubar1);
        frame.setJMenuBar(menubar1);
        frame.setResizable(false);
       // frame.setLayout(new FlowLayout());
        
        chessBoardPanel = new JPanel();
        infoPanel = new JPanel();
        
        
        
        
        //chessBoardPanel.setLocation(0, 0);
        //chessBoardPanel.setSize(BOARDWIDTH, HEIGHT);
        chessBoardPanel.setBounds(0, 0, 500, 500);
        chessBoardPanel.setBackground(Color.lightGray);
        //actionListeners mouseListener = new actionListeners();
        chessBoardPanel.addMouseListener(this);
        
        
       
        infoPanel.setBounds(500, 0, 200, 500);
        
        infoPanel.setBackground(Color.GRAY);
        infoPanel = setInfoPanel(infoPanel);
        
        
        //add components to frame 
        MD = new MultiDraw(chessBoardPanel.getSize());
        chessBoardPanel.add(MD);

    //chessBoardPanel.setVisible(false);
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
    
    public JMenuBar setMenuBar(JMenuBar toolBar) {
        
        //actionListeners toolbarListener = new actionListeners();
        
        JMenu menu1;
        JMenu menu2;
        JMenuItem subMenuPVP;
        JMenu subMenuPVE;
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

        subMenuPVP=new JMenuItem("PVP");
        subMenuPVE=new JMenu("PVE");
        
         item5=new JMenuItem("Easy");
         item6=new JMenuItem("Normal");
         item7=new JMenuItem("Hard");
        
        
        //draw tool bar subitems
         menu1.add(item0);
         menu1.addSeparator();
         menu1.add(item1);
         menu1.addSeparator();
         menu1.add(item2);
        
        menu2.add(subMenuPVP);
        menu2.addSeparator();
        menu2.add(subMenuPVE);
        
        subMenuPVE.add(item5);
        subMenuPVE.add(item6);
        subMenuPVE.add(item7);

        toolBar.add(menu1);
        toolBar.add(menu2);
        //
        
        
        
        //actionListers for menus
        item0.addActionListener(this);
        item1.addActionListener(this);
        item2.addActionListener(this);
        subMenuPVP.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        item7.addActionListener(this);
        return toolBar;
    }
    public static JPanel setInfoPanel(JPanel infoPanel) {
    	BorderLayout layout1 = new BorderLayout();  
        infoPanel.setLayout(layout1);
    	GridLayout layout2 = new GridLayout(3,1);
       
        JPanel lp = new JPanel();
        lp.setLayout(layout2);
        JLabel modeLabel ;
        JLabel AILabel;
        JLabel round;
        if(mode == 0) {
        	modeLabel = new JLabel("Game mode: PVP");
        	AILabel = new JLabel("AI level: Not Avilable");
        }else {
        	modeLabel = new JLabel("Game mode: PVE");
        	AILabel = new JLabel("AI level: "+ AIlvl);
        }
        round = new JLabel("Round:"+ turn/2);
        
        
        modeLabel.setFont(new Font("Arial",Font.PLAIN,20));
        AILabel.setFont(new Font("Arial",Font.PLAIN,20));
        round.setFont(new Font("Arial",Font.PLAIN,20));
        
        
        //infoPanel.add(modeLabel);
        //infoPanel.add(AILabel);
        //infoPanel.add(round);
        //infoPanel.setVisible(true);
        lp.add(modeLabel);
        lp.add(AILabel);
        lp.add(round);
        infoPanel.add(lp,BorderLayout.EAST);
        return infoPanel;
    }
    
    public void gameOver(int gameStatus) {
        JDialog dialog = new JDialog();
        dialog.setSize(360,230);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Game Over!");
        
        JPanel buttonsPanel = new JPanel();
    	JPanel InstrPanel = new JPanel();
    	
    	
    	GridLayout layout1 = new GridLayout(3,1);  
        FlowLayout buttonsLayout1 = new FlowLayout(); 
        
        JButton backButton = new JButton("Start New Game");
        JButton exitButton = new JButton("Exit");
        JLabel InstrLabel = new JLabel();
        
        dialog.setLayout(layout1);
        buttonsPanel.setLayout(buttonsLayout1);
  	  	InstrPanel.setLayout(buttonsLayout1);
  	  	InstrLabel.setFont(new Font("Arial",Font.PLAIN,18));
  	  	
  	  	backButton.addActionListener(new ActionListener(){
  	  		

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				dialog.dispose();
				
			}
  	  		
  	  	});
  	  	exitButton.addActionListener(new ActionListener(){
  	  		

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
  	  		
  	  	});
        if(gameStatus == 3){
        	 InstrLabel = new JLabel("Draw!!");
        }else {
        	 InstrLabel = new JLabel("Player "+gameStatus+" wins this game!");
        }
        InstrPanel.add(InstrLabel);
        buttonsPanel.add(backButton);
        buttonsPanel.add(exitButton);
        
        
        dialog.add(InstrPanel);
        dialog.add(buttonsPanel);
        
        dialog.setModal(true);
        dialog.setVisible(true);
        
    }
    public static void restart() {
    	gameStatus=0;
    	turn=0;
    	for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new Color(255,255,255);
                valueGrid[row][col] = 0;
                
            }
        }
    	//infoPanel = setInfoPanel(infoPanel);
    	//infoPanel.repaint();
    	chessBoardPanel.repaint();
    }
    public static class MultiDraw extends JPanel {
            /**
         * 
         */
        private static final long serialVersionUID = 1L;
            int startX = 10;
            int startY = 10;
            int cellWidth = 65;
            
           
           // turn = dataProcess.startPlayer();
            
            //Set details
            
            
            
            
    //Draw grid
            public MultiDraw(Dimension dimension) {
                setSize(dimension);
                setPreferredSize(dimension);
                
                
                for (int row = 0; row < grid.length; row++) {
                    for (int col = 0; col < grid[0].length; col++) {
                        grid[row][col] = new Color(255,255,255);
                        
                    }
                }
                
                
                //��PVE �ҵ�������ʱ����һ��������괥��ǰд������һ���UI��
                if(mode == 1&& turn == 1) {
                    
                    // this following methods return the col for later use
                    PVE pveObj = new PVE(valueGrid);
                    int col=pveObj.AILevelOne(valueGrid); 
                    int yPosition = board.setPieceOnBoard(col,2);
                    paintOnUI(col,yPosition,2);
                    
                    
                    
                    
                    
                    
                    
                }
                
                
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
                chessBoardPanel.repaint();
             //System.out.println(xSpot + " " + ySpot);
            }
           
        
    
            
          
    

}
    
        
        
        
        public void actionPerformed(ActionEvent event)  {
            String command = event.getActionCommand();//gets the name of the button
           
            //System.out.println(command);
            switch(command) {
            case "Restart the Game":
                restart();
                
                System.out.println(command);
                
                break;
            case "PVP":
                System.out.println(command);
                board =new dataProcess();
                mode=0;
                AIlvl = 0;
                restart();
                break;
            case "Easy":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 1;
                restart();
                break;
            case "Normal":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 2;
                restart();
                break;
            case "Hard":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 3;
                restart();
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

        public static void main(String[] args){
            
            board = new dataProcess(valueGrid);
            new menuUI_v2();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            int[] conditionVars;
            int playerNo;
            int x = e.getX();
          
            int xSpot = x/65;
           
            if(menuUI_v2.gameStatus !=0) {
                gameOver(gameStatus);
                
                return;
            }
            if(mode == 0){
                if(xSpot>=0&&xSpot<7&&!dataProcess.isColFull(xSpot)) {
                    playerNo = board.getPlayerID(turn);
                    int ySpot = board.setPieceOnBoard(playerNo, xSpot);
                    //output where did user clicked on
                    MultiDraw.paintOnUI(xSpot,ySpot,playerNo);
                    conditionVars = board.winCondition(playerNo, 4);//
                    if(conditionVars[0] == 1) {
                        //System.out.println(conditionVars[1]);
                        gameStatus = conditionVars[1];
                        gameOver(conditionVars[1]);
                        
                        return;
                    }
                turn++;
                }
            }else if(mode == 1) {//PVEģʽʱ����괥���¼�
                /*
                 *
                 * 
                 */
                if(xSpot>=0&&xSpot<7&&!dataProcess.isColFull(xSpot)) {
                    playerNo=1;
                
                    int ySpot = board.setPieceOnBoard(playerNo, xSpot);
                    //output where did user clicked on
                    MultiDraw.paintOnUI(xSpot,ySpot,playerNo);
                    conditionVars = board.winCondition(playerNo, 4);//
                    turn++;
                    if(conditionVars[0] == 1) {
                        //System.out.println(conditionVars[1]);
                        gameOver(conditionVars[1]);
                        
                        //����д�������������뻹��ʤ������
                        return;
                    }
                    playerNo=2;
                    int[][] dataOnBoard = board.readValueFromBoard();
                    int col; 
                    PVE pveObj = new PVE(valueGrid);
                    if(AIlvl==1){
                        col=pveObj.AILevelOne(dataOnBoard);
                    }else if(AIlvl ==2) {
                            
                            col=pveObj.AILevelTwo(dataOnBoard);
                    }else{
                            col=pveObj.AILEvelThree(dataOnBoard);
                    }
                        ySpot = board.setPieceOnBoard(playerNo,col);
                        
                        MultiDraw.paintOnUI(col,ySpot,playerNo);
                        conditionVars = board.winCondition(playerNo, 4);
                    if(conditionVars[0] == 1) {
                        System.out.println(conditionVars[1]);
                        gameOver(conditionVars[1]);
                        return;
                    }
                }
                turn++;
            }
            //draw
            if(turn == 42){
                gameStatus = 3;
                gameOver(gameStatus);
                return;
            }
            chessBoardPanel.repaint();
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