package com.attila.logic.EventHandler;

import com.attila.logic.LineClear;
import com.attila.logic.ShapeData;

public class DownData {
    private final ShapeData shapeData;
    private final LineClear lineClear;

    public DownData(ShapeData shapeData, LineClear lineClear) {
        this.shapeData = shapeData;
        this.lineClear = lineClear;
    }
    public ShapeData getShapeData() {
        return shapeData;
    }

    public LineClear getLineClear() {
        return lineClear;
    }


}



