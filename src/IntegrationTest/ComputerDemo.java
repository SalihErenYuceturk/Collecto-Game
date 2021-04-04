package IntegrationTest;

import Logic.Board;
import Logic.Game;
import Logic.EasyComputer;
import Logic.HardComputer;
import Logic.Player;
import Logic.BoardController;

/*
This is a test of the two computer difficulty levels. 100 games are played and the final result is printed. The
assumption is that the hard difficulty will win most of the games against the easy difficulty and this is indeed the
case.
*/

public class ComputerDemo
{
    public static void main(String[] args)
    {
        int easyComputerVictory = 0;
        int hardComputerVictory = 0;
        int draw = 0;

        for (int i = 0; i < 100; i += 1)
        {
            Board gameBoard = new Board();
            Player player1 = new EasyComputer("Easy Computer");
            Player player2 = new HardComputer("Hard Computer");
            Game game = new Game(gameBoard, player1, player2);

            while (true)
            {
                gameBoard.setSingleMoveList(BoardController.listSingleMove(gameBoard.getBoard()));
                gameBoard.setDoubleMoveList(BoardController.listDoubleMove(gameBoard.getBoard()));

                if (!gameBoard.getSingleMoveList().isEmpty())
                {
                    if (game.getTurn() instanceof EasyComputer)
                    {
                        ((EasyComputer) game.getTurn()).makeSingleMove(gameBoard.getSingleMoveList());
                    }
                    else if (game.getTurn() instanceof HardComputer)
                    {
                        ((HardComputer) game.getTurn()).makeSingleMove(gameBoard.getSingleMoveList(),
                                gameBoard.getBoard());
                    }
                    gameBoard.setBoard(BoardController.singleMove(gameBoard.getBoard(),
                            game.getTurn().getSingleMove()));
                    game.getTurn().updateScore(gameBoard.getBoard());
                    gameBoard.setBoard(BoardController.removeBalls(gameBoard.getBoard()));
                }
                else if (gameBoard.getSingleMoveList().isEmpty() && !gameBoard.getDoubleMoveList().isEmpty())
                {
                    if (game.getTurn() instanceof EasyComputer)
                    {
                        ((EasyComputer) game.getTurn()).makeDoubleMove(gameBoard.getDoubleMoveList());
                    }
                    else if (game.getTurn() instanceof HardComputer)
                    {
                        ((HardComputer) game.getTurn()).makeDoubleMove(gameBoard.getDoubleMoveList());
                    }
                    gameBoard.setBoard(BoardController.doubleMove(gameBoard.getBoard(), game.getTurn().getFirstMove(),
                            game.getTurn().getSecondMove()));
                    gameBoard.setBoard(BoardController.removeBalls(gameBoard.getBoard()));
                }
                else if (gameBoard.getSingleMoveList().isEmpty() && gameBoard.getDoubleMoveList().isEmpty())
                {
                    if (game.getWinner() == null)
                    {
                        draw += 1;
                    }
                    else if (game.getWinner() == player1)
                    {
                        easyComputerVictory += 1;
                    }
                    else if (game.getWinner() == player2)
                    {
                        hardComputerVictory += 1;
                    }
                    break;
                }
                game.changeTurn();
            }
        }

        System.out.println("Easy Computer Wins: " + easyComputerVictory);
        System.out.println("Hard Computer Wins: " + hardComputerVictory);
        System.out.println("Draws: " + draw);
    }
}
