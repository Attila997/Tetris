package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;
/**
 * O shape.
 */
public class ShapeO implements Shape {
    /**
     * list of the shapes.
     */
    private final List<int[][]> listOfShapes = new ArrayList<>();

    /**
     * the possible stage of the shape.
     */
    public ShapeO() {
        listOfShapes.add(new int[][]{
                {0, 0, 0,0},
                {0, 1, 1,0},
                {0, 1, 1,0},
                {0, 0, 0,0}

        });
    }

    /**
     * Get the shapes of O shape.
     * @return the list of the O shape.
     */
    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}
