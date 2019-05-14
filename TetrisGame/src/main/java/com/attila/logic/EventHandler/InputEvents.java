package com.attila.logic.EventHandler;

import com.attila.logic.ShapeData;

/**
 * Abstract interface fot input events.
 */
public interface InputEvents {

    /**
     * Setup a new game and refresh the board to empty.
     */
    void createNewGame();

    /**
     * The event to move left a shape.
     * @param event triggers the method.
     * @return the data of the moved shape.
     */
    ShapeData leftEvent(MoveEvent event);

    /**
     * The event to move right a shape.
     * @param event triggers the method.
     * @return the data of the moved shape.
     */
    ShapeData rightEvent(MoveEvent event);

    /**
     * The event to rotate a shape left.
     * @param event triggers the method.
     * @return the data of the rotated shape.
     */
    ShapeData rotationEvent(MoveEvent event);

    /**
     * The event to move down a shape and watching for line clears, game over
     * and is the shape able to move down more or not.
     * @param event triggers the method.
     * @return the {@link DownData}
     */
    DownData downEvent(MoveEvent event);
}
