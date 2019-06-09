package Model;

import NotDecided.Move;

import java.util.ArrayList;

public class Pawn implements Piece {
    public String intialPos = "";
    public String currentPos = "";
    public Team team = null;
    public int points = 0;


    @Override
    public String getIntialPos() {
        return intialPos;
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        return null;
    }

    @Override
    public String getCurrentPos() {
        return currentPos;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
