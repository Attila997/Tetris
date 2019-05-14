package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;

//final mert nem akarjuk, hogy subclass legyen

/**
 * I shape.
 */
final class ShapeI implements Shape {
    /**
     * list of the shapes.
     */
    private final List<int[][]> listOfShapes = new ArrayList<>();

    /**
     * the possible stages of the shape.
     */
    public ShapeI() {
        listOfShapes.add(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
        listOfShapes.add(new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        });
    }

    /**
     * Get the shapes of I shape.
     * @return the list of the I shape
     */
    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}

