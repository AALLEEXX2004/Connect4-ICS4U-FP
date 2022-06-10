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
		boardGrid = new int[6][7];
		for(int x=0;x<6;x++) {
			for(int y=0;y<7;y++) {
				boardGrid[x][y]=0;
			}
		}
	}
	public int setPieceOnBoard(int playerID,int colNo) {
		int rowNo;
		for (rowNo=5;rowNo>=0;rowNo--) {
			if(boardGrid[rowNo][colNo]==0) {
				boardGrid[rowNo][colNo] = playerID;
				return rowNo;
				
			}
		}
		return rowNo;
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
	public static int readValueFromBoard(int cols, int rows){
		return boardGrid[rows][cols];
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
		  * 		-��Ϸ����/����
		  * 	- second represent whose chess row was find, 0 represent no row be found, 1: player1, 2: player2
		  * 		-�ҵ�˭��ָ����Ŀ����
		  *		- 3rd,4th are coordination of the last chess in the founded target(from left to right, top to bottom)
		  *		  	-1 means no value
		  *			-3��4Ϊ�������һ������꣬�����ң����ϵ��� 
		  *		-5th is the founded chess row layout
		  *			-1: no value	��
		  *			 0:horizontally	ˮƽ����
		  *			 1:vertically	��ֱ����
		  *			 2:diagonally(left top to right bottom)		��������б
		  *			 3:diagonally(left bottom to right top)		��������б
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
					numSerial = numSerial+boardGrid[y][x];
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
					numSerial = numSerial+boardGrid[y][x];
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
					numSerial = numSerial+boardGrid[y][x];
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
					numSerial = numSerial+boardGrid[y][x];
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
	
	
	
	public static int[] winCondition(int[][] grid,int playerNo,int requirePieceNum) {
		 String requiredChess = "";
			String numSerial;
			
			for(int i = 0; i<requirePieceNum;i++) {
				requiredChess = requiredChess + playerNo;
			}
			//check on rows
			for(int y=0;y<6;y++) {
				numSerial = "";
				for(int x=0;x<7;x++) {
					numSerial = numSerial+grid[y][x];
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
					numSerial = numSerial+grid[y][x];
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
					numSerial = numSerial+grid[y][x];
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
					numSerial = numSerial+grid[y][x];
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
		if(boardGrid[0][columnNo] !=0) {
			return true;
		}
		return false;
	}
}
