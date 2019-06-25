package Model;

public class Square {
    private boolean filled = false;
    private String color = null;
    Piece piece = null;


    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
