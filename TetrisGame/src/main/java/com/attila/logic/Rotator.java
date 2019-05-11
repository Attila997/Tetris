package com.attila.logic;

import com.attila.logic.shapes.Shape;

public class Rotator {

    private Shape shape;
    private int shapeIndex = 0;


    public void setShape(Shape shape) {
        this.shape = shape;
        shapeIndex = 0;
    }

    public void setShapeIndex(int shapeIndex) {
        this.shapeIndex = shapeIndex;
    }

    public int[][] getCurrentShape(){
        return shape.getShape().get(shapeIndex);
    }

    public RotatedShapeData getRotatedShape(){
        int rotatedShapeIndex = shapeIndex;
        rotatedShapeIndex++;
        return new RotatedShapeData(shape.getShape().get(rotatedShapeIndex), rotatedShapeIndex);
    }
}
