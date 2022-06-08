public class dataProcess {
	/*
	 * @author: Alex Liang
	 * some functions for game mechanics
	 * include:
	 * store the inputs(pieces) by a 2D array 
	 * setting piece on the right position
	 * determine the start player
	 * read the value from an exactly position/the whole board
	 * the game mechanics for victory/defeat judging
	 */
	
	static int[][] boardGrid;
	/*For the values in the boardGrid
	 * 		0: no chess here
	 * 		1: player1's chess is placing here
	 * 		2: player2's chess
	 */
	public dataProcess(int[][] grid){
		boardGrid = grid;
	}
	public dataProcess() {
		for(int x=0;x<7;x++) {
			for(int y=0;y<6;y++) {
				boardGrid[x][y]=0;
			}
		}
	}
	public int setPieceOnBoard(int playerID,int colNo) {
		int y;
		for (y=5;y>=0;y--) {
			if(boardGrid[colNo][y]==0) {
				boardGrid[colNo][y] = playerID;
				return y;
				
			}
		}
		return y;
	}
	public static int startPlayer() {
		int playerID;
		playerID =  (int) (10*(Math.random()));
		if(playerID>=5) {
			return 1;
		}else {
			return 0;
		}
	}
	public int getPlayerID(int inputTimes) {
		int playerID = inputTimes%2+1;
		return playerID;
	}
	public static int readValueFromBoard(int x, int y){
		return boardGrid[x][y];
	}
	
	
	public static int[][] readValueFromBoard(){
		return boardGrid;
	}
	public int[] winCondition(int playerNo, int requiredChessNum) {
		 /*
		  * 
		  * 
		  * - first parameter is the player id for check who wins the game
		  * 
		  * - Second parameter is the number of how many chess in a line is searching for
		  * 
		  * - for return variable
		  * 	the value should in this format  (0,0,0,-1,-1)
		  * 	- first value is find/not find the target chess row in board, 0 represent no, 1 represent yes
		  * 		-游戏继续/结束
		  * 	- second represent whose chess row was find, 0 represent no row be found, 1: player1, 2: player2
		  * 		-找到谁有指定数目连子
		  *		- 3rd,4th are coordination of the last chess in the founded target(from left to right, top to bottom)
		  *		  	-1 means no value
		  *			-3，4为连子最后一格的坐标，从左到右，从上到下 
		  *		-5th is the founded chess row layout
		  *			-1: no value	无
		  *			 0:horizontally	水平方向
		  *			 1:vertically	垂直方向
		  *			 2:diagonally(left top to right bottom)		左上右下斜
		  *			 3:diagonally(left bottom to right top)		右上左下斜
		  */	
		 String requiredChess = "";
			String numSerial;
			
			for(int i = 0; i<requiredChessNum;i++) {
				requiredChess = requiredChess + playerNo;
			}
			//check on rows
			for(int y=0;y<6;y++) {
				numSerial = "";
				for(int x=0;x<7;x++) {
					numSerial = numSerial+boardGrid[x][y];
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,0};
						return conditionCode;
					}
				}
				
			}
			
			
			//check on volumes
			for(int x=0;x<7;x++) {
				numSerial = "";
				for(int y=0;y<6;y++) {
					//System.out.println(x+"  "+y);
					numSerial = numSerial+boardGrid[x][y];
					//System.out.println(numSerial);
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,1};
						return conditionCode;
					}
				}
			}

			
			
	
			int[][] coodination = new int[][] {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5}};
			int x,y;
			for(int[] xy:coodination) {
				x=xy[0];
				y=xy[1];
				numSerial="";
				while(x<7&&y>=0) {
					numSerial = numSerial+boardGrid[x][y];
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,2};
						return conditionCode;
					}
					x++;
					y--;
				}
				
			}
			
			
			
			 coodination = new int[][] {{6,0},{5,0},{4,0},{3,0},{2,0},{1,0},{0,0},{0,1},{0,2},{0,3},{0,4},{0,5}};
			for(int[] xy:coodination) {
				x=xy[0];
				y=xy[1];
				numSerial="";
				while(x<7&&y<6) {
					numSerial = numSerial+boardGrid[x][y];
					x++;
					y++;
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,3};
						return conditionCode;
					}
				}
				
			}
			int [] conditionCode = {0,0,-1,-1,-1};
			return conditionCode;
		}
	public static boolean isColFull(int columnNo) {
		if(boardGrid[columnNo][0] !=0) {
			return true;
		}
		return false;
	}
}
