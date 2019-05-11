package com.attila.logic;

import com.attila.logic.shapes.Shape;
import com.attila.logic.shapes.ShapeGenerator;

import java.awt.*;

/**
 *
 */
public class BoardGenerator implements Board{

    private final int boardHeight;
    private final int boardWidth;
    private final ShapeGenerator shapeGenerator;
    private int[][] gameBoard;
    private Point offset;
    private Rotator rotator;

    public BoardGenerator(int boardHeight, int boardWidth) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        gameBoard = new int[boardHeight][boardWidth];
        shapeGenerator = new ShapeGenerator();
        rotator = new Rotator();
    }

    @Override
    public void newGame() {
        gameBoard = new int[boardHeight][boardWidth];
        createNewShape();
    }

    @Override
    public boolean createNewShape() {
        Shape shape = shapeGenerator.getShape();
        rotator.setShape(shape);
        //eltolás
        offset = new Point(3,0);
        return MatrixMath.intersect(gameBoard, rotator.getCurrentShape(),(int) offset.getX(),(int) offset.getY());
    }

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

    @Override
    public ShapeData getShapeData() {
        return new ShapeData((int) offset.getX(), (int) offset.getY(), rotator.getCurrentShape(), shapeGenerator.getNextShape().getShape().get(0));
    }

    @Override
    public int[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public void pushShapeToBackgroud() {
        gameBoard = MatrixMath.push(rotator.getCurrentShape(), gameBoard, (int) offset.getX(), (int) offset.getY());
    }

    @Override
    public LineClear lineClear() {
        LineClear lineClear = MatrixMath.checkRemove(gameBoard);
        gameBoard = lineClear.getNewMatrix();
        return lineClear;
    }

    @Override
    public Score getScore() {
        return null;
    }
}
