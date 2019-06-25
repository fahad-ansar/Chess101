package Model;

public class Board {

    private Square[][] ground = new Square[8][8];
    private TeamA teamA = new TeamA();
    private TeamB teamB = new TeamB();

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

    public String toString(){
        String result = "";

        result = result + teamA.getName() + ":" + teamA.getScore() + " || " + teamB.getName() + ":" + teamB.getScore() + "\n";
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                result = result + "|" + ground[i][j].getPiece().getName();
            }
            result = result + "\n";
        }


        return result;
    }
}
