package Model.MovesGeneration;

import java.util.ArrayList;

public class MovesAlgorithm {

    Generation genMove = new Generation();

    public ArrayList<Move> genMovesBishop(int i, int j){
        genMove.setStategy(new GMBishop());
        return genMove.generate(i,j);
    }

    public ArrayList<Move> genMovesKing(int i, int j){
        genMove.setStategy(new GMKing());
        return genMove.generate(i,j);
    }

    public ArrayList<Move> genMovesKnight(int i, int j){
        genMove.setStategy(new GMKnight());
        return genMove.generate(i,j);
    }

    public ArrayList<Move> genMovesPawn(int i, int j){
        genMove.setStategy(new GMPawn());
        return genMove.generate(i,j);
    }

    public ArrayList<Move> genMovesRook(int i, int j){
        genMove.setStategy(new GMRook());
        return genMove.generate(i,j);
    }

}
