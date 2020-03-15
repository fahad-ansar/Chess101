package Controller;

import Model.Model;
import Model.MovesGeneration.Move;
import Model.MovesGeneration.MovesAlgorithm;
import Model.Teams.Team;
import View.TBUI;

import static java.lang.Character.compare;

public class Controller {

    //0 is black TEAMA
    //1 is white TEAMB




    MovesAlgorithm movesAlgorithm = new MovesAlgorithm();
    MovesLimit movesLimit;
    TBUI tbinter = new TBUI();
    int turn = 1;

    Model model = new Model();


    public Controller(){

        tbinter.welcome();
        model.setBoardPieces();

        int mlimit = tbinter.getMovesLimit();

        String tmA = tbinter.getTeamName(0);
        String tmB = tbinter.getTeamName(1);

        model.setTeamNames(tmA,tmB);
        tbinter.Rules();

        while(mlimit!=0) {
            tbinter.printState(model.getTeam(0), model.getTeam(1), turn);
            int[] inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");

            //If selected piece is null
            while (model.getboard()[inpt[0]][inpt[1]].getPiece()==null) {
                System.out.println("There no piece there! you should increase power of your glasses, if you dont have one get one!\nTry Again!\n");
                inpt = tbinter.moveInput("piece you want to move", "PIECE SELECTION");
            }

            //If selected piece is not mine
            while (compare(model.getboard()[inpt[0]][inpt[1]].getPiece().getTeam().getinit(), (turn == 0) ? 'B' : 'W') != 0){
                System.out.println("Stop operating opposite team pieces, \nTry Again!\n");
                inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");
            }

            int[] inpt2 = tbinter.moveInput("destination","DESTINATION");

            //If killing my own piece
            while (true){
                if(model.getboard()[inpt2[0]][inpt2[1]].getPiece()==null) {
                    break;
                }
                else if (compare(model.getboard()[inpt2[0]][inpt2[1]].getPiece().getTeam().getinit(), (turn == 0) ? 'B' : 'W') != 0) {
                    break;
                }
                System.out.println("Please dont kill your own piece, Traitor!, \nTry Again!\n");
                inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");


                inpt2 = tbinter.moveInput("destination","DESTINATION");

            }


//            boolean[] wc = tbinter.winCheck(inpt2[0], inpt2[1], (turn == 0) ? "black" : "white", turn);
//            if(wc[0]&wc[1]) {
//                System.out.println("\n\n***CHECKMATE***\n\n");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            boolean jk = model.moveBoardPiece(inpt[0],inpt[1],inpt2[0],inpt2[1], turn);
            if(!jk){
                System.out.println("xxxxxxxxxxxxxxx Not a valid move xxxxxxxxxxxxxxxxx");
                inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");

                //If selected piece is null
                while (model.getboard()[inpt[0]][inpt[1]].getPiece()==null) {
                    System.out.println("There no piece there! you should increase power of your glasses, if you dont have one get one!\nTry Again!\n");
                    inpt = tbinter.moveInput("piece you want to move", "PIECE SELECTION");
                }

                //If selected piece is not mineprint
                while (compare(model.getboard()[inpt[0]][inpt[1]].getPiece().getTeam().getinit(), (turn == 0) ? 'B' : 'W') != 0){
                    System.out.println("Stop operating opposite team pieces, \nTry Again!\n");
                    inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");
                }

                inpt2 = tbinter.moveInput("destination","DESTINATION");

                //If killing my own piece
                while (true){
                    if(model.getboard()[inpt2[0]][inpt2[1]].getPiece()==null) {
                        break;
                    }
                    else if (compare(model.getboard()[inpt2[0]][inpt2[1]].getPiece().getTeam().getinit(), (turn == 0) ? 'B' : 'W') != 0) {
                        break;
                    }
                    System.out.println("Please dont kill your own piece, Traitor!, \nTry Again!\n");
                    inpt = tbinter.moveInput("piece you want to move","PIECE SELECTION");
                }

                 jk = model.moveBoardPiece(inpt[0],inpt[1],inpt2[0],inpt2[1], turn);

            }

            int k = 0;
            for (int i = 0; i < model.getboard().length; i++) {
                for (int j = 0; j < model.getboard()[i].length; j++) {
                    if(model.getboard()[i][j].getPiece()==null){}
                    else if(compare(model.getboard()[i][j].getPiece().getInitial(),'c')==0){
                        k++;
                    }
                }
            }
            System.out.println(k);
            if(k<2) {System.out.println("someone WON"); break;}


            mlimit--;
            model.flipBoard(turn);
            tbinter.boardflipping();
            turn = (turn==0)? 1:0;

        }

        System.out.println("GAME ENDED");

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }

}
