package com.attila.logic.shapes;

import com.attila.logic.MatrixMath;

import java.util.ArrayList;
import java.util.List;

//final mert nem akarjuk, hogy subclass legyen
final class ShapeI implements Shape {
    private final List<int[][]> listOfShapes = new ArrayList<>();

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

    @Override
    public List<int[][]> getShape() {
        return MatrixMath.copyToList(listOfShapes);
    }
}

