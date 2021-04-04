package UnitTest;

import Logic.BoardController;
import Logic.HardComputer;
import static Logic.BoardConstants.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HardComputerTest
{
    HardComputer testHardComputer = new HardComputer("EasyComputer");

    String[][] testArrayForSingleMove = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",RED       ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   0    "},
                    {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,RED       ,"   1    "},
                    {"   9    ",RED       ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   2    "},
                    {"   10   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,RED       ,EMPTY     ,EMPTY     ,"   3    "},
                    {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   4    "},
                    {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   5    "},
                    {"   13   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    String[][] testArrayForDoubleMove = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,PURPLE    ,"   0    "},
                    {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                    {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   2    "},
                    {"   10   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   3    "},
                    {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   4    "},
                    {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   5    "},
                    {"   13   ",PURPLE    ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    @Test
    void makeSingleMoveHard()
    {
        List<Integer> singleMoveList = BoardController.listSingleMove(testArrayForSingleMove);
        testHardComputer.makeSingleMove(singleMoveList, testArrayForSingleMove);
        assertEquals(testHardComputer.getSingleMove(), 1);
    }

    @Test
    void makeDoubleMoveEasy()
    {
        List<Integer> doubleMoveList = BoardController.listDoubleMove(testArrayForDoubleMove);
        testHardComputer.makeDoubleMove(doubleMoveList, testArrayForDoubleMove);
        assertTrue(doubleMoveList.contains(testHardComputer.getFirstMove()));
        assertTrue(doubleMoveList.contains(testHardComputer.getSecondMove()));
    }
}
