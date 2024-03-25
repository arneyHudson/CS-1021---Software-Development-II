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
 * Circle class is a specific type of shape that has
 * additional characteristics (a height and width)
 */
public class Circle extends Shape {

    private final double radius;
    private final double width;
    private final double height;

    /**
     * Circle constructor that takes in the basic shape
     * characteristics but adds a radius
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param radius the length from the middle of the circle to the outer edge
     * @param color gives the circle a color characteristic
     */
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
        this.width = radius;
        this.height = radius;
    }

    /**
     * Circle constructor that uses a width and height
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param width width of the circle
     * @param height height of the circle
     * @param color Color of the circle
     */
    public Circle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        this.radius = width / 2;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x + radius, y);
        final int degrees = 360;
        for(int i = 0; i < degrees; i++) {
            plotter.drawTo(x + radius * Math.cos(Math.toRadians(i)),
                    y + radius * Math.sin(Math.toRadians(i)));
        }
    }
}
