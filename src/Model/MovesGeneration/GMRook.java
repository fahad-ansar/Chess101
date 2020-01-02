package Model.MovesGeneration;

import Model.Board;
import Model.Pieces.Piece;

import java.util.ArrayList;

import static java.lang.Character.compare;

public class GMRook implements MovesGeneration{
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> rm = new ArrayList<Move>();

        char tm = Board.getInstance().getBoard()[i][j].getPiece().getTeam().getinit();

        //Down
        int ti = i;
        int tj = j;
        ti++;
        while(ti<8) {
            if (!Board.getInstance().getBoard()[ti][tj].isFilled()) {
                rm.add(new Move(ti, tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                rm.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti++;
        }

        //up
        ti = i;
        tj = j;
        ti--;
        while(ti>=0){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()) {
                rm.add(new Move(ti, tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                rm.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti--;
        }

        //left
        ti = i;
        tj = j;
        tj--;
        while(tj>=0){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()) {
                rm.add(new Move(ti, tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                rm.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            tj--;
        }

        //right
        ti = i;
        tj = j;
        tj++;
        while(tj<8){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()) {
                rm.add(new Move(ti, tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                rm.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            tj++;
        }

        return rm;
    }
}
