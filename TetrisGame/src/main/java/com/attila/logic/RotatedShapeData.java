package com.attila.logic;

public class RotatedShapeData {
    private final int[][] shape;
    private final int position;

    public RotatedShapeData(int[][] shape, int position) {
        this.shape = shape;
        this.position = position;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getPosition() {
        return position;
    }
}
