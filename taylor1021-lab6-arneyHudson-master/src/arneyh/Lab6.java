/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 6 - Exceptions
 * Name: Hudson Arney
 * Created: 1/17/2022
 * Updated: 1/24/2022
 */

package arneyh;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Objects;

/**
 * Lab5 Contains the driver as well as the method that displays the output
 */
public class Lab6 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lab6.fxml")));
        stage.setTitle("Website Tester");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

