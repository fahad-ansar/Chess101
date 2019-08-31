package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;


//figure out the diagnol formula

public class GMBishop implements MovesGeneration{
    @Override
    public ArrayList<Move> getMoves(int i, int j) {
        ArrayList<Move> bp = new ArrayList<>();

        //right down
        int ti = i;
        int tj = j;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                System.out.println(ti+" "+tj);
            }
            ti-=1;
            tj+=1;
        }

        //left down
        ti = i;
        tj = j;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                System.out.println(ti+" "+tj);
            }
            ti-=1;
            tj-=1;
        }

        //right down
        ti = i;
        tj = j;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                System.out.println(ti+" "+tj);
            }
            ti+=1;
            tj+=1;
        }

        //left down
        ti = i;
        tj = j;
        while ((ti>=0 && ti<8 && tj>=0 && tj<8)){
            if(!Board.getInstance().getBoard()[ti][tj].isFilled()){
                System.out.println(ti+" "+tj);
            }
            ti+=1;
            tj-=1;
        }


        return bp;
    }
}
