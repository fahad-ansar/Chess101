package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;

public class GMKing implements MovesGeneration {
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> km = new ArrayList<Move>();
        if(j<8 && !Board.getInstance().getBoard()[i][j+1].isFilled()) km.add(new Move(i, j+1));
        if(j>0 && !Board.getInstance().getBoard()[i][j-1].isFilled()) km.add(new Move(i, j-1));
        if(i<8 && !Board.getInstance().getBoard()[i+1][j].isFilled()) km.add(new Move(i+1, j));
        if(i>0 && !Board.getInstance().getBoard()[i-1][j].isFilled()) km.add(new Move(i-1, j));
        return km;
    }
}
