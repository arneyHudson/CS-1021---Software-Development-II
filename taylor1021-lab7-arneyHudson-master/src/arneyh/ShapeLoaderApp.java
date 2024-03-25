/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 7 - Shaped Revisited
 * Name: Hudson Arney
 * Created: 1/23/2022
 * Updated: 1/30/2022
 */

package arneyh;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * ShapeLoaderApp Class
 * That creates a TextInputDialog for the user to select a file
 * Once a file is selected a plot will be displayed with the various
 * shapes selected from the File chosen.
 * There are various error checks throughout the code.
 */
public class ShapeLoaderApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     * @param stage Default stage given to a JavaFX program.
     */
    @Override
    public void start(Stage stage) {
        WinPlotterFX plot = new WinPlotterFX();
        try {
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setContentText("Enter a filename: ");
            Optional<String> textBox = textInputDialog.showAndWait();
            Scanner input = new Scanner(Files.newInputStream(Path.of(textBox.get())));
            plot.setWindowTitle(input.nextLine());
            plot.setWindowSize(input.nextInt(), input.nextInt());
            Color backGround = stringToColor(input.next());
            plot.setBackgroundColor(backGround.getRed(),
                    backGround.getGreen(), backGround.getBlue());
            List<Shape> shape = readShapes(input);
            drawShapes(plot, shape);
            plot.showPlotter();
        } catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Picture Size Error");
            alert.setContentText("A non-integer was used for the files size");
            alert.showAndWait();
        } catch(InputMismatchException e) {
            System.out.println("Input Mismatch Exception");
        } catch(IllegalArgumentException e) {
            plot.showPlotter();
            System.out.println("Illegal Argument Exception");
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("File Reading Error");
            alert.setContentText("The file you are trying to reach does \n" +
                    "not exist or has illegal inputs");
            alert.showAndWait();
        }
    }

    private Shape parseShape(Scanner input) throws IllegalFormatException {
        String type = input.next();
        Shape shape = null;
        try {
            if (type.equalsIgnoreCase("P:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                shape = new Point(x, y, color);
            } else if (type.equalsIgnoreCase("C:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                double radius = input.nextDouble();
                shape = new Circle(x, y, radius, color);
            } else if (type.equalsIgnoreCase("R:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                double width = input.nextDouble();
                double height = input.nextDouble();
                shape = new Rectangle(x, y, width, height, color);
            } else if (type.equalsIgnoreCase("T:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                double base = input.nextDouble();
                double height = input.nextDouble();
                shape = new Triangle(x, y, base, height, color);
            } else if (type.equalsIgnoreCase("LR:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                double width = input.nextDouble();
                double height = input.nextDouble();
                String name = input.nextLine();
                shape = new LabeledRectangle(x, y, width, height, color, name);
            } else if (type.equalsIgnoreCase("LT:")) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Color color = stringToColor(input.next());
                double base = input.nextDouble();
                double height = input.nextDouble();
                String name = input.nextLine();
                shape = new LabeledTriangle(x, y, base, height, color, name);
            }
        } catch(NumberFormatException e) {
            System.out.println("Numbers Inputted for the coordinates of the shapes are incorrect.");
        }

        return shape;
    }

    private static Color stringToColor(String hexTriple) throws InputMismatchException {

        final int index1 = 1;
        final int index3 = 3;
        final int index5 = 5;
        final int index7 = 7;
        final int base16 = 16;
        final int correctLength = 7;

        if(hexTriple.indexOf('#') != 0 || hexTriple.length() != correctLength) {
            throw new InputMismatchException("Invalid Color Format Inputted.");
        }

        for(int i = 1; i < hexTriple.length(); i++) {
            if(Character.digit(hexTriple.charAt(i), base16) == -1) {
                throw new InputMismatchException("Invalid Hex Number Entered.");
            }
        }

        int r = Integer.valueOf(hexTriple.substring(index1, index3), base16);
        int g = Integer.valueOf(hexTriple.substring(index3, index5), base16);
        int b = Integer.valueOf(hexTriple.substring(index5, index7), base16);

        return Color.rgb(r, g, b);
    }

    private List<Shape> readShapes(Scanner input) {
        List<Shape> shape = new ArrayList<>();
        while(input.hasNextLine()) {
            try {
                shape.add(parseShape(input));
            } catch(IllegalFormatException e) {
                System.out.println("Illegal Format Exception");
            }
        }
        return shape;
    }

    private void drawShapes(WinPlotterFX plot, List<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.setPenColor(plot);
            shape.draw(plot);
        }
    }

}


