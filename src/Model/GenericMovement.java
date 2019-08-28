package Model;

import java.util.ArrayList;

public class GenericMovement {
    public ArrayList<Move> getAllMoves(int i, int j) {
        ArrayList<Move> result =  new ArrayList<Move>();

        if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("ROOK")){
            result.addAll(makeRook(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("KING")){
            result.addAll(makeKing(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("BISHOP")){
            result.addAll(makeBishop(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("KNIGHT")) {
            result.addAll(makeKnight(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("PAWN")) {
            result.addAll(makePawn(i,j));
        }
            return result;
    }

    private ArrayList<Move> makeRook(int i, int j) {
        ArrayList<Move> rm = new ArrayList<Move>();

        return rm;
    }

    private ArrayList<Move> makeKing(int i, int j) {
        ArrayList<Move> km = new ArrayList<Move>();
        return km;
    }


    private ArrayList<Move> makeBishop(int i, int j) {
        ArrayList<Move> bm = new ArrayList<Move>();
        return bm;
    }

    private ArrayList<Move> makeKnight(int i, int j) {
        ArrayList<Move> kim = new ArrayList<Move>();
        return kim;
    }

    private ArrayList<Move> makePawn(int i, int j) {
        ArrayList<Move> pm = new ArrayList<Move>();
        return pm;
    }
}

