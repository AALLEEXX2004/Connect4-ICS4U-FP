
public class chessboard {
	/*
	 * For the values on the boardGrid
	 * 		0: no chess here
	 * 		1: player1's chess is placing here
	 * 		2: player2's chess
	 */
	static int[][] boardGrid = new int[7][6];
	public chessboard(){
		for(int x=0;x<7;x++) {
			for(int y=0;y<6;y++) {
				boardGrid[x][y] = 0;
			}
		}
	}
	public void setChessOnBoard(int playerID,int colNo) {
		for (int y=7;y>=0;y--) {
			if(boardGrid[colNo][y]==0) {
				boardGrid[colNo][y] = playerID;
				break;
			}
		}
	}
	public int readValueFromBoard(int x, int y){
		return boardGrid[x][y];
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
		  * 	the value should in this format  (0,0,-1,-1)
		  * 	- first value is find/not find the target chess row in board, 0 represent no, 1 represent yes
		  * 	- second represent whose chess row was find, 0 represent no row be found, 1: player1, 2: player2
		  *		- 3rd,4th are coordination of the last chess in the founded target(from left to right, top to bottom)
		  *		  -1 means no value 
		  *		-5th is the founded chess row layout
		  *			-1: no value
		  *			 0:horizontally
		  *			 1:vertically
		  *			 2:diagonally(left top to right bottom)
		  *			 3:diagonally(left bottom to right top)
		  */	
		 String requiredChess = "";
			String numSerial;
			
			for(int i = 0; i<requiredChessNum;i++) {
				requiredChess = requiredChess + playerNo;
			}
			//check on rows
			for(int x=0;x<6;x++) {
				numSerial = "";
				for(int y=0;y<6;y++) {
					numSerial = numSerial+boardGrid[x][y];
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,0};
						return conditionCode;
					}
				}
				
			}
			
			
			//check on volumes
			for(int x=0;x<6;x++) {
				numSerial = "";
				for(int y=0;y<6;y++) {
					numSerial = numSerial+boardGrid[y][x];
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,1};
						return conditionCode;
					}
				}
			}

			
			
	
			int[][] coodination = new int[][] {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7}};
			int x,y;
			for(int[] xy:coodination) {
				x=xy[0];
				y=xy[1];
				numSerial="";
				while(x<6&&y>=0) {
					numSerial = numSerial+boardGrid[x][y];
					if(numSerial.contains(requiredChess)){
						int[] conditionCode  = {1,playerNo,x,y,2};
						return conditionCode;
					}
					x++;
					y--;
				}
				
			}
			
			
			
			 coodination = new int[][] {{5,0},{4,0},{3,0},{2,0},{1,0},{0,0},{0,1},{0,2},{0,3},{0,4},{0,5}};
			for(int[] xy:coodination) {
				x=xy[0];
				y=xy[1];
				numSerial="";
				while(x<6&&y<6) {
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
	public boolean isColFull(int columnNo) {
		if(boardGrid[0][columnNo] !=0) {
			return true;
		}
		return false;
	}
}
