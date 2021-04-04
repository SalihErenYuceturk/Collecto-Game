package Logic;

import static Logic.BoardConstants.*;


import java.util.*;

public class GeneralPlayer
{
    String name;
    HashMap<String, Integer> scores = new HashMap<String, Integer>();
    int singleMove;
    List<Integer> doubleMove = new ArrayList<>();

    /**
     * Class constructor.
     */
    public GeneralPlayer() { }

    /**
     * Gives the name assigned to the player.
     *
     * @return The name of the player.
     * @requires name != null
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Assigns/changes the name of the player.
     *
     * @param nameIn Name of the player.
     * @requires name!= null
     */
    public void setName(String nameIn)
    {
        this.name = nameIn;
    }

    /**
     * Returns a hashmap with the the score and number of balls of the player.
     *
     * @return Score log.
     * @requires scores has all correct string key and integer values
     */
    public HashMap<String, Integer> getScore()
    {
        return scores;
    }

    /**
     * Resets the score log in case the players start a rematch on the same connection.
     *
     * @requires scores has string keys and integer values
     * @ensures The scores hashmap has the correct keys and zero score values.
     */
    public void resetScores()
    {
        this.scores.put("score", 0);
        this.scores.put(BLUE, 0);
        this.scores.put(YELLOW, 0);
        this.scores.put(RED, 0);
        this.scores.put(ORANGE, 0);
        this.scores.put(PURPLE, 0);
        this.scores.put(GREEN, 0);
    }

    /**
     * Updates the score of the current player after a move has been made.
     *
     * @param boardIn Current instance of the game board.
     * @requires a valid move that results in at least two balls of the same
     * color to touch has been made
     * @ensures for each ball of the same color that touch, a point is added to
     * that ball and the overall score is updated.
     */
    public void updateScore(String[][] boardIn)
    {
        String[][] board = BoardController.copyBoard(boardIn);

        for (int y = 1; y < 8; y++)
        {
            for (int x = 1; x < 8; x++)
            {
                if (!board[y][x].equals(EMPTY))
                {
                    if (board[y][x].equals(board[y + 1][x])
                            || board[y][x].equals(board[y - 1][x])
                            || board[y][x].equals(board[y][x + 1])
                            || board[y][x].equals(board[y][x - 1]))
                    {
                        switch (board[y][x])
                        {
                            case BLUE:
                                this.scores.put(BLUE, scores.get(BLUE) + 1);
                                break;
                            case YELLOW:
                                this.scores.put(YELLOW, scores.get(YELLOW) + 1);
                                break;
                            case RED:
                                this.scores.put(RED, scores.get(RED) + 1);
                                break;
                            case ORANGE:
                                this.scores.put(ORANGE, scores.get(ORANGE) + 1);
                                break;
                            case PURPLE:
                                this.scores.put(PURPLE, scores.get(PURPLE) + 1);
                                break;
                            case GREEN:
                                this.scores.put(GREEN, scores.get(GREEN) + 1);
                                break;
                        }
                    }
                }
            }
        }

        this.scores.put("score", (scores.get(BLUE) / 3) + (scores.get(YELLOW) / 3) + (scores.get(RED) / 3) + (scores.get(ORANGE) / 3) + (scores.get(PURPLE) / 3) + (scores.get(GREEN) / 3));
    }

    /**
     * Prints the information of the player to be displayed under the board.
     *
     * @requires the scores hashmap to have the correct type of keys and values
     */
    public void printPlayer()
    {
        System.out.println("Player: " + name + "\n" + "Score: " + scores.get("score") + "\n" + "blue: " + scores.get(BLUE) + "  yellow: " + scores.get(YELLOW) + "  red: " + scores.get(RED) + "  orange: " + scores.get(ORANGE) + "  purple: " + scores.get(PURPLE) + "  green: " + scores.get(GREEN));
    }

    /**
     * Returns the single move that has either been set by the human or decided by the computer.
     *
     * @return An integer from 0 to 27.
     * @requires singleMove to be valid and current
     */
    public int getSingleMove()
    {
        return this.singleMove;
    }

    /**
     * Returns the first move of a double move.
     *
     * @return An integer from 0 to 27.
     * @requires doubleMove.get(0) to be a valid first move and current
     */
    public int getFirstMove()
    {
        return doubleMove.get(0);
    }

    /**
     * Returns the second move of a double move.
     *
     * @return An integer from 0 to 27.
     * @requires doubleMove.get(1) to be a valid second move and current
     */
    public int getSecondMove()
    {
        return doubleMove.get(1);
    }
}
