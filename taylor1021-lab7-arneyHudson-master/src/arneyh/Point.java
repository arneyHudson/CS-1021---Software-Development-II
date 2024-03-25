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
 * Point Class
 * Very basic class similar to the other shape subclasses
 * Has the ability to draw the point on the canvas
 */
public class Point extends Shape {

    /**
     * Point Constructor that takes coordinates and a color to make a spot on the graph
     * @param x x-coordinate for the point
     * @param y y-coordinate for the point
     * @param color a color given for the point
     */
    public Point(double x, double y, Color color) throws IllegalArgumentException {
        super(x, y, color);
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawPoint(x, y);
    }
}
