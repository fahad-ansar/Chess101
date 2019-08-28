package Model;



public interface Piece {
    public String getName();
    public String getIntialPos();
    public String getCurrentPos();
    public void setCurrentPos(String currentPos);
    public Team getTeam();
    public int getPoints();
    public PiecePoints getKillwill();
}
