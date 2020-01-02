package Model;


import Model.Pieces.Piece;
import Model.Teams.TeamA;
import Model.Teams.TeamB;

public class Board {

    //primitive types
    private Square[][] ground = new Square[8][8];
    private TeamA teamA = new TeamA();
    private TeamB teamB = new TeamB();
    private PieceFactory factory = new PieceFactory();
    private static Board singletons = null;

    /*
    * It return the only instance of the board
    * @return an instance of board if not instantiated, makes and returns
    *
    * */
    public static Board getInstance(){
        if(singletons == null ) singletons = new Board();
        return singletons;
    }


    //returns the whole board
    public Square[][] getBoard(){
        return ground;
    }

    //Purpose: Simply it prints the whole board on the screen
    public void printBoard(int turnC) {
        if(turnC==1) System.out.println("\n                                               " + teamA.getName());
        else if(turnC==0) System.out.println("                                               " + teamB.getName());

        System.out.println("                                           --------------\n");
        System.out.println("         0            1            2            3            4            5            6            7");
        System.out.println();
        for (int i = 0; i < ground.length; i++) {
            System.out.print(i+"   ");
            for (int j = 0; j < ground.length; j++) {
                if (ground[i][j].getPiece() != null) {
                    System.out.print(ground[i][j].getPiece().getName() + " | ");
                } else {
                    System.out.print((ground[i][j].getColor().equals("white")) ? "    Θ      | " : "    Ξ      | ");
                }
            }
            System.out.println();
        }
        System.out.println("\n                                            -------------");
        if(turnC==1) System.out.println("                                               " + teamB.getName());
        else if(turnC==0) System.out.println("                                               " + teamA.getName());

    }


    //Purpose: Initialize all the pieces to their initial positions
    public void initialPieces() {
        //Pawn
//        for (int i = 0; i < 8; i++) {
//            ground[1][i].setPiece(factory.create("P", teamA));
//            ground[6][i].setPiece(factory.create("P", teamB));
//            ground[1][i].getPiece().setIntialPos(1,i);
//            ground[6][i].getPiece().setIntialPos(6,i);
//        }
        //Rook
        ground[0][0].setPiece(factory.create("R", teamA));
        ground[0][7].setPiece(factory.create("R", teamA));
        ground[7][0].setPiece(factory.create("R", teamB));
        ground[7][7].setPiece(factory.create("R", teamB));
        //setting intial state of the pieces
        ground[0][0].getPiece().setIntialPos(0,0);
        ground[0][7].getPiece().setIntialPos(0,7);
        ground[7][0].getPiece().setIntialPos(7,0);
        ground[7][7].getPiece().setIntialPos(7,7);

        //Bishop
        ground[0][2].setPiece(factory.create("B", teamA));
        ground[0][5].setPiece(factory.create("B", teamA));
        ground[7][2].setPiece(factory.create("B", teamB));
        ground[7][5].setPiece(factory.create("B", teamB));
        //setting intial state of the pieces
        ground[0][2].getPiece().setIntialPos(0,2);
        ground[0][5].getPiece().setIntialPos(0,5);
        ground[7][2].getPiece().setIntialPos(7,2);
        ground[7][5].getPiece().setIntialPos(7,5);

        //Knight
        ground[0][1].setPiece(factory.create("Kn", teamA));
        ground[0][6].setPiece(factory.create("Kn", teamA));
        ground[7][1].setPiece(factory.create("Kn", teamB));
        ground[7][6].setPiece(factory.create("Kn", teamB));
        //setting intial state of the pieces
        ground[0][1].getPiece().setIntialPos(0,1);
        ground[0][6].getPiece().setIntialPos(0,6);
        ground[7][1].getPiece().setIntialPos(7,1);
        ground[7][6].getPiece().setIntialPos(7,6);

        //Queen
        ground[0][3].setPiece(factory.create("Q", teamA));
        ground[7][3].setPiece(factory.create("Q", teamB));
        //setting initial positions
        ground[0][3].getPiece().setIntialPos(0,3);
        ground[7][3].getPiece().setIntialPos(7,3);


        //King
        ground[0][4].setPiece(factory.create("K", teamA));
        ground[7][4].setPiece(factory.create("K", teamB));
        //setting intial positions of pieces
        ground[0][4].getPiece().setIntialPos(0,4);
        ground[7][4].getPiece().setIntialPos(7,4);


    }

    //Purpose: Intialize whole board with square without pieces
    public void intialize() {
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground.length; j++) {
                ground[i][j] = new Square();
                ground[i][j].setIndex((ground.length - i) + "" + (char) (65 + j));
                if ((i + j) % 2 == 0) {
                    ground[i][j].setColor("BLACK");
                } else {
                    ground[i][j].setColor("WHITE");
                }
            }
        }
        System.out.println("Board intialized!");
    }


    /*
    * Purpose: To make a piece move from one index to the other index
    *
    * @param indexes of first position , indexes of destination
    * */
    public Piece movePiece(int i1, int j1, int i2, int j2) {
            Piece temp = ground[i2][j2].getPiece();
            ground[i2][j2].setPiece(ground[i1][j1].getPiece());
            ground[i1][j1].setPiece(null);
            return temp;
    }


    /*
     * It returns 'teamA'
     *
     * @return TeamA
     */
    public TeamA getTeamA() {
        return teamA;
    }

    /*
     * It returns 'teamB'
     *
     * @return TeamB
     */
    public TeamB getTeamB() {
        return teamB;
    }


    //This method sets the name of 'teamB'
    public void setTeamB(String teamB) {
        this.teamB.setName(teamB);
    }

    //This method sets the name of 'teamB'
    public void setTeamA(String teamA) {
        this.teamA.setName(teamA);
    }


    /*
    * Flips the board upside down
    * */
    public void upsideDown(int turnC){
        Square groundTemp[][] = new Square[8][8];
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                groundTemp[i][j] = ground[i][j];
            }
        }

        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                ground[(ground.length-1)-i][(ground[i].length-1)-j] =groundTemp[i][j];
            }
        }

        if(turnC==0) turnC=1;
        else if(turnC==1) turnC=0;
    }


    //These methods are extra operation might be using it
    public int isNull() {
        int jk = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ground[i][j].getPiece() == null) {
                    jk = 0;
                    break;
                }
            }
            if (jk == 0) break;
        }
        return jk;
    }

    public void wipeOff() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ground[i][j].piece = null;
            }
        }
    }


}
