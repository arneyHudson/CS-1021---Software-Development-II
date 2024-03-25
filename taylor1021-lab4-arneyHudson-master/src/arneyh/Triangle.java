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
 * Triangle class is a specific type of shape that has
 * additional characteristics (a height and base)
 */
public class Triangle extends Shape {
    protected final double base;
    protected final double height;

    /**
     * Triangle constructor that takes in the basic shape
     * characteristics but adds a base and height
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param base the triangles bottom line
     * @param height the triangle's length from the top to bottom
     * @param color gives the triangle a color characteristic
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x + base / 2, y + height);
        plotter.drawTo(x, y);
    }
}