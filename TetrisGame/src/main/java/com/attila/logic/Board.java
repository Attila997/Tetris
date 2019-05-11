package com.attila.logic;

public interface Board {
    /**
     * Előkésziti a táblát az új játékra
     */
    void newGame();

    /**
     * Létrehoz egy uj formát
     * @return
     */
    boolean createNewShape();

    boolean moveShapeLeft();

    boolean moveShapeRight();

    boolean moveShapeDown();

    boolean rotateShapeLeft();

    ShapeData getShapeData();

    int[][] getGameBoard();

    void pushShapeToBackgroud();

    LineClear lineClear();

    Score getScore();

}
