package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;

public class GMPawn implements MovesGeneration {
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> pm = new ArrayList<Move>();
        int temp[] = Board.getInstance().getBoard()[i][j].getPiece().getIntialPos();
        if(temp[0]==(i+1) && temp[1]==j+1){
            if(i==2){
                if(!Board.getInstance().getBoard()[i+2][j].isFilled())pm.add(new Move(i+2,j));
                if(!Board.getInstance().getBoard()[i+1][j].isFilled())pm.add(new Move(i+1,j));
            }
            else if(i==7){
                if(!Board.getInstance().getBoard()[i-2][j].isFilled())pm.add(new Move(i-2,j));
                if(!Board.getInstance().getBoard()[i-1][j].isFilled())pm.add(new Move(i-1,j));
            }
        }else{
            if(!Board.getInstance().getBoard()[i+1][j].isFilled())pm.add(new Move(i+1,j));
            if(!Board.getInstance().getBoard()[i-1][j].isFilled())pm.add(new Move(i-1,j));
        }
        return pm;
    }
}
