/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 4 - Inheritance with Shapes
 * Name: Hudson Arney
 * Created: 1/4/2022
 * Updated: 1/10/2022
 */

package arneyh;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This class draws a face out of a bunch of rectangles.
 * @author taylor
 * @version 20191216
 */
public class FaceMaker extends Application {

    /**
     * Window Size for the GUI
     */
    public static final int WINDOW_SIZE = 600;

    /**
     * Grids for the window of the GUI
     */
    public static final int GRID_INCREMENT = WINDOW_SIZE/10;

    /**
     * Head size of the shapes. Also used for the sizes of the characteristics of the face
     */
    public static final int HEAD_SIZE = 400;

    /**
     * 0.2
     */
    public final double point2 = 0.2;

    /**
     * 0.4
     */
    public final double point4 = 0.4;

    /**
     * 0.6
     */
    public final double point6 = 0.6;

    /**
     * 0.8
     */
    public final double point8 = 0.8;


    /**
     * Launches the JavaFX application
     * @param args ignored
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println("Goodbye");
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     * @param stage Default stage given to a JavaFX program. Unused.
     */
    @Override
    public void start(Stage stage) {
        WinPlotterFX plotter = new WinPlotterFX();
        plotter.setWindowTitle("Face Maker");
        plotter.setWindowSize(WINDOW_SIZE, WINDOW_SIZE);
        plotter.setBackgroundColor(Color.BLACK.getRed(), Color.BLACK.getGreen(),
                Color.BLACK.getBlue());
        final boolean showGrid = true;
        plotter.setGrid(showGrid, GRID_INCREMENT, GRID_INCREMENT, Color.GRAY);

        Scanner in = new Scanner(System.in);
        String choice;

        System.out.println("""
            Enter 0 to quit\s
            Enter 1 to make a face using rectangles
            Enter 2 to make a face using triangles
            Enter 3 to make a face using circles
            Enter 4 to make a face using labeled rectangles
            Enter 5 to make a face using labeled triangles
            Enter anything else to make a face using random shapes
            """);


        choice = in.nextLine();

        Shape head = createHead(choice);
        Shape leftEye = createLeftEye(choice);
        Shape rightEye = createRightEye(choice);
        Shape nose = createNose(choice);
        Shape mouth = createMouth(choice);

        head.draw(plotter);
        leftEye.draw(plotter);
        rightEye.draw(plotter);
        nose.draw(plotter);
        mouth.draw(plotter);

        plotter.showPlotter();

    }

    /**
     * Creates and returns a shape representing the head
     * @return shape representing the head
     */
    private Shape createHead(String choice) {
        final int xLeft = (WINDOW_SIZE-HEAD_SIZE)/2;
        final int yBottom = (WINDOW_SIZE-HEAD_SIZE)/2;

        switch (choice) {
            case "1":
                return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
            case "2":
                return new Triangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
            case "3":
                return new Circle(WINDOW_SIZE / 2, WINDOW_SIZE / 2,
                        HEAD_SIZE, HEAD_SIZE, Color.WHITE);
            case "4":
                return new LabeledRectangle(xLeft, yBottom, HEAD_SIZE,
                        HEAD_SIZE, Color.WHITE, "head");
            case "5":
                return new LabeledTriangle(xLeft, yBottom, HEAD_SIZE,
                        HEAD_SIZE, Color.WHITE, "head");
            default:
                double randomNum = Math.random();
                if (randomNum < point2) {
                    return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
                } else if (randomNum <= point4 && randomNum > point2) {
                    return new Triangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
                } else if (randomNum <= point6 && randomNum > point4) {
                    return new Circle(WINDOW_SIZE / 2, WINDOW_SIZE / 2,
                            HEAD_SIZE, HEAD_SIZE, Color.WHITE);
                } else if (randomNum <= point8 && randomNum > point6) {
                    return new LabeledRectangle(xLeft, yBottom, HEAD_SIZE,
                            HEAD_SIZE, Color.WHITE, "head");
                } else {
                    return new LabeledTriangle(xLeft, yBottom, HEAD_SIZE,
                            HEAD_SIZE, Color.WHITE, "head");
                }
        }
    }

    /**
     * Creates and returns a shape representing the right eye
     * @return shape representing the right eye
     */
    private Shape createRightEye(String choice) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 + size;

