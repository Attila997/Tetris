package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;

public class ShapeZ implements Shape {

    private final List<int[][]> listOfShapes = new ArrayList<>();

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

    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}