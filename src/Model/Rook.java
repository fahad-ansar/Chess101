package Model;

public class Rook implements Piece{
    public final static PiecePoints killwill = PiecePoints.ROOK;
    private String intialPos = "";
    private String currentPos = "";
    public Team team = null;

    public String getName(){
        String t = team.getName().toString();
        return t.charAt(0)+"" + t.charAt(2) + " -Rook ";
    }

    public PiecePoints getKillwill(){
        return killwill;
    }

    public Rook(Team team){
        this.team = team;
    }

    @Override
    public String getIntialPos() { return intialPos; }

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
        return killwill.getValue();
    }


}
