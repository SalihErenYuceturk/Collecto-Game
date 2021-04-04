package UnitTest;

import Logic.Board;
import Logic.Game;
import Logic.Human;
import static Logic.BoardConstants.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest
{
    Board testBoard = new Board();
    Human testPlayer1 = new Human("mark");
    Human testPlayer2 = new Human("jack");
    Game testGame = new Game(testBoard, testPlayer1, testPlayer2);

    String[][] testArrayLowerScore = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",PURPLE    ,PURPLE    ,GREEN     ,BLUE      ,GREEN     ,ORANGE    ,PURPLE    ,"   0    "},
                    {"   8    ",YELLOW    ,PURPLE    ,YELLOW    ,ORANGE    ,YELLOW    ,BLUE      ,ORANGE    ,"   1    "},
                    {"   9    ",RED       ,YELLOW    ,ORANGE    ,RED       ,GREEN     ,PURPLE    ,RED       ,"   2    "},
                    {"   10   ",PURPLE    ,RED       ,BLUE      ,EMPTY     ,YELLOW    ,ORANGE    ,YELLOW    ,"   3    "},
                    {"   11   ",BLUE      ,YELLOW    ,GREEN     ,ORANGE    ,PURPLE    ,BLUE      ,ORANGE    ,"   4    "},
                    {"   12   ",RED       ,RED       ,BLUE      ,BLUE      ,YELLOW    ,GREEN     ,PURPLE    ,"   5    "},
                    {"   13   ",BLUE      ,RED       ,GREEN     ,BLUE      ,GREEN     ,PURPLE    ,RED       ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    String[][] testArrayHigherScore = new String[][]
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
    void changeTurn()
    {
        assertEquals(testGame.getTurn(), testPlayer1);
        testGame.changeTurn();
        assertEquals(testGame.getTurn(), testPlayer2);
        testGame.changeTurn();
        assertEquals(testGame.getTurn(), testPlayer1);
    }

    @Test
    void getWinner()
    {
        assertNull(testGame.getWinner());
        testPlayer1.updateScore(testArrayLowerScore);
        assertEquals(testGame.getWinner(), testPlayer1);
        assertNotEquals(testGame.getWinner(), testPlayer2);
        testPlayer2.updateScore(testArrayHigherScore);
        assertEquals(testGame.getWinner(), testPlayer2);
        assertNotEquals(testGame.getWinner(), testPlayer1);
    }
}