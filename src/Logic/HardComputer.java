package Logic;

import java.util.*;

import static Logic.BoardConstants.*;

public class HardComputer extends GeneralPlayer
{

    /**
     * Class constructor.
     *
     * @param nameIn Name of the player. A name is chosen regardless of the kind of player.
     * @requires nameIn != null
     */
    public HardComputer(String nameIn)
    {
        this.name = nameIn;
        resetScores();
    }

    /**
     * The computer player decides on a single move based on the list of possible moves.
     * The hard computer will choose a move that removes the most balls from the list.
     *
     * @param singleMoveListIn List of single moves.
     * @param boardIn          State of the game board.
     * @requires singleMoveListIn and boardIn are both valid and current
     * @ensures a valid move is chosen and singleMove is updated to the most current choice
     */
    public void makeSingleMove(List<Integer> singleMoveListIn, String[][] boardIn)
    {
        HashMap<Integer, Integer> moveResult = new HashMap<Integer, Integer>();
        int moveResultIndex = 0;

        for (int move : singleMoveListIn)
        {
            String[][] imaginaryBoard = BoardController.copyBoard(boardIn);
            imaginaryBoard = BoardController.singleMove(imaginaryBoard, move);
            int numberOfBallsRemoved = 0;

            for (int y = 1; y < 8; y++)
            {
                for (int x = 1; x < 8; x++)
                {
                    if (!imaginaryBoard[y][x].equals(EMPTY))
                    {
                        if (imaginaryBoard[y][x].equals(imaginaryBoard[y + 1][x])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y - 1][x])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y][x + 1])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y][x - 1]))
                        {
                            numberOfBallsRemoved += 1;
                        }
                    }
                }
            }
            moveResult.put(moveResultIndex, numberOfBallsRemoved);
            moveResultIndex += 1;
        }
        ArrayList<Integer> moveResultValues = new ArrayList<Integer>(moveResult.values());
        int maximumNumberOfBallsRemoved = Collections.max(moveResultValues);
        this.singleMove = singleMoveListIn.get(moveResultValues.indexOf(maximumNumberOfBallsRemoved));
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
