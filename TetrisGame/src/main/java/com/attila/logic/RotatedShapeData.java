package com.attila.logic;

/**
 * Data od the rotated shape.
 */
public class RotatedShapeData {
    /**
     * Matrix of the Shape.
     */
    private final int[][] shape;
    /**
     * Position of the shape.
     */
    private final int position;

    /**
     * Assignment constructor.
     * @param shape Matrix of the Shape
     * @param position Position of the shape
     */
    public RotatedShapeData(int[][] shape, int position) {
        this.shape = shape;
        this.position = position;
    }

    /**
     *
     * @return the matrix of the shape
     */
    public int[][] getShape() {
        return shape;
    }

    /**
     *
     * @return the position of the shape
     */
    public int getPosition() {
        return position;
    }
}
