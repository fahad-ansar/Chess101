package Model.MovesGeneration;


import java.util.ArrayList;

/*
* All movement finding classe only searches for empty boxes , insert
* the filled ones also!
* */


public class Generation {


    MovesGeneration movesGeneration;

    public void setStategy(MovesGeneration gen){
        movesGeneration=gen;
    }

    public ArrayList<Move> generate(int i, int j){
        return movesGeneration.getMoves(i,j);
    }

}






