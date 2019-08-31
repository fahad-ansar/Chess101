package Controller;

import Model.Model;
import Model.MovesGeneration.Move;
import Model.MovesGeneration.MovesAlgorithm;
import View.TBUI;

public class Controller {




    //Todo
    //Sync UML with the code
    //Move limit apply with deducting each move
    //whole system needs optimization
    //set scoring system, for now every kill 100
    //Make use of exceptions

    MovesAlgorithm movesAlgorithm = new MovesAlgorithm();
    MovesLimit movesLimit;
    TBUI tbinter = new TBUI();


    Model model = new Model();

    int turn = 0;

    public Controller(){

        tbinter.welcome();
        model.setBoardPieces();
        int mlimit = tbinter.getMovesLimit();
        String tmA = tbinter.getTeamName(0);
        String tmB = tbinter.getTeamName(1);
        model.setTeamNames(tmA,tmB);
        tbinter.Rules();

        while(mlimit!=0) {
            tbinter.printState(model.getTeam(0), model.getTeam(1), (turn == 0) ? model.getTeam(0).getName() : model.getTeam(1).getName());
            int[] inpt = tbinter.moveInput("piece you want to move");
            int[] inpt2 = tbinter.moveInput("destination");
            boolean[] wc = tbinter.winCheck(inpt2[0], inpt2[1], (turn == 0) ? "black" : "white");
            if(wc[1]) model.getTeam(turn).setScore(model.getTeam(turn).getScore()+50);
            if(wc[0]) model.getTeam(turn).setScore(model.getTeam(turn).getScore()+100);
            model.moveBoardPiece(inpt[0],inpt[1],inpt2[0],inpt2[1]);
            mlimit--;
            model.flipBoard();
        }

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }

}
