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
import javafx.scene.paint.Color;

/**
 * Shape Class
 * Used for all other classes as they are all shapes.
 * The default things every shape has is a color, as well as
 * an x and y value
 */
public abstract class Shape {
    private Color color;
    protected final double x;
    protected final double y;

    /**
     * Shape constructor that takes in an x value,
     * y value, and color
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param color gives the shape a color characteristic
     */
    public Shape(double x, double y, Color color) throws IllegalArgumentException {
        if(x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinate is less than 0.");
        }
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Draw method that takes the characteristics of
     * a shape and applies them to a window
     * @param plotter plotter from the WinPlotterFX class that allows the program
     *                to draw
     */
    public abstract void draw(WinPlotterFX plotter);

    /**
     * Set Pen Color method that will draw the shape in a certain color.
     * @param plotter from the WinPlotterFX class
     */
    public void setPenColor(WinPlotterFX plotter) {
        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Setter method for the color of a shape
     * @param color color of a shape
     */
    public void setColor(Color color) {
        this.color = color;
    }
}


