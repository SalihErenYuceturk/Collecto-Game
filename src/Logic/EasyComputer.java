package Logic;

import java.util.*;

public class EasyComputer extends GeneralPlayer
{

    /**
     * Class constructor.
     *
     * @param nameIn Name of the player. A name is chosen regardless of the kind of player.
     * @requires nameIn != null
     */
    public EasyComputer(String nameIn)
    {
        this.name = nameIn;
        resetScores();
    }

    /**
     * The computer player decides on a single move based on the list of possible
     * moves. The easy computer will choose a random move from the list.
     *
     * @param singleMoveListIn List of single moves.
     * @param boardIn          State of the game board.
     * @requires singleMoveListIn and boardIn are both valid and current
     * @ensures a valid move is chosen and singleMove is updated to the most current choice
     */
    public void makeSingleMove(List<Integer> singleMoveListIn, String[][] boardIn)
    {
        Random randomNumber = new Random();
        this.singleMove = singleMoveListIn.get(randomNumber.nextInt(singleMoveListIn.size()));
    }

    /**
     * The computer player decides on a double move to make.
     *
     * @param doubleMoveListIn List of double moves.
     * @param boardIn          State of the game board.
     * @requires doubleMoveListIn and boardIn are both valid and current.
     * @ensures doubleMove is updated with a valid double move.
     */
    public void makeDoubleMove(List<Integer> doubleMoveListIn, String[][] boardIn)
    {
        String[][] imaginaryBoard = BoardController.copyBoard(boardIn);
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
