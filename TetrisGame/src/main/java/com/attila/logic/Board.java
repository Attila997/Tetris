package com.attila.logic;

/**
 * Abstract interface for the board.
 */
public interface Board {
    /**
     * Prepare the game.
     */
    void newGame();

    /**
     * Új formát hoz létre.
     * @return a visszaadott értéket a {@code GameController.downEvent} használni,
     * ha {@code createNewShape} igaz értéket ad vissza akkor a forma lemozgása megáll,
     * hamis esetén minden folytatódik
     */
    boolean createNewShape();

    /**
     * Move a shape left.
     * @return true, if the shape not able to move left, else if it can.
     */
    boolean moveShapeLeft();

    /**
     * Move a shape right.
     * @return true, if the shape not able to move right, else if it can.
     */
    boolean moveShapeRight();

    /**
     * Move a shape down.
     * @return true, if the shape not able to move down, else if it can.
     */
    boolean moveShapeDown();

    /**
     * Rotate the shape.
     * @return true, if the shape not able to be rotated, else if it can be.
     */
    boolean rotateShapeLeft();

    /**
     *
     * @return {@link ShapeData}.
     */
    ShapeData getShapeData();

    /**
     *
     * @return the Matrix of the gameboard.
     */
    int[][] getGameBoard();

    /**
     * Merge the shape into the board.
     */
    void pushShapeToBackgroud();

    /**
     * Check the fulled lines and set the gameboard to the updated gameboard.
     * @return {@link LineClear}
     */
    LineClear lineClear();

    /**
     * Return the score.
     * @return {@link Score}
     */
    Score getScore();

}
