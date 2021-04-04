package Logic;

import static Logic.BoardConstants.*;

public class Game
{
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    /**
     * The class constructor.
     *
     * @param boardIn A valid starting board.
     * @param player1In The first player.
     * @param player2In The second player.
     */
    public Game(Board boardIn, Player player1In, Player player2In)
    {
        this.board = boardIn;
        this.player1 = player1In;
        this.player2 = player2In;
        this.currentPlayer = player1;
    }

    /**
     * Changes the turn of the player. To be used at the end of every turn.
     */
    public void changeTurn()
    {
        if (currentPlayer == player1)
        {
            currentPlayer = player2;
        }
        else if (currentPlayer == player2)
        {
            currentPlayer = player1;
        }
    }

    /**
     * Returns the player whose turn it is.
     *
     * @return The player object assigned as the current player.
     */
    public Player getTurn()
    {
        return currentPlayer;
    }

    /**
     * Returns a player as the winner. The scores are compared. If they are the same, the number of balls that don't
     * result in a score are compared for each player. If this is also the same, the game is a draw.
     *
     * @return Player if one has won, null if a draw.
     */
    public Player getWinner()
    {
        int player1Score = player1.getScore().get("score");
        int player2Score = player2.getScore().get("score");
        if (player1Score == player2Score)
        {
            player1Score = (player1.getScore().get(BLUE) - (3 * (player1.getScore().get(BLUE) / 3)))
                    + (player1.getScore().get(YELLOW) - (3 * (player1.getScore().get(YELLOW) / 3)))
                    + (player1.getScore().get(RED) - (3 * (player1.getScore().get(RED) / 3)))
                    + (player1.getScore().get(ORANGE) - (3 * (player1.getScore().get(ORANGE) / 3)))
                    + (player1.getScore().get(PURPLE) - (3 * (player1.getScore().get(PURPLE) / 3)))
                    + (player1.getScore().get(GREEN) - (3 * (player1.getScore().get(GREEN) / 3)));
            player2Score = (player2.getScore().get(BLUE) - (3 * (player2.getScore().get(BLUE) / 3)))
                    + (player2.getScore().get(YELLOW) - (3 * (player2.getScore().get(YELLOW) / 3)))
                    + (player2.getScore().get(RED) - (3 * (player2.getScore().get(RED) / 3)))
                    + (player2.getScore().get(ORANGE) - (3 * (player2.getScore().get(ORANGE) / 3)))
                    + (player2.getScore().get(PURPLE) - (3 * (player2.getScore().get(PURPLE) / 3)))
                    + (player2.getScore().get(GREEN) - (3 * (player2.getScore().get(GREEN) / 3)));
            if (player1Score > player2Score) {
                return player1;
            }
            else if (player2Score > player1Score)
            {
                return player2;
            }
            else
            {
                return null;
            }
        }
        else if (player1Score > player2Score)
        {
            return player1;
        }
        return player2;
    }
}
