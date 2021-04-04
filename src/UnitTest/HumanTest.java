package UnitTest;

import Logic.Human;
import org.junit.jupiter.api.Test;

import static Logic.BoardConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest
{
    Human testHuman = new Human("Human");
    String[][] testArrayForScore = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,PURPLE    ,GREEN     ,BLUE      ,GREEN     ,ORANGE    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,PURPLE    ,YELLOW    ,ORANGE    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,YELLOW    ,ORANGE    ,RED       ,YELLOW    ,PURPLE    ,RED       ,"   2    "},
                    {"   10   ",PURPLE    ,BLUE      ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,YELLOW    ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,RED       ,BLUE      ,BLUE      ,YELLOW    ,GREEN     ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,BLUE      ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    @Test
    void updateScore()
    {
        assertEquals(testHuman.getScore().get("score"), 0);
        assertEquals(testHuman.getScore().get(BLUE), 0);
        assertEquals(testHuman.getScore().get(YELLOW), 0);
        assertEquals(testHuman.getScore().get(RED), 0);
        assertEquals(testHuman.getScore().get(ORANGE), 0);
        assertEquals(testHuman.getScore().get(PURPLE), 0);
        assertEquals(testHuman.getScore().get(GREEN), 0);

        testHuman.updateScore(testArrayForScore);

        assertEquals(testHuman.getScore().get("score"), 4);
        assertEquals(testHuman.getScore().get(BLUE), 5);
        assertEquals(testHuman.getScore().get(YELLOW), 3);
        assertEquals(testHuman.getScore().get(RED), 3);
        assertEquals(testHuman.getScore().get(ORANGE), 0);
        assertEquals(testHuman.getScore().get(PURPLE), 3);
        assertEquals(testHuman.getScore().get(GREEN), 0);
    }
}