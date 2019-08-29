package Model;



public interface Piece {
    public String getName();
    public int[] getIntialPos();
    public String getCurrentPos();
    public void setCurrentPos(String currentPos);
    public Team getTeam();
    public int getPoints();
    public void setIntialPos(int i, int j);
    public PiecePoints getKillwill();
}
