package com.attila.main;

import com.attila.logic.Board;
import com.attila.logic.BoardGenerator;
import com.attila.logic.EventHandler.DownData;
import com.attila.logic.EventHandler.EventSource;
import com.attila.logic.EventHandler.InputEvents;
import com.attila.logic.EventHandler.MoveEvent;
import com.attila.logic.LineClear;
import com.attila.logic.ShapeData;

public class GameController implements InputEvents {

    private final UIController uiController;

    private Board board = new BoardGenerator(24,10);


    public GameController(UIController controller) {
        uiController = controller;
        board.createNewShape();
        uiController.setInputEvents(this);
        uiController.initGameView(board.getGameBoard(), board.getShapeData());
        uiController.bindScore(board.getScore().getPropertyOfScore());
    }

    @Override
    public void createNewGame() {
        board.newGame();
        uiController.refresGameRectangel(board.getGameBoard());
    }

    @Override
    public ShapeData leftEvent(MoveEvent event) {
        board.moveShapeLeft();
        return board.getShapeData();
    }

    @Override
    public ShapeData rightEvent(MoveEvent event) {
        board.moveShapeRight();
        return board.getShapeData();
    }

    @Override
    public ShapeData rotationEvent(MoveEvent event) {
        board.rotateShapeLeft();
        return board.getShapeData();
    }

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
