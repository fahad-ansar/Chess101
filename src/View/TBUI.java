package View;

import Model.Board;
import Model.Teams.Team;

import java.util.Scanner;

public class TBUI {

    Scanner sc = new Scanner(System.in);

    public void welcome(){
        System.out.println("-> TEXT BASED INTERFACE");
        System.out.println("-------------------CHESS-101-------------------");
    }

    public String getTeamName(int aOrb){
        String temp ="";
        if(aOrb==0){
            System.out.println();
            System.out.println("Give Name to Team A:");
            temp = sc.next();
        }else if(aOrb==1){
            System.out.println("Give Name to Team B:");
            temp=sc.next();
        }
        return temp;
    }

    public int getMovesLimit(){
        int temp = 0;

        System.out.println("------------------MOVES-LIMIT--------------------");
        System.out.println("Select one of the following move limit (in total): ");
        System.out.println("- 50 Moves");
        System.out.println("- 100 Moves");
        System.out.println("- 500 Moves");
        System.out.println("- Unlimited (Only for DareDevil69 kind of people)");
        System.out.println("Give moves in number (50 for 50 moves, 0 for unlimited, etc");

        temp = sc.nextInt();

        return temp;
    }

    public void Rules(){
        System.out.println("---------------RULES-AND-METHOD-----------------");
        System.out.println("- All the normal rules are similar to actual chess");
        System.out.println("- For every kill there are points awarded to the killer \n * Pawn: 1 Point \n * Pawn:  Point \n * Knight: 3 Point \n * Bishop: 4 Point \n * Rook: 5 Point \n * Queen: 9 Point \n * King: 1000 Point ");
        System.out.println("- Every turn movement would be asked and piece would be moved");
    }

    public void printState(Team tA, Team tB, String turn){
        System.out.println("-------------------STATE-----------------------");
        System.out.println(tA.getName()+": "+tA.getScore());
        System.out.println(tB.getName()+": "+tB.getScore());
        Board.getInstance().printBoard();
        System.out.println("Turn: "+turn);

    }

    public int[] moveInput(String toFrom){
        int temp[] = new int[2];

        System.out.println("---------------MOVE----------------");
        System.out.println("Enter 'i' index of "+ toFrom+":");
        temp[0]=sc.nextInt();
        System.out.println("Enter 'j' index of " + toFrom + ":");
        temp[1]=sc.nextInt();


        return temp;
    }

    public boolean[] winCheck(int i, int j, String myColour){
        boolean temp[] = new boolean[2];

        if(Board.getInstance().getBoard()[i][j].isFilled()){
            temp[0] = true;
            if(Board.getInstance().getBoard()[i][j].getColor().equals(myColour)){
                temp[1]=true;
            }
        }

        return temp;
    } //[1] for win [2] for same colour

}
