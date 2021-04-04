package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Logic.BoardConstants.EMPTY;

public class BoardController {
    /**
     * Makes a single move and returns the resulting board.
     *
     * @param boardIn   The current state of the board.
     * @param direction Move.
     * @return The state of the board after the move has been made.
     * @requires direction to be a valid move and boardIn to be a valid board and current.
     * @ensures A board with the move having been made is returned.
     */
    public static String[][] singleMove(String[][] boardIn, int direction)
    {
        if (direction >= 0 && direction <= 6)
        {
            for (int i = 0; i < 13; i++) {
                for (int x = 2; x < 8; x++)
                {
                    if (boardIn[direction + 1][x - 1].equals(EMPTY))
                    {
                        boardIn[direction + 1][x - 1] = boardIn[direction + 1][x];
                        boardIn[direction + 1][x] = EMPTY;
                    }
                }
            }
        }
        if (direction >= 7 && direction <= 13)
        {
            for (int i = 0; i < 13; i++) {
                for (int x = 6; x > 0; x--)
                {
                    if (boardIn[direction - 6][x + 1].equals(EMPTY))
                    {
                        boardIn[direction - 6][x + 1] = boardIn[direction - 6][x];
                        boardIn[direction - 6][x] = EMPTY;
                    }
                }
            }
        }
        if (direction >= 14 && direction <= 20)
        {
            for (int i = 0; i < 13; i++)
            {
                for (int y = 2; y < 8; y++)
                {
                    if (boardIn[y - 1][direction - 13].equals(EMPTY))
                    {
                        boardIn[y - 1][direction - 13] = boardIn[y][direction - 13];
                        boardIn[y][direction - 13] = EMPTY;
                    }
                }
            }
        }
        if (direction >= 21 && direction <= 27)
        {
            for (int i = 0; i < 13; i++) {
                for (int y = 6; y > 0; y--)
                {
                    if (boardIn[y + 1][direction - 20].equals(EMPTY))
                    {
                        boardIn[y + 1][direction - 20] = boardIn[y][direction - 20];
                        boardIn[y][direction - 20] = EMPTY;
                    }
                }
            }
        }
        return boardIn;
    }

    /**
     * Makes a double move and returns the resulting board.
     *
     * @param boardIn         The current state of the board.
     * @param firstDirection  First move.
     * @param secondDirection Second move.
     * @return The state of the board after the double move has been made.
     * @requires firstDirection and secondDirection to be valid moves
     * and boardIn to be a valid board and current.
     * @ensures A board with the moves having been made is returned.
     */
    public static String[][] doubleMove(String[][] boardIn, int firstDirection, int secondDirection)
    {
        singleMove(boardIn, firstDirection);
        singleMove(boardIn, secondDirection);
        return boardIn;
    }

    /**
     * Creates a list of valid single moves for the current board.
     *
     * @param boardIn The current state of the board.
     * @return A list of valid single moves.
     * @requires boardIn to be valid and current.
     * @ensures The returned list is valid.
     */
    public static List<Integer> listSingleMove(String[][] boardIn)
    {
        List<Integer> singleMoveList = new ArrayList<>();
        for (int direction = 0; direction < 28; direction++)
        {
            String[][] imaginaryBoard = copyBoard(boardIn);
            imaginaryBoard = singleMove(imaginaryBoard, direction);

            for (int y = 1; y < 8; y++)
            {
                for (int x = 1; x < 8; x++)
                {
                    // If one tile after the potential move is the same as another touching tile, the move is valid.
                    if (!imaginaryBoard[y][x].equals(EMPTY)
                            && (imaginaryBoard[y][x].equals(imaginaryBoard[y + 1][x])
                            || imaginaryBoard[y][x].equals(imaginaryBoard[y - 1][x])
                            || imaginaryBoard[y][x].equals(imaginaryBoard[y][x + 1])
                            || imaginaryBoard[y][x].equals(imaginaryBoard[y][x - 1])))
                    {
                        singleMoveList.add(direction);
                    }
                }
            }
        }
        return singleMoveList;
    }

