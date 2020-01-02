package Model;


import Model.MovesGeneration.Move;
import Model.MovesGeneration.MovesAlgorithm;
import Model.Pieces.Piece;
import Model.Teams.Team;

import java.util.ArrayList;

import static java.lang.Character.compare;

public class Model {


    //All the needed primitives
    Board board;


    //Not working now might be adding its functionality later
    MovesAlgorithm moveCollector =  new MovesAlgorithm();


    public Model(){
        board = Board.getInstance();
    }


    //using method of board to move a piece
    public boolean moveBoardPiece(int i_1, int j_1, int i_2, int j_2, int my){

        ArrayList<Move> gep = new ArrayList<Move>();

        if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'p')==0)gep = moveCollector.genMovesPawn(i_1,j_1);

        else if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'q')==0)gep = moveCollector.genMovesQeen(i_1,j_1);

        else if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'r')==0)gep = moveCollector.genMovesRook(i_1,j_1);

        else if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'c')==0)gep = moveCollector.genMovesKing(i_1,j_1);

        else if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'k')==0)gep = moveCollector.genMovesKnight(i_1,j_1);

        else if(compare(Board.getInstance().getBoard()[i_1][j_1].getPiece().getInitial(),'b')==0)gep = moveCollector.genMovesBishop(i_1,j_1);

        boolean letin = false;

        for(int h=0;h<gep.size();h++){
            Move t = gep.get(h);
            if(t.index_i == i_2 & t.index_j == j_2){
                letin = true;
            }
        }


        if(letin) {
            Piece temp = board.movePiece(i_1, j_1, i_2, j_2);
            if (temp != null) {
                if (my == 0) {
                    getTeam(0).addKilledOponents(temp);
                    getTeam(0).setScore(temp);
                } else if (my == 1) {
                    getTeam(1).addKilledOponents(temp);
                    getTeam(1).setScore(temp);

                }

            }
        }

        return letin;
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

    public void flipBoard(int turn){
        board.upsideDown(turn);
    }

    public Team getTeam(int a){
        Team res = null;
        if(a==0) res = board.getTeamA();
        else if(a==1) res = board.getTeamB();
        return res;
    }

    //Simply prints the board
    public void printBoardState(int turn){
        board.printBoard(turn);
    }

}
