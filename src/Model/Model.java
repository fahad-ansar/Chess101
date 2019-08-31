package Model;


import Model.MovesGeneration.MovesAlgorithm;
import Model.Teams.Team;

public class Model {




    //All the needed primitives
    Board board;


    //Not working now might be adding its functionality later
    MovesAlgorithm moveCollector =  new MovesAlgorithm();


    public Model(){
        board = Board.getInstance();
    }


    //using method of board to move a piece
    public void moveBoardPiece(int i_1, int j_1, int i_2, int j_2){
        board.movePiece(i_1,j_1,i_2,j_2);
    }


    //sets all pieces to their original position *****Might be needing a small fix
    public void setBoardPieces(){
        board.intialize();
        board.initialPieces();
    }

    //It returns the main chess board
    public Square[][] getboard(){
        return board.getBoard();
    }


    //sets the team names using board method together
    public void setTeamNames(String tA, String tB){
        board.setTeamA(tA);
        board.setTeamB(tB);
    }

    public void flipBoard(){
        board.upsideDown();
    }

    public Team getTeam(int a){
        Team res = null;
        if(a==0) res = board.getTeamA();
        else if(a==1) res = board.getTeamB();
        return res;
    }

    //Simply prints the board
    public void printBoardState(){
        board.printBoard();
    }

}
