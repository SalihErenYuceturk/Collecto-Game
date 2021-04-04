package UnitTest;

import Logic.BoardChecker;
import org.junit.jupiter.api.Test;

import static Logic.BoardConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardCheckerTest
{
    String[][] validBoardArray = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,RED       ,GREEN     ,BLUE      ,GREEN     ,ORANGE    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,PURPLE    ,YELLOW    ,ORANGE    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,YELLOW    ,ORANGE    ,RED       ,GREEN     ,PURPLE    ,RED       ,"   2    "},
                    {"   10   ",PURPLE    ,RED       ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,YELLOW    ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,ORANGE    ,BLUE      ,GREEN     ,YELLOW    ,GREEN     ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,BLUE      ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    String[][] invalidBoardArray1 = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,RED       ,GREEN     ,BLUE      ,GREEN     ,YELLOW    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,PURPLE    ,YELLOW    ,ORANGE    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,YELLOW    ,ORANGE    ,RED       ,GREEN     ,PURPLE    ,PURPLE    ,"   2    "},
                    {"   10   ",RED       ,RED       ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,YELLOW    ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,ORANGE    ,BLUE      ,GREEN     ,YELLOW    ,YELLOW    ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,BLUE      ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    String[][] invalidBoardArray2 = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,RED       ,GREEN     ,BLUE      ,GREEN     ,ORANGE    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,PURPLE    ,YELLOW    ,YELLOW    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,RED       ,ORANGE    ,RED       ,GREEN     ,PURPLE    ,RED       ,"   2    "},
                    {"   10   ",PURPLE    ,RED       ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,EMPTY     ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,ORANGE    ,BLUE      ,GREEN     ,YELLOW    ,GREEN     ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,BLUE      ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    @Test
    void checkBallCount()
    {
        assertTrue(BoardChecker.checkBallCount(validBoardArray));
        assertFalse(BoardChecker.checkBallCount(invalidBoardArray1));
        assertFalse(BoardChecker.checkBallCount(invalidBoardArray2));
    }

    @Test
    void checkArrangement()
    {
        assertTrue(BoardChecker.checkArrangement(validBoardArray));
        assertFalse(BoardChecker.checkArrangement(invalidBoardArray2));
        assertFalse(BoardChecker.checkArrangement(invalidBoardArray2));
    }
}