package com.attila.logic;

public class LineClear {
    //blank final - construktorral lesz inicializalva
    private final int linesRemoved;
    private final int[][] newMatrix;
    private final int scoreBonus;

    public LineClear(int linesRemoved, int[][] newMatrix, int scoreBonus) {
        this.linesRemoved = linesRemoved;
        this.newMatrix = newMatrix;
        this.scoreBonus = scoreBonus;
    }

    public int getLinesRemoved() {
        return linesRemoved;
    }

    public int[][] getNewMatrix() {
        return MatrixMath.copy(newMatrix);
    }

    public int getScoreBonus() {
        return scoreBonus;
    }

}
