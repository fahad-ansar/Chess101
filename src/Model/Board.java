package Model;


public class Board {

    private Square[][] ground = new Square[8][8];
    private TeamA teamA = new TeamA();
    private TeamB teamB = new TeamB();
    private PieceFactory factory = new PieceFactory();
    private static Board singletons = null;


    public Board() {
        teamA.setName("Fahad");
        teamB.setName("Param");
        intialize();
        initialPieces();

        System.out.println();
        printBoard();
        printBoard();
    }


    public static Board getInstance(){
        if(singletons == null ) singletons = new Board();
        return singletons;
    }

    public void movePiece(int i1, int j1, int i2, int j2) {
            ground[i2][j2].setPiece(ground[i1][j1].getPiece());
            ground[i1][j1].setPiece(null);
    }

    public void initialPieces() {
        //Pawn
        for (int i = 0; i < 8; i++) {
            ground[1][i].setPiece(factory.create("P", teamA));
            ground[6][i].setPiece(factory.create("P", teamB));
        }
        //Rook
        ground[0][0].setPiece(factory.create("R", teamA));
        ground[0][7].setPiece(factory.create("R", teamA));
        ground[7][0].setPiece(factory.create("R", teamB));
        ground[7][7].setPiece(factory.create("R", teamB));

        //Bishop
        ground[0][2].setPiece(factory.create("B", teamA));
        ground[0][5].setPiece(factory.create("B", teamA));
        ground[7][2].setPiece(factory.create("B", teamB));
        ground[7][5].setPiece(factory.create("B", teamB));

        //Knight
        ground[0][1].setPiece(factory.create("Kn", teamA));
        ground[0][6].setPiece(factory.create("Kn", teamA));
        ground[7][1].setPiece(factory.create("Kn", teamB));
        ground[7][6].setPiece(factory.create("Kn", teamB));

        //Queen
        ground[0][3].setPiece(factory.create("Q", teamA));
        ground[7][3].setPiece(factory.create("Q", teamB));

        //King
        ground[0][4].setPiece(factory.create("K", teamA));
        ground[7][4].setPiece(factory.create("K", teamB));


    }

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

    public Square[][] getBoard() {
        return ground;
    }

    public TeamA getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamA teamA) {
        this.teamA = teamA;
    }

    public TeamB getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamB teamB) {
        this.teamB = teamB;
    }

    public void printBoard() {
        System.out.println("                                               " + teamA.getName());
        System.out.println("                                           --------------");
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground.length; j++) {
                if (ground[i][j].getPiece() != null) {
                    System.out.print(ground[i][j].getPiece().getName() + " | ");
                } else {
                    System.out.print((ground[i][j].getColor().equals("white")) ? "    Θ     | " : "    Ξ     | ");
                }
            }
            System.out.println();
        }
        System.out.println("                                            -------------");
        System.out.println("                                               " + teamB.getName());
    }

    private void intialize() {
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground.length; j++) {
                ground[i][j] = new Square();
                ground[i][j].setIndex((ground.length - i) + "" + (char) (65 + j));
                if ((i + j) % 2 == 0) {
                    ground[i][j].setColor("BLACK");
                } else {
                    ground[i][j].setColor("WHITE");
                }
//                System.out.print(ground[i][j].getIndex() + " | ");
            }
//            System.out.println();
        }
        System.out.println("Board intialized!");
    }

    public static void main(String[] args) {
        Board b = new Board();

    }
}
