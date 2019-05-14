package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;
/**
 * J shape.
 */
public class ShapeJ implements Shape{
    /**
     * list of the shapes.
     */
    private final List<int[][]> listOfShapes = new ArrayList<>();

    /**
     * the possible stages of the shape.
     */
    public ShapeJ() {
        listOfShapes.add(new int[][]{
                {0, 0, 0,0},
                {0, 0, 1,0},
                {1, 1, 1,0},
                {0, 0, 0,0}
        });
        listOfShapes.add(new int[][]{
                {0, 1, 0,0},
                {0, 1, 0,0},
                {0, 1, 1,0},
                {0, 0, 0,0}
        });
        listOfShapes.add(new int[][]{
                {0, 0, 0,0},
                {0, 1, 1,1},
                {0, 1, 0,0},
                {0, 0, 0,0}
        });
        listOfShapes.add(new int[][]{
                {0, 0, 0,0},
                {0, 1, 1,0},
                {0, 0, 1,0},
                {0, 0, 1,0}
        });
    }

    /**
     * Get the shapes of J shape.
     * @return the list of the J shape
     */
    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}
