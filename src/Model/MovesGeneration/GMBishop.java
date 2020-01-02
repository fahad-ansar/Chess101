package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;

import static java.lang.Character.compare;


//figure out the diagnol formula

public class GMBishop implements MovesGeneration{
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> bp = new ArrayList<>();
        char tm = Board.getInstance().getBoard()[i][j].getPiece().getTeam().getinit();

        //right down
        int ti = i;
        int tj = j;
        ti-=1;
        tj+=1;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                bp.add(new Move(ti,tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                bp.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti-=1;
            tj+=1;
        }

        //left down
        ti = i;
        tj = j;
        ti-=1;
        tj-=1;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                bp.add(new Move(ti,tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                bp.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti-=1;
            tj-=1;
        }

        //right down
        ti = i;
        tj = j;
        ti+=1;
        tj+=1;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                bp.add(new Move(ti,tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                bp.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti+=1;
            tj+=1;
        }

        //left down
        ti = i;
        tj = j;
        ti+=1;
        tj-=1;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                bp.add(new Move(ti,tj));
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()& compare(Board.getInstance().getBoard()[ti][tj].getPiece().getTeam().getinit(), tm)!=0){
                bp.add(new Move(ti,tj));
                break;
            }else if(Board.getInstance().getBoard()[ti][tj].isFilled()){break;}
            ti+=1;
            tj-=1;
        }


        return bp;
    }
}
