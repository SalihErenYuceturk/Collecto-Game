package Logic;

public class Human extends GeneralPlayer
{
    /**
     * Class constructor.
     *
     * @param nameIn Name of the player. A name is chosen regardless of the kind of player.
     * @requires nameIn != null
     */
    public Human(String nameIn)
    {
        this.name = nameIn;
        this.scores.put("score", 0);
        resetScores();
    }

    /**
     * Receives as move from the human player input.
     *
     * @param moveIn An integer from 0 to 27 as the move.
     * @requires moveIn to be a valid move
     * @ensures singleMove is updated to the most current choice
     */
    public void setSingleMove(int moveIn)
    {
        this.singleMove = moveIn;
    }

    /**
     * Receives a double move from the human player input.
     *
     * @param firstMoveIn  The first move.
     * @param secondMoveIn The second move.
     * @requires firstMoveIn and secondMoveIn are valid moves
     * @ensures doubleMove is updated to the most current choice
     */
    public void setDoubleMove(int firstMoveIn, int secondMoveIn)
    {
        this.doubleMove.clear();
        this.doubleMove.add(firstMoveIn);
        this.doubleMove.add(secondMoveIn);
    }
}
