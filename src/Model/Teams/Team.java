package Model.Teams;

import Model.Model;
import Model.Pieces.Piece;

import java.util.ArrayList;

public abstract class Team {
    private String name = "";
    private int score = 0;
    private int turncount = 0;
    private ArrayList<Piece> killedOponents = new ArrayList<>();

    public String  getKilledOponents() {
        String p = "-";
        for(int i=0; i<killedOponents.size(); i++) p = p + " , "+ killedOponents.get(i).getName();
        return p;
    }

    public void addKilledOponents(Piece killedOponent) {
        this.killedOponents.add(killedOponent);
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

    public void setScore(Piece score) {
        char l = score.getInitial();

        if(l=='c') this.score= this.score+99999999;
        else if(l=='q')this.score= this.score+9;
        else if(l=='r')this.score= this.score+5;
        else if(l=='b')this.score= this.score+4;
        else if(l=='k')this.score= this.score+3;
        else if(l=='p')this.score= this.score+1;


    }

//    public int getTurncount() {
//        return turncount;
//    }
//
//    public void turncountPlus() {
//        turncount += 1;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", turncount=" + turncount +
                '}';
    }

    public abstract char getinit();
}
