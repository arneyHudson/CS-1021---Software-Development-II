/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 9 - Final Project Part 2
 * Name: Hudson Arney
 * Created: 2/7/2022
 * Updated: 2/14/2022
 */

package arneyh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;

import static arneyh.ImageIO.read;

/**
 * Lab 8 Controller Class
 * Contains all FXML aspects of code
 */
public class Lab8Controller implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private Button reloadButton;
    @FXML
    private Button grayscaleButton;
    @FXML
    private Button negativeButton;
    @FXML
    private Button redButton;
    @FXML
    private Button redGrayButton;
    @FXML
    private Button showFilterButton;

    @FXML
    private ImageView displayImage;
    @FXML
    private Pane mainGrid;
    @FXML
    private Label coordinate;
    @FXML
    private Label color;

    private Image image;
    private File imageFile;
    private Stage otherStage;
    private SecondaryController otherController;


    /**
     * Setter method that sets up new stage by updating the otherStage
     * @param otherStage modifies the otherStage
     */
    public void setOtherStage(Stage otherStage) {
        this.otherStage = otherStage;
    }

    /**
     * Setter method that sets up the secondary controller by updating the other controller
     * @param otherController modifies the otherController
     */
    public void setOtherController(SecondaryController otherController) {
        this.otherController = otherController;
    }

    /**
     * Used to show the secondary filter kernel window
     * @param event Because the button is pressed to open the next window
     */
    public void showOther(ActionEvent event) {
        if (otherStage.isShowing()) {
            otherStage.hide();
        } else {
            Stage myStage = (Stage) mainGrid.getScene().getWindow();
            otherStage.setX(myStage.getX());
            otherStage.setY(myStage.getY() + myStage.getHeight());
            otherStage.setWidth(myStage.getWidth());
            otherStage.show();
        }
    }

    /**
     * Setter method that sets up the Pane by updating the mainGrid
     * @param mainGrid modifies the mainGrid
     */
    public void setMainGrid(Pane mainGrid) {
        this.mainGrid = mainGrid;
    }

    /**
     * Load method will load the images file that contains the images and open them when clicked
     * @param event uses the open button
     */
    @FXML
    public void load(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Image File");
            fileChooser.setInitialDirectory(new File("images"));
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                Path path = file.toPath();
                displayImage.setImage(read(path));
                image = displayImage.getImage();
                enableButtons(event);
            }
        } catch (NoSuchElementException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Such Element Exception");
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Illegal Argument Exception");
            alert.showAndWait();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("File Not Found");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("IO Exception");
            alert.showAndWait();
        }
    }

    /**
     * Save Method will save the new image
     *
     * @param event uses the save button
     */
    @FXML
    public void save(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Where to Save File");
            fileChooser.setInitialDirectory(new File("images"));
            File newFile = fileChooser.showSaveDialog(null);
            ImageIO.write(displayImage.getImage(), newFile.toPath());
        } catch (NoSuchElementException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Such Element Exception");
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Illegal Argument Exception");
            alert.showAndWait();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("File Not Found");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("IO Exception");
            alert.showAndWait();
        }
    }

    /**
     * Reload method will revert an images changes back to the original image
     *
     * @param event Uses the reload button
     */
    @FXML
    public void reload(ActionEvent event) {
        displayImage.setImage(image);
    }

    /**
     * Grayscale method converts the given images color into an all gray image, pixel by pixel
     *
     * @param event uses grayscale button
     */
    @FXML
    public void grayscale(ActionEvent event) {
        Image im;
        final double redToGray = 0.2126;
        final double greenToGray = 0.7152;
        final double blueToGray = 0.0722;
        im = transformImage(displayImage.getImage(), (int y, Color c) ->
                Color.gray(c.getRed() * redToGray + c.getGreen() * greenToGray +
                        c.getBlue() * blueToGray));
        displayImage.setImage(im);
    }

    /**
     * Negative Method converts the given images color to the opposite color, pixel by pixel
     *
     * @param event uses negative button
     */
    @FXML
    public void negative(ActionEvent event) {
        Image im = transformImage(displayImage.getImage(), (int y, Color c) ->
                Color.color(Math.abs(1.0 - c.getRed()), Math.abs(1.0 - c.getGreen()),
                        Math.abs(1.0 - c.getBlue())));
        displayImage.setImage(im);
    }

    /**
     * red method that takes all color out of image except for the red
     *
     * @param event when the red button is pressed
     */
    @FXML
    public void red(ActionEvent event) {
        Image im = transformImage(displayImage.getImage(), (int y, Color c) ->
                Color.color(c.getRed(), 0, 0));
        displayImage.setImage(im);
    }

    /**
     * redGray method that converts one row to grayscale and the next row to red continuously
     *
     * @param event used when the red gray button is pressed
     */
    @FXML
    public void redGray(ActionEvent event) {
        Image im;
        final double redToGray = 0.2126;
        final double greenToGray = 0.7152;
        final double blueToGray = 0.0722;
        Transformable trans = (int y, Color c) -> {
            if (y % 2 == 0) {
                return Color.color(c.getRed(), 0, 0);
            } else {
                return Color.gray(c.getRed() * redToGray + c.getGreen() * greenToGray +
                        c.getBlue() * blueToGray);
            }
        };

        im = transformImage(displayImage.getImage(), trans);
        displayImage.setImage(im);

    }

    private static Image transformImage(Image image, Transformable transform) {
        WritableImage writeImage = null;
        try {
            int width = (int) image.getWidth();
            int height = (int) image.getHeight();
            writeImage = new WritableImage(width, height);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Color c = image.getPixelReader().getColor(i, j);
                    writeImage.getPixelWriter().setColor(i, j, transform.apply(j, c));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception");
        }
        return writeImage;
    }

    /**
     * getImage method used by the secondary controller
     * @return an image that the display currently holds
     */
    public Image getImage() {
        return displayImage.getImage();
    }

    /**
     * Setter method that sets up the image by updating the image in the secondary controller
     *
     * @param image modifies the image
     */
    public void setImage(Image image) {
        displayImage.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Disables the buttons that affect a picture until a picture has been selected
     * @param event used once the open button is pressed
     */
    private void enableButtons(ActionEvent event) {
        List<Button> buttonList = new ArrayList<>(Arrays.asList(saveButton, reloadButton,
                grayscaleButton, negativeButton, redButton, redGrayButton, showFilterButton));
        buttonList.forEach(b -> b.setDisable(false));
    }

    /**
     * Coordinates Method that displays the (x,y)
     * coordinate of your hovering mouse over the picture
     * @param event MouseEvent that takes into account when a mouse is being dragged over
     */
    @FXML
    private void coordinates(MouseEvent event) {
        coordinate.setText("(X,Y) Coordinate: (" + (int)event.getX() + ", "
                + (int)event.getY() +")");
    }

}
