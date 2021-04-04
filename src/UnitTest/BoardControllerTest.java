package UnitTest;

import org.junit.jupiter.api.Test;
import Logic.BoardController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Logic.BoardConstants.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardControllerTest
{
    String[][] testArray = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ",GREEN     ,EMPTY     ,EMPTY     ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                    {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                    {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                    {"   10   ",EMPTY     ,RED       ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                    {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                    {"   12   ",EMPTY     ,RED       ,EMPTY     ,GREEN     ,PURPLE    ,EMPTY     ,RED       ,"   5    "},
                    {"   13   ",EMPTY     ,GREEN     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };

    @Test
    void singleMoveUp()
    {
        String[][] testArrayUp = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",GREEN     ,RED       ,EMPTY     ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,RED       ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,GREEN     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,EMPTY     ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,PURPLE    ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,EMPTY     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };
        assertEquals(Arrays.deepToString(testArrayUp), Arrays.deepToString(BoardController.singleMove(testArray, 15)));
    }

    @Test
    void singleMoveLeft()
    {
        String[][] testArrayLeft = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",GREEN     ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,EMPTY     ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,RED       ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,RED       ,EMPTY     ,GREEN     ,PURPLE    ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,GREEN     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };

        assertEquals(Arrays.deepToString(testArrayLeft), Arrays.deepToString(BoardController.singleMove(testArray, 0)));
    }

    @Test
    void singleMoveRight()
    {
        String[][] testArrayRight = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",GREEN     ,EMPTY     ,EMPTY     ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,RED       ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,RED       ,GREEN     ,PURPLE    ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,GREEN     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };

        assertEquals(Arrays.deepToString(testArrayRight), Arrays.deepToString(BoardController.singleMove(testArray, 12)));
    }

    @Test
    void singleMoveDown()
    {
        String[][] testArrayDown = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",GREEN     ,EMPTY     ,EMPTY     ,EMPTY     ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,RED       ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,RED       ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,RED       ,EMPTY     ,GREEN     ,PURPLE    ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,GREEN     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };

        assertEquals(Arrays.deepToString(testArrayDown), Arrays.deepToString(BoardController.singleMove(testArray, 24)));
    }

    @Test
    void doubleMove()
    {
        String[][] testArrayForDoubleMove = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",GREEN     ,RED       ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,RED       ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,GREEN     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,EMPTY     ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,PURPLE    ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,EMPTY     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };

        assertEquals(Arrays.deepToString(testArrayForDoubleMove), Arrays.deepToString(BoardController.doubleMove(testArray, 15, 0)));
    }

    @Test
    void listSingleMove()
    {
        List<Integer> singleMoveList = new ArrayList<>();
        singleMoveList = BoardController.listSingleMove(testArray);

        List<Integer> methodMoves = new ArrayList<>();
        for (int move : singleMoveList)
        {
            if (!methodMoves.contains(move))
            {
                methodMoves.add(move);
            }
        }

        List<Integer> testMoves = new ArrayList<>();
        testMoves.add(5);
        testMoves.add(12);
        testMoves.add(15);
        testMoves.add(16);
        testMoves.add(20);
        testMoves.add(21);
        testMoves.add(22);
        testMoves.add(23);
        testMoves.add(26);

        assertEquals(methodMoves, testMoves);
        assertEquals(methodMoves.size(), 9);
    }

    @Test
    void listDoubleMove()
    {
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
        List<Integer> doubleMoveList = new ArrayList<>();
        doubleMoveList = BoardController.listDoubleMove(testArrayForDoubleMove);

        int[] testDoubleMoves = new int[]{0, 14, 0, 14, 0, 21, 0, 21, 13, 20, 13, 20, 13, 27, 13, 27, 14, 0,
                14, 0, 14, 7, 14, 7, 27, 6, 27, 6, 27, 13, 27, 13}; // Every possible move is written twice as the
        // algorithm will count them twice because for every double move, two balls are next to a ball of the same
        // color.

        assertEquals(doubleMoveList.toString(), Arrays.toString(testDoubleMoves));
    }

    @Test
    void checkSingleMove()
    {
        List<Integer> singleMoveList = new ArrayList<>();
        singleMoveList.add(0);
        singleMoveList.add(13);
        singleMoveList.add(22);

        assertTrue(BoardController.checkSingleMove(singleMoveList, 13));
        assertFalse(BoardController.checkSingleMove(singleMoveList, 10));
    }

    @Test
    void checkDoubleMove()
    {
        List<Integer> doubleMoveList = new ArrayList<>();
        doubleMoveList.add(10);
        doubleMoveList.add(25);
        doubleMoveList.add(4);
        doubleMoveList.add(19);

        assertTrue(BoardController.checkDoubleMove(doubleMoveList, 10, 25));
        assertFalse(BoardController.checkDoubleMove(doubleMoveList, 3, 19));
    }

    @Test
    void removeBalls()
    {
        String[][] testArrayBeforeRemoveBalls = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",EMPTY     ,EMPTY     ,RED       ,RED       ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,RED       ,YELLOW    ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,RED       ,YELLOW    ,BLUE      ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,RED       ,YELLOW    ,BLUE      ,BLUE      ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,EMPTY     ,YELLOW    ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };
        String[][] testArrayAfterRemoveBalls = new String[][]
                {
                        {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                        {"   7    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,YELLOW    ,ORANGE    ,EMPTY     ,"   0    "},
                        {"   8    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,"   1    "},
                        {"   9    ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,GREEN     ,ORANGE    ,"   2    "},
                        {"   10   ",EMPTY     ,EMPTY     ,EMPTY     ,ORANGE    ,PURPLE    ,BLUE      ,YELLOW    ,"   3    "},
                        {"   11   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,YELLOW    ,GREEN     ,EMPTY     ,"   4    "},
                        {"   12   ",EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,EMPTY     ,RED       ,"   5    "},
                        {"   13   ",EMPTY     ,EMPTY     ,EMPTY     ,RED       ,ORANGE    ,RED       ,YELLOW    ,"   6    "},
                        {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
                };

        assertEquals(Arrays.deepToString(testArrayAfterRemoveBalls), Arrays.deepToString(BoardController.removeBalls(testArrayBeforeRemoveBalls)));
    }

    @Test
    void copyBoard()
    {
        assertEquals(Arrays.deepToString(BoardController.copyBoard(testArray)), Arrays.deepToString(testArray));
    }
}