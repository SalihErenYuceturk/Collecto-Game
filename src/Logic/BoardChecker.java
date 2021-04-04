package Logic;

import static Logic.BoardConstants.*;

public class BoardChecker
{
    /**
     * Checks that the correct number of each ball is present on the board.
     *
     * @param boardIn The board to be checked.
     * @return true if correct, else false.
     */
    public static boolean checkBallCount(String[][] boardIn)
    {
        int greenCount = 8;
        int blueCount = 8;
        int yellowCount = 8;
        int purpleCount = 8;
        int redCount = 8;
        int orangeCount = 8;
        int emptyCount = 1;
        for (int y = 0; y < SIZE + 2; y++)
        {
            for (int x = 0; x < SIZE + 2; x++)
            {
                if (y != 0 && x != 0 && x != (SIZE + 1) && y != (SIZE + 1))
                {
                    if (greenCount > 0 && boardIn[y][x].equals(GREEN))
                    {
                        greenCount -= 1;
                    }
                    else if (blueCount > 0 && boardIn[y][x].equals(BLUE))
                    {
                        blueCount -= 1;
                    }
                    else if (yellowCount > 0 && boardIn[y][x].equals(YELLOW))
                    {
                        yellowCount -= 1;
                    }
                    else if (purpleCount > 0 && boardIn[y][x].equals(PURPLE))
                    {
                        purpleCount -= 1;
                    }
                    else if (redCount > 0 && boardIn[y][x].equals(RED))
                    {
                        redCount -= 1;
                    }
                    else if (orangeCount > 0 && boardIn[y][x].equals(ORANGE))
                    {
                        orangeCount -= 1;
                    }
                    else if (emptyCount > 0 && boardIn[y][x].equals(EMPTY))
                    {
                        emptyCount -= 1;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks that no two balls of the same color touch.
     *
     * @param boardIn Board to be checked.
     * @return true if no two same colors touch, else false.
     */
    public static boolean checkArrangement(String[][] boardIn)
    {
        for (int y = 1; y < 8; y++)
        {
            for (int x = 1; x < 8; x++)
            {
                if (!boardIn[y][x].equals(EMPTY)
                        && (boardIn[y][x].equals(boardIn[y + 1][x])
                        || boardIn[y][x].equals(boardIn[y - 1][x])
                        || boardIn[y][x].equals(boardIn[y][x + 1])
                        || boardIn[y][x].equals(boardIn[y][x - 1])))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks that both methods that check a valid board return true.
     *
     * @param boardIn Board to be checked.
     * @return true if the board is valid, else false.
     */
    public static boolean isValid(String[][] boardIn)
    {
        return checkBallCount(boardIn) && checkArrangement(boardIn);
    }
}
