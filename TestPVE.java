import java.util.Scanner;

/**
 * Write a description of class TestPVE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestPVE 
{
    public static void main (String args[]){
        int grid[][]= new int [7][8];
        Scanner sc = new Scanner(System.in);
        PVE game = new PVE (grid);
        boolean placeStatus;
        int col=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                grid[i][j]=0;
            }
        }
        do{
            do{
            placeStatus=game.placeDisc(grid,col,1);
            // recieve new col if player enter full col( write another line to do so)
            if(placeStatus==true){
                break;
            }   
        }while(placeStatus==false);
        if(game.CheckWin(grid,1)==true)
            break;
        // this depend the level player choose
        game.AILevelOne(grid);
        // game.AILevelTwo(grid);
        //game.AiLevelThree(grid);
        if(game.CheckWin(grid,1)==true)
        System.out.println("You Win!");
        else if(game.CheckWin(grid,4)==true)
        System.out.println("AI Win!");
        else if (game.checkTie(grid)==true)
        System.out.println("Tie!");
        
        }while(game.CheckWin(grid,1)==false&&game.checkTie(grid)==false);
        
    }
}

