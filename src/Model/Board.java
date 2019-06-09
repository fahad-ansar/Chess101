package Model;

public class Board {

    Square[][] ground = new Square[8][8];
    TeamA teamA = new TeamA();
    TeamB teamB = new TeamB();

    public Square[][] getBoard() {
        return ground;
    }


    public TeamA getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamA teamA) {
        this.teamA = teamA;
    }

    public TeamB getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamB teamB) {
        this.teamB = teamB;
    }
}
