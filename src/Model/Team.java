package Model;


public abstract class Team {
    private String name = "";
    private int score = 0;
    private int turncount = 0;
    private PieceFactory pieceFactory = new PieceFactory();


    public Piece createPiece(String piece){
        return pieceFactory.create(piece);
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
                ", pieceFactory=" + pieceFactory +
                '}';
    }
}
