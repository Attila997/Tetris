package com.attila.logic.EventHandler;

import com.attila.logic.LineClear;
import com.attila.logic.ShapeData;

/**
 * Data of the moving down shape.
 */
public class DownData {
    /**
     * Data of the shape.
     */
    private final ShapeData shapeData;
    /**
     * Cleared line's data.
     */
    private final LineClear lineClear;

    /**
     * Assignment constructor.
     * @param shapeData Data of the shape.
     * @param lineClear Cleared line's data.
     */
    public DownData(ShapeData shapeData, LineClear lineClear) {
        this.shapeData = shapeData;
        this.lineClear = lineClear;
    }

    /**
     * Getter for {@link ShapeData}.
     * @return the data of a shape.
     */
    public ShapeData getShapeData() {
        return shapeData;
    }

    /**
     * Getter for {@link ShapeData}.
     * @return the data of a shape.
     */
    public LineClear getLineClear() {
        return lineClear;
    }


}



