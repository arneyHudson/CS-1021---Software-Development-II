/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 9 - Final Project Part 2
 * Name: Hudson Arney
 * Created: 2/7/2022
 * Updated: 2/14/2022
 */

package arneyh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.Objects;

/**
 * Lab 8 Contains the driver as well as the method that displays the output
 */
public class Lab8 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader();
        Parent root = mainLoader.load(Objects.requireNonNull(getClass().
                getResource("lab8.fxml")).openStream());
        primaryStage.setTitle("Picture Manipulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Lab8Controller mainController = mainLoader.getController();
        mainController.setMainGrid((Pane)root);

        FXMLLoader secondaryLoader = new FXMLLoader();
        Stage secondaryStage = new Stage();
        Parent secondaryRoot =
                secondaryLoader.load(Objects.requireNonNull(Objects.requireNonNull(getClass().
                        getResource("FilterKernel.fxml")).openStream()));

        SecondaryController secondaryController = secondaryLoader.getController();
        secondaryStage.setTitle("Filter Kernel");
        secondaryStage.setScene(new Scene(secondaryRoot));
        secondaryStage.hide();

        mainController.setOtherStage(secondaryStage);
        mainController.setOtherController(secondaryController);

        secondaryController.setMainStage(primaryStage);
        secondaryController.setMainController(mainController);
    }

    public static void main(String[] args) {
        launch(args);
    }

}