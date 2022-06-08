import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//import boardUI.MultiDraw;

import javax.swing.*;

import java.awt.*;

public class menuUI implements ActionListener,MouseListener

{

    
    
    static final int WIDTH=700;
    static final int HEIGHT=500;
    static final int BOARDWIDTH = 500;
    
    JFrame frame;
    static JPanel chessBoardPanel;
    JPanel infoPanel;
    
    private static dataProcess board ;
     PVE pveObj = new PVE(valueGrid);
    
    public static int rows = 6;
    public static int cols = 7;
    private static int[][] valueGrid;
    private static int gameStatus = 0;//for check game is over or still continue,0 fro continue, 1 for player1 win, 2for player2 win, 3 for draw;
    private static int mode = 0 ;//0 represent PVP mode,1 represent PVE mode
    private static int AIlvl = 0;
    public static int turn =0;

    public menuUI(){

                
        //intialize window
        frame =new JFrame("Connect 4");
        JMenuBar menubar1=new JMenuBar();
        menubar1=setMenuBar(menubar1);
        frame.setJMenuBar(menubar1);
        frame.setBackground(Color.lightGray);
        frame.setResizable(false);
        
        chessBoardPanel = new JPanel();
        infoPanel = new JPanel();
        
        
        
        
        chessBoardPanel.setLocation(0, 0);
        chessBoardPanel.setSize(BOARDWIDTH, HEIGHT);
        chessBoardPanel.setBackground(Color.lightGray);
        //actionListeners mouseListener = new actionListeners();
        chessBoardPanel.addMouseListener(this);
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
        infoPanel.setLayout(new FlowLayout());
        
        return infoPanel;
    }
    
    public void gameOver(int gameStatus) {
        new gameOverWindow(gameStatus);
    }
    public static void restart() {

        chessBoardPanel.add(new MultiDraw(chessBoardPanel.getSize()));
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
            static Color[][] grid = new Color[rows][cols];
            
            
            
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
             //System.out.println(xSpot + " " + ySpot);
            }
           
            public void gameOver(int gameStatus) {
                new gameOverWindow(gameStatus);
            }
    
            
          
    

}
    //public static class actionListeners implements ActionListener,MouseListener{
        
        
        
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
                break;
            case "Easy":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 1;
                break;
            case "Normal":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 2;
                break;
            case "Hard":
                System.out.println(command);
                board =new dataProcess();
                mode = 1;
                AIlvl = 3;
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
            valueGrid = new int[cols][rows];
            board = new dataProcess(valueGrid);
            new menuUI();
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
            //int y = e.getY();
            int xSpot = x/65;
            //int ySpot = y/cellWidth;
            if(menuUI.gameStatus !=0) {
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
                        System.out.println(conditionVars[1]);
                        gameStatus = conditionVars[1];
                        gameOver(conditionVars[1]);
                        chessBoardPanel.repaint();
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
                    chessBoardPanel.repaint();
                    if(conditionVars[0] == 1) {
                        System.out.println(conditionVars[1]);
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
