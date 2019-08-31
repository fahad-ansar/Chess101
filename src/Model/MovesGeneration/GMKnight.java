package Model.MovesGeneration;

import Model.Board;

import java.util.ArrayList;

//Might need nested ifs
public class GMKnight implements MovesGeneration {

    ArrayList<Move> yu = new ArrayList<>();

    @Override
    public ArrayList<Move> getMoves(int i, int j) {

        //up
        doublet1(i + 2, j);
        //Down
        doublet1(i - 2, j);
        //Left
        doublet2(i, j + 2);
        //Right
        doublet2(i, j - 2);

        return yu;
    }

    public void doublet1(int tempO, int temP) {
        chknAdd(tempO, temP - 1);
        chknAdd(tempO, temP + 1);
    }

    public void doublet2(int tempO, int temP) {
        chknAdd(tempO + 1, temP);
        chknAdd(tempO - 1, temP);
    }

    public void chknAdd(int tempO, int tempP) {
        if (tempO >= 0 && tempO < 8 && tempP >= 0 && tempP < 8) {
            if (!Board.getInstance().getBoard()[tempO][tempP].isFilled()) {
                yu.add(new Move(tempO, tempP));

            }
        }
    }
}
