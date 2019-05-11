package com.attila.logic.EventHandler;

import com.attila.logic.ShapeData;

public interface InputEvents {

    void createNewGame();

    ShapeData leftEvent(MoveEvent event);

    ShapeData rightEvent(MoveEvent event);

    ShapeData rotationEvent(MoveEvent event);

    DownData downEvent(MoveEvent event);
}
