package Model;

public class PieceFactory {

    public Piece create(String piece, Team team) {
        Piece result = null;

        if(piece.equals("B")){
            result = new Bishop(team);
        }else if(piece.equals("R")){
            result = new Rook(team);
        }else if(piece.equals("P")){
            result = new Pawn(team);
        }else if(piece.equals("Kn")){
            result = new Knight(team);
        }else if(piece.equals("K")){
            result = new King(team);
        }else if(piece.equals("Q")){
            result = new Queen(team);
        }

        return result;
    }
}
