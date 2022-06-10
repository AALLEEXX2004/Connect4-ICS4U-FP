import java.util.Random;

/**
 * Write a description of class ConnectFour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PVE
{
    static int[][]grid;
    boolean player1, player2, AI;
    int player1Disc=1;
    int player2Disc=2;
    int AIDisc=4;
    int count;
    public PVE(int[][] grid){
        grid=this.grid;
    }
    
    
    public int getDisc(int playerDisc){
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]==playerDisc)
                count++;
            }
        }
        return count;
    }
    
    public void displayGrid(int [][] grid){
        System.out.println();
        System.out.println();
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==0){
                    System.out.println("|    |");
                }
                else if (grid[i][j]==1){
                    System.out.println("|  1  |");
                }
                else if (grid[i][j]==2){
                    System.out.println("|  2  |");
                }
            }
        }
    }
    public boolean placeDisc(int [][] grid, int col, int playerDisc){
        for(int i=(grid.length-1); i>=0; i--){
        	System.out.println(grid.length-1);
        	System.out.println(grid[0].length-1);
            if (grid[i][col]==0){

            return true;
            }
         }
         return false;
    }
    
   
    public boolean CheckWin(int [][] grid, int PlayerDisc){
        for(int i=0; i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
               
               if((i+3)<=grid.length-1){
                   if((grid[i][j]==grid[i+1][j])&&(grid[i+1][j]==grid[i+2][j])&&(grid[i+2][j]==grid[i+3][j])&&(grid[i+3][j]==PlayerDisc));
                   return true;
               }
               
               if((j+3)<=grid[0].length-1){
                   if((grid[i][j]==grid[i][j+1])&&(grid[i][j+1]==grid[i][j+2])&&(grid[i][j+2]==grid[i][j+2])&&(grid[i][j+3]==PlayerDisc));
                   return true;
               }
               if(((i+3)<=grid.length-1)&&((j+3)<=grid[0].length-1)){
                   if((grid[i][j]==grid[i+1][j+1])&&(grid[i+1][j+1]==grid[i+2][j+2])&&(grid[i+2][j+2]==grid[i+3][j+3])&&(grid[i+3][j+3]==PlayerDisc));
                   return true;
                }
              
               if(((i+3)<=grid.length-1)&&((j-3)>=0)){
                   if((grid[i][j]==grid[i-1][j+1])&&(grid[i-1][j+1]==grid[i-2][j+2])&&(grid[i-2][j+2]==grid[i-3][j+3])&&(grid[i-3][j+3]==PlayerDisc));
                   return true;
                }
              
            }
        }
        return false;
    }
    public boolean checkTie(int grid[][]){
        int value =0;
         for(int i=0; i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j]!=0){
                  value++;  
                }
            }
        }
        if(value==42){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean CheckPlacement(int grid[][], int row, int col){
        if((grid[row][col-1]==1)||grid[row][col-1]==2){
            return true;
        }
        else{ 
            return false;
     }
    }

    public int CheckTwo (int grid[][]){
    	int col;
    	int[] pieceInfo = dataProcess.winCondition(grid, 1, 2);
    	int[] exceptPoint1 = new int[2];
    	int[] exceptPoint2 = new int[2];
    	if(pieceInfo[0] == 1) {
    		switch(pieceInfo[4]) {
    		case(0):
    			exceptPoint1[0]= pieceInfo[2]-2;
    			exceptPoint1[1]= pieceInfo[3];
    			exceptPoint2[0]= pieceInfo[2]+1;
    			exceptPoint2[1]= pieceInfo[3];
    			if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
    				System.out.println(exceptPoint1[0]+" "+exceptPoint1[1]);
    				if(exceptPoint1[1]==5&&grid[exceptPoint1[0]][exceptPoint1[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
    				if((grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0)) {
    					col=exceptPoint1[0];
    					break;
    				}
    			}
    			if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
    				if(exceptPoint2[1]==5&&grid[exceptPoint2[0]][exceptPoint2[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
    				if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
    					col = exceptPoint2[1];
    					break;
    				}
    			}
    				col=-1;
    			
    			break;
    		case(1):
    			
    			if(pieceInfo[2]!=0) {
        			col=pieceInfo[1];
        			}else {
        				col=-1;
        			}
    			break;
    		case(2):
    			exceptPoint1[0]= pieceInfo[2]-2;
				exceptPoint1[1]= pieceInfo[3]-2;
				exceptPoint2[0]= pieceInfo[2]+1;
				exceptPoint2[1]= pieceInfo[3]+1;
				if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
					
					
					if(grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0) {
    					col=exceptPoint1[0];
    					break;
    				}
				}
				if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
					if(exceptPoint2[1]==5&&grid[exceptPoint2[0]][exceptPoint2[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
					if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
						col = exceptPoint2[1];
						break;
					}
				}
    			col=-1;
    			
    			break;
    		case(3):
    			exceptPoint1[0]= pieceInfo[2]+2;
				exceptPoint1[1]= pieceInfo[3]-22;
				exceptPoint2[0]= pieceInfo[2]-1;
				exceptPoint2[1]= pieceInfo[3]+1;
				if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
					if(exceptPoint1[1]==5&&grid[exceptPoint1[0]][exceptPoint1[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
					if(grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0) {
    					col=exceptPoint1[0];
    					break;
    				}
				}
				if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
					if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
						col = exceptPoint2[1];
						break;
					}
				}
    				col=-1;
    			
    			break;
    		default:
    			col=-1;
    		}
    	}else {
    		col=-1;
    	}
    	return col;
    }
    public int CheckThree(int grid[][], int DiscValue){
    	int col;
    	int[] pieceInfo = dataProcess.winCondition(grid, 1, 3);
    	int[] exceptPoint1 = new int[2];
    	int[] exceptPoint2 = new int[2];
    	if(pieceInfo[0] == 1) {
    		switch(pieceInfo[4]) {
    		case(0):
    			exceptPoint1[0]= pieceInfo[2]-3;
    			exceptPoint1[1]= pieceInfo[3];
    			exceptPoint2[0]= pieceInfo[2]+1;
    			exceptPoint2[1]= pieceInfo[3];
    			if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
    				System.out.println(exceptPoint1[0]+" "+exceptPoint1[1]);
    				if(exceptPoint1[1]==5&&grid[exceptPoint1[0]][exceptPoint1[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
    				if((grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0)) {
    					col=exceptPoint1[0];
    					break;
    				}
    			}
    			if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
    				if(exceptPoint2[1]==5&&grid[exceptPoint2[0]][exceptPoint2[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
    				if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
    					col = exceptPoint2[1];
    					break;
    				}
    			}
    				col=-1;
    			
    			break;
    		case(1):
    			if(grid[pieceInfo[1]][0]==0) {
        			col=pieceInfo[1];
        			}else {
        				col=-1;
        			}
    			break;
    		case(2):
    			exceptPoint1[0]= pieceInfo[2]-3;
				exceptPoint1[1]= pieceInfo[3]-3;
				exceptPoint2[0]= pieceInfo[2]+1;
				exceptPoint2[1]= pieceInfo[3]+1;
				if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
					
					
					if(grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0) {
    					col=exceptPoint1[0];
    					break;
    				}
				}
				if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
					if(exceptPoint2[1]==5&&grid[exceptPoint2[0]][exceptPoint2[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
					if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
						col = exceptPoint2[1];
						break;
					}
				}
    			col=-1;
    			
    			break;
    		case(3):
    			exceptPoint1[0]= pieceInfo[2]+3;
				exceptPoint1[1]= pieceInfo[3]-3;
				exceptPoint2[0]= pieceInfo[2]-1;
				exceptPoint2[1]= pieceInfo[3]+1;
				if(exceptPoint1[0]<6&&exceptPoint1[0]>=0&&exceptPoint1[1]>=0&&exceptPoint1[1]<7){
					if(exceptPoint1[1]==5&&grid[exceptPoint1[0]][exceptPoint1[1]]==0) {
						col=exceptPoint1[0];
						break;
					}
					if(grid[exceptPoint1[0]][exceptPoint1[1]]==0 && grid[exceptPoint1[0]][exceptPoint1[1]+1]!=0) {
    					col=exceptPoint1[0];
    					break;
    				}
				}
				if(exceptPoint2[0]<6&&exceptPoint2[0]>=0&&exceptPoint2[1]>=0&&exceptPoint2[1]<7){
					if(grid[exceptPoint2[0]][exceptPoint2[1]]==0 && grid[exceptPoint2[0]][exceptPoint2[1]+1]!=0){
						col = exceptPoint2[1];
						break;
					}
				}
    				col=-1;
    			
    			break;
    		default:
    			col=-1;
    		}
    		return col;
    	}
    	
       for(int i=0; i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
   
             
                if((j+3)<=grid[0].length-1){
                   if((grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i][j+1]==0||grid[i][j+2]==0||grid[i][j+3]==0)){
                      if((grid[i][j]==0)){
                           if(i==grid.length){
                               //grid[i][j]=4;
                               return j;
                            }
                            else if(CheckPlacement(grid,i,j)){
                               // grid[i][j]=4;
                               return j;
                            }
                    }
                    else if((grid[i][j+1]==0)){
                          if(i==grid.length){
                               //grid[i+1][j]=4;
                               return j+1;
                            }
                            else if(CheckPlacement(grid,i,j+1)){
                                //grid[i+1][j]=4;
                               return j+1;
                            }
                    }
                       else if((grid[i][j+2]==0)){
                           if(i==grid.length){
                               //grid[i+2][j]=4;
                               return j+2;
                            }
                            else if(CheckPlacement(grid,i,j+2)){
                                //grid[i+2][j]=4;
                               return j+2;
                            }
                       
                    }
                       else if((grid[i][j+3]==0)){
                       if(i==grid.length){
                               //grid[i+3][j]=4;
                               return j+3;
                            }
                            else if(CheckPlacement(grid,i,j+3)){
                               // grid[i+3][j]=4;
                               return j+3;
                            }
                    } 
                }
            }   
    
            if((i+3)<=grid.length-1){
                   if((grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i+3][j]==DiscValue*3)&&(grid[i][j]==0)){
                       //grid[i][j]=DiscValue;
                        return j;
                        
                       }
               }
            
              
            if(((i+3)<=grid.length-1)&&((j+3)<=grid[0].length-1)){
                   if((grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]+grid[i+3][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i+1][j+1]==0||grid[i+2][j+2]==0||grid[i+3][j+3]==0)){
                      if((grid[i][j]==0)){
                           if(i==grid.length){
                               //grid[i][j]=4;
                               return j;
                            }
                            else if(CheckPlacement(grid,i,j)){
                                //grid[i][j]=4;
                               return j;
                            }                      
                       }
                       else if((grid[i+1][i+1]==0)&&CheckPlacement(grid, i+1,j+1)){
                           //grid[i+1][j+1]=4;
                           return j+1;
                           }
                        else if((grid[i+2][i+2]==0)&&CheckPlacement(grid, i+2,j+2)){
                           //grid[i+2][j+2]=4;
                           return j+2;
                           }
                       else if((grid[i+3][i+3]==0)&&CheckPlacement(grid, i+3,j+3)){
                           //grid[i+3][j+3]=4;
                           return j+3;
                           }
                }   
            if(((i+3)<=grid.length-1)&&((j-3)>=0)){
                   if((grid[i][j]+grid[i-1][j+1]+grid[i-2][j+2]+grid[i-3][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i-1][j-1]==0||grid[i-2][j-2]==0||grid[i-3][j-3]==0)){
                       if((grid[i][j]==0)){
                           if(i==grid.length){
                              // grid[i][j]=4;
                               return j;
                            }
                            else if(CheckPlacement(grid,i,j)){
                               // grid[i][j]=4;
                               return j;
                            }                      
                       }
                       else if((grid[i-1][i+1]==0)&&CheckPlacement(grid, i-1,j+1)){
                           //grid[i-1][j+1]=4;
                           return j+1;
                           }
                        else if((grid[i-2][i+2]==0)&&CheckPlacement(grid, i-2,j+2)){
                           //grid[i-2][j+2]=4;
                           return j+2;
                           }
                       else if((grid[i-3][i+3]==0)&&CheckPlacement(grid, i-3,j+3)){
                           //grid[i-3][j+3]=4;
                           return j+3;
                           } 
                   }
            }
        }
    

    }
}
    return -1;
}   
    
    public int AILevelOne(int grid[][]){
    boolean position=false;
    int choice;
      do{     
      Random rdm = new Random ();
      choice = rdm.nextInt(7);
       position= placeDisc(grid, choice, AIDisc);
       if(position == true){
           return choice;
           
       }
      
    }while(position==false);
     return 0;
    }
    
public int AILevelTwo(int grid[][]){
    
    if(CheckThree(grid,4)!=-1){
        return CheckThree(grid,4);
    }
    if(CheckTwo(grid)!=-1){
       return CheckTwo(grid);
    }
    else{
        return AILevelOne(grid);
    }
    }

public int AILEvelThree(int grid[][]){
    int col;
    if(CheckThree(grid,1)!=-1){
        
        col= CheckThree(grid,1); 
        return col;
    }
     if(CheckThree(grid,4)!=-1){
       col= CheckThree(grid,4);
       return col;
    }
     if(CheckTwo(grid)!=-1){
       col= CheckTwo(grid);
       return col;
    }
    else{
      col=  AILevelOne(grid);
      return col;
    }
    
}
    
}