        switch (choice) {
            case "1":
                return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
            case "2":
                return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
            case "3":
                return new Circle(xLeft + size / 2, yBottom + size / 2, size, size, Color.WHITE);
            case "4":
                return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "right eye");
            case "5":
                return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "right eye");
            default:
                double randomNum = Math.random();
                if (randomNum < point2) {
                    return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point4 && randomNum > point2) {
                    return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point6 && randomNum > point4) {
                    return new Circle(xLeft + size / 2,
                            yBottom + size / 2, size, size, Color.WHITE);
                } else if (randomNum <= point8 && randomNum > point6) {
                    return new LabeledRectangle(xLeft, yBottom, size,
                            size, Color.WHITE, "right eye");
                } else {
                    return new LabeledTriangle(xLeft, yBottom, size,
                            size, Color.WHITE, "right eye");
                }
        }
    }

    /**
     * Creates and returns a shape representing the left eye
     * @return shape representing the left eye
     */
    private Shape createLeftEye(String choice) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 - size*2;

        switch (choice) {
            case "1":
                return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
            case "2":
                return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
            case "3":
                return new Circle(xLeft + size / 2, yBottom + size / 2, size, size, Color.WHITE);
            case "4":
                return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "left eye");
            case "5":
                return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "left eye");
            default:
                double randomNum = Math.random();
                if (randomNum < point2) {
                    return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point4 && randomNum > point2) {
                    return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point6 && randomNum > point4) {
                    return new Circle(xLeft + size / 2,
                            yBottom + size / 2, size, size, Color.WHITE);
                } else if (randomNum <= point8 && randomNum > point6) {
                    return new LabeledRectangle(xLeft, yBottom, size,
                            size, Color.WHITE, "left eye");
                } else {
                    return new LabeledTriangle(xLeft, yBottom, size,
                            size, Color.WHITE, "left eye");
                }
        }
    }

    /**
     * Creates and returns a shape representing the nose
     * @return shape representing the nose
     */
    private Shape createNose(String choice) {
        final double scaleFactor = 0.2;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE / 2 - size / 2;
        final double yBottom = (WINDOW_SIZE) / 2;

        switch (choice) {
            case "1":
                return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
            case "2":
                return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
            case "3":
                return new Circle(xLeft + size / 2, yBottom + size / 2, size, size, Color.WHITE);
            case "4":
                return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "nose");
            case "5":
                return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "nose");
            default:
                double randomNum = Math.random();
                if (randomNum < point2) {
                    return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point4 && randomNum > point2) {
                    return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point6 && randomNum > point4) {
                    return new Circle(xLeft + size / 2,
                            yBottom + size / 2, size, size, Color.WHITE);
                } else if (randomNum <= point8 && randomNum > point6) {
                    return new LabeledRectangle(xLeft, yBottom, size,
                            size, Color.WHITE, "nose");
                } else {
                    return new LabeledTriangle(xLeft, yBottom, size,
                            size, Color.WHITE, "nose");
                }
        }
    }

    /**
     * Creates and returns a shape representing the mouth
     * @return shape representing the mouth
     */
    private Shape createMouth(String choice) {
        final double scaleFactor = 0.3;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE / 2 - size/2;
        final double yBottom = (WINDOW_SIZE)/2 - size*3/2;

        switch (choice) {
            case "1":
                return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
            case "2":
                return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
            case "3":
                return new Circle(xLeft + size / 2, yBottom + size / 2, size, size, Color.WHITE);
            case "4":
                return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "mouth");
            case "5":
                return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "mouth");
            default:
                double randomNum = Math.random();
                if (randomNum < point2) {
                    return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point4 && randomNum > point2) {
                    return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
                } else if (randomNum <= point6 && randomNum > point4) {
                    return new Circle(xLeft + size / 2,
                            yBottom + size / 2, size, size, Color.WHITE);
                } else if (randomNum <= point8 && randomNum > point6) {
                    return new LabeledRectangle(xLeft, yBottom, size,
                            size, Color.WHITE, "mouth");
                } else {
                    return new LabeledTriangle(xLeft, yBottom, size,
                            size, Color.WHITE, "mouth");
                }
        }
    }

}
