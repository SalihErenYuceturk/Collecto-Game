package IntegrationTest;

import Logic.Board;
import Logic.Game;
import Logic.GeneralPlayer;
import Logic.EasyComputer;
import Logic.HardComputer;
import Logic.Human;
import Logic.BoardController;

import java.util.Scanner;

public class GameDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Collecto Game");

        System.out.println("Choose Player 1:");
        System.out.println("[1] Human");
        System.out.println("[2] Computer (Easy)");
        System.out.println("[3] Computer (Hard)");
        int player1Choice = keyboard.nextInt();
        System.out.print("Enter Player 1 Name: ");
        keyboard.nextLine();
        String player1Name = keyboard.nextLine();

        System.out.println("Choose Player 2:");
        System.out.println("[1] Human");
        System.out.println("[2] Computer (Easy)");
        System.out.println("[3] Computer (Hard)");
        int player2Choice = keyboard.nextInt();
        System.out.print("Enter Player 2 Name: ");
        keyboard.nextLine();
        String player2Name = keyboard.nextLine();

        GeneralPlayer player1 = null;
        GeneralPlayer player2 = null;

        switch (player1Choice)
        {
            case 1:
                player1 = new Human(player1Name);
                break;
            case 2:
                player1 = new EasyComputer(player1Name);
                break;
            case 3:
                player1 = new HardComputer(player1Name);
                break;
        }

        switch (player2Choice)
        {
            case 1:
                player2 = new Human(player2Name);
                break;
            case 2:
                player2 = new EasyComputer(player2Name);
                break;
            case 3:
                player2 = new HardComputer(player2Name);
                break;
        }

        int turn = 0;
        Board gameBoard = new Board();
        Game game = new Game(gameBoard, player1, player2);

        while (true)
        {
            turn += 1;
            System.out.println("\n" + "\n" + "------------------------------------------------------------------------------------------");
            System.out.println("Turn: " + turn);
            gameBoard.printBoard();
            game.getTurn().printPlayer();

            gameBoard.setSingleMoveList(BoardController.listSingleMove(gameBoard.getBoard()));
            gameBoard.setDoubleMoveList(BoardController.listDoubleMove(gameBoard.getBoard()));

            if (!gameBoard.getSingleMoveList().isEmpty())
            {
                if (game.getTurn() instanceof Human)
                {
                    System.out.println("Make a move (-1 for hint).");
                    System.out.print("Move: ");
                    int singleMove = keyboard.nextInt();
                    while (singleMove == -1)
                    {
                        BoardController.getHint(gameBoard.getSingleMoveList(), gameBoard.getDoubleMoveList());
                        System.out.println("Make a move (-1 for hint).");
                        System.out.print("Move: ");
                        singleMove = keyboard.nextInt();
                    }
                    ((Human) game.getTurn()).setSingleMove(singleMove);
                }
                else if (game.getTurn() instanceof EasyComputer)
                {
                    ((EasyComputer) game.getTurn()).makeSingleMove(gameBoard.getSingleMoveList(), gameBoard.getBoard());
                } else if (game.getTurn() instanceof HardComputer) {
                    ((HardComputer) game.getTurn()).makeSingleMove(gameBoard.getSingleMoveList(), gameBoard.getBoard());
                }
                if (BoardController.checkSingleMove(gameBoard.getSingleMoveList(), game.getTurn().getSingleMove()))
                {
                    gameBoard.setBoard(BoardController.singleMove(gameBoard.getBoard(), game.getTurn().getSingleMove()));
                    game.getTurn().updateScore(gameBoard.getBoard());
                    gameBoard.setBoard(BoardController.removeBalls(gameBoard.getBoard()));
                }
                else
                {
                    System.out.println("\n" + "Error: Invalid move.");
                    game.changeTurn();
                }
            }
            else if (gameBoard.getSingleMoveList().isEmpty() && !gameBoard.getDoubleMoveList().isEmpty())
            {
                if (game.getTurn() instanceof Human)
                {
                    System.out.println("Make a double move (both -1 for hint).");
                    System.out.print("Move 1: ");
                    int firstMove = keyboard.nextInt();
                    System.out.print("Move 2: ");
                    int secondMove = keyboard.nextInt();
                    while (firstMove == -1 && secondMove == -1)
                    {
                        BoardController.getHint(gameBoard.getSingleMoveList(), gameBoard.getDoubleMoveList());
                        System.out.println("Make a double move (both -1 for hint).");
                        System.out.print("Move 1: ");
                        firstMove = keyboard.nextInt();
                        System.out.print("Move 2: ");
                        secondMove = keyboard.nextInt();
                    }
                    ((Human) game.getTurn()).setDoubleMove(firstMove, secondMove);
                }
                else if (game.getTurn() instanceof EasyComputer)
                {
                    ((EasyComputer) game.getTurn()).makeDoubleMove(gameBoard.getDoubleMoveList(), gameBoard.getBoard());
                }
                else if (game.getTurn() instanceof HardComputer)
                {
                    ((HardComputer) game.getTurn()).makeDoubleMove(gameBoard.getDoubleMoveList(), gameBoard.getBoard());
                }
                if (BoardController.checkDoubleMove(gameBoard.getDoubleMoveList(), game.getTurn().getFirstMove(), game.getTurn().getSecondMove()))
                {
                    gameBoard.setBoard(BoardController.doubleMove(gameBoard.getBoard(), game.getTurn().getFirstMove(), game.getTurn().getSecondMove()));
                    gameBoard.setBoard(BoardController.removeBalls(gameBoard.getBoard()));
                }
                else
                {
                    System.out.println("\n" + "Error: Invalid move.");
                    game.changeTurn();
                }
            }
            else if (gameBoard.getSingleMoveList().isEmpty() && gameBoard.getDoubleMoveList().isEmpty())
            {
                System.out.println("\n" + "\n" + "------------------------------------------------------------------------------------------");
                System.out.println("Game Over!");
                if (game.getWinner() == null)
                {
                    System.out.println("Draw");
                }
                else
                {
                    System.out.println("Winner: " + game.getWinner().getName() + "\n");
                    game.getWinner().printPlayer();
                }
                break;
            }
            game.changeTurn();
        }
    }
}