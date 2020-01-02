package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;

import static java.lang.Character.compare;

public class GMKing implements MovesGeneration {
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> km = new ArrayList<Move>();
        char tm = Board.getInstance().getBoard()[i][j].getPiece().getTeam().getinit();
        //right
        if(j+1<8) {
            if (!Board.getInstance().getBoard()[i][j + 1].isFilled()) {
                km.add(new Move(i, j + 1));
            }else if(Board.getInstance().getBoard()[i][j + 1].isFilled()& compare(Board.getInstance().getBoard()[i][j + 1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i, j + 1));
            }
        }
        //left
        if(j-1>=0) {
            if (!Board.getInstance().getBoard()[i][j - 1].isFilled()) {
                km.add(new Move(i, j - 1));
            }else if(Board.getInstance().getBoard()[i][j - 1].isFilled()& compare(Board.getInstance().getBoard()[i][j - 1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i,j - 1));
            }
        }
        //down
        if(i+1<8) {
            if (!Board.getInstance().getBoard()[i + 1][j].isFilled()) {
                km.add(new Move(i + 1, j));
            }else if(Board.getInstance().getBoard()[i + 1][j].isFilled()& compare(Board.getInstance().getBoard()[i + 1][j].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i + 1,j));
            }
        }
        //up
        if(i-1>=0) {
            if (!Board.getInstance().getBoard()[i - 1][j].isFilled()) {
                km.add(new Move(i - 1, j));
            }else if(Board.getInstance().getBoard()[i - 1][j].isFilled()& compare(Board.getInstance().getBoard()[i - 1][j].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i - 1,j));
            }
        }

        //upRight
        if(i-1>=0 && j+1<8) {
            if (!Board.getInstance().getBoard()[i - 1][j+1].isFilled()) {
                km.add(new Move(i - 1, j+1));
            }else if(Board.getInstance().getBoard()[i - 1][j+1].isFilled()& compare(Board.getInstance().getBoard()[i - 1][j+1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i - 1,j+1));
            }
        }
        //upLeft
        if(i-1>=0 && j-1>=0) {
            if (!Board.getInstance().getBoard()[i - 1][j-1].isFilled()) {
                km.add(new Move(i - 1, j-1));
            }else if(Board.getInstance().getBoard()[i - 1][j-1].isFilled()& compare(Board.getInstance().getBoard()[i - 1][j-1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i - 1,j-1));
            }
        }
        //downLeft
        if(i+1<8 && j-1>=0) {
            if (!Board.getInstance().getBoard()[i + 1][j-1].isFilled()) {
                km.add(new Move(i + 1, j-1));
            }else if(Board.getInstance().getBoard()[i + 1][j-1].isFilled()& compare(Board.getInstance().getBoard()[i + 1][j-1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i + 1,j-1));
            }
        }
        //downRight
        if(i+1<8 && j+1<8) {
            if (!Board.getInstance().getBoard()[i + 1][j+1].isFilled()) {
                km.add(new Move(i + 1, j+1));
            }else if(Board.getInstance().getBoard()[i + 1][j+1].isFilled()& compare(Board.getInstance().getBoard()[i + 1][j+1].getPiece().getTeam().getinit(), tm)!=0){
                km.add(new Move(i + 1,j+1));
            }
        }
        return km;
    }
}
