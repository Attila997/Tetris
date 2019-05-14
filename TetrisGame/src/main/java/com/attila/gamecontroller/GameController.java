package com.attila.gamecontroller;

import com.attila.logic.Board;
import com.attila.logic.BoardGenerator;
import com.attila.logic.EventHandler.DownData;
import com.attila.logic.EventHandler.EventSource;
import com.attila.logic.EventHandler.InputEvents;
import com.attila.logic.EventHandler.MoveEvent;
import com.attila.logic.LineClear;
import com.attila.logic.ShapeData;
import com.attila.main.UIController;

/**
 * Prepare the game.
 */
public class GameController implements InputEvents {

    /**
     * Controller of the User Interface.
     */
    private final UIController uiController;

    /**
     * New board.
     */
    private Board board = new BoardGenerator(24,10);

    /**
     * Create a new shape, inicialize the game view and set the score.
     * @param controller to reach the ui elements.
     */
    public GameController(UIController controller) {
        uiController = controller;
        board.createNewShape();
        uiController.setInputEvents(this);
        uiController.initGameView(board.getGameBoard(), board.getShapeData());
        uiController.bindScore(board.getScore().getPropertyOfScore());
    }

    /**
     * Setup a new game and refresh the board to empty.
     */
    @Override
    public void createNewGame() {
        board.newGame();
        uiController.refresGameRectangel(board.getGameBoard());
    }

    /**
     * The event to move left a shape.
     * @param event triggers the method.
     * @return the data of the moved shape.
     */
    @Override
    public ShapeData leftEvent(MoveEvent event) {
        board.moveShapeLeft();
        return board.getShapeData();
    }

/**
 * The event to move right a shape.
 * @param event triggers the method.
 * @return the data of the moved shape.
 */
    @Override
    public ShapeData rightEvent(MoveEvent event) {
        board.moveShapeRight();
        return board.getShapeData();
    }

    /**
     * The event to rotate a shape left.
     * @param event triggers the method.
     * @return the data of the rotated shape.
     */
    @Override
    public ShapeData rotationEvent(MoveEvent event) {
        board.rotateShapeLeft();
        return board.getShapeData();
    }

    /**
     * The event to move down a shape and watching for line clears, game over
     * and is the shape able to move down more or not.
     * @param event triggers the method.
     * @return the {@link DownData}
     */
    @Override
    public DownData downEvent(MoveEvent event) {
        boolean allowToMove = board.moveShapeDown();
        LineClear lineClear = null;
        if (!allowToMove){
            board.pushShapeToBackgroud();
            lineClear = board.lineClear();
            if (lineClear.getLinesRemoved() > 0){
                board.getScore().add(lineClear.getScoreBonus());
            }
            if (board.createNewShape()) {
                uiController.gameOver(board.getScore());
            }
            uiController.refresGameRectangel(board.getGameBoard());
        } else {
            if (event.getEventSource() == EventSource.USER){
                board.getScore().add(1);
            }
        }

        return new DownData(board.getShapeData(), lineClear);
    }
}
