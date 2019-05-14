package com.attila.logic;

import com.attila.logic.shapes.Shape;

/**
 * Class for the rotator
 */
public class Rotator {

    /**
     * A shape.
     */
    private Shape shape;
    /**
     * The index in the list of shape.
     */
    private int shapeIndex = 0;


    /**
     * Initialize the shape and the index.
     * @param shape a shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
        shapeIndex = 0;
    }

    /**
     * set the shape index value.
     * @param shapeIndex index of the shape
     */
    public void setShapeIndex(int shapeIndex) {
        this.shapeIndex = shapeIndex;
    }

    /**
     * Get the current shape matrix.
     * @return the matrix of the shape
     */
    public int[][] getCurrentShape(){
        return shape.getShape().get(shapeIndex);
    }

    /**
     * Rotate the shape.
     * @return the rotated shape's data
     */
    public RotatedShapeData getRotatedShape(){
        int rotatedShapeIndex = shapeIndex;
        //elosztja az adott indexet a forma lehetséges állásának listájával
        rotatedShapeIndex = (++rotatedShapeIndex) % shape.getShape().size();
        return new RotatedShapeData(shape.getShape().get(rotatedShapeIndex), rotatedShapeIndex);
    }
}
