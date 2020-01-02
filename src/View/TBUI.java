package View;

import Model.Board;
import Model.Model;
import Model.Teams.Team;
import Model.Teams.TeamB;

import java.util.Scanner;

import static java.lang.Character.compare;

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
            while (temp==null | temp==""){
                System.out.println("please try again,Didnt got anythin!");
                temp = sc.next();
            }
        }else if(aOrb==1){
            System.out.println("Give Name to Team B:");
            temp=sc.next();
            while (temp==null | temp==""){
                System.out.println("please try again,Didnt got anythin!");
                temp = sc.next();
            }
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
        System.out.println("Give moves in number (50 for 50 moves, -1 for unlimited, etc \nEntering any other number would be your custom number of moves");


        while (!sc.hasNextInt()){
            System.out.println("Not a number, please try again");
            sc.next();
        }
        temp = sc.nextInt();

        return temp;
    }

    public void Rules(){
        System.out.println("---------------RULES-AND-METHOD-----------------");
        System.out.println("- All the normal rules are similar to actual chess");
        System.out.println("- For every kill there are points awarded to the killer \n * Pawn: 1 Point  \n * Knight: 3 Point \n * Bishop: 4 Point \n * Rook: 5 Point \n * Queen: 9 Point \n * King: 1000 Point ");
        System.out.println("- Board would be rotated at each turn, Player whose turn it is would be at bottom side of the board");
        System.out.println("- Every turn movement would be asked and piece would be moved");
    }

    public void printState(Team tA, Team tB, int turn){
        System.out.println("\n-------------------GAME STATE-----------------------");
        System.out.println(tA.getName()+"***");
        System.out.println("SCORE: "+tA.getScore());
        System.out.println("Killed players of opposite team: " + tA.getKilledOponents());
        System.out.println();

        System.out.println(tB.getName()+"***");
        System.out.println("SCORE: "+tB.getScore());
        System.out.println("Killed players of opposite team: " + tB.getKilledOponents());
        System.out.println();
        System.out.println("\n----------------------------------------------BOARD----------------------------------------------");

        Board.getInstance().printBoard(turn);
        String nm = (turn==0)?tA.getName():tB.getName();
        System.out.println("TURN: "+ nm);


    }

    public int[] moveInput(String toFrom,String head){
        int temp[] = new int[2];

        inpp(toFrom, head, temp);

        while (temp[0]<0 | temp[0]>8 | temp[1]<0 | temp[1]>8 ){
            System.out.println("Index out of [0-7] range!, Try again!");
            inpp(toFrom, head, temp);
        }


        return temp;
    }

    private void inpp(String toFrom, String head, int[] temp) {
        System.out.println("\n-----------------"+head+"------------------");
        System.out.println("Enter 'i' and 'j' index of "+ toFrom+" seperated by a space:");
        while (!sc.hasNextInt()){
            System.out.println("Not a number, please try again");
            sc.next();
        }
        temp[0] = sc.nextInt();

        while (!sc.hasNextInt()){
            System.out.println("Not a number, please try again");
            sc.next();
        }
        temp[1] = sc.nextInt();


    }

    public void boardflipping(){
        System.out.println("\n\n\n------------------------------BOARD ROTATED------------------------------\n\n\n");
    }

    public boolean[] winCheck(int i, int j, String myColour, int turn){
        boolean temp[] = new boolean[2];
        if(Board.getInstance().getBoard()[i][j].getPiece()!=null) {
            if (Board.getInstance().getBoard()[i][j].isFilled() & compare(Board.getInstance().getBoard()[i][j].getPiece().getInitial(), 'c') == 0) {
                temp[0] = true;
                if (compare(Board.getInstance().getBoard()[i][j].getPiece().getTeam().getinit(), (turn == 0) ? 'B' : 'W') != 0) {
                    temp[1] = true;
                }
            }
        }

        return temp;
    } //[1] for win [2] for other team

}
