package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.compare;

public class GMPawn implements MovesGeneration {
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> pm = new ArrayList<Move>();
        char tm = Board.getInstance().getBoard()[i][j].getPiece().getTeam().getinit();

        //First move up or down
        if(i==1){
            if(!Board.getInstance().getBoard()[i+2][j].isFilled() & !Board.getInstance().getBoard()[i+1][j].isFilled()){pm.add(new Move(i+2,j));}
        }
        else if(i==6){
            if(!Board.getInstance().getBoard()[i-2][j].isFilled() & !Board.getInstance().getBoard()[i-1][j].isFilled())
            {pm.add(new Move(i-2,j));}
        }

        //One move in middle towards up
        if(i+1<8) {
            if (!Board.getInstance().getBoard()[i + 1][j].isFilled()) {
                pm.add(new Move(i + 1, j));
            }
        }

        //One move in middle towards down
        if(i-1>=0) {
            if (!Board.getInstance().getBoard()[i - 1][j].isFilled()) {
                pm.add(new Move(i - 1, j));
            }
        }

        //Diagonal left or right-  towards up
        if(i-1>=0 & j-1>=0) {
            if(Board.getInstance().getBoard()[i - 1][j-1].getPiece()!=null) {
                if (Board.getInstance().getBoard()[i - 1][j - 1].isFilled() & compare(Board.getInstance().getBoard()[i - 1][j - 1].getPiece().getTeam().getinit(), tm) != 0) {
                    pm.add(new Move(i - 1, j - 1));
                }
            }
        }

        if(i-1>=0 & j+1<8) {
            if(Board.getInstance().getBoard()[i - 1][j+1].getPiece()!=null) {
                if (Board.getInstance().getBoard()[i - 1][j + 1].isFilled() & compare(Board.getInstance().getBoard()[i - 1][j + 1].getPiece().getTeam().getinit(), tm) != 0) {
                    pm.add(new Move(i - 1, j + 1));
                }
            }
        }

        //Diagonal left or right- towards down
        if(i+1<8 & j+1<8) {
            if(Board.getInstance().getBoard()[i + 1][j+1].getPiece()!=null) {
                if (Board.getInstance().getBoard()[i + 1][j + 1].isFilled() & compare(Board.getInstance().getBoard()[i + 1][j + 1].getPiece().getTeam().getinit(), tm) != 0) {
                    pm.add(new Move(i + 1, j + 1));
                }
            }
        }

        if(i+1<8 & j-1>=0) {
            if(Board.getInstance().getBoard()[i + 1][j-1].getPiece()!=null) {
                if (Board.getInstance().getBoard()[i + 1][j - 1].isFilled() & compare(Board.getInstance().getBoard()[i + 1][j - 1].getPiece().getTeam().getinit(), tm) != 0) {
                    pm.add(new Move(i + 1, j - 1));
                }
            }
        }

        return pm;
    }
}
