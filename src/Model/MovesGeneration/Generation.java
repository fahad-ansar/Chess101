package Model.MovesGeneration;


import java.util.ArrayList;

/*
* All movement finding classe only searches for empty boxes , insert
* the filled ones also!
* */


public class Generation {


    MovesGeneration movesGeneration;

    ArrayList<Move> temp = new ArrayList<Move>();

    public void setStategy(MovesGeneration gen){
        movesGeneration=gen;
    }

    public ArrayList<Move> generate(int i, int j){
        temp = movesGeneration.getMoves(i,j);
        return temp;
    }

}






