package Logic;

import java.util.*;

public class EasyComputer extends Player
{

    /**
     * Class constructor.
     *
     * @param nameIn Name of the player. A name is chosen regardless of the kind of player.
     */
    public EasyComputer(String nameIn)
    {
        this.name = nameIn;
        resetScores();
    }

    /**
     * The computer player decides on a single move based on the list of possible moves. The easy computer will choose
     * a random move from the list.
     *
     * @param singleMoveListIn List of single moves.
     */
    public void makeSingleMove(List<Integer> singleMoveListIn)
    {
        Random randomNumber = new Random();
        this.singleMove = singleMoveListIn.get(randomNumber.nextInt(singleMoveListIn.size()));
    }

    /**
     * The computer player decides on a double move to make.
     *
     * @param doubleMoveListIn List of double moves.
     */
    public void makeDoubleMove(List<Integer> doubleMoveListIn)
    {
        this.doubleMove.clear();
        Random randomNumber = new Random();
        int randomMove = randomNumber.nextInt(doubleMoveListIn.size());
        if (randomMove % 2 == 1)
        {
            randomMove -= 1;
        }
        this.doubleMove.add(doubleMoveListIn.get(randomMove));
        this.doubleMove.add(doubleMoveListIn.get(randomMove + 1));
    }
}
