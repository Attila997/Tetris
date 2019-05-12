package com.attila.main;

import com.attila.logic.EventHandler.*;
import com.attila.logic.Score;
import com.attila.logic.ShapeData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UIController implements Initializable {

    @FXML
    private TextField Username;

    @FXML
    private Button newGameButton;

    @FXML
    private GridPane shapePanel;

    @FXML
    private GridPane gamePanel;

    @FXML
    private Button exitButton;

    @FXML
    private GridPane nextShapePane;

    @FXML
    private Text scoreValue;

    private InputEvents inputEvents;

    private Timeline timeline;

    /**
     * A tábla téglalapja
     */
    private Rectangle[][] displayRectangle;
    private Rectangle[][] shapeRectangle;
    private User user;
    public UIController() throws IOException {
    }

    @FXML
    private void onExitButton(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void newGame(ActionEvent event) {
        Username.clear();
        timeline.stop();
        inputEvents.createNewGame();
        gamePanel.requestFocus();
        timeline.play();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BooleanBinding isTextFieldEmpty = Bindings.isEmpty(Username.textProperty());
        newGameButton.disableProperty().bind(isTextFieldEmpty);

        gamePanel.setFocusTraversable(true);
        //Requests that this Node get the input focus
        gamePanel.requestFocus();
        gamePanel.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.LEFT){
                refreshShape(inputEvents.leftEvent(new MoveEvent(EventSource.USER,EventType.LEFT)));
                keyEvent.consume();
            }
            if (keyEvent.getCode() == KeyCode.RIGHT){
                refreshShape(inputEvents.rightEvent(new MoveEvent(EventSource.USER,EventType.RIGHT)));
                keyEvent.consume();
            }
            if (keyEvent.getCode() == KeyCode.DOWN){
                onMoveDown(new MoveEvent(EventSource.USER,EventType.DOWN));
                keyEvent.consume();
            }
            if (keyEvent.getCode() == KeyCode.UP){
                refreshShape(inputEvents.rotationEvent(new MoveEvent(EventSource.USER,EventType.ROTATE)));
                keyEvent.consume();
            }
        });
    }

    /**
     * A játéktábla inicializálására szolgáló metódus
     * @param board A tábla
     * @param shapeData A formák adatai
     */
    public void initGameView(int[][] board, ShapeData shapeData){
        displayRectangle = new Rectangle[board.length][board[0].length];
        //Kirajzoljuk a táblát
        for (int i = 3; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                //a tábla mezői
                Rectangle rectangle = new Rectangle(20,20);
                rectangle.setFill(Color.TRANSPARENT);
                displayRectangle[i][j] = rectangle;
                gamePanel.add(rectangle, j, i -3);
            }
        }


        shapeRectangle = new Rectangle[shapeData.getShapeData().length][shapeData.getShapeData()[0].length];
        for (int i = 0; i < shapeData.getShapeData().length; i++){
            for (int j = 0; j < shapeData.getShapeData()[i].length; j++){
                Rectangle rectangle = new Rectangle(20,20);
                //a formák maguk alapján kapnak szint
                rectangle.setFill(getColor(shapeData.getShapeData()[i][j]));
                shapeRectangle[i][j] = rectangle;
                shapePanel.add(rectangle,j,i);
            }
        }

        shapePanel.setLayoutX(gamePanel.getLayoutX() + shapeData.getXpos() * shapePanel.getVgap() + shapeData.getXpos() * 20);
        shapePanel.setLayoutY(-65 + gamePanel.getLayoutY() + shapeData.getYpos() * shapePanel.getHgap() + shapeData.getYpos() * 20);

        generateNextShape(shapeData.getNextShapeData());

        timeline = new Timeline(new KeyFrame(Duration.millis(400), m -> onMoveDown(new MoveEvent(EventSource.THREAD, EventType.DOWN))));
        timeline.setCycleCount(Timeline.INDEFINITE);
        //timeline.play();
    }


    private Paint getColor(int i) {
        Paint paint;
        switch (i){
            case 0:
                paint = Color.TRANSPARENT;
                break;
            case 1:
                paint = Color.GREEN;
                break;
            case 2:
                paint = Color.BLUE;
                break;
            case 3:
                paint = Color.YELLOW;
                break;
            case 4:
                paint = Color.RED;
                break;
            case 5:
                paint = Color.BROWN;
                break;
            case 6:
                paint = Color.DARKORANGE;
                break;
            case 7:
                paint = Color.DARKMAGENTA;
                break;
            default:
                paint = Color.WHITE;
                break;
        }
        return paint;
    }

    public void refresGameRectangel(int[][] board) {
        for (int i = 4; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                setRectangle(displayRectangle[i][j],board[i][j]);
            }
        }
    }

    private void setRectangle(Rectangle rectangle, int colorNumber){
        rectangle.setFill(getColor(colorNumber));
    }

    /**
     * Megrajzolja a format miközben lefelé mozog
     * @param shapeData a forma adatai
     */
    private void refreshShape(ShapeData shapeData) {
        shapePanel.setLayoutX(gamePanel.getLayoutX() + shapeData.getXpos() * shapePanel.getVgap() + shapeData.getXpos() * 20);
        shapePanel.setLayoutY(-60 + gamePanel.getLayoutY() + shapeData.getYpos() * shapePanel.getHgap() + shapeData.getYpos() * 20);
        for (int i = 0; i < shapeData.getShapeData().length; i++) {
            for (int j = 0; j < shapeData.getShapeData()[i].length; j++) {
                setRectangle( shapeRectangle[i][j], shapeData.getShapeData()[i][j]);
            }
        }
        generateNextShape(shapeData.getNextShapeData());
    }

    /**
     * Megadja mi történjen ha a forma lefelé mozog
     * @param event
     */
    private void onMoveDown(MoveEvent event){
        DownData downData = inputEvents.downEvent(event);
        refreshShape(downData.getShapeData());
        gamePanel.requestFocus();

    }

    private void generateNextShape(int[][] nextShapeData) {
        nextShapePane.getChildren().clear();
        for (int i = 0; i < nextShapeData.length; i++) {
            for (int j = 0; j < nextShapeData[i].length; j++) {
                Rectangle rectangle = new Rectangle(20, 20);
                setRectangle(rectangle, nextShapeData[i][j]);
                if (nextShapeData[i][j] != 0) {
                    nextShapePane.add(rectangle, j, i);
                }
            }
        }
    }


    public void gameOver(Score score){
        timeline.stop();
        try {
            saveUser(score);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void saveUser(Score score) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Username: ",Username.getText());
        jsonObject.put("Score: ", score.getPropertyOfScore().getValue());

        try {
            File file = new File("users.json");
            FileWriter writer = new FileWriter(file);
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        /*
        Writer writer = new FileWriter("Users.json");
        Gson gson = new Gson();
        user = new User(getUsername(), score.getPropertyOfScore().getValue());
        System.out.println(user.getName() + user.getScore());
        gson.toJson(user,writer);
        */
    }

    public void bindScore(IntegerProperty integerProperty){
        scoreValue.textProperty().bind(integerProperty.asString());
    }

    public void setInputEvents(InputEvents events) {
        this.inputEvents = events;
    }

    public String getUsername() {
        return Username.getText();
    }

    public void setUsername(TextField username) {
        Username = username;
    }
}
