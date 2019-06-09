package Model;

public enum PiecePoints {
    KING(1000),QUEEN(9),ROOK(5),BISHOP(4),KNIGHT(3),PAWN(1);

    private int value;

    PiecePoints(int val){
        this.value=val;
    }

    public int getValue(){
        return value;
    }
}
