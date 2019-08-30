package Model.Teams;

import Model.Model;
import Model.Pieces.Piece;

import java.util.ArrayList;

public abstract class Team {
    private String name = "";
    private int score = 0;
    private int turncount = 0;
    private ArrayList<Piece> killedOponents;

    public ArrayList<Piece> getKilledOponents() {
        return killedOponents;
    }

    public void addKilledOponents(Piece killedOponent) {
        killedOponents.add(killedOponent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTurncount() {
        return turncount;
    }

    public void turncountPlus() {
        turncount += 1;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", turncount=" + turncount +
                '}';
    }
}
