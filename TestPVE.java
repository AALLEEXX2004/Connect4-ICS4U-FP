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
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                grid[i][j]=0;
            }
        }
        do{
            do{
            placeDisc=game.placeDisc(grid,col,1);
            // recieve new col if player enter full col( write another line to do so)
            if(placeDisc==true){
                break;
            }   
        }while(placeDisc==false);
        if(game.checkWin(grid,1)==true)
            break;
        // this depend the level player choose
        game.AILevelOne(grid);
        // game.AILevelTwo(grid);
        //game.AiLevelThree(grid);
        if(game.checkWin(grid,1)==true)
        System.out.println("You Win!");
        else if(game.checkWin(grid,4)==true)
        System.out.println("AI Win!");
        else if (game.checkTie(grid)==true)
        System.out.println("Tie!");
        
        }while(game.checkWin(grid,1)==false&&game.checkTie(grid)==false);
        
    }
}

