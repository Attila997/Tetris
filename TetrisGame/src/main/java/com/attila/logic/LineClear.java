package com.attila.logic;

/**
 * Class for the line clears.
 */
public class LineClear {

    /**
     * Number of the removed lines.
     */
    private final int linesRemoved;
    /**
     * Matrix after line clear.
     */
    private final int[][] newMatrix;
    /**
     * The score bonus after line clear.
     */
    private final int scoreBonus;

    /**
     * Assigment constructor.
     * @param linesRemoved Number of the removed lines
     * @param newMatrix Matrix after line clear
     * @param scoreBonus The score bonus after line clear
     */
    public LineClear(int linesRemoved, int[][] newMatrix, int scoreBonus) {
        this.linesRemoved = linesRemoved;
        this.newMatrix = newMatrix;
        this.scoreBonus = scoreBonus;
    }

    /**
     *
     * @return number of removed lines
     */
    public int getLinesRemoved() {
        return linesRemoved;
    }

    /**
     *
     * @return the Matrix of the gamaboard
     */
    public int[][] getNewMatrix() {
        return MatrixMath.copy(newMatrix);
    }

    /**
     *
     * @return value of the score
     */
    public int getScoreBonus() {
        return scoreBonus;
    }

}
