import java.util.Random;

/**
 * Write a description of class ConnectFour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ConnectFour
{
    static int[][]grid;
    boolean player1, player2, AI;
    int player1Disc=1;
    int player2Disc=2;
    int AIDisc=4;
    int count;
    public ConnectFour(int[][] grid){
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
            if (grid[i][col]==0){
            grid[i][col]=playerDisc;
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

    public boolean CheckTwo (int grid[][]){
    for(int i=0; i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                
            //02020
            if(i<2){
                   if ((grid[i][j]==grid[i+2][j])&&(grid[i+2][j]==grid[i+4][j])&&(grid[i+4][j]==0)&&(grid[i+1][j]==grid[i+2][j])&&grid[i+3][j]==2){
                     placeDisc(grid,i,4);
                     return true;
                   }
            }
            //0220
            if(i<3){
                if((grid[i][j]==grid[i+3][j])&&(grid[i+3][j]==0)&&(grid[i+1][j]==grid[i+2][j])&&(grid[i+2][j]==2)){
                    placeDisc(grid,i,4);
                    return true;
                }
            }
            
          }
        }
        return false;
    }
    public boolean CheckThree(int grid[][], int DiscValue){
       for(int i=0; i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
   
             
                if((j+3)<=grid[0].length-1){
                   if((grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i][j+1]==0||grid[i][j+2]==0||grid[i][j+3]==0)){
                      if((grid[i][j]==0)){
                           if(i==grid.length){
                               grid[i][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i,j)){
                                grid[i][j]=4;
                               return true;
                            }
                    }
                    else if((grid[i+1][j]==0)){
                          if(i==grid.length){
                               grid[i+1][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i+1,j)){
                                grid[i+1][j]=4;
                               return true;
                            }
                    }
                       else if((grid[i+2][j]==0)){
                           if(i==grid.length){
                               grid[i+2][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i+2,j)){
                                grid[i+2][j]=4;
                               return true;
                            }
                       
                    }
                       else if((grid[i-3][j]==0)){
                       if(i==grid.length){
                               grid[i+3][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i+3,j)){
                                grid[i+3][j]=4;
                               return true;
                            }
                    } 
                }
            }   
    
            if((i+3)<=grid.length){
                   if((grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i+3][j]==DiscValue*3)&&(grid[i][j]==0)){
                       grid[i][j]=DiscValue;
                        return true;
                        
                       }
               }
            
              
            if(((i+3)<=grid.length-1)&&((j+3)<=grid[0].length-1)){
                   if((grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]+grid[i+3][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i+1][j+1]==0||grid[i+2][j+2]==0||grid[i+3][j+3]==0)){
                      if((grid[i][j]==0)){
                           if(i==grid.length){
                               grid[i][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i,j)){
                                grid[i][j]=4;
                               return true;
                            }                      
                       }
                       else if((grid[i+1][i+1]==0)&&CheckPlacement(grid, i+1,j+1)){
                           grid[i+1][j+1]=4;
                           return true;
                           }
                        else if((grid[i+2][i+2]==0)&&CheckPlacement(grid, i+2,j+2)){
                           grid[i+2][j+2]=4;
                           return true;
                           }
                       else if((grid[i+3][i+3]==0)&&CheckPlacement(grid, i+3,j+3)){
                           grid[i+3][j+3]=4;
                           return true;
                           }
                }   
            if(((i+3)<=grid.length-1)&&((j-3)>=0)){
                   if((grid[i][j]+grid[i-1][j+1]+grid[i-2][j+2]+grid[i-3][j+3]==DiscValue*3)&&(grid[i][j]==0||grid[i-1][j-1]==0||grid[i-2][j-2]==0||grid[i-3][j-3]==0)){
                       if((grid[i][j]==0)){
                           if(i==grid.length){
                               grid[i][j]=4;
                               return true;
                            }
                            else if(CheckPlacement(grid,i,j)){
                                grid[i][j]=4;
                               return true;
                            }                      
                       }
                       else if((grid[i-1][i+1]==0)&&CheckPlacement(grid, i-1,j+1)){
                           grid[i-1][j+1]=4;
                           return true;
                           }
                        else if((grid[i-2][i+2]==0)&&CheckPlacement(grid, i-2,j+2)){
                           grid[i-2][j+2]=4;
                           return true;
                           }
                       else if((grid[i-3][i+3]==0)&&CheckPlacement(grid, i-3,j+3)){
                           grid[i-3][j+3]=4;
                           return true;
                           } 
                   }
            }
        }
    

    }
}
return false;
 }   
    
    public void AILevelOne(int grid[][]){
    boolean position;
      do{     
      Random rdm = new Random ();
      int choice = rdm.nextInt(8);
       position= placeDisc(grid, choice, AIDisc);
       if(position == true){
           break;
       }
      
    }while(position==false);
          
    }
    
public void AILevelTwo(int grid[][]){
    if(CheckThree(grid,4)){
        CheckThree(grid,4);
    }
    else if(CheckTwo(grid)){
        CheckTwo(grid);
    }
    else{
        AILevelOne(grid);
    }
    }
public void AiLEvelThree(int grid[][]){
    if(CheckThree(grid,1)){
       CheckThree(grid,1); 
    }
    else if(CheckThree(grid,4)){
        CheckThree(grid,4);
    }
    else if(CheckTwo(grid)){
        CheckTwo(grid);
    }
    else{
        AILevelOne(grid);
    }
}
    
}