    /**
     * Creates a list of valid double moves for the current board.
     *
     * @param boardIn The current state of the board.
     * @return A list of valid double moves.
     * @requires boardIn is valid and current.
     * @ensures The returned list is valid.
     */
    public static List<Integer> listDoubleMove(String[][] boardIn)
    {
        List<Integer> doubleMoveList = new ArrayList<>();
        for (int firstDirection = 0; firstDirection < 28; firstDirection++)
        {
            for (int secondDirection = 0; secondDirection < 28; secondDirection++)
            {
                String[][] imaginaryBoard = copyBoard(boardIn);
                imaginaryBoard = doubleMove(imaginaryBoard, firstDirection, secondDirection);

                for (int y = 1; y < 8; y++)
                {
                    for (int x = 1; x < 8; x++)
                    {
                        // If one tile after the potential move is the same as another touching tile, the move is valid.
                        if (!imaginaryBoard[y][x].equals(EMPTY)
                                && (imaginaryBoard[y][x].equals(imaginaryBoard[y + 1][x])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y - 1][x])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y][x + 1])
                                || imaginaryBoard[y][x].equals(imaginaryBoard[y][x - 1])))
                        {
                            doubleMoveList.add(firstDirection);
                            doubleMoveList.add(secondDirection);
                        }
                    }
                }
            }
        }
        return doubleMoveList;
    }

    /**
     * Checks if the single move that has been chosen is
     * valid by comparing it to the list of valid double moves.
     *
     * @param singleMoveListIn List of valid single moves.
     * @param direction        Single move.
     * @return true if the move is valid, else false.
     * @requires singleMoveListIn to be valid
     */
    public static boolean checkSingleMove(List<Integer> singleMoveListIn, int direction)
    {
        return singleMoveListIn.contains(direction);
    }

    /**
     * Checks if the double move that has been chosen is valid by comparing
     * it to the list of valid double moves.
     *
     * @param doubleMoveListIn List of valid double moves.
     * @param firstDirection   First move.
     * @param secondDirection  Second move.
     * @return true if the double move is valid, else false.
     * @requires doubleMoveListIn to be valid
     */
    public static boolean checkDoubleMove(List<Integer> doubleMoveListIn, int firstDirection, int secondDirection)
    {
        for (int i = 0; i < doubleMoveListIn.size(); i += 2)
        {
            if (doubleMoveListIn.get(i) == firstDirection
                    && doubleMoveListIn.get(i + 1) == secondDirection)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the balls with the same colors that touch.
     * Every tile is compared to the ones around it, and if two
     * colors are the same, that tile is put in a list. All balls
     * in the list are then removed.
     *
     * @param boardIn The current state of the board.
     * @return The board after the balls have been removed.
     * @requires boardIn to be a board that is valid and in a state
     * after a move or double move has been made, thus with
     * touching colors.
     * @ensures All the balls of the same colors that touch have been removed from the board.
     */
    public static String[][] removeBalls(String[][] boardIn)
    {
        // Space to store balls that will be removed.
        int[] yCoordinates = new int[50];
        int[] xCoordinates = new int[50];
        int arrayIndex = 0;

        // Identify which balls should be removed.
        for (int y = 1; y < 8; y++)
        {
            for (int x = 1; x < 8; x++)
            {
                if (!boardIn[y][x].equals(EMPTY))
                {
                    if (boardIn[y][x].equals(boardIn[y + 1][x])
                            || boardIn[y][x].equals(boardIn[y - 1][x])
                            || boardIn[y][x].equals(boardIn[y][x + 1])
                            || boardIn[y][x].equals(boardIn[y][x - 1]))
                    {
                        yCoordinates[arrayIndex] = y;
                        xCoordinates[arrayIndex] = x;
                        arrayIndex += 1;
                    }
                }
            }
        }

        for (int i = 0; i < 50; i++)
        {
            boardIn[yCoordinates[i]][xCoordinates[i]] = EMPTY;
        }
        return boardIn;
    }

    /**
     * Gives a hint to the player during the game, if the
     * player enters -1 as a move. The method returns a random
     * valid move. It prints a single move if a single move can
     * be made. If no single moves can be made, it prints a double
     * move.
     *
     * @param singleMoveListIn The list of valid single moves.
     * @param doubleMoveListIn The list of valid double moves.
     * @requires both singleMoveListIn and doubleMoveListIn are either empty or have valid moves.
     * @ensures A hint is printed on the console.
     */
    public static void getHint(List<Integer> singleMoveListIn, List<Integer> doubleMoveListIn)
    {
        if (!singleMoveListIn.isEmpty())
        {
            Random randomNumber = new Random();
            System.out.println("Hint: " + singleMoveListIn.get(randomNumber.nextInt(singleMoveListIn.size())));
        }
        else
        {
            Random randomNumber = new Random();
            int randomMove = randomNumber.nextInt(doubleMoveListIn.size());
            if (randomMove % 2 == 1)
            {
                randomMove -= 1;
            }
            System.out.println("Hint: " + doubleMoveListIn.get(randomMove) + " and " + doubleMoveListIn.get(randomMove + 1));
        }
    }

    /**
     * Creates a copy of the board to be used in other methods.
     *
     * @param boardIn The current state of the board.
     * @return A copy of the board.
     * @requires boardIn to be not null, be a valid board and the respect the template.
     * @ensures A copy of boardIn is made that does not point to the same place in the
     * memory as the original.
     */
    public static String[][] copyBoard(String[][] boardIn)
    {
        String[][] boardCopy = new String[9][9];
        for (int y = 0; y < 9; y++)
        {
            for (int x = 0; x < 9; x++)
            {
                boardCopy[y][x] = boardIn[y][x];
            }
        }
        return boardCopy;
    }
}
