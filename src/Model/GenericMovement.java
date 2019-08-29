package Model;
import java.util.ArrayList;

public class GenericMovement {

    Board board = Board.getInstance();
    public GenericMovement(){
        board.setTeamA("Fahad");
        board.setTeamB("Param");
        board.intialize();
        board.initialPieces();
//
        board.printBoard();
        getAllMoves(1,0);
    }

    public ArrayList<Move> getAllMoves(int i, int j) {
        ArrayList<Move> result =  new ArrayList<Move>();

//
        if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("ROOK")){
            result.addAll(makeRook(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("KING")){
            result.addAll(makeKing(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("BISHOP")){
            result.addAll(makeBishop(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("KNIGHT")) {
            result.addAll(makeKnight(i,j));
        }
        else if(Board.getInstance().getBoard()[i][j].getPiece().getKillwill().toString().equals("PAWN")) {
            result.addAll(makePawn(i,j));
        }
            return result;
    }

    /**
     * Made some algorithms just need to add the 'kill the filled oens' algorithm
     *
     */



    //Donw with both
    private ArrayList<Move> makeRook(int i, int j) {
        ArrayList<Move> rm = new ArrayList<Move>();
        Piece p = Board.getInstance().getBoard()[i][j].getPiece();

        //Down
        int ti = i;
        int tj = j;
        ti++;
        while(ti<9 && !board.getBoard()[ti][tj].isFilled()){
            System.out.println("in1");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            ti++;
        }

        //up
        ti = i;
        tj = j;
        ti--;
        while(ti>=0 && !board.getBoard()[ti][tj].isFilled()){
            System.out.println("in2");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            ti--;
        }

        //left
        ti = i;
        tj = j;
        tj--;
        while(tj>=0 && !board.getBoard()[ti][tj].isFilled()){
            System.out.println("in3");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            tj--;
        }

        //right
        ti = i;
        tj = j;
        tj++;
        while(tj<9 && !board.getBoard()[ti][tj].isFilled()){
            System.out.println("in4");
            rm.add(new Move(ti,tj));
            System.out.println(ti+""+tj);
            tj++;
        }

        return rm;
    }

    private ArrayList<Move> makeKing(int i, int j) {
        ArrayList<Move> km = new ArrayList<Move>();
        if(j<8 && !board.getBoard()[i][j+1].isFilled()) km.add(new Move(i, j+1));
        if(j>0 && !board.getBoard()[i][j-1].isFilled()) km.add(new Move(i, j-1));
        if(i<8 && !board.getBoard()[i+1][j].isFilled()) km.add(new Move(i+1, j));
        if(i>0 && !board.getBoard()[i-1][j].isFilled()) km.add(new Move(i-1, j));
        return km;
    }


    //Need to figure out diagonal formula
    private ArrayList<Move> makeBishop(int i, int j) {
        ArrayList<Move> bm = new ArrayList<Move>();
        return bm;
    }

    //Might need nested Ifs
    private ArrayList<Move> makeKnight(int i, int j) {
        ArrayList<Move> kim = new ArrayList<Move>();
        return kim;
    }

    //Done
    private ArrayList<Move> makePawn(int i, int j) {
        ArrayList<Move> pm = new ArrayList<Move>();
        int temp[] = board.getBoard()[i][j].getPiece().getIntialPos();
        if(temp[0]==(i+1) && temp[1]==j+1){
            if(i==2){
                if(!board.getBoard()[i+2][j].isFilled())pm.add(new Move(i+2,j));
                if(!board.getBoard()[i+1][j].isFilled())pm.add(new Move(i+1,j));
            }
            else if(i==7){
                if(!board.getBoard()[i-2][j].isFilled())pm.add(new Move(i-2,j));
                if(!board.getBoard()[i-1][j].isFilled())pm.add(new Move(i-1,j));
            }
        }else{
            if(!board.getBoard()[i+1][j].isFilled())pm.add(new Move(i+1,j));
            if(!board.getBoard()[i-1][j].isFilled())pm.add(new Move(i-1,j));
        }
        return pm;
    }

    public static void main(String[] args) {
        GenericMovement gm = new GenericMovement();

    }
}

