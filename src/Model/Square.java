package Model;

public class Square {
    private String color = null;
    private String index = "";
    Piece piece = null;

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece piece) {this.piece = piece;}

    public void setIndex(String index){this.index = index;}

    public String getIndex(){return index;}

    public boolean isFilled() {
        return piece != null;
    }

    public String getColor() {
        int i = Integer.parseInt(index.charAt(0)+"");
        int j = ((int)index.charAt(1))-65;
        return ((i+j)%2==0)?"white":"black";
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String result = "";
        if(color!=null) result+=color+" ";
        if(isFilled()) result+="filled with";
        if(piece!=null){
            result+=piece.getName();
            result+=piece.getTeam().getName();
        }
        return result;
    }
}
