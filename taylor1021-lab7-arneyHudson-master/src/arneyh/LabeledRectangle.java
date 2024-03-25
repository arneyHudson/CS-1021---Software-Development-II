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
 * LabeledRectangle class is a specific type of Rectangle that has
 * additional characteristics (a name)
 */
public class LabeledRectangle extends Rectangle {
    private final String name;

    /**
     * Labeled Rectangle constructor that takes in the Rectangle
     * characteristics but adds a name
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param width the length from the nearest x value of a point to last x value of a point
     * @param height the length from the nearest y value of a point to the last y value of a point
     * @param color gives the labeled rectangle a color characteristic
     * @param name gives a name characteristic to the labeled rectangle
     */
    public LabeledRectangle(double x, double y, double width,
                            double height, Color color, String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x, y, name);
    }
}
