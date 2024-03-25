/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 9 - Final Project Part 2
 * Name: Hudson Arney
 * Created: 2/7/2022
 * Updated: 2/14/2022
 */

package arneyh;

import edu.msoe.cs1021.ImageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import java.net.URL;

/**
 * Controller class for the Filter Kernel Window
 * Contains 9 different text fields that change the pictures visibility
 */
public class SecondaryController implements Initializable {
    private Stage mainStage;
    private Lab8Controller mainController;

    @FXML
    private TextField topLeft;
    @FXML
    private TextField topCenter;
    @FXML
    private TextField topRight;
    @FXML
    private TextField centerLeft;
    @FXML
    private TextField center;
    @FXML
    private TextField centerRight;
    @FXML
    private TextField bottomLeft;
    @FXML
    private TextField bottomCenter;
    @FXML
    private TextField bottomRight;

    private double divide = 1;

    /**
     * Setter method for mainStage
     * @param mainStage mainStage
     */
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setMainController(Lab8Controller mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    @FXML
    private void blur(ActionEvent event) {
        final int blurDivideByNine = 9;
        topLeft.setText("0");
        topCenter.setText("1");
        topRight.setText("0");
        centerLeft.setText("1");
        center.setText("5");
        centerRight.setText("1");
        bottomLeft.setText("0");
        bottomCenter.setText("1");
        bottomRight.setText("0");
        divide = blurDivideByNine;
    }

    @FXML
    private void sharpen(ActionEvent event) {
        topLeft.setText("0");
        topCenter.setText("-1");
        topRight.setText("0");
        centerLeft.setText("-1");
        center.setText("5");
        centerRight.setText("-1");
        bottomLeft.setText("0");
        bottomCenter.setText("-1");
        bottomRight.setText("0");
        divide = 1;
    }

    @FXML
    private void apply(ActionEvent event) {
        double[] kernel = { Double.parseDouble(topLeft.getText()) / divide,
                Double.parseDouble(topCenter.getText()) / divide,
                Double.parseDouble(topRight.getText()) / divide,
                Double.parseDouble(centerLeft.getText()) / divide,
                Double.parseDouble(center.getText()) / divide,
                Double.parseDouble(centerRight.getText()) / divide,
                Double.parseDouble(bottomLeft.getText()) / divide,
                Double.parseDouble(bottomCenter.getText()) / divide,
                Double.parseDouble(bottomRight.getText()) / divide};
        Image image = mainController.getImage();
        mainController.setImage(ImageUtil.convolve(image, kernel));
    }
}
