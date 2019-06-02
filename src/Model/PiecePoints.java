package Model;

public enum PiecePoints {
    KING(1000),QUEEN(9);

    private int value;

    PiecePoints(int val){
        this.value=val;
    }

    public int getValue(){
        return value;
    }
}
