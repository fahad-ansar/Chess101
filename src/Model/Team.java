package Model;

import java.time.Period;

public abstract class Team {
    String name = "";
    int score = 0;
    int turncount = 0;

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

    public void setTurncount(int turncount) {
        this.turncount = turncount;
    }
}
