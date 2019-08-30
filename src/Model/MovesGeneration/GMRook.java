package Model.MovesGeneration;

import Model.Board;
import Model.Pieces.Piece;

import java.util.ArrayList;

public class GMRook implements MovesGeneration{
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> rm = new ArrayList<Move>();
        Piece p = Board.getInstance().getBoard()[i][j].getPiece();

        //Down
        int ti = i;
        int tj = j;
        ti++;
        while(ti<9 && !Board.getInstance().getBoard()[ti][tj].isFilled()){
            System.out.println("in1");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            ti++;
        }

        //up
        ti = i;
        tj = j;
        ti--;
        while(ti>=0 && !Board.getInstance().getBoard()[ti][tj].isFilled()){
            System.out.println("in2");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            ti--;
        }

        //left
        ti = i;
        tj = j;
        tj--;
        while(tj>=0 && !Board.getInstance().getBoard()[ti][tj].isFilled()){
            System.out.println("in3");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            tj--;
        }

        //right
        ti = i;
        tj = j;
        tj++;
        while(tj<9 && !Board.getInstance().getBoard()[ti][tj].isFilled()){
            System.out.println("in4");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            tj++;
        }

        return rm;
    }
}
