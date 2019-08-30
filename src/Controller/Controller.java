package Controller;

import Model.Model;

public class Controller {




    //Todo
    /*
     * Make board search algorithm inside board and flipping methods for user turns
     * Apply Facade pattern on move algorithm & Fill method of  move algorithm type
     * Plan flow in here
     * Sync UML with the code
     * make methods of TBUI
     * */



    Model model;


    public Controller(){
        model = new Model();
        model.setTeamNames("Fahad","Param");
        model.setBoardPieces();
        model.printBoardState();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }

}
