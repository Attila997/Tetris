package com.attila.logic;

public class ShapeData {
    /**
     * X coordinate of the shape.
     */
    private final int Xpos;

    /**
     * Y coordinate of the shape.
     */
    private final int Ypos;

    /**
     * Matrix of the shape.
     */
    private final int[][] shapeData;

    /**
     * Matrix of the next shape.
     */
    private final int[][] nextShapeData;

    /**
     * Assignment constructor.
     * @param xpos X coordinate of the shape
     * @param ypos Y coordinate of the shape
     * @param shapeData Data of the shape
     * @param nextShapeData Data of the next shape
     */
    public ShapeData(int xpos, int ypos, int[][] shapeData, int[][] nextShapeData) {
        this.Xpos = xpos;
        this.Ypos = ypos;
        this.shapeData = shapeData;
        this.nextShapeData = nextShapeData;
    }

    /**
     *
     * @return the x coordinate
     */
    public int getXpos() {
        return Xpos;
    }

    /**
     *
     * @return the y coordinate
     */
    public int getYpos() {
        return Ypos;
    }

    /**
     *
     * @return the Matrix of the shape
     */
    public int[][] getShapeData() {
        return MatrixMath.copy(shapeData);
    }

    /**
     *
     * @return the matrix of the next shape
     */
    public int[][] getNextShapeData() {
        return MatrixMath.copy(nextShapeData);
    }
}
