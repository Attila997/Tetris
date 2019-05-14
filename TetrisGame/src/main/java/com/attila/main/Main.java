package com.attila.main;

import com.attila.gamecontroller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starting scene.
 *
 */
public class Main extends Application {

    /**
     * Initializes the main window.
     * @param stage is where we are setting our scenes on.
     * @throws Exception if something fails.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/BoardController.fxml"));
        Parent root = fxmlLoader.load();

        UIController uiC = fxmlLoader.getController();
        stage.setTitle("Tetris");
        stage.setScene(new Scene(root, 650, 850));
        stage.show();
        new GameController(uiC);
    }


    /**
     * Initialises the whole application.
     * @param args command-line-arguments in a string array.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
