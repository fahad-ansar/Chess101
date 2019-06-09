package Model;

import NotDecided.Move;

import java.util.ArrayList;

public interface Piece {
    public String getIntialPos();
    public ArrayList<Move> getPossibleMoves();
    public String getCurrentPos();
    public Team getTeam();
    public int getPoints();
}
