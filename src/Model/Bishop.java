package Model;

import NotDecided.Move;

import java.util.ArrayList;

public class Bishop implements Piece{

    public final static PiecePoints killwill = PiecePoints.BISHOP;
    private String intialPos = "";
    private String currentPos = "";
    public Team team = null;
    private int points = 0;

    public String getName(){
        return team + "-Bishop";
    }

    public Bishop(Team team){
        this.team = team;
    }

    @Override
    public String getIntialPos() { return intialPos; }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        return null;
    }

    @Override
    public String getCurrentPos() {
        return currentPos;
    }

    @Override
    public void setCurrentPos(String currentPos) {
        this.currentPos = currentPos;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }
}
