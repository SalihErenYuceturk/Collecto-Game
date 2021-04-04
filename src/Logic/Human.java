package Logic;

public class Human extends Player
{
    /**
     * Class constructor.
     *
     * @param nameIn Name of the player. A name is chosen regardless of the kind of player.
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
     */
    public void setDoubleMove(int firstMoveIn, int secondMoveIn)
    {
        this.doubleMove.clear();
        this.doubleMove.add(firstMoveIn);
        this.doubleMove.add(secondMoveIn);
    }
}
