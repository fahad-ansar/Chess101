package Model;

import NotDecided.Move;

import java.util.ArrayList;

public interface Piece {
    public String getName();
    public String getIntialPos();
    public ArrayList<Move> getPossibleMoves();
    public String getCurrentPos();
    public void setCurrentPos(String currentPos);
    public Team getTeam();
    public int getPoints();
    public void setPoints(int points);

}
