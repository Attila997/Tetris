package com.attila.logic;

public class ShapeData {
    /**
     * A shape X pozicioja
     */
    private final int Xpos;

    /**
     *A shape Y pozicioja
     */
    private final int Ypos;

    /**
     * A forma adatai
     */
    private final int[][] shapeData;

    /**
     * A következő forma adatai
     */
    private final int[][] nextShapeData;


    public ShapeData(int xpos, int ypos, int[][] shapeData, int[][] nextShapeData) {
        this.Xpos = xpos;
        this.Ypos = ypos;
        this.shapeData = shapeData;
        this.nextShapeData = nextShapeData;
    }

    public int getXpos() {
        return Xpos;
    }

    public int getYpos() {
        return Ypos;
    }

    public int[][] getShapeData() {
        return MatrixMath.copy(shapeData);
    }

    public int[][] getNextShapeData() {
        return MatrixMath.copy(nextShapeData);
    }
}
