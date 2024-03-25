/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 5 - Game of Life
 * Name: Hudson Arney
 * Created: 1/11/2022
 * Updated: 1/17/2022
 */

package arneyh;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Lab5 Contains the driver as well as the method that displays the output
 */
public class Lab5 extends Application {

    @Override
    public void start(Stage stage) {
        final int paneSize = 400;
        Pane gamePane = new Pane();
        LifeGrid lifeGrid = new LifeGrid(gamePane, paneSize, paneSize);
        Label lifeLabel = new Label("Cells Alive: " + lifeGrid.aliveCount());
        Label deadLabel = new Label("Cells Dead: " + lifeGrid.deadCount());

        Button randButton = new Button("Randomize");
        randButton.setOnAction(event -> {
            lifeGrid.randomize();
            callLabel(lifeGrid, lifeLabel, deadLabel);
        });

        Button iterateButton = new Button("Iterate");
        iterateButton.setOnAction(event -> {
            lifeGrid.iterate();
            callLabel(lifeGrid, lifeLabel, deadLabel);
        });

        gamePane.setOnMouseClicked(mouseEvent -> {
            lifeGrid.deadToAlive(mouseEvent.getX(), mouseEvent.getY());
            callLabel(lifeGrid, lifeLabel, deadLabel);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(lifeLabel, deadLabel, gamePane, randButton, iterateButton);
        vBox.setAlignment(Pos.CENTER_LEFT);

        Scene scene = new Scene(vBox);
        stage.setTitle("Lab 5: Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    private void callLabel(LifeGrid lifeGrid, Label lifeLabel, Label deadLabel) {
        lifeLabel.setText("Cells Alive: " + lifeGrid.aliveCount());
        deadLabel.setText("Cells Dead: " + lifeGrid.deadCount());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
