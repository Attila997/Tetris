package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;
/**
 * Z shape.
 */
public class ShapeZ implements Shape {

    /**
     * list of the shapes.
     */
    private final List<int[][]> listOfShapes = new ArrayList<>();

    /**
     * the possible stages of the shape.
     */
    public ShapeZ() {
        listOfShapes.add(new int[][]{
                {0, 0, 0,0},
                {1, 1, 0,0},
                {0, 1, 1,0},
                {0, 0, 0,0}
        });
        listOfShapes.add(new int[][]{
                {0, 1, 0,0},
                {1, 1, 0,0},
                {1, 0, 0,0},
                {0, 0, 0,0}
        });
    }

    /**
     * Get the shapes of Z shape.
     * @return the list of the Z shape.
     */
    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}
