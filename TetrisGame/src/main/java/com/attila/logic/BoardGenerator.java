package com.attila.logic;

import com.attila.logic.shapes.Shape;
import com.attila.logic.shapes.ShapeGenerator;

import java.awt.*;

/**
 * Generate the board.
 */
public class BoardGenerator implements Board{
    /**
     * Height of the board.
     */
    private final int boardHeight;

    /**
     * Width of the board.
     */
    private final int boardWidth;

    /**
     * Shape generator.
     */
    private final ShapeGenerator shapeGenerator;

    /**
     * The game board.
     */
    private int[][] gameBoard;
    /**
     * Offset for the shapes.
     */
    private Point offset;
    /**
     * The rotator.
     */
    private Rotator rotator;
    /**
     * Score.
     */
    private final Score score;

    /**
     * Generate the board.
     * @param boardHeight Height of the board.
     * @param boardWidth Width of the board.
     */
    public BoardGenerator(int boardHeight, int boardWidth) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        gameBoard = new int[boardHeight][boardWidth];
        shapeGenerator = new ShapeGenerator();
        rotator = new Rotator();
        score = new Score();
    }

    /**
     * Prepare the game.
     */
    @Override
    public void newGame() {
        gameBoard = new int[boardHeight][boardWidth];
        createNewShape();
    }

    /**
     * Új formát hoz létre.
     * @return a visszaadott értéket a {@code GameController.downEvent} használni,
     * ha {@code createNewShape} igaz értéket ad vissza akkor a forma lemozgása megáll,
     * hamis esetén minden folytatódik
     */
    @Override
    public boolean createNewShape() {
        Shape shape = shapeGenerator.getShape();
        rotator.setShape(shape);
        offset = new Point(3,0);
        return MatrixMath.intersect(gameBoard, rotator.getCurrentShape(),(int) offset.getX(),(int) offset.getY());
    }

    /**
     * Move a shape left.
     * @return true, if the shape not able to move left, else if it can.
     */
    @Override
    public boolean moveShapeLeft() {
        int[][] currentBoard = MatrixMath.copy(gameBoard);
        Point p = new Point(offset);
        p.translate(-1,0);
        boolean allowToMove = MatrixMath.intersect(currentBoard, rotator.getCurrentShape(),(int) p.getX(),(int) p.getY());
        if (allowToMove){
            return false;
        } else {
            offset = p;
            return true;
        }
    }

    /**
     * Move a shape right.
     * @return true, if the shape not able to move right, else if it can.
     */
    @Override
    public boolean moveShapeRight() {
        int[][] currentBoard = MatrixMath.copy(gameBoard);
        Point p = new Point(offset);
        p.translate(1,0);
        boolean allowToMove = MatrixMath.intersect(currentBoard, rotator.getCurrentShape(),(int) p.getX(),(int) p.getY());
        if (allowToMove){
            return false;
        } else {
            offset = p;
            return true;
        }
    }

    /**
     * Move a shape down.
     * @return true, if the shape not able to move down, else if it can.
     */
    @Override
    public boolean moveShapeDown() {
        int[][] currentBoard = MatrixMath.copy(gameBoard);
        Point p = new Point(offset);
        p.translate(0,1);
        boolean allowToMove = MatrixMath.intersect(currentBoard, rotator.getCurrentShape(),(int) p.getX(),(int) p.getY());
        if (allowToMove){
            return false;
        } else {
            offset = p;
            return true;
        }
    }

    /**
     * Rotate the shape.
     * @return true, if the shape not able to be rotated, else if it can be.
     */
    @Override
    public boolean rotateShapeLeft() {
        int[][] currentBoard = MatrixMath.copy(gameBoard);
        RotatedShapeData rotatedShapeData = rotator.getRotatedShape();
        boolean allowToMove = MatrixMath.intersect(currentBoard, rotatedShapeData.getShape(),(int) offset.getX(),(int) offset.getY());
        if (allowToMove){
            return false;
        } else {
            rotator.setShapeIndex(rotatedShapeData.getPosition());
            return true;
        }
    }

    /**
     *
     * @return {@link ShapeData}.
     */
    @Override
    public ShapeData getShapeData() {
        return new ShapeData((int) offset.getX(), (int) offset.getY(), rotator.getCurrentShape(), shapeGenerator.getNextShape().getShape().get(0));
    }

    /**
     *
     * @return the Matrix of the gamaboard.
     */
    @Override
    public int[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public void pushShapeToBackgroud() {
        gameBoard = MatrixMath.push(rotator.getCurrentShape(), gameBoard, (int) offset.getX(), (int) offset.getY());
    }

    /**
     * Check the fulled lines and set the gameboard to the updated gameboard.
     * @return {@link LineClear}
     */
    @Override
    public LineClear lineClear() {
        LineClear lineClear = MatrixMath.checkRemove(gameBoard);
        gameBoard = lineClear.getNewMatrix();
        return lineClear;
    }

    /**
     * Return the score.
     * @return {@link Score}
     */
    @Override
    public Score getScore() {
        return score;
    }
}
