package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static Logic.BoardConstants.*;

public class Board
{
    private String[][] board;
    private List<Integer> singleMoveList = new ArrayList<>();
    private List<Integer> doubleMoveList = new ArrayList<>();

    /**
     * Class constructor.
     */
    public Board()
    {
        this.board = createBoard();
    }

    /**
     * Creates and returns a valid starting board. Uses the helper methods in BoardChecker to ensure a valid board is
     * created.
     *
     * @return A 2D array of string that is a valid game board.
     */
    static String[][] createBoard()
    {
        String[][] board = TEMPLATE;
        boolean isValidBoard = false;
        while (!isValidBoard)
        {
            for (int y = 1; y < (SIZE + 1); y++)
            {
                for (int x = 1; x < (SIZE + 1); x++)
                {
                    if (y == ((SIZE + 1) / 2) && x == ((SIZE + 1) / 2)) // Skip the middle tile.
                    {
                        board[y][x] = EMPTY;
                        continue;
                    }
                    boolean isValidColor = true;
                    while (isValidColor)
                    {
                        int randomColor = new Random().nextInt(6);
                        if (!board[y - 1][x].equals(COLORS[randomColor])
                                && !board[y][x - 1].equals(COLORS[randomColor]))
                        {
                            board[y][x] = COLORS[randomColor];
                            isValidColor = false;
                        }
                    }
                }
            }
            isValidBoard = BoardChecker.isValid(board);
        }
        return board;
    }

    /**
     * Updates the state of the board.
     *
     * @param boardIn The new state of the board.
     */
    public void setBoard(String[][] boardIn)
    {
        this.board = boardIn;
    }

    /**
     * Gives the board.
     *
     * @return The current state of the board.
     */
    public String[][] getBoard()
    {
        return this.board;
    }

    /**
     * Prints the current state of the board to the console.
     */
    public void printBoard()
    {
        System.out.println();
        for (int i = 0; i < 9; i++)
        {
            System.out.println(Arrays.deepToString(board[i]));
        }
    }

    /**
     * Updates the valid single move list.
     *
     * @param singleMoveListIn A new list of valid single moves.
     */
    public void setSingleMoveList(List<Integer> singleMoveListIn)
    {
        singleMoveList.clear();
        this.singleMoveList.addAll(singleMoveListIn);
    }

    /**
     * Gives the current list of valid single moves.
     *
     * @return List of single moves.
     */
    public List<Integer> getSingleMoveList()
    {
        return this.singleMoveList;
    }

    /**
     * Updates the list of valid double moves.
     *
     * @param doubleMoveListIn A new list of valid double moves.
     */
    public void setDoubleMoveList(List<Integer> doubleMoveListIn)
    {
        doubleMoveList.clear();
        this.doubleMoveList.addAll(doubleMoveListIn);
    }

    /**
     * Gives the current list of valid double moves.
     *
     * @return List of double moves.
     */
    public List<Integer> getDoubleMoveList()
    {
        return this.doubleMoveList;
    }
}