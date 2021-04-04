package UnitTest;

import Logic.BoardController;
import org.junit.jupiter.api.Test;
import Logic.Board;

import static Logic.BoardConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    String[][] testArray = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,YELLOW    ,GREEN     ,BLUE      ,GREEN     ,ORANGE    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,ORANGE    ,YELLOW    ,ORANGE    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,YELLOW    ,ORANGE    ,RED       ,GREEN     ,PURPLE    ,RED       ,"   2    "},
                    {"   10   ",PURPLE    ,RED       ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,YELLOW    ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,GREEN     ,BLUE      ,BLUE      ,YELLOW    ,GREEN     ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,ORANGE    ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    @Test
    void createBoard()
    {
        Board testBoard = new Board();

        String[][] initialArray = testBoard.getBoard();
        String[][] checkedArray = BoardController.removeBalls(testBoard.getBoard());

        // If after applying the removeBalls method on the initial
        // board it is still the same, then the board must be valid.
        // This is assuming that the number of balls of each color
        // are correct and the middle is empty. These two have been
        // tested on BordCheckerTest. With these three tests passed,
        // the initialisation algorithm is guaranteed to give a valid board.
        assertArrayEquals(initialArray, checkedArray);
    }
}