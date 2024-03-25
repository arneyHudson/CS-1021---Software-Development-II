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
import javafx.scene.paint.Color;

/**
 * Rectangle class is a specific type of shape that has
 * additional characteristics (a height and width)
 */
public class Rectangle extends Shape {
    protected final double height;
    protected final double width;

    /**
     * Rectangle constructor that takes in the basic shape
     * characteristics but adds a width and height
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param width the length from the nearest x value of a point to last x value of a point
     * @param height the length from the nearest y value of a point to the last y value of a point
     * @param color gives the rectangle a color characteristic
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + width);
        plotter.drawTo(x, y + height);
        plotter.drawTo(x, y);
    }
}

